package com.example.shaikhahmaasher.swappee_1;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shaikhah Maasher on 9/26/2016.
 */
public class RegisterRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "http://tswappee.comuf.com/Register.php";
    private Map<String, String> params;

    public RegisterRequest(String username, String email, String gender, String country,
                           String city, String pass, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("username", username);
        params.put("email", email);
        params.put("gender", gender);
        params.put("country", country);
        params.put("city", city);
        params.put("pass", pass);
    }
    @Override
    public Map<String, String> getParams() {

        return params;
    }
}
