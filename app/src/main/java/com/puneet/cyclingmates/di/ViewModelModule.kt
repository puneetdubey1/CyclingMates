package com.puneet.cyclingmates.di

import com.puneet.cyclingmates.data.api.EndpointApiCall
import com.puneet.cyclingmates.data.repository.CyclistRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {

    @Provides
    fun provideCyclistRepository(apiEndpoint: EndpointApiCall) = CyclistRepository(apiEndpoint)
}