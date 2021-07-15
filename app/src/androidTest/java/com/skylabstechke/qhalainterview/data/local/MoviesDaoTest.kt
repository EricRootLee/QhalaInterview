package com.skylabstechke.qhalainterview.data.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.asLiveData
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.skylabstechke.qhalainterview.data.common.TEST_COMMON.MOVIES_TEST_ENTITY
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest

class MoviesDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

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
        dao.insertMovies(MOVIES_TEST_ENTITY)
        val getMovies = dao.getMovies().asLiveData()


    }
}