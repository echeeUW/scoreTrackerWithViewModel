package com.info448.scoretrackerwithviewmodelspr20

import android.app.Application
import com.info448.scoretrackerwithviewmodelspr20.manager.ApiManager
import com.info448.scoretrackerwithviewmodelspr20.manager.GameStatsManager

class ScoreTrackerApp: Application() {

    lateinit var gameStatsManager: GameStatsManager
        private set

    lateinit var apiManager: ApiManager
        private set

    override fun onCreate() {
        super.onCreate()
        gameStatsManager = GameStatsManager()
        apiManager = ApiManager()
    }
}

