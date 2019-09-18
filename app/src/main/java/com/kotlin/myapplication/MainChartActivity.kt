package com.kotlin.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainChartActivity : AppCompatActivity(), MainChartActivityView {

    private val viewModelResolver = ViewModelResolver()
    private val presenter = MainChartActivityPresenterImpl(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.fetchData()
    }

    override fun paintChart(inputValues: List<Float>, range: Float) {
        chart.setData(viewModelResolver.getViewModelLineChart(inputValues, range))
    }
}
