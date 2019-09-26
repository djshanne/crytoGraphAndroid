package com.kotlin.myapplication.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.myapplication.R
import com.kotlin.myapplication.dependencies.componets.DaggerAppComponent
import com.kotlin.myapplication.utils.Utils
import com.kotlin.views.models.LineChartViewModel
import kotlinx.android.synthetic.main.main_chart_activity.*
import javax.inject.Inject

class MainChartActivity : AppCompatActivity(),
    MainChartActivityView, View.OnClickListener {

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
        mainChartActivityRefresh.setOnButtonClickListener(this)
        title = getString(R.string.chart_name)
    }

    private fun initPresenter() {
        presenter.setView(this)
        //TODO fix issue with view model lifecycle
//        val model = ViewModelProvider(this).get(LineChartViewModel::class.java)
//        paintChart(model)
        presenter.fetchData()

    }

    override fun onClick(p0: View?) {
        presenter.fetchData()
    }


    override fun paintChart(viewModel: LineChartViewModel) {
        if (!viewModel.isEmpty()) {
            mainChartActivityErrorView.visibility = View.GONE
            mainChartActivityChart.setData(viewModel)
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
        mainChartActivityErrorView.visibility = View.GONE
    }

    override fun hasInternetConnection(): Boolean {
        return Utils.isOnline(this)
    }

    override fun paintError(message: String?) {
        if (!message.isNullOrEmpty())
            mainChartActivityErrorView.setData(message)
        else
            mainChartActivityErrorView.setData(getString(R.string.error_generic))
        mainChartActivityErrorView.visibility = View.VISIBLE
    }

    override fun paintNoInternetConnection() {
        mainChartActivityErrorView.setData(getString(R.string.error_no_internet_connection))
        mainChartActivityErrorView.visibility = View.VISIBLE
    }

    override fun onPause() {
        presenter.onPause()
        super.onPause()
    }
}
