package com.skylabstechke.qhalainterview.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies_table")
class MoviesEntity(
  var moviesData:List<String>
 ){

  @PrimaryKey(autoGenerate = false)
  var id:Int =0
 }
