package com.kotlin.repository.sources.local

import com.kotlin.repository.Repository
import com.kotlin.repository.models.Graph
import io.reactivex.Observable

class LocalSource : Repository {
    override fun getGraph(): Observable<Graph>? {
        return null
    }
}
