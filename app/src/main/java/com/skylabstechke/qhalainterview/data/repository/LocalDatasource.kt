package com.skylabstechke.qhalainterview.data.repository

import com.skylabstechke.qhalainterview.data.local.MoviesDao
import com.skylabstechke.qhalainterview.data.local.MoviesEntity
import com.skylabstechke.qhalainterview.data.models.MoviesModel
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ActivityRetainedScoped
class LocalDatasource @Inject constructor(
    private val moviesDao: MoviesDao
) {
    fun getMovies():Flow<List<MoviesEntity>>{
        return moviesDao.getMovies()
    }

  suspend  fun insertMovies(moviesEntity: MoviesEntity){
        return moviesDao.insertMovies(moviesEntity)
    }

}