package es.arcx.isolatedwebapps;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class LinkedinActivity extends AppCompatActivity {

    private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        myWebView = (WebView) findViewById(R.id.webview);
        if(myWebView != null) {
            myWebView.setWebViewClient(new CustomWebView(this, "www.linkedin.com", ""));
            WebSettings webSettings = myWebView.getSettings();
            if(webSettings != null) {
                webSettings.setJavaScriptEnabled(true);
            }
            myWebView.loadUrl("https://www.linkedin.com/m/");

        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (myWebView.canGoBack()) {
                        myWebView.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }
}
