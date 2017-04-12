package com.elgeekman.alejandrorodriguezuson.zeldabreathofthewild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.NativeExpressAdView;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;

import static com.elgeekman.alejandrorodriguezuson.zeldabreathofthewild.R.id.imageViewExpand;
import static com.elgeekman.alejandrorodriguezuson.zeldabreathofthewild.R.id.linearLayoutDetails;
import static javax.xml.datatype.DatatypeConstants.DURATION;

public class recetas extends AppCompatActivity {

    private ViewGroup linearLayoutDetails;
    private ImageView imageViewExpand;
    private static final int DURATION = 250;
    private static String LOG_TAG = "EXAMPLE";

    NativeExpressAdView mAdView;
    VideoController mVideoController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recetas);

        AdRequest adRequest = new AdRequest.Builder().build();

        linearLayoutDetails = (ViewGroup) findViewById(R.id.linearLayoutDetails);
        imageViewExpand = (ImageView) findViewById(R.id.imageViewExpand);

        Toolbar toolbarCard = (Toolbar) findViewById(R.id.toolbarCard);
        toolbarCard.setTitle(R.string.olinguito);
        toolbarCard.setSubtitle(R.string.subtitle);







        Button recetas = (Button) findViewById(R.id.Crafteo);
        recetas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast personajes = Toast.makeText(getApplicationContext(), "Ya estas en recetas" , Toast.LENGTH_LONG);

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

        Button personajes = (Button) findViewById(R.id.Personajes);
        personajes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent personajes = new Intent (v.getContext(), MainActivity.class);
                startActivityForResult(personajes, 0);
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
        Button noticias = (Button) findViewById(R.id.Noticias);
        noticias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent noticias = new Intent (v.getContext(), noticias.class);
                startActivityForResult(noticias, 0);
            }
        });
    }
    public void toggleDetails(View view) {
        if (linearLayoutDetails.getVisibility() == View.GONE) {
            ExpandAndCollapseViewUtil.expand(linearLayoutDetails, DURATION);
            imageViewExpand.setImageResource(R.mipmap.more);
            rotate(-180.0f);
        } else {
            ExpandAndCollapseViewUtil.collapse(linearLayoutDetails, DURATION);
            imageViewExpand.setImageResource(R.mipmap.less);
            rotate(180.0f);
        }
    }

    private void rotate(float angle) {
        Animation animation = new RotateAnimation(0.0f, angle, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setFillAfter(true);
        animation.setDuration(DURATION);
        imageViewExpand.startAnimation(animation);
    }



}
