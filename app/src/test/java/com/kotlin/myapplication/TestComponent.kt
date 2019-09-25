package com.kotlin.myapplication

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [TestViewModule::class])
interface TestComponent {
    fun inject(target: AppUnitTest)
}