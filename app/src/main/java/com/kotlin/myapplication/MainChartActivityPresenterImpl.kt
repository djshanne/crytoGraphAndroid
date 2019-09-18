package com.kotlin.myapplication

class MainChartActivityPresenterImpl(private val view: MainChartActivityView) :
    MainChartActivityPresenter {

    override fun fetchData() {
        val v = ArrayList<Float>()
        for (x in 0 until 10)
            v.add((Math.random() * 100f).toFloat() - 30)
        view.paintChart(v, 100f)
    }
}