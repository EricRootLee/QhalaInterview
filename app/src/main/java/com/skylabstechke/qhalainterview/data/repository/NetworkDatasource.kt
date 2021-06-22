package com.skylabstechke.qhalainterview.data.repository

import com.skylabstechke.qhalainterview.data.network.MoviesApi
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

class NetworkDatasource @Inject constructor(
    private val moviesApi: MoviesApi
) {

    suspend fun getMovies(): Flow<Response<Int>> {
        return moviesApi.getMovies()
    }

}