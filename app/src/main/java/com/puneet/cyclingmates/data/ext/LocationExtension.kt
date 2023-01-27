package com.puneet.cyclingmates.data.ext

import com.puneet.cyclingmates.data.model.Location


fun Location.formattedLocation() = "${this.city}, ${this.country}"
