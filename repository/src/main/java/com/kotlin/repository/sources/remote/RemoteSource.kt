package com.kotlin.repository.sources.remote

import com.kotlin.repository.Repository
import com.kotlin.repository.models.Graph
import com.kotlin.repository.components.DaggerRepositoryComponent
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RemoteSource : Repository {

    @Inject
    lateinit var restClient: CryptoApi

    init {
        DaggerRepositoryComponent.create().inject(this)
    }

    override fun getGraph(): Observable<Graph> {
        return restClient.getGraph().subscribeOn(Schedulers.io())
    }
}