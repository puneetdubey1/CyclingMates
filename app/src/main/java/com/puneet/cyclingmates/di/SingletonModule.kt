package com.puneet.cyclingmates.di

import com.google.gson.Gson
import com.puneet.cyclingmates.BuildConfig
import com.puneet.cyclingmates.data.api.ServiceClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object SingletonModule {

    @Provides
    fun provideServiceClient()= ServiceClient(BuildConfig.BASE_API_URL, Gson())

    @Provides
    fun provideApiEndpoint(serviceClient: ServiceClient) = serviceClient.getRestService()
}