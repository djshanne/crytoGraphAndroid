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
            chartDataHandler.fetchData()?.observeOn(AndroidSchedulers.mainThread())
                ?.map {
                    val values = ArrayList<Value>()
                    for (x in it.values)
                        values.add(Value(x.x, x.y))
                    LineChartViewModel(values)
                }?.subscribe(view::paintChart)
    }

    override fun onPause() {
        fetchDataDisposable?.dispose()
    }
}