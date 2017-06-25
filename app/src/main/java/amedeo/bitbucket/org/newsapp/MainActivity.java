package amedeo.bitbucket.org.newsapp;

import android.content.Context;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Story>> {

    StoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new StoryAdapter(this, new ArrayList<Story>());
        ListView storyListView = (ListView) findViewById(R.id.storyList);
        storyListView.setAdapter(adapter);
        getSupportLoaderManager().initLoader(1, null, this).forceLoad();

    }

    @Override
    public Loader<List<Story>> onCreateLoader(int id, Bundle args) {
        return new StoryLoader(MainActivity.this);
    }

    @Override
    public void onLoadFinished(Loader<List<Story>> loader, List<Story> data) {

        // Hide loading indicator because the data has been loaded
        View loadingIndicator = findViewById(R.id.loading_indicator);
        loadingIndicator.setVisibility(View.GONE);

        adapter.setStories(data);
    }

    @Override
    public void onLoaderReset(Loader<List<Story>> loader) {
        adapter.setStories(new ArrayList<Story>());
    }

}
