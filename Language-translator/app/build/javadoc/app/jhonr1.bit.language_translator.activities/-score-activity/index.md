[app](../../index.md) / [jhonr1.bit.language_translator.activities](../index.md) / [ScoreActivity](./index.md)

# ScoreActivity

`class ScoreActivity : AppCompatActivity, OnNavigationItemSelectedListener`

It has Bottom navigation menu, Drawer menu on top left.
Bottom navigation menu item takes you to the corresponding activity.
Drawer menu has language settings, Dark theme mode, Exit app.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ScoreActivity()`<br>It has Bottom navigation menu, Drawer menu on top left. Bottom navigation menu item takes you to the corresponding activity. Drawer menu has language settings, Dark theme mode, Exit app. |

### Properties

| Name | Summary |
|---|---|
| [toolbar](toolbar.md) | `lateinit var toolbar: Toolbar` |

### Functions

| Name | Summary |
|---|---|
| [onBackPressed](on-back-pressed.md) | `fun onBackPressed(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>calls the Main activity and do the transition when back button is pressed |
| [onCreate](on-create.md) | `fun onCreate(savedInstanceState: `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Sets bottom navigation menu, score layout page, drawer menu when this activity is called. |
| [onNavigationItemSelected](on-navigation-item-selected.md) | `fun onNavigationItemSelected(item: `[`MenuItem`](https://developer.android.com/reference/android/view/MenuItem.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>It takes menu item, current activity and the side drawer meny layout as input when an item is selected |
| [toggleDayNight](toggle-day-night.md) | `fun toggleDayNight(view: `[`View`](https://developer.android.com/reference/android/view/View.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Set the default dayNight mode based on the "Night Mode" ON or OFF, save the current theme mode to preferences |
