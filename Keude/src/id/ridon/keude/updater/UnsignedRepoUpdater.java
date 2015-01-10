package id.ridon.keude.updater;

import android.content.Context;
import android.util.Log;
import id.ridon.keude.data.Repo;

import java.io.File;

public class UnsignedRepoUpdater extends RepoUpdater {

    public UnsignedRepoUpdater(Context ctx, Repo repo) {
        super(ctx, repo);
    }

    @Override
    protected File getIndexFromFile(File file) throws UpdateException {
        Log.d("Keude", "Getting unsigned index from " + getIndexAddress());
        return file;
    }

    @Override
    protected String getIndexAddress() {
        return repo.address + "/index.xml";
    }
}
