package com.kotlin.myapplication

import com.kotlin.views.models.LineChartViewModel
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import javax.inject.Inject

class AppUnitTest {

    @Inject
    lateinit var view: MainChartActivityView


    @Before
    fun beforeTest() {
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setComputationSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setNewThreadSchedulerHandler { Schedulers.trampoline() }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
    }


    @Test
    fun is_connection_ok() {
//        DaggerTestComponent.create().inject(this)
        val presenter = MainChartActivityPresenterImpl()
        presenter.setView(view)
        presenter.fetchData()
    }

    @Test
    fun is_connection_ko() {

        val view: MainChartActivityView = object : MainChartActivityView {
            override fun hasInternetConnection(): Boolean {
                return false
            }

            override fun paintError(message: String?) {
                if (!message.isNullOrEmpty()) {
                    assertEquals(message, "No Internet Connection")
                } else
                    assertTrue(false)
            }

            override fun paintNoInternetConnection() {
            }

            override fun showLoading() {
            }

            override fun hideLoading() {
            }

            override fun paintRetrieveDataError() {
            }

            override fun paintChart(viewModel: LineChartViewModel) {

            }

            override fun paintTitle(name: String) {

            }

        }

        val presenter = MainChartActivityPresenterImpl()
        presenter.setView(view)
        presenter.fetchData()
    }


}
