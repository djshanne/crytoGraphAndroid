package com.kotlin.domain

import org.junit.Assert.assertEquals
import org.junit.Test

class DomainUnitTest {
    @Test
    fun test_type_chart_is_market_price() {
        val handler = ChartDataHandler()
        handler.fetchData().doOnNext { assertEquals("Market Price (USD)", it.name) }.subscribe()
    }
}
