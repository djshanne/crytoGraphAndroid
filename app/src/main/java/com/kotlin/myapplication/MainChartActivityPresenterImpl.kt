package com.kotlin.myapplication

import com.kotlin.domain.ChartDataHandler
import com.kotlin.myapplication.componets.DaggerAppComponent
import com.kotlin.views.models.LineChartViewModel
import com.kotlin.views.models.Value
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
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
                    .doOnError {
                        view.paintError(it.message)
                    }
                    .subscribe()
        } else
            view.paintNoInternetConnection()
    }

    override fun onPause() {
        fetchDataDisposable?.dispose()
    }

    override fun setView(view: MainChartActivityView) {
        this.view = view
    }

}