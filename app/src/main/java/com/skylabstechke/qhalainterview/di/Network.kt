package com.skylabstechke.qhalainterview.di

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.skylabstechke.qhalainterview.data.network.MoviesApi
import com.skylabstechke.qhalainterview.utils.Common.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@InstallIn(ApplicationComponent::class)
@Module
object Network {


    @Singleton
    @Provides
    fun provideOkhttpClientInstance(): OkHttpClient {
        return OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS)
            .addNetworkInterceptor(StethoInterceptor())
            .readTimeout(15, TimeUnit.SECONDS).build()
    }

    @Singleton
    @Provides

    fun provideGsonConvertor(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    fun provideRetrofitInstance(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Singleton
    @Provides
    fun provideApiInstance(retrofit: Retrofit): MoviesApi {
        return retrofit.create(MoviesApi::class.java)
    }
}