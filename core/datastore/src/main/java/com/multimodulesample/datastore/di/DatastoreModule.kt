package com.picker.core.datastore.di

import android.content.Context
import com.multimodulesample.datastore.MultiModuleSampleDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatastoreModule {

    @Provides
    @Singleton
    fun providesDatastore(@ApplicationContext context: Context): MultiModuleSampleDataStore {
        return MultiModuleSampleDataStore(context)
    }
}