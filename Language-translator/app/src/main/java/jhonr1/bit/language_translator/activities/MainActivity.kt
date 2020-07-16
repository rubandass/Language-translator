package jhonr1.bit.language_translator.activities

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import jhonr1.bit.language_translator.R
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.layout_switch.*

/**
 * After the Splash screen activity, the Main activity is called when opening the app.
 * It has Bottom navigation menu, Drawer menu on top left.
 * Bottom navigation menu items takes you to the corresponding activity.
 * Drawer menu has language settings, Dark theme mode, Exit app.
 */
class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var toolbar: Toolbar
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView

    /**
     * Sets bottom navigation menu, Main layout page, drawer menu when Main activity is called.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        /**
         * Set locale from preference Manager
         */
        val locale = CustomLanguageSettingsAlertDialog(this)
        locale.loadLocale()
        /**
         * Set theme from preference Manager
         */
        val theme = UtilityClass.getTheme(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = findViewById(R.id.toolbarMain)
        setSupportActionBar(toolbar)

        btnGettingStarted.setOnClickListener{
            val settingsGettingStarted = CustomGettingStartedAlertDialog(this)
            settingsGettingStarted.show()
        }
        navView = findViewById(R.id.nav_view)
        UtilityClass.toggleButtonStateSet(navView, theme)

        /**
         * Setting Navigation Drawer to the toolbarMain
         */
        drawerLayout = findViewById(R.id.drawer_layout)
        UtilityClass.setNavDrawerMenu(this,drawerLayout,toolbar)

        navView.setNavigationItemSelectedListener(this)

        /**
         * Setting Bottom navigation item actions
         */
        UtilityClass.bottomNavMenu(this, bottomNavigationViewHome, true)
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
        UtilityClass.toggleDayNight(drawer_switch, delegate, this@MainActivity)
    }

    /**
     * Exit the app when back button pressed
     */
    override fun onBackPressed() {
        val exitAlertDialog = CustomExitAlertDialog(this, this, R.layout.exit_dialog)
        exitAlertDialog.show(resources.getString(R.string.app_name))
    }
}
