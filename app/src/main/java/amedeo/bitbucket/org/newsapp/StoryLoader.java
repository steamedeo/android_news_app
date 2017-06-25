package amedeo.bitbucket.org.newsapp;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stefano on 24/06/2017.
 */

public class StoryLoader extends AsyncTaskLoader<List<Story>> {

    private final String URL_BASE = "http://content.guardianapis.com/search?q=";
    private final String CRITERIA = "Economics";

    public StoryLoader(Context context){
        super(context);
    }

    @Override
    public List<Story> loadInBackground(){

        //create request url
        String requestUrl = URL_BASE + CRITERIA + "&api-key=test";

        // Perform the HTTP request
        ArrayList<Story> books = Utils.fetchStoryData(requestUrl);

        return books;

    }

}
