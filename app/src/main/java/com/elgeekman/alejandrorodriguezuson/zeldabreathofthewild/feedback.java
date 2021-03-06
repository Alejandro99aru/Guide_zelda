package com.elgeekman.alejandrorodriguezuson.zeldabreathofthewild;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class feedback extends AppCompatActivity {



    Intent rateApp;

    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        AdRequest adRequest = new AdRequest.Builder().build();



        rateApp = new Intent(Intent.ACTION_VIEW);

        Button rate = (Button) findViewById(R.id.rate);
        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rateApp.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.elgeekman.elgeekman&hl=es"));
                startActivity(rateApp);
            }
        });

        Button feedback = (Button) findViewById(R.id.Feedback_feedback);
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast feedback = Toast.makeText(getApplicationContext(), "Ya estas en feedback" , Toast.LENGTH_LONG);

                feedback.show();

            }
        });
        Button chat = (Button) findViewById(R.id.chat_feedback);
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chat = new Intent (v.getContext(), LoginActivity1.class);
                startActivityForResult(chat, 0);
            }
        });

        Button mapa = (Button) findViewById(R.id.Mapa_feedback);
        mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapa = new Intent (v.getContext(), Map.class);
                startActivityForResult(mapa, 0);
            }
        });

        Button crafteo = (Button) findViewById(R.id.Crafteo_feedback);
        crafteo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent crafteo = new Intent (v.getContext(), recetas.class);
                startActivityForResult(crafteo, 0);
            }
        });

        Button personajes = (Button) findViewById(R.id.Personajes_feedback);
        personajes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent personajes = new Intent (v.getContext(), MainActivity.class);
                startActivityForResult(personajes, 0);
            }
        });
        Button noticias = (Button) findViewById(R.id.Noticias_feedback);
        noticias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent noticias = new Intent (v.getContext(), noticias.class);
                startActivityForResult(noticias, 0);
            }
        });

        final EditText your_name        = (EditText) findViewById(R.id.your_name);
        final EditText your_email       = (EditText) findViewById(R.id.your_email);
        final EditText your_subject     = (EditText) findViewById(R.id.your_subject);
        final EditText your_message     = (EditText) findViewById(R.id.your_message);


        Button email = (Button) findViewById(R.id.post_message);
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name      = your_name.getText().toString();
                String email     = your_email.getText().toString();
                String subject   = your_subject.getText().toString();
                String message   = your_message.getText().toString();
                if (TextUtils.isEmpty(name)){
                    your_name.setError("Escribe tu nombre");
                    your_name.requestFocus();
                    return;
                }

                Boolean onError = false;
                if (!isValidEmail(email)) {
                    onError = true;
                    your_email.setError("Email incorrecto");
                    return;
                }

                if (TextUtils.isEmpty(subject)){
                    your_subject.setError("Enter Your Subject");
                    your_subject.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(message)){
                    your_message.setError("Escribe tu mensaje");
                    your_message.requestFocus();
                    return;
                }

                Intent sendEmail = new Intent(android.content.Intent.ACTION_SEND);

            /* Fill it with Data */
                sendEmail.setType("plain/text");
                sendEmail.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"alejandro99aru.com"});
                sendEmail.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
                sendEmail.putExtra(android.content.Intent.EXTRA_TEXT,
                        "name:"+name+'\n'+"Email ID:"+email+'\n'+"Message:"+'\n'+message);

            /* Send it off to the Activity-Chooser */
                startActivity(Intent.createChooser(sendEmail, "Enviar sugerencia mediante..."));


            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        //Get a Tracker (should auto-report)


    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }


    // validating email id

    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }




}
