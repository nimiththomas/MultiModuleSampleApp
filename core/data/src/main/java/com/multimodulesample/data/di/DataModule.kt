package com.multimodulesample.data.di

import com.multimodulesample.data.DataStoreRepository
import com.multimodulesample.data.Feature1Repository
import com.multimodulesample.data.Feature2Repository
import com.multimodulesample.data.data.DataStoreRepositoryImpl
import com.multimodulesample.data.data.Feature1RepositoryImpl
import com.multimodulesample.data.data.Feature2RepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
abstract class DataModule {
    @Binds
    @Singleton
    abstract fun provideDataStoreRepository(
        dataStoreRepositoryImpl: DataStoreRepositoryImpl
    ): DataStoreRepository

    @Binds
    @Singleton
    abstract fun provideFeature1Repository(
        feature1RepositoryImpl: Feature1RepositoryImpl
    ): Feature1Repository

    @Binds
    @Singleton
    abstract fun provideFeature2Repository(
        feature2RepositoryImpl: Feature2RepositoryImpl
    ): Feature2Repository

}