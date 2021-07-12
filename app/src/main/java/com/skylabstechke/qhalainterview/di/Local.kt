package com.skylabstechke.qhalainterview.di

import android.content.Context
import androidx.room.Room
import com.skylabstechke.qhalainterview.data.local.MoviesDao
import com.skylabstechke.qhalainterview.data.local.MoviesDatabase
import com.skylabstechke.qhalainterview.utils.Common.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton


@InstallIn(ApplicationComponent::class)
@Module
object Local {
    @Singleton
    @Provides
    fun provideDatabaseInstance(@ApplicationContext context: Context) =
         Room.databaseBuilder(
            context,
            MoviesDatabase::class.java,
            DATABASE_NAME
        ).build()

    @Singleton
    @Provides
    fun provideMoviesDao(database: MoviesDatabase) =
         database.getMoviesDao()



}