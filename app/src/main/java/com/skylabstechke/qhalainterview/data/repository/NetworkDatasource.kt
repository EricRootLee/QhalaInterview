package com.skylabstechke.qhalainterview.data.repository

import com.skylabstechke.qhalainterview.data.models.MoviesModel
import com.skylabstechke.qhalainterview.data.network.MoviesApi
import dagger.hilt.android.scopes.ActivityRetainedScoped
import retrofit2.Response
import javax.inject.Inject

@ActivityRetainedScoped
class NetworkDatasource @Inject constructor(
    private val moviesApi: MoviesApi
) {

    suspend fun getMovies(): Response<MoviesModel> {
        return moviesApi.getMovies()
    }

}