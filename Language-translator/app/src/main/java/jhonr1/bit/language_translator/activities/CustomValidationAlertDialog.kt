package jhonr1.bit.language_translator.activities

import android.content.Context
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import jhonr1.bit.language_translator.R

/**
 * Error validation class
 */
class CustomValidationAlertDialog(context: Context, private val message: String) : DialogFragment() {
    private val builder = AlertDialog.Builder(context)

    /**
     * shows error in a alert dialog
     */
    fun show(){
        builder.setCancelable(true)
        builder.setNeutralButton(R.string.msg_ok) { _, _ ->  }
        builder.setMessage(message)
        builder.setView(view).create()
        builder.show()
    }
}