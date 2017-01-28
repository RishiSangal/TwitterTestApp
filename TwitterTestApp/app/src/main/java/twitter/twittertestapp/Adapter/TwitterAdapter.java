package twitter.twittertestapp.Adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.twitter.sdk.android.core.models.Tweet;

import java.util.List;

import twitter.twittertestapp.SearchHashTagActivity;

/**
 * Created by Rishi.Sangal on 1/27/2017.
 */

public class TwitterAdapter extends BaseAdapter {


    Activity activity_;
    List<Tweet> tweets;
    public TwitterAdapter(Activity activity, List<Tweet> mTweets) {
        activity_ = activity;
    }

    @Override
    public int getCount() {
        return tweets.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    public void setTweets(List<Tweet> mTweets) {
        tweets = mTweets;
    }
}
