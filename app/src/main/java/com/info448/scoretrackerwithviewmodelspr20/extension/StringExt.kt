package com.info448.scoretrackerwithviewmodelspr20.extension

import android.app.Application
import android.content.Context

fun String.getFirstAndLastCharacters() : String? {


    return if (this.isNotEmpty()) {
        val firstChar = get(0)
        val lastChar = get(1)
        "$firstChar - $lastChar"
    } else {
        null
    }
}

fun String.getCountDivideBy2() = length / 2