package jhonr1.bit.language_translator.interfaces

import jhonr1.bit.language_translator.enums.DownloadStatus

/**
 * Interface class which is used by RawDataAsync class
 */
interface IDataDownloadComplete {
    /**
     *     When implemented, gets the status (enum value) of the async task - checks if its completed
     */
    fun onDownloadComplete(data: String, status: DownloadStatus)
}