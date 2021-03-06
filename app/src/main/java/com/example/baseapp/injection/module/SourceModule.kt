package com.example.baseapp.injection.module

import com.example.data.local.TokenManager
import com.example.data.remote.api.AuthApi
import com.example.data.remote.api.MusicApi
import com.example.data.source.AuthLocalSource
import com.example.data.source.AuthRemoteSource
import com.example.data.source.MusicRemoteSource
import com.example.domain.source.IAuthLocalSource
import com.example.domain.source.IAuthRemoteSource
import com.example.domain.source.IMusicRemoteSource
import dagger.Module
import dagger.Provides

@Module
class SourceModule {

  @Provides
  fun provideAuthRemoteSource(authApi: AuthApi): IAuthRemoteSource {
    return AuthRemoteSource(authApi)
  }

  @Provides
  fun provideAuthLocalSource(tokenManager: TokenManager): IAuthLocalSource {
    return AuthLocalSource(tokenManager)
  }

  @Provides
  fun provideMusicRemoteSource(musicApi: MusicApi): IMusicRemoteSource {
    return MusicRemoteSource(musicApi)
  }
}