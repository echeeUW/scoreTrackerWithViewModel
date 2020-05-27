package com.info448.scoretrackerwithviewmodelspr20.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe

import com.info448.scoretrackerwithviewmodelspr20.R
import com.info448.scoretrackerwithviewmodelspr20.extension.getApp
import com.info448.scoretrackerwithviewmodelspr20.extension.getFirstAndLastCharacters
import com.info448.scoretrackerwithviewmodelspr20.viewmodel.ScoreViewModel
import kotlinx.android.synthetic.main.fragment_plus_minus.*

class PlusMinusFragment : Fragment() {

    private val scoreViewModel: ScoreViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val app = context.getApp()
        scoreViewModel.init(app.gameStatsManager, app.apiManager)

        val firstAndLast = "Eric Cheezit".getFirstAndLastCharacters()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_plus_minus, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        scoreViewModel.score.observe(viewLifecycleOwner) { score ->
            tvMiniScore.text = score.toString()
        }

        btnPlus.setOnClickListener {
            scoreViewModel.addScore()
        }

        btnMinus.setOnClickListener {
            scoreViewModel.loseScore()
        }
    }


}
