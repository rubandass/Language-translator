package jhonr1.bit.language_translator.helpers

import android.os.AsyncTask
import jhonr1.bit.language_translator.interfaces.IDataDownloadAvailable
import org.json.JSONArray
import org.json.JSONObject

/**
 * Async class which fetch data from the RawDataAsync class
 */
class YandexAsyncTask(private val listener: IDataDownloadAvailable) : AsyncTask<String, Void, String>() {

    override fun onPostExecute(result: String) {
        super.onPostExecute(result)
        listener.onDataAvailable(result)
    }

    /**
     * Convert xml data into plain text
     */
    override fun doInBackground(vararg url: String?): String {
        var text = ""
        try {
            val jsonData = JSONObject(url[0])
            val textArr: JSONArray = jsonData.getJSONArray("text")
            text = textArr.getString(0)
        } catch (e: Exception) {
            cancel(true)
            listener.onError(e)
        }
        return text
    }

}