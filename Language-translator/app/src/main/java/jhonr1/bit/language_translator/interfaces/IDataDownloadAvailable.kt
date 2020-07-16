package jhonr1.bit.language_translator.interfaces

/**
 * Interface class which is used by YandexAsyncTask class.
 */
interface IDataDownloadAvailable {
    fun onDataAvailable(data: String)
    fun onError(e: Exception)
}