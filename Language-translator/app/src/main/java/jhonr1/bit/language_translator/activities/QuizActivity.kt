package jhonr1.bit.language_translator.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.Toolbar
import jhonr1.bit.language_translator.R
import jhonr1.bit.language_translator.helpers.Questions
import kotlinx.android.synthetic.main.content_quiz.*
import kotlin.collections.ArrayList

/**
 * It has Bottom navigation menu, quiz questions layout
 * Bottom navigation menu items takes you to the corresponding activity.
 */
class QuizActivity : AppCompatActivity() {

    private var score = 0
    private var index = 0
    private val questionsListEnglish: ArrayList<Questions> = ArrayList()
    private val questionsListFrench: ArrayList<Questions> = ArrayList()
    private val questionsListSpanish: ArrayList<Questions> = ArrayList()
    private val questionsListItalian: ArrayList<Questions> = ArrayList()
    private val questionsListGerman: ArrayList<Questions> = ArrayList()
    lateinit var toolbar: Toolbar
    lateinit var selectedLanguage: String

    /**
     * Sets bottom navigation menu, Quiz layout page when this activity is called.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        selectedLanguage =  intent.getStringExtra("language")
        /**
         * Change the activity title according to the selected quiz language
         */
        title = "${resources.getString(R.string.quiz_header)}-${selectedLanguage}"

        UtilityClass.bottomNavMenu(this, bottomNavigationViewQuiz, true)

        /**
         * Loads the questions based on the selected language when starting the quiz
         */
        when(selectedLanguage){
            "English" ->{
                setupQuestionsEnglish()
                loadQuestion(questionsListEnglish)
                btnAnswer.setOnClickListener(AnswerButtonOnClickHandler(questionsListEnglish))
                btnNext.setOnClickListener(NextButtonOnClickHandler(questionsListEnglish))
            }

            "French" ->{
                setupQuestionsFrench()
                loadQuestion(questionsListFrench)
                btnAnswer.setOnClickListener(AnswerButtonOnClickHandler(questionsListFrench))
                btnNext.setOnClickListener(NextButtonOnClickHandler(questionsListFrench))
            }

            "Spanish" ->{
                setupQuestionsSpanish()
                loadQuestion(questionsListSpanish)
                btnAnswer.setOnClickListener(AnswerButtonOnClickHandler(questionsListSpanish))
                btnNext.setOnClickListener(NextButtonOnClickHandler(questionsListSpanish))
            }

            "Italian" ->{
                setupQuestionsItalian()
                loadQuestion(questionsListItalian)
                btnAnswer.setOnClickListener(AnswerButtonOnClickHandler(questionsListItalian))
                btnNext.setOnClickListener(NextButtonOnClickHandler(questionsListItalian))
            }

            "German" ->{
                setupQuestionsGerman()
                loadQuestion(questionsListGerman)
                btnAnswer.setOnClickListener(AnswerButtonOnClickHandler(questionsListGerman))
                btnNext.setOnClickListener(NextButtonOnClickHandler(questionsListGerman))
            }
        }
    }

    /**
     * calls the Language selection activity and do the transition when back button is pressed
     */
    override fun onBackPressed() {
        startActivity(Intent(this, QuizLanguageSelectionActivity::class.java))
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }

    /**
     * Calls the Quiz activity when back arrow is clicked at the tool bar
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        return super.onOptionsItemSelected(item)
    }

    /**
     * Validates the user's answer and display appropriate color for the right and wrong answers.
     */
    inner class AnswerButtonOnClickHandler(private val questionsList: ArrayList<Questions>): View.OnClickListener{
        override fun onClick(v: View?){
            if (optionsGroup.checkedRadioButtonId == -1) {
                // no radio button is checked
                val validationErrorMessage = resources.getString(R.string.msg_radio_option_selection)
                val validation = CustomValidationAlertDialog(this@QuizActivity, validationErrorMessage)
                validation.show()
            } else {
                // one of the radio button is checked
                val selected = optionsGroup.checkedRadioButtonId
                val chosen = findViewById<RadioButton>(selected)
                if (chosen.text == questionsList[index].correctAns()) {
                    score++
                    chosen.setBackgroundColor(resources.getColor(R.color.colorCorrectAnswer))
                } else {
                    chosen.setBackgroundColor(resources.getColor(R.color.colorWrongAnswer))
                    correctAnswerColor(questionsList)
                }
                btnNext.visibility = View.VISIBLE
                btnAnswer.visibility = View.INVISIBLE
                Toast.makeText(
                    applicationContext,
                    questionsList[index].info(),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    /**
     * Loads the next question, if no questions to load then calls the Score activity.
     */
    inner class NextButtonOnClickHandler(private val questionsList: ArrayList<Questions>): View.OnClickListener{
        override fun onClick(v: View?) {
            optionsGroup.clearCheck()
            clearColor()
            index += 1
            if (index < questionsList.size) {
                loadQuestion(questionsList)
                btnNext.visibility = View.INVISIBLE
                btnAnswer.visibility = View.VISIBLE
            } else {
                val intent = Intent(this@QuizActivity, ScoreActivity::class.java)
                intent.putExtra("results", score)
                intent.putExtra("language", selectedLanguage)
                intent.putExtra("question_size", questionsList.size)
                startActivity(intent)
            }
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
    }

    /**
     * Clears the background color for the radiobutton options before load next question.
     */
    private fun clearColor() {
        val sharedPreferences = getSharedPreferences("Settings", Activity.MODE_PRIVATE)
        val theme = sharedPreferences.getInt("selected_theme", AppCompatDelegate.MODE_NIGHT_NO)
        rdbtnOption1.setBackgroundColor(theme)
        rdbtnOption2.setBackgroundColor(theme)
        rdbtnOption3.setBackgroundColor(theme)
        rdbtnOption4.setBackgroundColor(theme)
    }

    /**
     * Display green color for the correct answer
     */
    private fun correctAnswerColor(questionsArrayList: ArrayList<Questions>) {
        val value1 = rdbtnOption1.text
        val value2 = rdbtnOption2.text
        val value3 = rdbtnOption3.text
        val value4 = rdbtnOption4.text
        val color = resources.getColor(R.color.colorCorrectAnswer)
        if (value1 == questionsArrayList[index].correctAns()) {
            rdbtnOption1.setBackgroundColor(color)
        }
        if (value2 == questionsArrayList[index].correctAns()) {
            rdbtnOption2.setBackgroundColor(color)
        }
        if (value3 == questionsArrayList[index].correctAns()) {
            rdbtnOption3.setBackgroundColor(color)
        }
        if (value4 == questionsArrayList[index].correctAns()) {
            rdbtnOption4.setBackgroundColor(color)
        }
    }

    /**
     * Load question, image and options
     */
    private fun loadQuestion(questionsArrayList: ArrayList<Questions>) {
        txvQuestion.text = questionsArrayList[index].question()
        imageQuestion.setImageResource(questionsArrayList[index].picture())
        rdbtnOption1.text = questionsArrayList[index].option1()
        rdbtnOption2.text = questionsArrayList[index].option2()
        rdbtnOption3.text = questionsArrayList[index].option3()
        rdbtnOption4.text = questionsArrayList[index].option4()
    }

    /**
     * Sets question for English language quiz
     */
    private fun setupQuestionsEnglish() {

        questionsListEnglish.add(
            Questions(
                "Guess the artist",
                R.drawable.earring_jan,
                "Michelangelo",
                "Pablo Picasso",
                "Leonardo da Vinci",
                "Jan Vermeer",
                "Jan Vermeer",
                "Jan Vermeer painted this iconic portraits and is a beautiful example of the Baroque style and the use of light."
            )
        )
        questionsListEnglish.add(
            Questions(
                "Guess the artist",
                R.drawable.field_claude,
                "Claude Monet",
                "Andy Warhol",
                "Rene Magritte",
                "Vincent Van Gogh",
                "Claude Monet",
                "This beautiful pastoral scene encapsulates the essence of how the impressionists captured the beauty and simplicity of nature."
            )
        )

        questionsListEnglish.add(
            Questions(
                "Guess the artist",
                R.drawable.lastsupper_leonardo,
                "Michelangelo",
                "Leonardo da Vinci",
                "Jackson Pollock",
                "Henri Matisse",
                "Leonardo da Vinci",
                "Leonardo da Vinci paints one of the most famous scenes in the Bible – The Last Supper"
            )
        )
        questionsListEnglish.add(
            Questions(
                "Guess the artist",
                R.drawable.monalisa_leonardo,
                "Leonardo da Vinci",
                "Claude Monet",
                "Edvard Munch",
                "Henri Matisse",
                "Leonardo da Vinci",
                "Leonardo da Vinci worked on his masterpiece over a period of 20 years. The enigmatic smile has captured the imagination of the world. "
            )
        )

        questionsListEnglish.add(
            Questions(
                "Guess the artist",
                R.drawable.scream_edward,
                "Picasso",
                "Claude Monet",
                "Edvard Munch",
                "Michelangelo",
                "Edvard Munch",
                "A painting that symbolises the anguish and pain of modern life."
            )
        )

    }

    /**
     * Sets question for French language quiz
     */
    private fun setupQuestionsFrench() {

        questionsListFrench.add(
            Questions(
                "A female deer is known as a __ in french",
                R.drawable.doe,
                "chèvre",
                "vache",
                "Biche",
                "chat",
                "Biche",
                "A female deer is usually called a 'doe'."
            )
        )
        questionsListFrench.add(
            Questions(
                "A baby fox is known as a pup. What's the other name for it?",
                R.drawable.kit_fox,
                "vache",
                "kit renard",
                "lionceau",
                "Renard",
                "kit renard",
                "cat-sized kit fox subspecies has long, delicate ears to radiate heat (and for great hearing)"
            )
        )

        questionsListFrench.add(
            Questions(
                "What is the name of this animal in french?",
                R.drawable.arctic_whale,
                "poisson",
                "requin",
                "tortue",
                "Baleine arctique",
                "Baleine arctique",
                "Whales are the largest animals on Earth and live longer than all other mammals"
            )
        )
        questionsListFrench.add(
            Questions(
                "A group of deer is known as?",
                R.drawable.herd,
                "fierté",
                "troupeau",
                "a conduit",
                "dérive",
                "troupeau",
                "A group of deer is called a herd."
            )
        )

        questionsListFrench.add(
            Questions(
                "What is the name of the animal in french?",
                R.drawable.cheetah,
                "guépard",
                "Renard",
                "chèvre",
                "vache",
                "guépard",
                "Cheetah is the fastest animal on the earth."
            )
        )

    }

    /**
     * Sets question for Spanish language quiz
     */
    private fun setupQuestionsSpanish() {

        questionsListSpanish.add(
            Questions(
                "What is the correct translation for \"telephone\"?",
                R.drawable.telephone,
                "el teléfono",
                "un paraguas",
                "el agua",
                "una bicicleta",
                "el teléfono",
                "contact (someone) using the telephone."
            )
        )
        questionsListSpanish.add(
            Questions(
                "How do you say \"Good morning\"?",
                R.drawable.good_morning,
                "Buenas tardes",
                "Adios",
                "Buenas noches",
                "Buenos días",
                "Buenos días",
                "Expressing good wishes on meeting or parting during the morning."
            )
        )

        questionsListSpanish.add(
            Questions(
                "What is the correct translation for \"Please\"?",
                R.drawable.please,
                "izquierda",
                "Hola",
                "Perdón",
                "Por favor",
                "Por favor",
                "Cause to feel happy and satisfied."
            )
        )
        questionsListSpanish.add(
            Questions(
                "How do you say \"Thank You\"?",
                R.drawable.thankyou,
                "Perdón",
                "derecha",
                "Gracias",
                "Adios",
                "Gracias",
                "express gratitude to (someone), especially by saying \"Thank you\"."
            )
        )

        questionsListSpanish.add(
            Questions(
                "How do you say \"Good-bye\"?",
                R.drawable.goodbye,
                "Adios",
                "Buenas noches",
                "¿Dónde está la playa?",
                "izquierda",
                "Adios",
                "Used to express good wishes when parting or at the end of a conversation"
            )
        )

    }

    /**
     * Sets question for Italian language quiz
     */
    private fun setupQuestionsItalian() {

        questionsListItalian.add(
            Questions(
                "How do you say \"water\"?",
                R.drawable.water,
                "piatto",
                "latte",
                "scodella",
                "acqua",
                "acqua",
                "A colorless, transparent, odorless, tasteless liquid that forms the seas, lakes..."
            )
        )
        questionsListItalian.add(
            Questions(
                "What is the correct translation for \"hospital\"?",
                R.drawable.hospital,
                "aspirina",
                "ospedale",
                "acqua",
                "casa",
                "ospedale",
                "An institution providing medical and surgical treatment and nursing care"
            )
        )

        questionsListItalian.add(
            Questions(
                "What is the correct translation for \"credit card\"?",
                R.drawable.credit_card,
                "libro",
                "busta",
                "carta di credito",
                "giornale",
                "carta di credito",
                "A small plastic card issued by a bank, business, etc., allowing the holder to purchase goods or services on credit"
            )
        )
        questionsListItalian.add(
            Questions(
                "Which word represents this image?",
                R.drawable.key,
                "letto",
                "chiavi",
                "coltello",
                "pane tostato",
                "chiavi",
                "A small piece of shaped metal with incisions cut to fit the wards of a particular lock"
            )
        )

        questionsListItalian.add(
            Questions(
                "Which word represents this image?",
                R.drawable.bicycle,
                "bicicletta",
                "macchina",
                "letto",
                "piatto",
                "bicicletta",
                "A vehicle composed of two wheels held in a frame one behind the other"
            )
        )

    }

    /**
     * Sets question for German language quiz
     */
    private fun setupQuestionsGerman() {

        questionsListGerman.add(
            Questions(
                "How many letters does the german alphabet has?",
                R.drawable.german_letters,
                "26",
                "28",
                "27",
                "24",
                "26",
                "Like English, the German alphabet consists of 26 basic letters."
            )
        )
        questionsListGerman.add(
            Questions(
                "What are the colours of the German flag?",
                R.drawable.german_flag,
                "red, blue and yellow",
                "red, white and yellow",
                "red, brown and yellow",
                "red, black and yellow",
                "red, black and yellow",
                "German's flag: Black at top, Red at middle and Yellow at bottom"
            )
        )

        questionsListGerman.add(
            Questions(
                "What are the countries speak \"German\"?",
                R.drawable.german_speak_country,
                "Germany, Luxemburg, Netherlands",
                "Swizterland, Germany, Austria",
                "Czech Republic, Germany, Austria",
                "Switzerland, Poland, Austria",
                "Swizterland, Germany, Austria",
                "German is the official language of Germany, Austria, Switzerland"
            )
        )
        questionsListGerman.add(
            Questions(
                "Which of the following means \"Good morning.\"?",
                R.drawable.good_morning,
                "Guten Nacht",
                "Guten Abend",
                "Guten Morgen",
                "Guten Tag",
                "Guten Morgen",
                "Expressing good wishes on meeting or parting during the morning"
            )
        )

        questionsListGerman.add(
            Questions(
                "How would you write \"congratulations\"?",
                R.drawable.congratulations,
                "tschüss, auf Wiedersehen",
                "Glückwünsche",
                "Entschuldigung",
                "wirklich",
                "Glückwünsche",
                "Best wishes"
            )
        )

    }

}
