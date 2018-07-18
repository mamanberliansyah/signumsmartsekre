package io.github.bengkelradio.simplewebview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.HttpAuthHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;

public class cctv extends AppCompatActivity {
    WebView cctvView;
    TextView cctvText;
    Button cctvAuth;
    EditText inputPasswd;
    String cctvPasswd;

    Boolean connected = false;

    @Override
    public void onBackPressed(){
        if (connected){
            if(cctvView.canGoBack()){
                cctvView.goBack();
            } else {
                super.onBackPressed();
            }
        } else;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cctv);
        cctvAuth = (Button)findViewById(R.id.authButton);
        inputPasswd = (EditText)findViewById(R.id.editPass);
        cctvText = (TextView)findViewById(R.id.cctvText);

        cctvAuth.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cctvPasswd = inputPasswd.getText().toString();
                cctvView = (WebView)findViewById(R.id.cctvView);
                cctvView.getSettings().setJavaScriptEnabled(true);
                cctvView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
                cctvView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
                cctvView.loadUrl("http://167.205.48.30:11111");
                cctvView.setWebViewClient(new WebViewClient () {
                    public void onReceivedHttpAuthRequest(WebView view, HttpAuthHandler handler,
                                                          String host, String realm) {
                        handler.proceed("bengkrad", cctvPasswd);
                    }
                });
                connected = true;
                if (Objects.equals(cctvPasswd, "cctvimt")){
                    cctvText.setText("CCTV Succesfully Connected");
                } else {
                    cctvText.setText("Password Invalid");
                }
            }
        });
    }

}
