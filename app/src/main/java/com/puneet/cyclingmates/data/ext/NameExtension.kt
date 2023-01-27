package com.puneet.cyclingmates.data.ext

import com.puneet.cyclingmates.data.model.Name

fun Name.formattedName() = "${this.title} ${this.first} ${this.last}"
