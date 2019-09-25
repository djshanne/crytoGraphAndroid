package com.kotlin.myapplication

import com.kotlin.myapplication.presentation.MainChartActivityView
import com.kotlin.views.models.LineChartViewModel
import dagger.Module
import dagger.Provides


@Module
class TestViewModule {

    @Provides
    fun provideMainChartActivityView(): MainChartActivityView {
        return object : MainChartActivityView {
            override fun hasInternetConnection(): Boolean {
                return true
            }

            override fun paintError(message: String?) {
                assert(message.isNullOrEmpty())
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
    }

}