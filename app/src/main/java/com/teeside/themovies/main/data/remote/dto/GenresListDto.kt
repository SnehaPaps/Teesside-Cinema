package com.teeside.themovies.main.data.remote.dto

import com.teeside.themovies.main.domain.models.Genre

data class GenresListDto(
    val genres: List<Genre>
)