package jhonr1.bit.language_translator.activities

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import jhonr1.bit.language_translator.R

/**
 * Exit Alert dialog class
 */
class CustomExitAlertDialog(context: Context, private val activity: Activity, layout: Int) {

    private lateinit var alertDialog: AlertDialog
    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    private val view: View = inflater.inflate(layout,null)
    private val builder = AlertDialog.Builder(context)

    /**
     * Alert dialog contains Yes, No buttons and its behaviour.
     */
    fun show(title: String){
        builder.setTitle(title)
        builder.setIcon(R.drawable.translator_logo)
        builder.setCancelable(true)
        builder.setNegativeButton(R.string.no) { dialog, _ -> dialog.cancel()}
        builder.setPositiveButton(R.string.yes) {
                _, _ -> activity.finishAffinity()
        }

        alertDialog = builder.setView(view).create()
        builder.show()
    }

}
