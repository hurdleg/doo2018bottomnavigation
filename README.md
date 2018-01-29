# Doors Open Ottawa - Bottom Navigation

Demonstrate Android's _bottom navigation_ for DOO app.

## Implementation Notes

**Features** Android's class Fragment

Define three specialized Fragment classes:

1. HomeFragment.java
2. FavouritesFragment.java
3. FiltersFragment.java

## FIXes

#### Issue:

* Navigation icon does not match content after orientation change.

#### Fix:

* Add: `android:configChanges="orientation|screenSize"` to AndroidManifest.xml

## Report an Issue

Click <https://github.com/hurdleg/doo2018bottomnavigation/issues> to report an issue.
