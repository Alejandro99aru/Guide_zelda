package com.elgeekman.alejandrorodriguezuson.zeldabreathofthewild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import com.squareup.picasso.Picasso;

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

        // Prepare the Interstitial Ad
        interstitial = new InterstitialAd(MainActivity.this);
// Insert the Ad Unit ID
        interstitial.setAdUnitId(getString(R.string.interstetial_personajes));

        interstitial.loadAd(adRequest);
// Prepare an Interstitial Ad Listener
        interstitial.setAdListener(new AdListener() {
            public void onAdLoaded() {
// Call displayInterstitial() function
                displayInterstitial();
            }
        });

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

        Button mapa = (Button) findViewById(R.id.Mapa);
        mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapa = new Intent (v.getContext(), Map.class);
                startActivityForResult(mapa, 0);
            }
        });

        Button crafteo = (Button) findViewById(R.id.Crafteo);
        crafteo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent crafteo = new Intent (v.getContext(), recetas.class);
                startActivityForResult(crafteo, 0);
            }
        });

        Button feedback = (Button) findViewById(R.id.Feedback);
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent feedback = new Intent (v.getContext(), feedback.class);
                startActivityForResult(feedback, 0);
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