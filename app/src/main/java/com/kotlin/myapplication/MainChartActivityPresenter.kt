package com.kotlin.myapplication

interface MainChartActivityPresenter {

    fun fetchData()
    fun onPause()
    fun setView(view: MainChartActivityView)

}
