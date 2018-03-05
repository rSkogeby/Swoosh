package rskogeby.com.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_skill.*
import rskogeby.com.swoosh.R
import rskogeby.com.swoosh.Utilities.EXTRA_PLAYER
import rskogeby.com.swoosh.model.Player

class SkillActivity : BaseActivity() {

    lateinit var player : Player

    // Save instance state when turning screen
    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER,player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        player = intent.getParcelableExtra(EXTRA_PLAYER)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null) {
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)
        }
    }

    fun onBallerClick(view: View) {
        beginnerBtn.isChecked = false
        player.skill="baller"
    }

    fun onBeginnerClick(view: View) {
        ballerBtn.isChecked = false
        player.skill = "beginner"
    }

    fun isToggled(): Boolean {
        return ballerBtn.isChecked || beginnerBtn.isChecked
    }

    fun onSkillFinishClick(view: View) {
        if (player.skill != "" && isToggled()) {
            val lastActivity = Intent(this, FinishActivity::class.java)
            lastActivity.putExtra(EXTRA_PLAYER,player)
            startActivity(lastActivity)
        } else {
            Toast.makeText(this,"Please select a skill level.",Toast.LENGTH_SHORT).show()
        }
    }
}
