package com.skylabstechke.qhalainterview.data.local

import androidx.room.RoomDatabase

abstract class MoviesDatabase :RoomDatabase() {
    abstract fun moviesDao():MoviesDao
}