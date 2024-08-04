package com.teeside.themovies.search.data.repository

import com.teeside.themovies.main.data.mappers.toMedia
import com.teeside.themovies.main.data.remote.api.MediaApi
import com.teeside.themovies.main.domain.models.Media
import com.teeside.themovies.search.domain.repository.SearchRepository
import com.teeside.themovies.util.Constants
import com.teeside.themovies.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchRepositoryImpl @Inject constructor(
    private val mediaApi: MediaApi,
) : SearchRepository {

    override suspend fun getSearchList(
        fetchFromRemote: Boolean,
        query: String,
        page: Int,
        apiKey: String
    ): Flow<Resource<List<Media>>> {

        return flow {
            emit(Resource.Loading(true))

            val remoteMediaList = try {
                mediaApi.getSearchList(query, page, apiKey).results.map { media ->
                    media.toMedia(
                        type = media.media_type ?: Constants.unavailable,
                        category = media.category ?: Constants.unavailable
                    )
                }
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                emit(Resource.Loading(false))
                return@flow
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                emit(Resource.Loading(false))
                return@flow
            }

            emit(Resource.Success(remoteMediaList))

            emit(Resource.Loading(false))
        }
    }
}










