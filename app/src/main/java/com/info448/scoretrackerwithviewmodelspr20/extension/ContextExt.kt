package com.info448.scoretrackerwithviewmodelspr20.extension

import android.content.Context
import com.info448.scoretrackerwithviewmodelspr20.ScoreTrackerApp

fun Context.getApp(): ScoreTrackerApp {
    val app = (applicationContext as ScoreTrackerApp)
    return app
}