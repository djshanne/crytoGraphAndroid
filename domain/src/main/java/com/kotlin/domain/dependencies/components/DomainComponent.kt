package com.kotlin.domain.dependencies.components

import com.kotlin.domain.ChartDataHandler
import com.kotlin.domain.dependencies.modules.DomainModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DomainModule::class])
interface DomainComponent {
    fun inject(target: ChartDataHandler)
}