package com.kotlin.myapplication.componets

import com.kotlin.myapplication.MainChartActivity
import com.kotlin.myapplication.MainChartActivityPresenterImpl
import com.kotlin.myapplication.modules.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(target: MainChartActivity)
    fun inject(target: MainChartActivityPresenterImpl)
}