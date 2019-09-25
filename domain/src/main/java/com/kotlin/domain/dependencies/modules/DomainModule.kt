package com.kotlin.domain.dependencies.modules

import com.kotlin.repository.Repository
import com.kotlin.repository.RepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule {

    @Provides
    @Singleton
    fun provideRepository(): Repository {
        return RepositoryImpl()
    }
}