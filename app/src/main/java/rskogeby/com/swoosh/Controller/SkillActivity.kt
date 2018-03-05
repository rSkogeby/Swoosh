package rskogeby.com.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_skill.*
import rskogeby.com.swoosh.Utilities.EXTRA_LEAGUE
import rskogeby.com.swoosh.R

class SkillActivity : BaseActivity() {

    var league = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        league = intent.getStringExtra(EXTRA_LEAGUE)
    }
    fun onBallerClick(view: View) {
        beginnerBtn.isChecked = false
        league="baller"
    }

    fun onBeginnerClick(view: View) {
        ballerBtn.isChecked = false
        league = "beginner"
    }

    fun isToggled(): Boolean {
        return ballerBtn.isChecked || beginnerBtn.isChecked
    }

    fun onSkillFinishClick(view: View) {
        if (league != "" && isToggled()) {
            val skillActivity = Intent(this, SkillActivity::class.java)
            startActivity(skillActivity)
        } else {
            Toast.makeText(this,"Please select a skill level.",Toast.LENGTH_SHORT).show()
        }
    }
}
