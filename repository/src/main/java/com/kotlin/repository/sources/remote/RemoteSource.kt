package com.kotlin.repository.sources.remote

import com.kotlin.repository.Repository
import com.kotlin.repository.models.Graph
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RemoteSource : Repository {
    private var restClient: CryptoApi? = null
    private var retrofit: Retrofit? = null

    init {
        retrofit = Retrofit.Builder()
            .baseUrl("https://api.blockchain.info")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        restClient = retrofit?.create<CryptoApi>(CryptoApi::class.java)
    }

    override fun getGraph(): Observable<Graph>? {
        return restClient?.getGraph()?.subscribeOn(Schedulers.io())
    }
}