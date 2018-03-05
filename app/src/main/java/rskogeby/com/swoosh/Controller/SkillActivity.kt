package rskogeby.com.swoosh.Controller

import android.os.Bundle
import rskogeby.com.swoosh.Utilities.EXTRA_LEAGUE
import rskogeby.com.swoosh.R

class SkillActivity : BaseActivity() {

    var league = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        league = intent.getStringExtra(EXTRA_LEAGUE)
    }
}
