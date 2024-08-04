package com.teeside.themovies.main.domain.repository

import com.teeside.themovies.util.Resource
import com.teeside.themovies.main.domain.models.Genre
import kotlinx.coroutines.flow.Flow

interface GenreRepository {
    suspend fun getGenres(
        fetchFromRemote: Boolean,
        type: String,
        apiKey: String
    ): Flow<Resource<List<Genre>>>
}










