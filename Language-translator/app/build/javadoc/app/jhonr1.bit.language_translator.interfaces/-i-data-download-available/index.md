[app](../../index.md) / [jhonr1.bit.language_translator.interfaces](../index.md) / [IDataDownloadAvailable](./index.md)

# IDataDownloadAvailable

`interface IDataDownloadAvailable`

Interface class which is used by YandexAsyncTask class.

### Functions

| Name | Summary |
|---|---|
| [onDataAvailable](on-data-available.md) | `abstract fun onDataAvailable(data: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onError](on-error.md) | `abstract fun onError(e: `[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [TranslationActivity](../../jhonr1.bit.language_translator.activities/-translation-activity/index.md) | `class TranslationActivity : AppCompatActivity, `[`IDataDownloadComplete`](../-i-data-download-complete/index.md)`, `[`IDataDownloadAvailable`](./index.md)`, OnNavigationItemSelectedListener`<br>It has Bottom navigation menu, Drawer menu on top left. Bottom navigation menu items takes you to the corresponding activity. Drawer menu has language settings, Dark theme mode, Exit app. |
