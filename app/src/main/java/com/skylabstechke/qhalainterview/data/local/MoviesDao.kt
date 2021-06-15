package com.skylabstechke.qhalainterview.data.local

import androidx.room.Dao


@Dao
interface MoviesDao {
    suspend fun insertMovies()
}