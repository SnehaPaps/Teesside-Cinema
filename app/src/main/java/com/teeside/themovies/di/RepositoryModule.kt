package com.teeside.themovies.di

import com.teeside.themovies.media_details.data.repository.DetailsRepositoryImpl
import com.teeside.themovies.media_details.data.repository.ExtraDetailsRepositoryImpl
import com.teeside.themovies.media_details.domain.repository.DetailsRepository
import com.teeside.themovies.media_details.domain.repository.ExtraDetailsRepository
import com.teeside.themovies.main.data.repository.GenreRepositoryImpl
import com.teeside.themovies.main.data.repository.MediaRepositoryImpl
import com.teeside.themovies.search.data.repository.SearchRepositoryImpl
import com.teeside.themovies.main.domain.repository.GenreRepository
import com.teeside.themovies.main.domain.repository.MediaRepository
import com.teeside.themovies.search.domain.repository.SearchRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindMediaRepository(
        mediaRepositoryImpl: MediaRepositoryImpl
    ): MediaRepository

    @Binds
    @Singleton
    abstract fun bindSearchRepository(
        searchRepositoryImpl: SearchRepositoryImpl
    ): SearchRepository

    @Binds
    @Singleton
    abstract fun bindGenreRepository(
        genreRepositoryImpl: GenreRepositoryImpl
    ): GenreRepository

    @Binds
    @Singleton
    abstract fun bindDetailsRepository(
        detailsRepositoryImpl: DetailsRepositoryImpl
    ): DetailsRepository

    @Binds
    @Singleton
    abstract fun bindExtraDetailsRepository(
       extraDetailsRepositoryImpl: ExtraDetailsRepositoryImpl
    ): ExtraDetailsRepository

}
