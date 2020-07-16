[app](../../index.md) / [jhonr1.bit.language_translator.interfaces](../index.md) / [IDataDownloadComplete](./index.md)

# IDataDownloadComplete

`interface IDataDownloadComplete`

Interface class which is used by RawDataAsync class

### Functions

| Name | Summary |
|---|---|
| [onDownloadComplete](on-download-complete.md) | `abstract fun onDownloadComplete(data: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, status: `[`DownloadStatus`](../../jhonr1.bit.language_translator.enums/-download-status/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

```
    When implemented, gets the status (enum value) of the async task - checks if its completed<br>```
<br> |

### Inheritors

| Name | Summary |
|---|---|
| [TranslationActivity](../../jhonr1.bit.language_translator.activities/-translation-activity/index.md) | `class TranslationActivity : AppCompatActivity, `[`IDataDownloadComplete`](./index.md)`, `[`IDataDownloadAvailable`](../-i-data-download-available/index.md)`, OnNavigationItemSelectedListener`<br>It has Bottom navigation menu, Drawer menu on top left. Bottom navigation menu items takes you to the corresponding activity. Drawer menu has language settings, Dark theme mode, Exit app. |
