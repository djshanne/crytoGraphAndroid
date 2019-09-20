package com.kotlin.myapplication

import com.kotlin.views.models.LineChartViewModel

interface MainChartActivityView {

    fun paintChart(viewModel: LineChartViewModel)

}
