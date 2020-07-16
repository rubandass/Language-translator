package jhonr1.bit.language_translator.activities

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.MenuItem
import android.view.View
import android.widget.Switch
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import jhonr1.bit.language_translator.R

/**
 * Utility class contains bottom navigation menu creation, drawer menu creation and its actions
 */
class UtilityClass {

    companion object{

        private var slideStatus = false
        private var selfStatusHome = true
        private var selfStatusTranslation = false
        private var selfStatusQuiz = true

        /**
         * Load the background theme
         */
        fun getTheme(activity: Activity): Int{
            val sharedPreferences = activity.getSharedPreferences("Settings", Activity.MODE_PRIVATE)
            val theme = sharedPreferences.getInt("selected_theme", AppCompatDelegate.MODE_NIGHT_NO)
            AppCompatDelegate.setDefaultNightMode(theme)
            return theme
        }

        /**
         * Retrieves the Dark mode ON /OFF switch status
         */
        fun toggleButtonStateSet(
            navView: NavigationView,
            theme: Int
        ){
            val menuItem: MenuItem = navView.menu.findItem(R.id.switchToggleButton) // This is the menu item that contains switch icon
            val switch = menuItem.actionView.findViewById<View>(R.id.drawer_switch) as Switch
        // Setting switch button state
            if(theme == AppCompatDelegate.MODE_NIGHT_YES){
                switch.isChecked = true
            }
        }

        /**
         * Adding drawer menu to the activity layout
         */
        fun setNavDrawerMenu(activity: Activity,drawerLayout: DrawerLayout, toolbar: Toolbar){
            val toggle = ActionBarDrawerToggle(
                activity, drawerLayout, toolbar, 0, 0
            )
            drawerLayout.addDrawerListener(toggle)
            toggle.syncState()
        }

        /**
         * Contains actions of the drawer menu
         */
        fun itemSelectedOnDrawerMenu(item: MenuItem, context: Context, activity: Activity, drawerLayout: DrawerLayout){
            when (item.itemId) {
                R.id.action_about -> {
                    val aboutUsAlertDialog = CustomAboutUsAlertDialog(activity)
                    aboutUsAlertDialog.show()
                }

                R.id.action_settings -> {
                    val settingsAlertDialog = CustomLanguageSettingsAlertDialog(activity)
                    settingsAlertDialog.show(context.getString(R.string.language_change_title))
                }

                R.id.action_exit -> {
                    val exitAlertDialog = CustomExitAlertDialog(context, activity, R.layout.exit_dialog)
                    exitAlertDialog.show(context.getString(R.string.app_name))
                }
            }
            drawerLayout.closeDrawer(GravityCompat.START)
        }

        /**
         * Contains logic for the bottom navigation menu items
         */
        fun bottomNavMenu(activity: Activity, bottomNavView: BottomNavigationView, quizLangSelectCallable: Boolean){
            if (quizLangSelectCallable){
                selfStatusQuiz = false
            }
//            Setting Bottom navigation item actions
            bottomNavView.setOnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.navigation_home -> {
                        if(!selfStatusHome){
                            transitionHome(activity)
                        }
                    }

                    R.id.navigation_translation -> {
                        if(!selfStatusTranslation) {
                            transitionTranslate(activity)
                        }
                    }

                    R.id.navigation_quiz -> {
                        if (!selfStatusQuiz) {
                            transitionQuiz(activity)
                        }
                    }
                }
                false
            }
        }

        /**
         * Calls the Main activity with sliding animation
         */
        fun transitionHome(activity: Activity){
            selfStatusHome = true
            selfStatusTranslation = false
            selfStatusQuiz = false
            slideStatus = false
            val intent = Intent(activity, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            activity.startActivity(intent)
            activity.finish()
            activity.overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }

        /**
         * Calls the Translation activity with sliding animation
         */
        private fun transitionTranslate(activity: Activity){
            selfStatusTranslation = true
            selfStatusHome = false
            selfStatusQuiz = false

            val intent = Intent(activity, TranslationActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            activity.startActivity(intent)
            activity.finish()
            if (slideStatus) {
                activity.overridePendingTransition(
                    R.anim.slide_in_left,
                    R.anim.slide_out_right
                )
            } else {
                activity.overridePendingTransition(
                    R.anim.slide_in_right,
                    R.anim.slide_out_left
                )
            }
        }

        /**
         * Calls the Quiz activity with sliding animation
         */
        private fun transitionQuiz(activity: Activity){
            slideStatus = true
            selfStatusQuiz = true
            selfStatusHome = false
            selfStatusTranslation = false
            val intent = Intent(activity, QuizLanguageSelectionActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            activity.startActivity(intent)
            activity.finish()
            if (activity::class == QuizActivity::class || activity::class == ScoreActivity::class){
                activity.overridePendingTransition(
                    R.anim.slide_in_left,
                    R.anim.slide_out_right
                )
            }
            else {
                activity.overridePendingTransition(
                    R.anim.slide_in_right,
                    R.anim.slide_out_left
                )
            }
        }

        /**
         * Set the default dayNight mode based on the "Night Mode" ON or OFF, save the current theme mode to preferences
         */
        fun toggleDayNight(
            drawer_switch: Switch,
            delegate: AppCompatDelegate,
            activity: Activity
        ) {
            val mDayNightMode =
                if (drawer_switch.isChecked) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO
            AppCompatDelegate.setDefaultNightMode(mDayNightMode)
            delegate.applyDayNight()

            val editor = activity.getSharedPreferences("Settings", Activity.MODE_PRIVATE).edit()
            editor.putInt("selected_theme", mDayNightMode)
            editor.apply()
        }
    }
}