package com.example.domain.source

import com.example.domain.entity.Music
import com.example.domain.util.SafeResult

interface IMusicRemoteSource {
  suspend fun search(term: String): SafeResult<Music>
}