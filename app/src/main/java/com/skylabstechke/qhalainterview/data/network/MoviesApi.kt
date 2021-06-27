package com.skylabstechke.qhalainterview.data.network

import com.skylabstechke.qhalainterview.models.MoviesModel
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET

interface MoviesApi {
    @GET("/movies")
    suspend fun getMovies(
    ): Flow<Response<MoviesModel>>
}