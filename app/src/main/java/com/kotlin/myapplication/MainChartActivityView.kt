package com.kotlin.myapplication

import com.kotlin.views.models.LineChartViewModel

interface MainChartActivityView {

    fun paintChart(viewModel: LineChartViewModel)
    fun paintTitle(name: String)
    fun hasInternetConnection(): Boolean
    fun paintError(message: String?)
    fun paintNoInternetConnection()

}
