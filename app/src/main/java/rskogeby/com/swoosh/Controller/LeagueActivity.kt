package rskogeby.com.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_league.*
import rskogeby.com.swoosh.R
import rskogeby.com.swoosh.Utilities.EXTRA_PLAYER
import rskogeby.com.swoosh.model.Player

class LeagueActivity : BaseActivity() {

    var player = Player("","")

    // Save instance state when turning screen
    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER,player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null) {
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)
        }
    }

    fun onMensClicked(view: View) {
        womensLeagueBtn.isChecked = false
        coedLeagueBtn.isChecked = false

        player.league = "mens"
    }

    fun onWomensClicked(view: View) {
        mensLeaguebtn.isChecked = false
        coedLeagueBtn.isChecked = false

        player.league = "womens"
    }

    fun onCoedClicked(view: View) {
        mensLeaguebtn.isChecked = false
        womensLeagueBtn.isChecked = false

        player.league = "coed"
    }

    fun isToggled(): Boolean {
        return mensLeaguebtn.isChecked || womensLeagueBtn.isChecked || coedLeagueBtn.isChecked
    }

    fun buttonLeagueNEXT(view: View) {
        if(player.league != "" && isToggled()) {
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_PLAYER,player)
            startActivity(skillActivity)
        } else {
            Toast.makeText(this,"Please select a league.", Toast.LENGTH_SHORT).show()

        }
    }





}
