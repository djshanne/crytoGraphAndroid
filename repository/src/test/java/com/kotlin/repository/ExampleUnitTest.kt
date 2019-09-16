package com.kotlin.repository

import org.junit.Test

import org.junit.Assert.*

class ExampleUnitTest {
    @Test
    fun testList() {
        val rep = RespositoryImpl()
        rep.getGraph()
            .doOnNext { assertEquals("1", it) }
            .subscribe()
    }
}