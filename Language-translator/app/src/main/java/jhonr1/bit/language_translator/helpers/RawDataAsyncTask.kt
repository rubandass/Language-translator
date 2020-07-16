package jhonr1.bit.language_translator.helpers

import android.content.Context
import android.os.AsyncTask
import jhonr1.bit.language_translator.activities.CustomProgressBar
import jhonr1.bit.language_translator.enums.DownloadStatus
import jhonr1.bit.language_translator.interfaces.IDataDownloadComplete
import java.lang.Exception
import java.net.URL

/**
 * Asynchronous task class.
 * Fetching data in background.
 */
class RawDataAsyncTask(private val listener: IDataDownloadComplete, context: Context) : AsyncTask<String, Void, String>() {

    private var downloadStatus = DownloadStatus.NONE
    private var progressBar = CustomProgressBar(context)

    /**
     * Shows the progress dialog, before download starts
     */
    override fun onPreExecute() {
        progressBar.show()
    }

    /**
     * closes the progress dialog, when download finished
     */
    override fun onPostExecute(result: String) {
        progressBar.dismiss()
        listener.onDownloadComplete(result, downloadStatus)
    }

    /**
     * Fetching data in background.
     */
    override fun doInBackground(vararg url: String?): String {
        var data = ""
        try {
            downloadStatus = DownloadStatus.OK
            data = downloadXML(url[0])
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return data
    }

    /**
     * Download data as xml for the given url
     */
    private fun downloadXML(urlPath: String?): String {
        return URL(urlPath).readText()
    }
}
