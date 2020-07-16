[app](../../index.md) / [jhonr1.bit.language_translator.activities](../index.md) / [QuizActivity](./index.md)

# QuizActivity

`class QuizActivity : AppCompatActivity`

It has Bottom navigation menu, quiz questions layout
Bottom navigation menu items takes you to the corresponding activity.

### Types

| Name | Summary |
|---|---|
| [AnswerButtonOnClickHandler](-answer-button-on-click-handler/index.md) | `inner class AnswerButtonOnClickHandler : `[`OnClickListener`](https://developer.android.com/reference/android/view/View/OnClickListener.html)<br>Validates the user's answer and display appropriate color for the right and wrong answers. |
| [NextButtonOnClickHandler](-next-button-on-click-handler/index.md) | `inner class NextButtonOnClickHandler : `[`OnClickListener`](https://developer.android.com/reference/android/view/View/OnClickListener.html)<br>Loads the next question, if no questions to load then calls the Score activity. |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `QuizActivity()`<br>It has Bottom navigation menu, quiz questions layout Bottom navigation menu items takes you to the corresponding activity. |

### Properties

| Name | Summary |
|---|---|
| [selectedLanguage](selected-language.md) | `lateinit var selectedLanguage: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [toolbar](toolbar.md) | `lateinit var toolbar: Toolbar` |

### Functions

| Name | Summary |
|---|---|
| [onBackPressed](on-back-pressed.md) | `fun onBackPressed(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>calls the Language selection activity and do the transition when back button is pressed |
| [onCreate](on-create.md) | `fun onCreate(savedInstanceState: `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Sets bottom navigation menu, Quiz layout page when this activity is called. |
| [onOptionsItemSelected](on-options-item-selected.md) | `fun onOptionsItemSelected(item: `[`MenuItem`](https://developer.android.com/reference/android/view/MenuItem.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Calls the Quiz activity when back arrow is clicked at the tool bar |
