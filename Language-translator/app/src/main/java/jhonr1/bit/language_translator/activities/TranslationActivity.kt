package jhonr1.bit.language_translator.activities

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import jhonr1.bit.language_translator.R
import jhonr1.bit.language_translator.enums.DownloadStatus
import jhonr1.bit.language_translator.helpers.LanguageCode
import jhonr1.bit.language_translator.helpers.RawDataAsyncTask
import jhonr1.bit.language_translator.helpers.YandexAsyncTask
import jhonr1.bit.language_translator.interfaces.IDataDownloadAvailable
import jhonr1.bit.language_translator.interfaces.IDataDownloadComplete
import kotlinx.android.synthetic.main.content_translation.*
import kotlinx.android.synthetic.main.layout_switch.*
import java.util.*

/**
 * It has Bottom navigation menu, Drawer menu on top left.
 * Bottom navigation menu items takes you to the corresponding activity.
 * Drawer menu has language settings, Dark theme mode, Exit app.
 */
class TranslationActivity : AppCompatActivity(),IDataDownloadComplete, IDataDownloadAvailable, NavigationView.OnNavigationItemSelectedListener {

    private lateinit var rawDataAsyncTask: RawDataAsyncTask
    private lateinit var mTTS:TextToSpeech
    lateinit var toolbar: Toolbar
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView

    /**
     * Sets bottom navigation menu, translation layout page, drawer menu when Translation activity is called.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_translation)
        toolbar = findViewById(R.id.toolbarTranslation)
        setSupportActionBar(toolbar)

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
        UtilityClass.bottomNavMenu(this, bottomNavigationViewTranslation, true)

        val languages = resources.getStringArray(R.array.languages)
        /**
         * Access languages from the arraylist and populate the dropdown list
         */
        populateSpinner(spnrLanguage, languages)
        /**
         * Translate the text from English to the specified language
         */
        btnTranslate.setOnClickListener{
            if (txvUserInput.text.toString() != "") {
                val langCode = LanguageCode()
                val langFormat = langCode.languageCode(spnrLanguage.selectedItem.toString())
                val url: String = createURI(
                    getString(R.string.base_url),
                    getString(R.string.api_key), txvUserInput.text.toString(), langFormat
                )

                rawDataAsyncTask = RawDataAsyncTask(this, this@TranslationActivity)
                rawDataAsyncTask.execute(url)
            } else{
                val validationErrorMessage = resources.getString(R.string.error_msg_input_text)
                val validation = CustomValidationAlertDialog(this, validationErrorMessage)
                validation.show()
            }
        }

        mTTS = TextToSpeech(applicationContext, TextToSpeech.OnInitListener { status ->
            if (status != TextToSpeech.ERROR){
                mTTS.language = Locale.UK
            }
        })

        /**
         * This method helps to pronounce the translated text.
         */
        btnSpeak.setOnClickListener{
            val toSpeak = txvOutput.text.toString()
            if (toSpeak == ""){
                val validationErrorMessage = resources.getString(R.string.error_msg_speak)
                val validation = CustomValidationAlertDialog(this, validationErrorMessage)
                validation.show()
            }
            else{
                mTTS.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null)
            }
        }
    }

    /**
     * It takes menu item, current activity and the side drawer meny layout as input when an item is selected
     * @param[item] Menu item selected on the left drawer menu as input.
     * @return Boolean value as True.
     */
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        UtilityClass.itemSelectedOnDrawerMenu(item,this@TranslationActivity,this@TranslationActivity, drawerLayout)
        return true
    }

    /**
     * Set the default dayNight mode based on the "Night Mode" ON or OFF, save the current theme mode to preferences
     */
    fun toggleDayNight(view: View){
        UtilityClass.toggleDayNight(drawer_switch, delegate, this@TranslationActivity)
    }

    /**
     * calls the Main activity and do the transition when back button is pressed
     */
    override fun onBackPressed() {
        UtilityClass.transitionHome(this)
    }

    /**
     * @param[baseURL, apiKey, inputText, language] Create url function, which takes base url, apikey, input text, language to translate as parameters.
     * @return String url for translation.
     */
    private fun createURI(
        baseURL: String, apiKey: String, inputText: String, language: String
    ): String{
        return Uri.parse(baseURL)
            .buildUpon()
            .appendQueryParameter("key", apiKey)
            .appendQueryParameter("text", inputText)
            .appendQueryParameter("lang", language)
            .build().toString()
    }

    /**
     * Fill languages in drop down list
     */
    private fun populateSpinner(spinner: Spinner, array: Array<String>){
        val layoutID: Int = android.R.layout.simple_spinner_item
        spinner.adapter = ArrayAdapter(this@TranslationActivity, layoutID, array)
    }

    /**
     * Hide beyboard after exiting edit text field
     */
    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (currentFocus != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }
        return super.dispatchTouchEvent(ev)
    }

    /**
     * Get result from AsyncTask
     */
    override fun onDownloadComplete(data: String, status: DownloadStatus) {
        if (status == DownloadStatus.OK) {
            val yandexAsyncTask = YandexAsyncTask(this)
            yandexAsyncTask.execute(data)
        }
    }

    /**
     *Set translated text to output text field
     */
    override fun onDataAvailable(data: String) {
        txvOutput.text = data
    }

    override fun onError(e: Exception) {
    }

}
