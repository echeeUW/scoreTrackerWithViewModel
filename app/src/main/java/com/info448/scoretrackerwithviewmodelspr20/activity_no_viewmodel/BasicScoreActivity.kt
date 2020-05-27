package com.info448.scoretrackerwithviewmodelspr20.activity_no_viewmodel

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.info448.scoretrackerwithviewmodelspr20.R
import com.info448.scoretrackerwithviewmodelspr20.activity_with_viewmodel.ScoreActivity
import com.info448.scoretrackerwithviewmodelspr20.extension.getApp
import com.info448.scoretrackerwithviewmodelspr20.manager.GameStatsManager
import kotlinx.android.synthetic.main.activity_basic_score.*

class BasicScoreActivity : AppCompatActivity() {

    private var score = 80
    private lateinit var gameStatsManager: GameStatsManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_score)

        tvScore.text = "$score"
        tvScoreMsg.visibility = View.GONE

//        gameStatsManager = (application as ScoreTrackerApp).gameStatsManager
//        val app = AppUtil.getApp(this)
        val app = getApp()


        btnPlus.setOnClickListener {
            score += 10
            tvScore.text = "$score"
            tvScoreMsg.visibility = View.VISIBLE

            if (score >= 70) {
                tvScoreMsg.text = resources.getText(R.string.good_health_msg)
                tvScoreMsg.setTextColor(ContextCompat.getColor(this, R.color.green))
            } else {
                tvScoreMsg.text = resources.getText(R.string.bad_health_msg)
                tvScoreMsg.setTextColor(ContextCompat.getColor(this, R.color.red))
            }
        }

        btnMinus.setOnClickListener {

            tvScore.text = "$score"


            if (score >= 70) {
                tvScoreMsg.text = resources.getText(R.string.good_health_msg)
                tvScoreMsg.setTextColor(ContextCompat.getColor(this, R.color.green))
            } else {
                tvScoreMsg.text = resources.getText(R.string.bad_health_msg)
                tvScoreMsg.setTextColor(ContextCompat.getColor(this, R.color.red))

                if (score < 0) {
                    gameStatsManager.died()
                }

            }
        }


    }

}
