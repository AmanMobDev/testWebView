package com.project.navneetwebview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    WebView mWebView;

    Context context;

    LinearLayout linearLayout,linearLayout1;

    ImageView image,loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = MainActivity.this;

        getSupportActionBar().hide();
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN );

        mWebView = (WebView) findViewById( R.id.webView );
        image =  findViewById( R.id.gif );
        loading =  findViewById( R.id.progressBar );
        linearLayout =  findViewById(R.id.layout1);
        linearLayout1 = findViewById(R.id.network_layout);
        Button refresh1 = findViewById( R.id.refresh );

        Glide.with( getApplicationContext() ).load( R.drawable.wifi ).into( image );
        Glide.with( getApplicationContext() ).load( R.drawable.gear ).into( loading );

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        mWebView.getSettings().setAllowFileAccess(true);
        mWebView.setWebViewClient( new myWebClient() );
        mWebView.loadUrl("https:/www.google.com");

        mWebView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Utils.isNetworkConnected( getBaseContext() )) {
                    linearLayout.setVisibility(View.VISIBLE);
                    linearLayout1.setVisibility(View.GONE);
                    mWebView.setWebChromeClient( new WebChromeClient() );
                    mWebView.setWebViewClient(new myWebClient());
                    mWebView.getSettings().setJavaScriptEnabled( true );
                    mWebView.loadUrl( "https:/www.google.com" );

                } else {

                    Toast.makeText( getApplicationContext(), "Unable to connect to the internet", Toast.LENGTH_LONG ).show();
                }
            }
        } );

        refresh1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Utils.isNetworkConnected( getBaseContext() )) {
                    linearLayout.setVisibility(View.VISIBLE);
                    linearLayout1.setVisibility(View.GONE);
                    mWebView.setWebChromeClient( new WebChromeClient() );
                    mWebView.setWebViewClient(new myWebClient());
                    mWebView.getSettings().setJavaScriptEnabled( true );
                    mWebView.loadUrl( "https:/www.google.com" );

                } else {
                    Toast.makeText( getApplicationContext(), "Unable to connect to the internet", Toast.LENGTH_LONG ).show();
                }
            }
        } );


        if (Utils.isNetworkConnected( getBaseContext() )) {
            linearLayout.setVisibility(View.VISIBLE);
            linearLayout1.setVisibility(View.GONE);
            webSettings.setAllowFileAccess( true );
            mWebView.setWebViewClient(new myWebClient());
            mWebView.getSettings().setJavaScriptEnabled( true );
            mWebView.loadUrl( "https:/www.google.com" );

        } else {
            linearLayout1.setVisibility(View.VISIBLE);
            linearLayout.setVisibility(View.GONE);
        }

    }

    private class myWebClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            // TODO Auto-generated method stub
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub
            return super.shouldOverrideUrlLoading(view, url);

        }

        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            super.onPageFinished(view, url);
            mWebView.setVisibility(View.VISIBLE);
            loading.setVisibility(View.GONE);


        }


    }
}