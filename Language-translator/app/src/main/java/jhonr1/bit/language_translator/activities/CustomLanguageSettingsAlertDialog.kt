package jhonr1.bit.language_translator.activities

import android.app.Activity
import android.content.res.Configuration
import android.content.res.Resources
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import jhonr1.bit.language_translator.R
import java.util.*

/**
 * Language setting class
 */
class CustomLanguageSettingsAlertDialog(private val activity: Activity) : DialogFragment(){

    private lateinit var alertDialog: AlertDialog
    private val builder = AlertDialog.Builder(activity)

    /**
     * Shows dialog with languages as options
     */
    fun show(title: String){
        val res: Resources = activity.resources
        val languagesList = res.getStringArray(R.array.languages)
        val newLanguagesList = languagesList.plus("English")
        builder.setTitle(title)
        builder.setIcon(R.drawable.translator_logo)
        builder.setCancelable(true)

        val sharedPreferences = activity.getSharedPreferences("Settings", Activity.MODE_PRIVATE)
        val selectedLanguage = when(sharedPreferences.getString("selected_lang","en")){
            "fr"-> 0
            "es"-> 1
            "it"-> 2
            "de"-> 3
            "en"-> 4
            else-> -1
        }

        builder.setSingleChoiceItems(newLanguagesList, selectedLanguage){ dialog, i ->

            when (i) {
                0 -> {
                    setLocale("fr")
                    activity.recreate()
                }
                1 -> {
                    setLocale("es")
                    activity.recreate()
                }
                2 -> {
                    setLocale("it")
                    activity.recreate()
                }
                3 -> {
                    setLocale("de")
                    activity.recreate()
                }
                4 -> {
                    setLocale("en")
                    activity.recreate()
                }
                else -> {
                    setLocale("en")
                    activity.recreate()
                }
            }
            dialog.dismiss()
        }
        builder.setNegativeButton(R.string.language_change_cancel) { dialog, _ -> dialog.cancel()
        }
        alertDialog = builder.setView(view).create()
        builder.show()
    }

    /**
     * Set the selected language to the app and save to preferences
     */
    private fun setLocale(lang: String) {
        val locale = Locale(lang)
        Locale.setDefault(locale)

        val config = Configuration()
        config.locale = locale
        activity.resources.updateConfiguration(config, activity.resources.displayMetrics)

        //Save the language to shared preferences
        val editor = activity.getSharedPreferences("Settings", Activity.MODE_PRIVATE).edit()
        editor.putString("selected_lang", lang)
        editor.apply()
    }

    /**
     * load the language from shared preferences
     */
    fun loadLocale(){
        val sharedPreferences = activity.getSharedPreferences("Settings", Activity.MODE_PRIVATE)
        val language = sharedPreferences.getString("selected_lang","en")
        setLocale(language.toString())
    }

}