package jhonr1.bit.language_translator.activities

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import jhonr1.bit.language_translator.R

/**
 * Progress bar class
 */
class CustomProgressBar(context: Context) {

    private val inflater : LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    private val view: View = inflater.inflate(R.layout.progress_bar, null)
    private val dialog: Dialog = Dialog(context, R.style.CustomProgressBarTheme)

    /**
     * Show the progress bar dialog
     */
    fun show(){
        dialog.setContentView(view)
        dialog.show()
    }

    /**
     * Close the progress bar
     */
    fun dismiss(){
        dialog.dismiss()
    }

}