package com.skylabstechke.qhalainterview.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @Query("INSERT ")
    suspend fun insert()

}