package com.example.baseapp.injection.module

import com.example.data.local.TokenManager
import com.example.data.remote.api.AuthApi
import com.example.data.source.AuthLocalSource
import com.example.data.source.AuthRemoteSource
import com.example.domain.source.IAuthLocalSource
import com.example.domain.source.IAuthRemoteSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SourceModule {
  @Provides
  @Singleton
  fun provideAuthRemoteSource(authApi: AuthApi) : IAuthRemoteSource {
    return AuthRemoteSource(authApi)
  }

  @Provides
  @Singleton
  fun provideAuthLocalSource(tokenManager: TokenManager) : IAuthLocalSource{
    return AuthLocalSource(tokenManager)
  }
}