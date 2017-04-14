package com.rubydev.justnow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class NewsReader extends AppCompatActivity {
    WebView newsReader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsreader);
        newsReader = (WebView) findViewById(R.id.newsReader);
        newsReader.loadUrl();
    }
}
