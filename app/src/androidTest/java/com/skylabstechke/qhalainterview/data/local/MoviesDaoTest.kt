package com.skylabstechke.qhalainterview.data.local

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.skylabstechke.qhalainterview.data.models.MoviesModel
import com.skylabstechke.qhalainterview.data.models.Result
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class MoviesDaoTest {
    private lateinit var database: MoviesDatabase
    private lateinit var dao: MoviesDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            MoviesDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.getMoviesDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun insertMovies() = runBlocking {

        val moviesResult = listOf(
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
        )
        val moviesMoviesModel = MoviesModel(
            page = 0,
            results = moviesResult,
            totalPages = 0,
            totalResults = 0
        )
        val moviesEntity = MoviesEntity(
            moviesModel = moviesMoviesModel
        )
        dao.insertMovies(moviesEntity)
    }
}