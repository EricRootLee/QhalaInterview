package com.skylabstechke.qhalainterview.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.skylabstechke.qhalainterview.data.models.MoviesModel


class MoviesTypeConvertor(){
    var gson = Gson()

    @TypeConverter
    fun moviesToString(movies:MoviesModel):String{
        return  gson.toJson(movies)
    }

    @TypeConverter
    fun stringToMovies(data:String):MoviesModel{
        val listType  = object  : TypeToken<MoviesModel>() {}.type
        return gson.fromJson(data,listType  )
    }

}

