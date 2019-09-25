package com.kotlin.myapplication.dependencies.componets

import com.kotlin.myapplication.presentation.MainChartActivity
import com.kotlin.myapplication.presentation.MainChartActivityPresenterImpl
import com.kotlin.myapplication.dependencies.modules.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(target: MainChartActivity)
    fun inject(target: MainChartActivityPresenterImpl)
}