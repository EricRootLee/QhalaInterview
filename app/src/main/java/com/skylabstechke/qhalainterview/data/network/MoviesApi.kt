package com.skylabstechke.qhalainterview.data.network

import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET

interface MoviesApi {
    @GET("/movies")
    suspend fun getMovies(
    ): Flow<Response<Int>>
}