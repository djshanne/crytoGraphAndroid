package com.kotlin.repository.sources.remote

import com.kotlin.repository.models.Graph
import io.reactivex.Observable
import retrofit2.http.GET

interface CryptoApi {
    @GET("/charts/market-price?timespan=3days&format=json")
    fun getGraph(): Observable<Graph>
}