package com.puneet.cyclingmates.data.api

import com.puneet.cyclingmates.data.model.CyclistsResponse
import retrofit2.Response
import retrofit2.http.GET

interface EndpointApiCall {
    @GET("api/?results=50")
    suspend fun fetchCyclists(): Response<CyclistsResponse>
}