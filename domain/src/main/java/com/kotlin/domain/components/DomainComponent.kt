package com.kotlin.domain.components

import com.kotlin.domain.ChartDataHandler
import com.kotlin.domain.modules.DomainModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DomainModule::class])
interface DomainComponent {
    fun inject(activity: ChartDataHandler)
}