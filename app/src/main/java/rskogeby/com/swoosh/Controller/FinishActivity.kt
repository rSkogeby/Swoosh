package rskogeby.com.swoosh.Controller

import android.annotation.SuppressLint
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_finish.*
import rskogeby.com.swoosh.R
import rskogeby.com.swoosh.Utilities.EXTRA_LEAGUE
import rskogeby.com.swoosh.Utilities.EXTRA_SKILL

class FinishActivity : BaseActivity() {

    var league = ""
    var skill = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)
        league = intent.getStringExtra(EXTRA_LEAGUE)
        skill = intent.getStringExtra(EXTRA_SKILL)

        searchLeagueText.text = "Looking for a $league $skill league near you..."
    }
}
