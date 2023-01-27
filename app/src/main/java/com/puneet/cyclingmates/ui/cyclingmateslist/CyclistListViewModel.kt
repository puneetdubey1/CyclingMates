package com.puneet.cyclingmates.ui.cyclingmateslist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.puneet.cyclingmates.data.model.Cyclists
import com.puneet.cyclingmates.data.repository.CyclistRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CyclistListViewModel @Inject constructor(private val repository: CyclistRepository) :
    ViewModel() {

    val loading = MutableLiveData<Boolean>()
    val cyclistList = MutableLiveData<List<Cyclists>>()
    val errorMessage = MutableLiveData<String>()

    init {
        callFetchCyclistApi()
    }

    private fun callFetchCyclistApi() {
        loading.value = true
        viewModelScope.launch {
            repository.fetchCyclists(onSuccess = {
                cyclistList.value = it
                loading.value = false
            }, onError = {
                errorMessage.value = it
                loading.value = false
            })
        }
    }
}