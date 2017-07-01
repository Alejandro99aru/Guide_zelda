package com.elgeekman.alejandrorodriguezuson.zeldabreathofthewild;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.NativeExpressAdView;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crash.FirebaseCrash;

public class
MainActivity extends AppCompatActivity {

    InterstitialAd mInterstitialAd;
    private InterstitialAd interstitial;

    private FirebaseAnalytics mFirebaseAnalytics;

    private static String LOG_TAG = "EXAMPLE";

    NativeExpressAdView mAdView;
    VideoController mVideoController;

    ImageView link_image;
    ImageView zelda_image;
    ImageView revali_image;
    ImageView mipha_image;
    ImageView urbosa_image;
    ImageView ganon_image;
    ImageView daruk_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdRequest adRequest = new AdRequest.Builder().build();



        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        FirebaseCrash.log("Activity created");






        Button personajes = (Button) findViewById(R.id.Personajes);
        personajes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast personajes = Toast.makeText(getApplicationContext(), "Ya estas en personajes" , Toast.LENGTH_LONG);

                personajes.show();

            }
        });

        Button mapa = (Button) findViewById(R.id.Mapa_main);
        mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapa = new Intent (v.getContext(), Map.class);
                startActivityForResult(mapa, 0);
            }
        });

        Button crafteo = (Button) findViewById(R.id.Crafteo_main);
        crafteo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent crafteo = new Intent (v.getContext(), recetas.class);
                startActivityForResult(crafteo, 0);
            }
        });

        Button feedback = (Button) findViewById(R.id.Feedback_main);
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent feedback = new Intent (v.getContext(), feedback.class);
                startActivityForResult(feedback, 0);
            }
        });
        Button noticias = (Button) findViewById(R.id.Noticias_main);
        noticias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent noticias = new Intent (v.getContext(), noticias.class);
                startActivityForResult(noticias, 0);
            }
        });
        Button chat = (Button) findViewById(R.id.chat_main);
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chat = new Intent (v.getContext(), LoginActivity1.class);
                startActivityForResult(chat, 0);
            }
        });
        // Locate the NativeExpressAdView.
        mAdView = (NativeExpressAdView) findViewById(R.id.adView);

// Set its video options.
        mAdView.setVideoOptions(new VideoOptions.Builder()
                .setStartMuted(true)
                .build());

// The VideoController can be used to get lifecycle events and info about an ad's video
// asset. One will always be returned by getVideoController, even if the ad has no video
// asset.
        mVideoController = mAdView.getVideoController();
        mVideoController.setVideoLifecycleCallbacks(new VideoController.VideoLifecycleCallbacks() {
            @Override
            public void onVideoEnd() {
                Log.d(LOG_TAG, "Video playback is finished.");
                super.onVideoEnd();
            }
        });

// Set an AdListener for the AdView, so the Activity can take action when an ad has finished
// loading.
        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                if (mVideoController.hasVideoContent()) {
                    Log.d(LOG_TAG, "Received an ad that contains a video asset.");
                } else {
                    Log.d(LOG_TAG, "Received an ad that does not contain a video asset.");
                }
            }
        });

        mAdView.loadAd(new AdRequest.Builder().build());

    }
    public void displayInterstitial() {
// If Ads are loaded, show Interstitial else show nothing.
        if (interstitial.isLoaded()) {
            interstitial.show();
        }
    }
}
