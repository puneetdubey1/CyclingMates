package com.puneet.cyclingmates.ui.cyclingmateslist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.puneet.cyclingmates.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CyclistActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cyclist)
    }
}