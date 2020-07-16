package jhonr1.bit.language_translator.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import jhonr1.bit.language_translator.R
import kotlinx.android.synthetic.main.content_score.*
import kotlinx.android.synthetic.main.layout_switch.*

/**
 * It has Bottom navigation menu, Drawer menu on top left.
 * Bottom navigation menu item takes you to the corresponding activity.
 * Drawer menu has language settings, Dark theme mode, Exit app.
 */
class ScoreActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener  {

    private var currentScore = 0
    lateinit var toolbar: Toolbar
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView

    /**
     * Sets bottom navigation menu, score layout page, drawer menu when this activity is called.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)
        toolbar = findViewById(R.id.toolbarScore)
        setSupportActionBar(toolbarScore)

        val selectedLanguage = intent.getStringExtra("language")
        currentScore = intent.getIntExtra("results", 0)
//      Change the activity title according to the selected language for the quiz
        title = "${resources.getString(R.string.quiz_score_header)}-${selectedLanguage}"
        val locale = CustomLanguageSettingsAlertDialog(this)
        locale.loadLocale()

        val theme = UtilityClass.getTheme(this)

        navView = findViewById(R.id.nav_view)
        UtilityClass.toggleButtonStateSet(navView, theme)
        drawerLayout = findViewById(R.id.drawer_layout)
        UtilityClass.setNavDrawerMenu(this,drawerLayout,toolbar)
        navView.setNavigationItemSelectedListener(this)

        /**
         * Setting Bottom navigation item actions
         */
        UtilityClass.bottomNavMenu(this, bottomNavigationViewScore, true)

        /**
         * Highest score is calculated based on the language selected for quiz
         */
        when(selectedLanguage){
            "English" -> {
                scoreCalculation(currentScore, "en_score", "en_highest_score")
            }

            "French" -> {
                scoreCalculation(currentScore, "fr_score", "fr_highest_score")
            }

            "Spanish" -> {
                scoreCalculation(currentScore, "es_score", "es_highest_score")
            }

            "Italian" -> {
                scoreCalculation(currentScore, "it_score", "it_highest_score")
            }

            "German" -> {
                scoreCalculation(currentScore, "de_score", "de_highest_score")
            }
        }

        btnPlayAgain.setOnClickListener{
            val intent = Intent(this@ScoreActivity, QuizLanguageSelectionActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }
    }

    /**
     * It takes menu item, current activity and the side drawer meny layout as input when an item is selected
     * @param[item] Menu item selected on the left drawer menu as input.
     * @return Boolean value as True.
     */
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        UtilityClass.itemSelectedOnDrawerMenu(item,this,this, drawerLayout)
        return true
    }
    /**
     * Set the default dayNight mode based on the "Night Mode" ON or OFF, save the current theme mode to preferences
     */
    fun toggleDayNight(view: View){
        UtilityClass.toggleDayNight(drawer_switch, delegate, this)
    }

    /**
     * Highest score, current score is calculated based on the language selected for quiz
     */
    private fun scoreCalculation(currentScore: Int, prefName: String, prefKey: String){
        val scoreString = resources.getString(R.string.your_score)
        val questionSize = intent.getIntExtra("question_size", 0)
        val highestScoreString = resources.getString(R.string.highest_score)
        txvScore.text = "${scoreString} ${currentScore}/${questionSize}"
        //Get the score from shared preferences
        val scoreSharedPref = getSharedPreferences(prefName, Activity.MODE_PRIVATE).getInt(prefKey, 0)
        //Save the highest score to shared preferences
        val editor = getSharedPreferences(prefName, Activity.MODE_PRIVATE).edit()

        if(currentScore > scoreSharedPref){
            editor.putInt(prefKey, currentScore)
            editor.apply()
            txvHighestScore.text = "${highestScoreString} ${currentScore}"
        } else{
            txvHighestScore.text = "${highestScoreString} ${scoreSharedPref}"
        }
    }

    /**
     * calls the Main activity and do the transition when back button is pressed
     */
    override fun onBackPressed() {
        val intent = Intent(this@ScoreActivity, QuizLanguageSelectionActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}
