package com.kotlin.myapplication

import com.kotlin.domain.ChartDataHandler
import com.kotlin.views.models.LineChartViewModel
import com.kotlin.views.models.Value
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable

class MainChartActivityPresenterImpl(private val view: MainChartActivityView) :
    MainChartActivityPresenter {

    private var fetchDataDisposable: Disposable? = null
    private val chartDataHandler = ChartDataHandler()


    override fun fetchData() {
        fetchDataDisposable =
            chartDataHandler.fetchData()
                .map {
                    val values = ArrayList<Value>()
                    for (x in it.values)
                        values.add(Value(x.x, x.y))
                    LineChartViewModel(values, it.name)
                }
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext {
                    view.paintChart(it)
                    view.paintTitle(it.name)
                }
                .subscribe()
    }

    override fun onPause() {
        fetchDataDisposable?.dispose()
    }
}