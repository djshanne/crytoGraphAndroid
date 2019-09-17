package com.kotlin.repository

import org.junit.Test

import org.junit.Assert.*

class ExampleUnitTest {
    @Test
    fun testStatusOkApi() {
        val rep = RepositoryImpl()
        rep.getGraph()
            ?.doOnNext {
                assertEquals("ok", it.status)
            }
            ?.subscribe()
    }
}