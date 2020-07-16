[app](../../index.md) / [jhonr1.bit.language_translator.activities](../index.md) / [UtilityClass](./index.md)

# UtilityClass

`class UtilityClass`

Utility class contains bottom navigation menu creation, drawer menu creation and its actions

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `UtilityClass()`<br>Utility class contains bottom navigation menu creation, drawer menu creation and its actions |

### Companion Object Functions

| Name | Summary |
|---|---|
| [bottomNavMenu](bottom-nav-menu.md) | `fun bottomNavMenu(activity: `[`Activity`](https://developer.android.com/reference/android/app/Activity.html)`, bottomNavView: BottomNavigationView, quizLangSelectCallable: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Contains logic for the bottom navigation menu items |
| [getTheme](get-theme.md) | `fun getTheme(activity: `[`Activity`](https://developer.android.com/reference/android/app/Activity.html)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Load the background theme |
| [itemSelectedOnDrawerMenu](item-selected-on-drawer-menu.md) | `fun itemSelectedOnDrawerMenu(item: `[`MenuItem`](https://developer.android.com/reference/android/view/MenuItem.html)`, context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`, activity: `[`Activity`](https://developer.android.com/reference/android/app/Activity.html)`, drawerLayout: DrawerLayout): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Contains actions of the drawer menu |
| [setNavDrawerMenu](set-nav-drawer-menu.md) | `fun setNavDrawerMenu(activity: `[`Activity`](https://developer.android.com/reference/android/app/Activity.html)`, drawerLayout: DrawerLayout, toolbar: Toolbar): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Adding drawer menu to the activity layout |
| [toggleButtonStateSet](toggle-button-state-set.md) | `fun toggleButtonStateSet(navView: NavigationView, theme: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Retrieves the Dark mode ON /OFF switch status |
| [toggleDayNight](toggle-day-night.md) | `fun toggleDayNight(drawer_switch: `[`Switch`](https://developer.android.com/reference/android/widget/Switch.html)`, delegate: AppCompatDelegate, activity: `[`Activity`](https://developer.android.com/reference/android/app/Activity.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Set the default dayNight mode based on the "Night Mode" ON or OFF, save the current theme mode to preferences |
| [transitionHome](transition-home.md) | `fun transitionHome(activity: `[`Activity`](https://developer.android.com/reference/android/app/Activity.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Calls the Main activity with sliding animation |
