package com.example.shaikhahmaasher.swappee_1;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shaikhah Maasher on 9/26/2016.
 */
public class LoginRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "http://tswappee.comuf.com/Login.php";
    private Map<String, String> params;

    public LoginRequest(String username, String pass, Response.Listener<String> listener) {
        super(Request.Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("username", username);
        params.put("pass", pass);
    }
    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
