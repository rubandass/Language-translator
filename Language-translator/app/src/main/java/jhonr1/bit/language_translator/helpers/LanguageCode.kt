package jhonr1.bit.language_translator.helpers

/**
 * Returns language code for the given language
 */
class LanguageCode {
    fun languageCode(lang: String): String{
        return when(lang) {
            "Spanish" -> "en-es"
            "French" -> "en-fr"
            "Italian" -> "en-it"
            "German" -> "en-de"
            else -> "en-en"
        }
    }
}