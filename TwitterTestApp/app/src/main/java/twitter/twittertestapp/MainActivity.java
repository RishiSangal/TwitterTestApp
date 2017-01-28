package twitter.twittertestapp;

import android.content.Intent;
import android.os.Bundle;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

public class MainActivity extends BaseActivity {

    TwitterLoginButton login_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initalize();
    }

    private void initalize() {
        login_button = (TwitterLoginButton) findViewById(R.id.login_button);
        login_button.setCallback(callBackTwitter);
    }

    private Callback<TwitterSession> callBackTwitter = new Callback<TwitterSession>() {
        @Override
        public void success(Result<TwitterSession> result) {
            TwitterSession session = result.data;
            TwitterAuthToken authToken = session.getAuthToken();
            Intent i = new Intent(MainActivity.this, SearchHashTagActivity.class);
            i.putExtra(TOKEN, authToken.token);
            i.putExtra(SECRET, authToken.secret);
            startActivity(i);
        }

        @Override
        public void failure(TwitterException e) {

        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Pass the activity result to the login button.
        login_button.onActivityResult(requestCode, resultCode, data);
    }

}
