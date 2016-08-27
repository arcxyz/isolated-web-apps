package es.arcx.isolatedwebapps;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class CustomWebView extends WebViewClient {

    private Activity activity;
    private String hostname;
    private String CSS;

    public CustomWebView(Activity act, String hostname, String CSS) {
        this.activity = act;
        this.hostname = hostname;
        this.CSS = CSS;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (url.indexOf("https://") == 0 || url.indexOf("http://") == 0) {
            if (Uri.parse(url).getHost().equals(this.hostname)) {
                return false;
            }
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            this.activity.startActivity(intent);
        }
        return true;
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        injectCSS(this.CSS, view);
        super.onPageFinished(view, url);
    }

    private void injectCSS(String CSS, WebView webView) {
        try {
            webView.loadUrl("javascript:(function() {" +
                    "var parent = document.getElementsByTagName('head').item(0);" +
                    "var style = document.createElement('style');" +
                    "style.type = 'text/css';" +
                    "style.innerHTML = '" + CSS + "';" +
                    "parent.appendChild(style)" +
                    "})()");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
