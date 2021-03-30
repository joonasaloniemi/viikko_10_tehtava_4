/*
Viikko 10 - tehtävä 4
Tekijä: Joona Saloniemi
Päiväys: 29.3.2021
*/

package com.example.viikko_10_tehtava_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    WebView web;
    String text;
    EditText newTextInput;
    ArrayList<String> webSites;
    Integer i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newTextInput = (EditText) findViewById(R.id.newTextInput);
        web = findViewById(R.id.webView);
        web.setWebViewClient(new WebViewClient());
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl("file:///android_asset/index.html");
        webSites = new ArrayList<>();
        i = webSites.size();
    }

    public void refreshFunction (View V) {
        text = newTextInput.getText().toString();
        web.loadUrl("http://" + text);
        webSites.add(text);
        i = i + 1;
    }

    public void shoutOutFunction (View V) {
        web.evaluateJavascript("javascript:shoutOut()", null);
    }

    public void initializeFunction (View V) {
        web.evaluateJavascript("javascript:initialize()", null);
    }

    public void backFunction (View V) {
        if (i == webSites.size()) {
            text = webSites.get(i - 2);
            web.loadUrl("http://" + text);
            i = i - 2;
        } else if (i == 0) {
            text = webSites.get(i);
            web.loadUrl("http://" + text);
        } else {
            text = webSites.get(i - 1);
            web.loadUrl("http://" + text);
            i = i - 1;
        }
    }

    public void forwardFunction (View V) {
        if ((i + 1) == webSites.size()) {
            text = webSites.get(webSites.size() - 1);
            web.loadUrl("http://" + text);
        } else {
            text = webSites.get(i + 1);
            web.loadUrl("http://" + text);
            i = i + 1;
        }
    }

}