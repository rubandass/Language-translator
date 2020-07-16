[app](../../index.md) / [jhonr1.bit.language_translator.helpers](../index.md) / [RawDataAsyncTask](./index.md)

# RawDataAsyncTask

`class RawDataAsyncTask : `[`AsyncTask`](https://developer.android.com/reference/android/os/AsyncTask.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`Void`](https://developer.android.com/reference/java/lang/Void.html)`, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>`

Asynchronous task class.
Fetching data in background.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `RawDataAsyncTask(listener: `[`IDataDownloadComplete`](../../jhonr1.bit.language_translator.interfaces/-i-data-download-complete/index.md)`, context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`)`<br>Asynchronous task class. Fetching data in background. |

### Functions

| Name | Summary |
|---|---|
| [doInBackground](do-in-background.md) | `fun doInBackground(vararg url: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Fetching data in background. |
| [onPostExecute](on-post-execute.md) | `fun onPostExecute(result: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>closes the progress dialog, when download finished |
| [onPreExecute](on-pre-execute.md) | `fun onPreExecute(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Shows the progress dialog, before download starts |
