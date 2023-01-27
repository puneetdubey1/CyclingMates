package com.puneet.cyclingmates.ui.cyclingmatesdetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.puneet.cyclingmates.data.ext.formattedLocation
import com.puneet.cyclingmates.data.ext.formattedName
import com.puneet.cyclingmates.data.model.Cyclists
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

private const val USER_ARGS_KEY = "cyclist"

@HiltViewModel
class CyclistDetailsViewModel @Inject constructor(savedStateHandle: SavedStateHandle) : ViewModel() {
    private var cyclist: Cyclists = savedStateHandle.get<Cyclists>(USER_ARGS_KEY)!!

    val name = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val location = MutableLiveData<String>()
    val image = MutableLiveData<String>()
    val launchDialpad = MutableLiveData<String>()
    val launchEmail = MutableLiveData<String>()

    init {
        name.value = cyclist.name.formattedName()
        email.value = cyclist.email
        location.value = cyclist.location.formattedLocation()
        image.value = cyclist.picture.large
    }

    fun callButtonClicked() {
        launchDialpad.value = cyclist.phone
    }

    fun emailButtonClicked() {
        launchEmail.value = cyclist.email
    }
}