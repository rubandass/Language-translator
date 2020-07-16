package jhonr1.bit.language_translator.activities

import android.app.Activity
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import jhonr1.bit.language_translator.R

/**
 * Getting started Alert dialog class
 */
class CustomGettingStartedAlertDialog(private val context: Activity) : DialogFragment() {
    private lateinit var alertDialog: AlertDialog
    private val builder = AlertDialog.Builder(context)

    /**
     * Contains basic instructions about how to use this app.
     */
    fun show(){
        val messageList = context.resources.getStringArray(R.array.getting_started)
        builder.setTitle(context.resources.getString(R.string.msg_getting_started))
        builder.setIcon(R.drawable.translator_logo)
        builder.setCancelable(true)
        builder.setItems(messageList) { _, _ ->  }
        builder.setNeutralButton(R.string.msg_ok) { _, _ ->  }
        alertDialog = builder.setView(view).create()
        builder.show()
    }
}