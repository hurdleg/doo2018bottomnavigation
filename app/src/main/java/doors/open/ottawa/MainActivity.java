package doors.open.ottawa;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import doors.open.ottawa.fragments.FavoritesFragment;
import doors.open.ottawa.fragments.FiltersFragment;
import doors.open.ottawa.fragments.BuildingsFragment;

/**
 * Demonstrate bottom navigation for DOO app.
 *
 * Display 3 fragments: Home, Favorites, Filters
 *
 * Reference Links:
 *
 * https://www.androidhive.info/2017/12/android-working-with-bottom-navigation/
 *
 * http://blog.iamsuleiman.com/using-bottom-navigation-view-android-design-support-library/
 *
 * https://medium.com/@hitherejoe/exploring-the-android-design-support-library-bottom-navigation-drawer-548de699e8e0
 *
 * http://www.truiton.com/2017/01/android-bottom-navigation-bar-example/
 *
 * @author Gerald.Hurdle@AlgonquinCollege.com
 *
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG_FRAGMENT_BUILDINGS = "tag_frag_buildings";
    private static final String TAG_FRAGMENT_FAVORITES = "tag_frag_favorites";
    private static final String TAG_FRAGMENT_FILTERS   = "tag_frag_filters";

    /**
     * Maintains a list of Fragments for {@link BottomNavigationView}
     */
    private List<Fragment> mFragments = new ArrayList<>(3);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.navigation_buildings:
                                switchFragment(0, TAG_FRAGMENT_BUILDINGS);
                                return true;
                            case R.id.navigation_favorites:
                                switchFragment(1, TAG_FRAGMENT_FAVORITES);
                                return true;
                            case R.id.navigation_filters:
                                switchFragment(2, TAG_FRAGMENT_FILTERS);
                                return true;
                        }
                        return false;
                    }
                });

        this.initFragmentsList();

        // Set the 0th Fragment to be displayed by default.
        this.switchFragment(0, TAG_FRAGMENT_BUILDINGS);
    }

    @Override
    public void onResume() {
        this.switchFragment(0, TAG_FRAGMENT_BUILDINGS);
        super.onResume();
    }

    private void initFragmentsList() {
        mFragments.add(new BuildingsFragment());
        mFragments.add(new FavoritesFragment());
        mFragments.add(new FavoritesFragment());
    }

    private void switchFragment(int pos, String tag) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_container, mFragments.get(pos), tag)
                .commit();
    }

}
