package com.elgeekman.alejandrorodriguezuson.zeldabreathofthewild;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class Map extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapa);

        AdRequest adRequest = new AdRequest.Builder().build();


        WebView myWebView = (WebView) findViewById(R.id.wvMain);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl("https://zeldamaps.com/?game=BotW");


        Button personajes = (Button) findViewById(R.id.Personajes);
        personajes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent personajes = new Intent (v.getContext(), MainActivity.class);
                startActivityForResult(personajes, 0);

            }
        });


        Button mapa = (Button) findViewById(R.id.Mapa);
        mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast mapa = Toast.makeText(getApplicationContext(), "Ya estas en mapa" , Toast.LENGTH_LONG);

                mapa.show();
            }
        });
        Button noticias = (Button) findViewById(R.id.Noticias);
        noticias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent noticias = new Intent (v.getContext(), noticias.class);
                startActivityForResult(noticias, 0);
            }
        });
        Button crafteo = (Button) findViewById(R.id.Crafteo);
        crafteo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapa = new Intent (v.getContext(), recetas.class);
                startActivityForResult(mapa, 0);
            }
        });


    }


}