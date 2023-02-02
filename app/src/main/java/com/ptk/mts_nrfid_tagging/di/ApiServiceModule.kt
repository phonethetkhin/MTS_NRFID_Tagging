package com.ptk.mts_nrfid_tagging.di

import com.ptk.mts_nrfid_tagging.network.ApiService
import com.ptk.mts_nrfid_tagging.network.ApiServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiServiceModule {

    @Provides
    @Singleton
    fun provideApiService(apiService: ApiServiceImpl): ApiService = apiService

}
