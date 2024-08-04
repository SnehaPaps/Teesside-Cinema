package com.teeside.themovies.search.domain.repository

import com.teeside.themovies.util.Resource
import com.teeside.themovies.main.domain.models.Media
import kotlinx.coroutines.flow.Flow

interface SearchRepository {
    suspend fun getSearchList(
        fetchFromRemote: Boolean,
        query: String,
        page: Int,
        apiKey: String
    ): Flow<Resource<List<Media>>>

}










