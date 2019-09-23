package com.kotlin.repository.components

import com.kotlin.repository.RepositoryImpl
import com.kotlin.repository.modules.RepositoryModule
import com.kotlin.repository.sources.remote.RemoteSource
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RepositoryModule::class])
interface RepositoryComponent {
    fun inject(target: RemoteSource)
    fun inject(target: RepositoryImpl)
}