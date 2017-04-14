package com.rubydev.justnow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class NewsReader extends AppCompatActivity {
    WebView newsReader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsreader);

        Intent i = getIntent();
        newsReader = (WebView) findViewById(R.id.newsReader);
        newsReader.loadUrl(i.getStringExtra("newsreader"));
    }
}
