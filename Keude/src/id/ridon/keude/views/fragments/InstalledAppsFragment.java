package id.ridon.keude.views.fragments;

import android.net.Uri;
import id.ridon.keude.R;
import id.ridon.keude.data.AppProvider;
import id.ridon.keude.views.AppListAdapter;
import id.ridon.keude.views.InstalledAppListAdapter;

public class InstalledAppsFragment extends AppListFragment {

    @Override
    protected AppListAdapter getAppListAdapter() {
        return new InstalledAppListAdapter(getActivity(), null);
    }

    @Override
    protected String getFromTitle() {
        return getString(R.string.inst);
    }

    @Override
    protected Uri getDataUri() {
        return AppProvider.getInstalledUri();
    }

}
