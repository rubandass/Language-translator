package jhonr1.bit.language_translator.activities

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import jhonr1.bit.language_translator.R
import kotlinx.android.synthetic.main.content_quiz_language_selection.*
import kotlinx.android.synthetic.main.content_quiz_language_selection.spnrLanguage
import kotlinx.android.synthetic.main.layout_switch.*

/**
 * It has Bottom navigation menu, Drawer menu on top left.
 * Bottom navigation menu items takes you to the corresponding activity.
 * Drawer menu has language settings, Dark theme mode, Exit app.
 */
class QuizLanguageSelectionActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var toolbar: Toolbar
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView
    /**
     * Sets bottom navigation menu, Quiz language selection layout page, drawer menu when this activity is called.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_language_selection)
        toolbar = findViewById(R.id.toolbarQuizLanguageSelection)
        setSupportActionBar(toolbarQuizLanguageSelection)

        val locale = CustomLanguageSettingsAlertDialog(this)
        locale.loadLocale()

        val theme = UtilityClass.getTheme(this)

        navView = findViewById(R.id.nav_view)
        UtilityClass.toggleButtonStateSet(navView, theme)
        drawerLayout = findViewById(R.id.drawer_layout)
        UtilityClass.setNavDrawerMenu(this,drawerLayout,toolbar)
        navView.setNavigationItemSelectedListener(this)

        UtilityClass.bottomNavMenu(this, bottomNavigationViewQuizLanguageSelection, false)

        val languagesList = resources.getStringArray(R.array.languages)
        /**
         * Access languages from the list and add "English" with that
         */
        val newLanguagesList = languagesList.plus("English")
        populateSpinner(spnrLanguage, newLanguagesList)

        /**
         * Calls quiz activity
         */
        btnStartQuiz.setOnClickListener{
            val intent = Intent(this@QuizLanguageSelectionActivity, QuizActivity::class.java)
            intent.putExtra("language", spnrLanguage.selectedItem.toString())
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
    }

    /**
     * It takes menu item, current activity and the side drawer meny layout as input when an item is selected
     * @param[item] Menu item selected on the left drawer menu as input.
     * @return Boolean value as True.
     */
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        UtilityClass.itemSelectedOnDrawerMenu(item,this@QuizLanguageSelectionActivity,this@QuizLanguageSelectionActivity, drawerLayout)
        return true
    }

    /**
     * Set the default dayNight mode based on the "Night Mode" ON or OFF, save the current theme mode to preferences
     */
    fun toggleDayNight(view: View){
        UtilityClass.toggleDayNight(drawer_switch, delegate, this@QuizLanguageSelectionActivity)
    }

    /**
     * calls the Main activity and do the transition when back button pressed
     */
    override fun onBackPressed() {
        UtilityClass.transitionHome(this)
    }

    /**
     * Fills languages in drop down list
     */
    private fun populateSpinner(spinner: Spinner, array: Array<String>){
        val layoutID: Int = android.R.layout.simple_spinner_item
        spinner.adapter = ArrayAdapter(this@QuizLanguageSelectionActivity, layoutID, array)
    }
}
