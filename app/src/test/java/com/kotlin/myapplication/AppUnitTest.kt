package com.kotlin.myapplication

import com.kotlin.views.models.LineChartViewModel
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import junit.framework.Assert.assertEquals
import org.junit.Test

class AppUnitTest : MainChartActivityView {

    override fun paintChart(viewModel: LineChartViewModel) {
        assert(viewModel.values.isNotEmpty())
    }

    override fun paintTitle(name: String) {
        assertEquals("Market Price (USD)", name)
    }

    @Test
    fun is_presenter_ok() {
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setComputationSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setNewThreadSchedulerHandler { Schedulers.trampoline() }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }

        val presenter = MainChartActivityPresenterImpl(this)
        presenter.fetchData()
    }
}
