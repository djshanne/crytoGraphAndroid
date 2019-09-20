package com.kotlin.repository

import org.junit.Assert.assertEquals
import org.junit.Test

class RepositoryUnitTest {
    @Test
    fun testStatusOkApi() {
        val rep = RepositoryImpl()
        rep.getGraph()
            .doOnNext {
                assertEquals("ok", it.status)
            }
            ?.subscribe()
    }
}