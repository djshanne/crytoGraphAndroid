package com.kotlin.myapplication

import com.kotlin.domain.ChartDataHandler
import com.kotlin.domain.models.ChartDataModel
import com.kotlin.myapplication.componets.DaggerAppComponent
import com.kotlin.views.models.LineChartViewModel
import com.kotlin.views.models.Value
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class MainChartActivityPresenterImpl :
    MainChartActivityPresenter {


    private lateinit var view: MainChartActivityView
    private var fetchDataDisposable: Disposable? = null
    @Inject
    lateinit var chartDataHandler: ChartDataHandler

    init {
        DaggerAppComponent.create().inject(this)
    }

    override fun fetchData() {
        if (view.hasInternetConnection()) {
            view.showLoading()
            fetchDataDisposable =
                chartDataHandler.fetchData()
                    .delay(3, TimeUnit.SECONDS)
                    .map(this::mapFromDomainToView)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(this::onComplete, this::onError)
        } else
            view.paintNoInternetConnection()
    }

    private fun mapFromDomainToView(it: ChartDataModel): LineChartViewModel {
        val values = ArrayList<Value>()
        for (x in it.values)
            values.add(Value(x.x, x.y))
        return LineChartViewModel(values, it.name)
    }


    private fun onError(t: Throwable?) {
        view.paintRetrieveDataError()
        t?.let {
            view.paintError(t.localizedMessage)
        }
    }

    private fun onComplete(it: LineChartViewModel) {
        view.paintChart(it)
        view.paintTitle(it.name)
        view.hideLoading()
    }


    override fun onPause() {
        fetchDataDisposable?.dispose()
    }

    override fun setView(view: MainChartActivityView) {
        this.view = view
    }

}