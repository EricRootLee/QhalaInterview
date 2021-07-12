package com.skylabstechke.qhalainterview.data.network

import com.skylabstechke.qhalainterview.data.models.MoviesModel
import com.skylabstechke.qhalainterview.utils.Common
import com.skylabstechke.qhalainterview.utils.Common.API_KEY
import retrofit2.Response
import retrofit2.http.GET

interface MoviesApi {
    @GET("/3/movie/popular?api_key=${API_KEY}&language=en-US&page=1/")
    suspend fun getMovies(
    ): Response<MoviesModel>
}