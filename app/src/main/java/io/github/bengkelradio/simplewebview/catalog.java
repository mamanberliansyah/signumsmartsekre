package io.github.bengkelradio.simplewebview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class catalog extends AppCompatActivity {
    WebView libView;

    @Override
    public void onBackPressed(){
        if(libView.canGoBack()){
            libView.goBack();
         } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);
        libView = (WebView)findViewById(R.id.libView);
        libView.getSettings().setJavaScriptEnabled(true);
        libView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        libView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        libView.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
        libView.loadUrl("http://167.205.48.30:11000/db/");
        libView.setWebViewClient(new WebViewClient());
    }
}
