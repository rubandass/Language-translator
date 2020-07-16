[app](../../index.md) / [jhonr1.bit.language_translator.helpers](../index.md) / [YandexAsyncTask](./index.md)

# YandexAsyncTask

`class YandexAsyncTask : `[`AsyncTask`](https://developer.android.com/reference/android/os/AsyncTask.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`Void`](https://developer.android.com/reference/java/lang/Void.html)`, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>`

Async class which fetch data from the RawDataAsync class

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `YandexAsyncTask(listener: `[`IDataDownloadAvailable`](../../jhonr1.bit.language_translator.interfaces/-i-data-download-available/index.md)`)`<br>Async class which fetch data from the RawDataAsync class |

### Functions

| Name | Summary |
|---|---|
| [doInBackground](do-in-background.md) | `fun doInBackground(vararg url: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Convert xml data into plain text |
| [onPostExecute](on-post-execute.md) | `fun onPostExecute(result: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
