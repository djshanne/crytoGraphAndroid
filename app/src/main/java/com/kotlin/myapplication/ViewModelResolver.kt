package com.kotlin.myapplication

import com.kotlin.views.LineChartViewModel

class ViewModelResolver {
    fun getViewModelLineChart(inputValues: List<Float>, range: Float): LineChartViewModel {
        return object : LineChartViewModel {
            override fun getValues(): List<Float> {
                return inputValues
            }

            override fun getRange(): Float {
                return range
            }
        }
    }
}
