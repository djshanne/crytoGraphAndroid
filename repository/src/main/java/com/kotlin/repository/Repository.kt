package com.kotlin.repository

import com.kotlin.repository.models.Graph
import io.reactivex.Observable

interface Repository {
    fun getGraph(): Observable<Graph>?
}