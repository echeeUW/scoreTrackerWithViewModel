package com.info448.scoretrackerwithviewmodelspr20.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.info448.scoretrackerwithviewmodelspr20.manager.ApiManager
import com.info448.scoretrackerwithviewmodelspr20.manager.GameStatsManager

class ScoreViewModel: ViewModel() {

    var score = MutableLiveData<Int>(INIT_SCORE_VALUE)
    val hasGoodScore = MutableLiveData<Boolean>(true)
//    val listOfUseras = MutableLiveData<List<User>>()

    lateinit var gameStatsManager: GameStatsManager
    lateinit var apiManager: ApiManager

    companion object {
        private const val INIT_SCORE_VALUE = 80
    }

    fun init(gameStatsManager: GameStatsManager, apiManager: ApiManager) {
        this.gameStatsManager = gameStatsManager
        this.apiManager = apiManager
    }

    fun addScore() {
        score.value?.let {  currentScore ->
            score.value = currentScore+10

            hasGoodScore.value = hasGoodScore(currentScore)
        }
    }

    fun loseScore() {

        score.value?.let { currentScore ->
            score.value = currentScore -15

            hasGoodScore.value = hasGoodScore(currentScore)

            if (currentScore < 0) {
                gameStatsManager.died()
            }
        }
    }

    private fun hasGoodScore(score: Int): Boolean {
        return score >= 70
    }

    //    fun refreshUsers() {
//        apiManager.fetchAllUsers() { users ->
//            listOfUseras.value = users
//        }
//    }
}