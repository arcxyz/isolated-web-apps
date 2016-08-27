package es.arcx.isolatedwebapps;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class LinkedinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        WebView myWebView = (WebView) findViewById(R.id.webview);
        if(myWebView != null) {
            myWebView.setWebViewClient(new CustomWebView(this, "www.linkedin.com", ""));
            WebSettings webSettings = myWebView.getSettings();
            if(webSettings != null) {
                webSettings.setJavaScriptEnabled(true);
            }
            myWebView.loadUrl("https://www.linkedin.com/m/");

        }
    }
}
