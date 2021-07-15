package com.skylabstechke.qhalainterview.data.common

import com.skylabstechke.qhalainterview.data.local.MoviesEntity
import com.skylabstechke.qhalainterview.data.models.MoviesModel
import com.skylabstechke.qhalainterview.data.models.Result

object TEST_COMMON
{

    val MOVIES_TEST_ENTITY = MoviesEntity(
        moviesModel = MoviesModel(
            page = 0,
            results = listOf(
                Result(
                    false,
                    "/620hnMVLu6RSZW6a5rwO8gqpt0t.jpg",
                    id = 508943,
                    overview = "Luca and his best friend Alberto experience an unforgettable summer on the Italian Riviera. But all the fun is threatened by a deeply-held secret: they are sea monsters from another world just below the water’s surface.",
                    posterPath = "/jTswp6KyDYKtvC52GbHagrZbGvD.jpg",
                    releaseDate = "2021-06-17",
                    title = "Luca",
                    voteAverage = 8.2,
                    originalTitle = "Luca",
                    video = false,

                    voteCount = 1250,
                    originalLanguage = "en",
                    genreIds = listOf(
                        16,
                        35,
                        10751,
                        14
                    ),
                    popularity = 7586.545
                )
            ),
            totalPages = 0,
            totalResults = 0
        )
    )
}