package com.kotlin.repository

import com.kotlin.repository.sources.local.LocalSource
import com.kotlin.repository.sources.remote.CryptoApi
import com.kotlin.repository.sources.remote.RemoteSource
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.blockchain.info")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideRestClient(retrofit: Retrofit): CryptoApi {
        return retrofit.create<CryptoApi>(CryptoApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRemoteSource(): RemoteSource {
        return RemoteSource()
    }

    @Provides
    @Singleton
    fun provideLocalSource(): LocalSource {
        return LocalSource()
    }
}