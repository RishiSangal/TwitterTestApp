package twitter.twittertestapp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;

import java.util.Vector;

import io.fabric.sdk.android.Fabric;
import twitter.twittertestapp.common.IcommIntent;

/**
 * Created by Rishi.Sangal on 1/27/2017.
 */

public class BaseActivity extends AppCompatActivity implements IcommIntent{

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "fjAlIXw85PJgnq79PXPlwW9pV";
    private static final String TWITTER_SECRET = "nEgJ2lOOlpmBcoboMJQ0Ka5bMxhNKU8iHiMWmmMnHMSsudRgKe";


    Vector<ProgressDialog> progress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
        progress = new Vector<>();
    }

    public void showDialog() {
        showDialog("Loading please wait");
    }

    public void showDialog(String message) {
        progress.add(ProgressDialog.show(this, "", "Loading please wait", true, false));
    }

    public void dismissDialog() {
        if (progress != null)
            for (ProgressDialog prog : progress)
                prog.dismiss();
    }

    public static Toast toas;

    public void showToast(final String toast) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (toas != null) {
                    toas.makeText(getApplicationContext(), toast, Toast.LENGTH_SHORT).show();
                } else {
                    toas = new Toast(BaseActivity.this);
                    toas.makeText(getApplicationContext(), toast, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
