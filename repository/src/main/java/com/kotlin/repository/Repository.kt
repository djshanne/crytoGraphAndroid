package com.kotlin.repository

import io.reactivex.Observable

interface Repository {
    fun getGraph(): Observable<String>
}