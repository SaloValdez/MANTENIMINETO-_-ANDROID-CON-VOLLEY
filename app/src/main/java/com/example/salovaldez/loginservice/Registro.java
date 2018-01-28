package com.example.salovaldez.loginservice;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Registro extends AppCompatActivity implements View.OnClickListener {

    EditText etnombre,etcorreo,etcontra,etimagen;
    Button btn_Registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);


        etnombre = (EditText) findViewById(R.id.txtNombre);
        etcorreo = (EditText) findViewById(R.id.txtCorreo);
        etcontra = (EditText) findViewById(R.id.txtPas);
        etimagen = (EditText) findViewById(R.id.txtImagen);

        btn_Registrar = (Button) findViewById(R.id.btnRegistrar);


       btn_Registrar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        final String name = etnombre.getText().toString();
        final String cor = etcorreo.getText().toString();
        final String contras = etcontra.getText().toString();
        final String img = etimagen.getText().toString();

        Response.Listener<String> respoListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if (success){
                        Intent i = new Intent(Registro.this,MainActivity.class);
                        Registro.this.startActivity(i);
                    }else{

                        AlertDialog.Builder builder = new AlertDialog.Builder(Registro.this);
                        builder.setMessage("Error registro")
                                .setNegativeButton("Retry",null)
                                .create().show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        RegisterRequest  registerRequest = new RegisterRequest(name,cor,contras,img,respoListener);

        RequestQueue queue = Volley.newRequestQueue(Registro.this);
        queue.add(registerRequest);
    }
}
