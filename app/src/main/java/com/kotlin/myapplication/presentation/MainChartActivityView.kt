package com.kotlin.myapplication.presentation

import com.kotlin.views.models.LineChartViewModel

interface MainChartActivityView {
    fun paintChart(viewModel: LineChartViewModel)
    fun paintTitle(name: String)
    fun hasInternetConnection(): Boolean
    fun paintError(message: String?)
    fun paintNoInternetConnection()
    fun showLoading()
    fun hideLoading()
    fun paintRetrieveDataError()
}
