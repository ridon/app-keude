package id.ridon.keude.views;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import id.ridon.keude.Keude;
import id.ridon.keude.R;
import id.ridon.keude.data.AppProvider;
import id.ridon.keude.views.fragments.AvailableAppsFragment;
import id.ridon.keude.views.fragments.CanUpdateAppsFragment;
import id.ridon.keude.views.fragments.InstalledAppsFragment;

/**
 * Used by the Keude activity in conjunction with its ViewPager to support
 * swiping of tabs for both old devices (< 3.0) and new devices.
 */
public class AppListFragmentPagerAdapter extends FragmentPagerAdapter {

    private Keude parent = null;

    public AppListFragmentPagerAdapter(Keude parent) {
        super(parent.getSupportFragmentManager());
        this.parent = parent;
    }

    private String getUpdateTabTitle() {
        int updateCount = AppProvider.Helper.count(parent, AppProvider.getCanUpdateUri());

        // TODO: Make RTL friendly, probably by having a different string for both tab_updates_none and tab_updates
        return parent.getString(R.string.tab_updates) + " (" + updateCount + ")";
    }

    @Override
    public Fragment getItem(int i) {
        if (i == 0) {
            return new AvailableAppsFragment();
        }
        if (i == 1) {
            return new InstalledAppsFragment();
        }
        return new CanUpdateAppsFragment();
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public String getPageTitle(int i) {
        switch(i) {
            case 0:
                return parent.getString(R.string.tab_noninstalled);
            case 1:
                return parent.getString(R.string.inst);
            case 2:
                return getUpdateTabTitle();
            default:
                return "";
        }
    }

}
