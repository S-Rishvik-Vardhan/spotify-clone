package com.example.data.remote.api

import com.example.data.remote.model.music.MusicResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MusicApi {
  @GET("search")
  suspend fun search(
    @Query("term")
    term: String,
    @Query("entity")
    entity: String = "song"
  ): MusicResponse
}