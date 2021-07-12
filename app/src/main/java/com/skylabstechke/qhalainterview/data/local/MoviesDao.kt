package com.skylabstechke.qhalainterview.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movies: MoviesEntity)

    @Query("SELECT * FROM movies_table")
    fun getMovies(): Flow<List<MoviesEntity>>

}