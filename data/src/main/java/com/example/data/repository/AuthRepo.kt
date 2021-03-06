package com.example.data.repository

import com.example.domain.entity.Auth
import com.example.domain.entity.LoginRequest
import com.example.domain.entity.SignUpRequest
import com.example.domain.repository.IAuthRepo
import com.example.domain.source.IAuthLocalSource
import com.example.domain.source.IAuthRemoteSource
import com.example.domain.util.SafeResult
import com.example.domain.util.SafeResult.Failure
import com.example.domain.util.SafeResult.NetworkError
import com.example.domain.util.SafeResult.Success

class AuthRepo(
  private val authLocalSource: IAuthLocalSource,
  private val authRemoteSource: IAuthRemoteSource
) : IAuthRepo {
  override suspend fun login(loginRequest: LoginRequest): SafeResult<Auth> {
    return when (val result = authRemoteSource.login(loginRequest)) {
      is Failure -> result
      NetworkError -> NetworkError
      is Success -> {
        result.data.apply {
          authLocalSource.saveTokens(accessToken, refreshToken)
        }
        Success(result.data)
      }
    }
  }

  override suspend fun signUp(signUpRequest: SignUpRequest): SafeResult<Auth> {
    return when (val result = authRemoteSource.signUp(signUpRequest)) {
      is Failure -> result
      NetworkError -> NetworkError
      is Success -> {
        result.data.apply {
          authLocalSource.saveTokens(accessToken, refreshToken)
        }
        Success(result.data)
      }
    }
  }

  override suspend fun logout(): SafeResult<Unit> {
    authLocalSource.deleteTokens()
    return Success(Unit)
  }

  override suspend fun isUserLoggedIn(): Boolean = authLocalSource.isUserLoggedIn()
}