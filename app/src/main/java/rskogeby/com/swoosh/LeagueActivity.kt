package rskogeby.com.swoosh

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var selectedLeague = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    fun onMensClicked(view: View) {
        womensLeagueBtn.isChecked = false
        coedLeagueBtn.isChecked = false

        selectedLeague = "mens"
    }

    fun onWomensClicked(view: View) {
        mensLeaguebtn.isChecked = false
        coedLeagueBtn.isChecked = false

        selectedLeague = "womens"
    }

    fun onCoedClicked(view: View) {
        mensLeaguebtn.isChecked = false
        womensLeagueBtn.isChecked = false

        selectedLeague = "coed"
    }

    fun isToggled(): Boolean {
        return mensLeaguebtn.isChecked || womensLeagueBtn.isChecked || coedLeagueBtn.isChecked
    }

    fun buttonLeagueNEXT(view: View) {
        if(selectedLeague != "" && isToggled()) {
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_LEAGUE, selectedLeague)
            startActivity(skillActivity)
        } else {
            Toast.makeText(this,"Please select a league.", Toast.LENGTH_SHORT).show()

        }
    }





}
