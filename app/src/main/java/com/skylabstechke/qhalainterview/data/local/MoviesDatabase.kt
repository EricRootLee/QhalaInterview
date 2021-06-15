package com.skylabstechke.qhalainterview.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters

@Database(
    entities = [MoviesEntity::class],
    version = 1,
    exportSchema = false
)

@TypeConverters(MoviesTypeConvertor::class)
abstract class MoviesDatabase :RoomDatabase() {
    abstract fun moviesDao():MoviesDao
}