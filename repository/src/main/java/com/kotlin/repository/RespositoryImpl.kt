package com.kotlin.repository

import io.reactivex.Observable

class RespositoryImpl : Repository {
    override fun getGraph(): Observable<String> {
        return Observable.fromIterable(listOf("1"))
    }

}