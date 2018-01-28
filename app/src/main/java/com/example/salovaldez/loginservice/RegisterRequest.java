package com.example.salovaldez.loginservice;

import android.net.sip.SipSession;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SaloValdez on 27/01/2018.
 */

public class RegisterRequest extends StringRequest{

    private  static final String REGISTER_REQUEST_URL="http://192.168.46.2/WebService/registro.php";
    private Map<String,String>params;

    public RegisterRequest(String name, String correo, String contra, String imagen, Response.Listener<String> listener){
        super   (Method.POST,REGISTER_REQUEST_URL,listener,null);
        params = new HashMap<>();
        params.put("username",name);
        params.put("correo",correo);
        params.put("password",contra);
        params.put("imagen",imagen);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
