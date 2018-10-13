package com.example.studentportal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {

    private WebView webView;

    /**
     * In this onCreate the url that has been given gets opened.
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webView = (WebView) findViewById(R.id.webViewPortal);
        webView.getSettings().setJavaScriptEnabled(true);

        Intent intent = getIntent();

        String url = intent.getStringExtra(MainActivity.URL);
        webView.loadUrl(url);

    }
}

