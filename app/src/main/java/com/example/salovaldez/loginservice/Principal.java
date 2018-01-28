package com.example.salovaldez.loginservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
TextView nombres,usu,contra,img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        nombres =  (TextView) findViewById(R.id.TextV_nombre);
        usu =  (TextView) findViewById(R.id.TextV_correo);
        contra =  (TextView) findViewById(R.id.TextV_contraseña);
        img =  (TextView) findViewById(R.id.TextV_imagen);

        //Intent in = getIntent();

      //  String name = in.getStringExtra("name");
        //String username = in.getStringExtra("username");
        //String pas = in.getStringExtra("pas");
        //String imgs = in.getStringExtra("img");

        //nombres.setText(name);
        //usu.setText(username);
        //contra.setText(pas);
        //img.setText(imgs);

    }
}
