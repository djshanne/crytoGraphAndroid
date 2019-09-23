package com.kotlin.repository

import com.kotlin.repository.models.Graph
import com.kotlin.repository.sources.components.DaggerRepositoryComponent
import com.kotlin.repository.sources.local.LocalSource
import com.kotlin.repository.sources.remote.RemoteSource
import io.reactivex.Observable
import javax.inject.Inject


class RepositoryImpl : Repository {

    @Inject
    lateinit var remote: RemoteSource
    @Inject
    lateinit var local: LocalSource

    init {
        DaggerRepositoryComponent.create().inject(this)
    }

    override fun getGraph(): Observable<Graph> {
        return remote.getGraph()
    }

}