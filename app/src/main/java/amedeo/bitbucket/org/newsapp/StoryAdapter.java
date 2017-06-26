package amedeo.bitbucket.org.newsapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class StoryAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private List<Story> stories = new ArrayList<Story>();

    public StoryAdapter(Context context, List<Story> stories) {
        this.stories = stories;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        Story story = (Story) getItem(position);

        if (view == null) {
            view = inflater.inflate(R.layout.story_list_item, null);
        }

        TextView titleView = (TextView) view.findViewById(R.id.title);
        titleView.setText(story.getTitle());

        TextView sectionView = (TextView) view.findViewById(R.id.section);
        sectionView.setText(story.getSection());

        TextView urlView = (TextView) view.findViewById(R.id.url);
        urlView.setText(story.getUrl());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView urlView = (TextView) view.findViewById(R.id.url);
                String url = urlView.getText().toString();

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                view.getContext().startActivity(browserIntent);

            }
        });

        return view;
    }

    @Override
    public Object getItem(int position) {
        return stories.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return stories.size();
    }

    public void setStories(List<Story> data) {
        stories.addAll(data);
        notifyDataSetChanged();
    }
}
