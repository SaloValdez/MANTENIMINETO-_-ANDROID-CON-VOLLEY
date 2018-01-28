package com.example.salovaldez.loginservice;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

     EditText txtCor,txtPas;
   Button btnIngresar;

    TextView tv_registrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCor = (EditText) findViewById(R.id.TV_usu);
        txtPas = (EditText) findViewById(R.id.Tv_pas);

        tv_registrar = (TextView) findViewById(R.id.tv_registrar);
        btnIngresar = (Button) findViewById(R.id.btnIngresar);

        tv_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this,Registro.class);
                MainActivity.this.startActivity(i);
            }
        });

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String correo =txtCor.getText().toString();
                final String pas =txtPas.getText().toString();

                Response.Listener <String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success){

                              //  String name = jsonResponse.getString("name");
                                //String imagen = jsonResponse.getString("imagen");

                                Intent in = new Intent(MainActivity.this,Principal.class);
                                //in.putExtra("name",name);
                               // in.putExtra("correo",correo);
                                //in.putExtra("pas",pas);
                                //in.putExtra("imagen",imagen);

                                MainActivity.this.startActivity(in);


                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                builder.setMessage("Error login")
                                        .setNegativeButton("Retry",null)
                                        .create().show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };


                LoginRequest loginRequest = new LoginRequest(correo,pas,responseListener);

                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                queue.add(loginRequest);


            }
        });
    }


}
