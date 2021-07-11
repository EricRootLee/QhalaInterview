package com.skylabstechke.qhalainterview.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.skylabstechke.qhalainterview.data.models.MoviesModel
import com.skylabstechke.qhalainterview.utils.Common.MOVIES_TABLE

@Entity(tableName = MOVIES_TABLE)
class MoviesEntity(
    private val moviesData: MoviesModel
) {

    @PrimaryKey(autoGenerate = false)
    private val id: Int = 0

}
