package com.kotlin.repository

import com.kotlin.repository.models.Graph
import com.kotlin.repository.sources.local.LocalSource
import com.kotlin.repository.sources.remote.RemoteSource
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers


class RepositoryImpl : Repository {

    var remote = RemoteSource()
    var local = LocalSource()

    override fun getGraph(): Observable<Graph>? {
        return remote.getGraph()
    }


}