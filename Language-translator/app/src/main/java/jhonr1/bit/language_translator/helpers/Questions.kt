package jhonr1.bit.language_translator.helpers

/**
 * Quiz question class. It accepts question, image, answers, correct answer and information.
 * This class is used to create a question object when its being called.
 */
class Questions(
            private val question: String,
            private val picture: Int,
            private val option1: String,
            private val option2: String,
            private val option3: String,
            private val option4: String,
            private val correctAns: String,
            private val info: String
        )
{

    override fun toString(): String {
        return "option1='" + option1 + '\'' +
                ", option2='" + option2 + '\'' +
                ", option3='" + option3 + '\'' +
                ", option4='" + option4 + '\'' +
                ", correctAns='" + correctAns + '\''
    }

    fun question(): String {
        return question
    }

    fun picture(): Int {
        return picture
    }

    fun option1(): String {
        return option1
    }

    fun option2(): String {
        return option2
    }

    fun option3(): String {
        return option3
    }

    fun option4(): String {
        return option4
    }

    fun correctAns(): String {
        return correctAns
    }

    fun info(): String {
        return info
    }

}