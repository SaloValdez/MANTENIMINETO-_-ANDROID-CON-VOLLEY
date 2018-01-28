package com.example.salovaldez.loginservice;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SaloValdez on 27/01/2018.
 */

public class LoginRequest extends StringRequest{

    private  static final String LOGIN_REQUEST_URL="http://192.168.46.2/WebService/login.php";
    private Map<String,String> params;

    public LoginRequest(String correo, String pas, Response.Listener<String> listener){
        super   (Request.Method.POST,LOGIN_REQUEST_URL,listener,null);
        params = new HashMap<>();
        params.put("correo ",correo);
        params.put("pas",pas);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
