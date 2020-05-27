package com.info448.scoretrackerwithviewmodelspr20.activity_with_viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.observe
import com.info448.scoretrackerwithviewmodelspr20.R
import com.info448.scoretrackerwithviewmodelspr20.ScoreTrackerApp
import com.info448.scoretrackerwithviewmodelspr20.viewmodel.ScoreViewModel
import kotlinx.android.synthetic.main.activity_score.*

class ScoreActivity : AppCompatActivity() {

    private val scoreViewModel: ScoreViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val app = (application as ScoreTrackerApp)

        scoreViewModel.init(app.gameStatsManager, app.apiManager)

        scoreViewModel.score.observe(this) { score ->
            tvScore.text = score.toString()
        }

        scoreViewModel.hasGoodScore.observe(this) { hasGoodScore ->
            tvScoreMsg.visibility = View.VISIBLE
            tvScoreMsg.text = if (hasGoodScore) {
                resources.getText(R.string.good_health_msg)
            } else {
                resources.getText(R.string.bad_health_msg)
            }
            tvScoreMsg.setTextColor(if (hasGoodScore) {
                getColor(R.color.green)
            } else {
                getColor(R.color.red)
            })
        }

        btnPlus.setOnClickListener {
            scoreViewModel.addScore()
        }

        btnMinus.setOnClickListener {
            scoreViewModel.loseScore()
        }
    }
}
