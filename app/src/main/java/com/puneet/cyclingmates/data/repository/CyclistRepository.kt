package com.puneet.cyclingmates.data.repository

import com.puneet.cyclingmates.data.api.EndpointApiCall
import com.puneet.cyclingmates.data.model.Cyclists
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CyclistRepository constructor(private val apiEndpoint: EndpointApiCall) {

    suspend fun fetchCyclists(onSuccess: (List<Cyclists>) -> Unit, onError: (String) -> Unit) {
        try {
            val response = withContext(Dispatchers.IO) { apiEndpoint.fetchCyclists() }
            response.body()?.takeIf { response.isSuccessful }?.let { onSuccess.invoke(it.results) }
                ?: onError.invoke(response.message())
        } catch (e: Exception) {
            onError.invoke(e.localizedMessage)
        }
    }
}