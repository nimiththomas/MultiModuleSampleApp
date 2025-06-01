package com.multimodulesample.network.di

import android.content.Context
import com.multimodulesample.network.utils.ConnectivityManagerNetworkMonitor
import com.picker.core.network.di.restservice.ApiService
import com.picker.core.network.di.utils.NetworkMonitor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    @Provides
    @Singleton
    fun okHttpCallFactory(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor()
                .apply {
                    setLevel(HttpLoggingInterceptor.Level.BODY)
                },
        )
        .build()


//    @Provides
//    fun providesFirebaseAuthInstance(): FirebaseAuth {
//        return Firebase.auth
//    }


//    @Provides
//    fun providesPickerFireBaseDataSource(
//        firebaseAuth: FirebaseAuth
//    ): MultiModuleSampleFireBaseDataSource {
//        return MultiModuleSampleFireBaseDataSource(firebaseAuth)
//    }

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpCallFactory: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://eb.thepicker.co/") // Replace with your base URL
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpCallFactory)
            .build()
    }

    @Provides
    fun providesApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun provideNetworkMonitor(
        @ApplicationContext context: Context
    ): NetworkMonitor {
        return ConnectivityManagerNetworkMonitor(context)
    }


}