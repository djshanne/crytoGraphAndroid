package com.kotlin.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.kotlin.myapplication.componets.DaggerAppComponent
import com.kotlin.myapplication.utils.Utils
import com.kotlin.views.models.LineChartViewModel
import kotlinx.android.synthetic.main.main_chart_activity.*
import javax.inject.Inject

class MainChartActivity : AppCompatActivity(), MainChartActivityView {

    @Inject
    lateinit var presenter: MainChartActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerAppComponent.create().inject(this)
        setContentView(R.layout.main_chart_activity)
        presenter.setView(this)
        presenter.fetchData()
        title = getString(R.string.chart_name)
    }

    override fun paintChart(viewModel: LineChartViewModel) {
        genericErrorView.visibility = View.GONE
        chart.setData(viewModel)
    }

    override fun paintTitle(name: String) {
        title = "${getString(R.string.chart_name)}: $name"
    }

    override fun hasInternetConnection(): Boolean {
        return Utils.isOnline(this)
    }

    override fun paintError(message: String?) {
        if (!message.isNullOrEmpty())
            genericErrorView.setData(message)
        else
            genericErrorView.setData(getString(R.string.error_generic))
        genericErrorView.visibility = View.VISIBLE
    }

    override fun paintNoInternetConnection() {
        genericErrorView.setData(getString(R.string.error_no_internet_connection))
        genericErrorView.visibility = View.VISIBLE
    }

    override fun onPause() {
        presenter.onPause()
        super.onPause()
    }
}
