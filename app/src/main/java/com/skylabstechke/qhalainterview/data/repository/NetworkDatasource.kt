package com.skylabstechke.qhalainterview.data.repository

import com.skylabstechke.qhalainterview.data.network.MoviesApi
import com.skylabstechke.qhalainterview.data.models.MoviesModel
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.flow.Flow
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