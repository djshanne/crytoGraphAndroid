package com.kotlin.myapplication

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
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
        initUi()
        initPresenter()
    }

    private fun initUi() {
        setContentView(R.layout.main_chart_activity)
        title = getString(R.string.chart_name)
    }

    private fun initPresenter() {
        presenter.setView(this)
        //TODO fix issue with view model lifecycle
//        val model = ViewModelProvider(this).get(LineChartViewModel::class.java)
//        paintChart(model)
        presenter.fetchData()

    }

    override fun paintChart(viewModel: LineChartViewModel) {
        if (!viewModel.isEmpty()) {
            genericErrorView.visibility = View.GONE
            chart.setData(viewModel)
        } else {
            paintError(getString(R.string.status_data_empty))
        }
    }

    override fun paintRetrieveDataError() {
        paintError(getString(R.string.error_generic))
    }

    override fun paintTitle(name: String) {
        title = "${getString(R.string.chart_name)}: $name"
    }

    override fun showLoading() {
        paintError(getString(R.string.status_data_loading))
    }

    override fun hideLoading() {
        genericErrorView.visibility = View.GONE
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
