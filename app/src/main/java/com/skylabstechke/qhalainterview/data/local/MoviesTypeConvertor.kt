package com.skylabstechke.qhalainterview.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class MoviesTypeConvertor {

    private var gson: Gson = Gson()

    @TypeConverter
    fun moviesToString(movies: List<String>): String {
        return gson.toJson(movies)
    }

    @TypeConverter
    fun stringToMovies(data: String): List<String> {
        val listType = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(data, listType)
    }
}