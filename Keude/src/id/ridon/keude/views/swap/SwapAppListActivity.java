package id.ridon.keude.views.swap;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import id.ridon.keude.R;
import id.ridon.keude.data.AppProvider;
import id.ridon.keude.views.AppListAdapter;
import id.ridon.keude.views.AvailableAppListAdapter;
import id.ridon.keude.views.fragments.AppListFragment;

public class SwapAppListActivity extends ActionBarActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(android.R.id.content, new SwapAppListFragment())
                    .commit();
        }

    }

    private static class SwapAppListFragment extends AppListFragment {

        @Override
        protected int getHeaderLayout() {
            return R.layout.swap_success_header;
        }

        @Override
        protected AppListAdapter getAppListAdapter() {
            return new AvailableAppListAdapter(getActivity(), null);
        }

        @Override
        protected String getFromTitle() {
            return getString(R.string.swap);
        }

        @Override
        protected Uri getDataUri() {
            return AppProvider.getCategoryUri("LocalRepo");
        }

    }

}
