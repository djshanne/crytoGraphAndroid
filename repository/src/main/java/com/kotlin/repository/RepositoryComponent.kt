package com.kotlin.repository

import com.kotlin.repository.sources.remote.RemoteSource
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RepositoryModule::class])
interface RepositoryComponent {
    fun inject(activity: RemoteSource)
    fun inject(activity: RepositoryImpl)
}