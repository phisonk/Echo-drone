package com.echo.karndiss.openecho;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickopen(View v){
        Button button = (Button) v;
        ((Button) v).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //calling an activity using <intent-filter> action name

                Intent intent = getPackageManager().getLaunchIntentForPackage("com.parrot.freeflight4mini");
                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                try{
                    startActivity(intent);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
    public void onClickmove(View v){
        Button button = (Button) v;
        ((Button) v).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent("com.echo.karndiss.openecho.KwanActivity");
                startActivity(intent);
            }
        });
    }
    public void onClickturnon(View v){
        Button button = (Button) v;
        ((Button) v).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openWebURL("http://192.168.1.33:40000/speaker/turn/on/");
            }
        });
    }
    public void onClickturnoff(View v){
        Button button = (Button) v;
        ((Button) v).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openWebURL("http://192.168.1.33:40000/speaker/turn/off/");
            }
        });
    }
    public void onClickturnon_0(View v){
        Button button = (Button) v;
        ((Button) v).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openWebURL("http://192.168.1.34:40000/speaker/turn/on/");
            }
        });
    }
    public void onClickturnoff_0(View v){
        Button button = (Button) v;
        ((Button) v).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openWebURL("http://192.168.1.34:40000/speaker/turn/off/");
            }
        });
    }
    public void openWebURL( String inURL ) {
        Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( inURL ) );

        startActivity( browse );
    }
    public void httpsend(String urll){
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = urll;
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(stringRequest);
    }
}
