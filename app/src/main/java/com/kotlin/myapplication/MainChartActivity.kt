package com.kotlin.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kotlin.myapplication.componets.DaggerAppComponent
import com.kotlin.views.models.LineChartViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainChartActivity : AppCompatActivity(), MainChartActivityView {

    @Inject
    lateinit var presenter: MainChartActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerAppComponent.create().inject(this)
        setContentView(R.layout.activity_main)
        presenter.setView(this)
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
