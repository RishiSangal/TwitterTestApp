package twitter.twittertestapp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import com.twitter.sdk.android.tweetui.SearchTimeline;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;

import java.util.Calendar;
import java.util.Date;

import im.delight.android.location.SimpleLocation;
import twitter.twittertestapp.Adapter.TwitterAdapter;


/**
 * Created by Rishi.Sangal on 1/27/2017.
 */
public class SearchHashTagActivity extends BaseActivity {

    SimpleLocation location;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        location = new SimpleLocation(this);
        getOneMonthDate();
        initalize();
    }

    Date dateObject;
    private void getOneMonthDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.roll(Calendar.MONTH, -1);
        dateObject = calendar.getTime();
    }

    EditText edtSearch;
    ListView recSearch;
    TwitterAdapter adapter;
    private void initalize() {
        edtSearch = (EditText) findViewById(R.id.edtSearch);
        recSearch = (ListView) findViewById(R.id.recSearch);
        edtSearch.addTextChangedListener(textWatcherListener);
    }

    private TextWatcher textWatcherListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if (charSequence.toString().length() < 1){
            }
            else {
                recSearch.setAdapter(retrieveTimeLineByHashtag(SearchHashTagActivity.this,
                        "#"+charSequence.toString()));
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    public TweetTimelineListAdapter retrieveTimeLineByHashtag(Context context, String hashtag){

        SearchTimeline searchTimeline = new SearchTimeline.Builder().query(hashtag)
                .untilDate(dateObject).build();
        TweetTimelineListAdapter adapter = new TweetTimelineListAdapter.Builder(context).
                setTimeline(searchTimeline).build();
        return adapter;
    }


}
