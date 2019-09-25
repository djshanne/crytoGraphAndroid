package com.kotlin.myapplication.dependencies.modules

import com.kotlin.domain.ChartDataHandler
import com.kotlin.myapplication.presentation.MainChartActivityPresenter
import com.kotlin.myapplication.presentation.MainChartActivityPresenterImpl
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideMainChartPresenter(): MainChartActivityPresenter {
        return MainChartActivityPresenterImpl()
    }

    @Provides
    fun provideChartDataHandler(): ChartDataHandler {
        return ChartDataHandler()
    }

}