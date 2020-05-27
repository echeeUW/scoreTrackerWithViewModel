package com.info448.scoretrackerwithviewmodelspr20.activity_with_viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.info448.scoretrackerwithviewmodelspr20.R
import com.info448.scoretrackerwithviewmodelspr20.ScoreTrackerApp
import kotlinx.android.synthetic.main.activity_account_info.*

class AccountInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_info)

        val userInfoManager = (application as ScoreTrackerApp).gameStatsManager
        val gameStatsManager = (application as ScoreTrackerApp).gameStatsManager

//        btnSignOut.setOnClickListener {
//            userInfoManager.signOut()
//            if (numberOfUsers > 0 ) {
//                gameStatsManager.reset()
//            }
//            finish()
//
//        }
    }
}
