package es.arcx.isolatedwebapps;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class FacebookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        String facebookCSS = "#header{position:fixed !important;top:0;}#root{margin-top:44px!important;}";
        WebView myWebView = (WebView) findViewById(R.id.webview);

        if(myWebView != null) {
            myWebView.setWebViewClient(new CustomWebView(this, "m.facebook.com", facebookCSS));
            WebSettings webSettings = myWebView.getSettings();
            if(webSettings != null) {
                webSettings.setJavaScriptEnabled(true);
                webSettings.setUserAgentString("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36");
            }
            myWebView.loadUrl("https://m.facebook.com");
        }
    }
}
