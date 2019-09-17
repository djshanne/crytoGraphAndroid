package com.kotlin.repository.sources.remote

import com.kotlin.repository.models.Graph
import io.reactivex.Observable
import retrofit2.http.GET

interface CryptoApi {
    @GET("/charts/transactions-per-second?timespan=5weeks&rollingAverage=8hours&format=json")
    fun getGraph(): Observable<Graph>
}