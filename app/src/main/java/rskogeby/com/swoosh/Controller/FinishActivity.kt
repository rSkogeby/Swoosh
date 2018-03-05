package rskogeby.com.swoosh.Controller

import android.annotation.SuppressLint
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_finish.*
import rskogeby.com.swoosh.R
import rskogeby.com.swoosh.Utilities.EXTRA_PLAYER
import rskogeby.com.swoosh.model.Player


class FinishActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)
        val player = intent.getParcelableExtra<Player>(EXTRA_PLAYER)

        searchLeagueText.text = "Looking for a ${player.league} ${player.skill} league near you..."
    }
}
