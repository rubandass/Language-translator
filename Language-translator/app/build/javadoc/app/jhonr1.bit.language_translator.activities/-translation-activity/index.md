[app](../../index.md) / [jhonr1.bit.language_translator.activities](../index.md) / [TranslationActivity](./index.md)

# TranslationActivity

`class TranslationActivity : AppCompatActivity, `[`IDataDownloadComplete`](../../jhonr1.bit.language_translator.interfaces/-i-data-download-complete/index.md)`, `[`IDataDownloadAvailable`](../../jhonr1.bit.language_translator.interfaces/-i-data-download-available/index.md)`, OnNavigationItemSelectedListener`

It has Bottom navigation menu, Drawer menu on top left.
Bottom navigation menu items takes you to the corresponding activity.
Drawer menu has language settings, Dark theme mode, Exit app.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `TranslationActivity()`<br>It has Bottom navigation menu, Drawer menu on top left. Bottom navigation menu items takes you to the corresponding activity. Drawer menu has language settings, Dark theme mode, Exit app. |

### Properties

| Name | Summary |
|---|---|
| [toolbar](toolbar.md) | `lateinit var toolbar: Toolbar` |

### Functions

| Name | Summary |
|---|---|
| [dispatchTouchEvent](dispatch-touch-event.md) | `fun dispatchTouchEvent(ev: `[`MotionEvent`](https://developer.android.com/reference/android/view/MotionEvent.html)`?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Hide beyboard after exiting edit text field |
| [onBackPressed](on-back-pressed.md) | `fun onBackPressed(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>calls the Main activity and do the transition when back button is pressed |
| [onCreate](on-create.md) | `fun onCreate(savedInstanceState: `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Sets bottom navigation menu, translation layout page, drawer menu when Translation activity is called. |
| [onDataAvailable](on-data-available.md) | `fun onDataAvailable(data: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Set translated text to output text field |
| [onDownloadComplete](on-download-complete.md) | `fun onDownloadComplete(data: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, status: `[`DownloadStatus`](../../jhonr1.bit.language_translator.enums/-download-status/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Get result from AsyncTask |
| [onError](on-error.md) | `fun onError(e: `[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onNavigationItemSelected](on-navigation-item-selected.md) | `fun onNavigationItemSelected(item: `[`MenuItem`](https://developer.android.com/reference/android/view/MenuItem.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>It takes menu item, current activity and the side drawer meny layout as input when an item is selected |
| [toggleDayNight](toggle-day-night.md) | `fun toggleDayNight(view: `[`View`](https://developer.android.com/reference/android/view/View.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Set the default dayNight mode based on the "Night Mode" ON or OFF, save the current theme mode to preferences |
