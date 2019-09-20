package com.kotlin.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kotlin.views.models.LineChartViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainChartActivity : AppCompatActivity(), MainChartActivityView {


    private val presenter = MainChartActivityPresenterImpl(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.fetchData()
        title = getString(R.string.chart_name)
    }

    override fun paintChart(viewModel: LineChartViewModel) {
        chart.setData(viewModel)
    }

    override fun paintTitle(name: String) {
        title = "${getString(R.string.chart_name)}: $name"
    }

    override fun onPause() {
        presenter.onPause()
        super.onPause()
    }
}
