package com.kotlin.myapplication.presentation

interface MainChartActivityPresenter {
    fun fetchData()
    fun onPause()
    fun setView(view: MainChartActivityView)
}
