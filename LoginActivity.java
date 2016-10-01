package com.example.shaikhahmaasher.swappee_1;

/**
 * Created by Shaikhah Maasher on 9/26/2016.
 */
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etUser_email = (EditText) findViewById(R.id.etUsername);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);

        final TextView tvRegisterLink = (TextView) findViewById(R.id.tvRegisterLink);
        final Button bLogin = (Button) findViewById(R.id.bSignIn);

        tvRegisterLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("loginActivity","login listener");
                final String username = etUser_email.getText().toString();
                final String pass = etPassword.getText().toString();

                // Response received from the server
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("loginActivity","response listener");
                        try {
                            Log.d("loginActivity","before jsonResponse");
                            JSONObject jsonResponse = new JSONObject(response);
                            Log.d("loginActivity","jsonResponse");
                            boolean success = jsonResponse.getBoolean("success");
                            Log.d("loginActivity","successResponse"+success);
                            // Data to send to profile
                            if (success) {

                                Log.d("loginActivity","login success");

                                String username = jsonResponse.getString("username");
                                String email = jsonResponse.getString("email");
                                String gender = jsonResponse.getString("gender");
                                String country = jsonResponse.getString("country");
                                String city = jsonResponse.getString("city");

                                /*
                                // Search more -  **Cache
                                Intent intent = new Intent(LoginActivity.this, UserAreaActivity.class);
                                intent.putExtra("username", username);
                                intent.putExtra("email", email);
                                intent.putExtra("gender", gender);
                                LoginActivity.this.startActivity(intent);
                                */
                            } else {
                                Log.d("loginActivity","Failed");
                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                builder.setMessage("Login Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                LoginRequest loginRequest = new LoginRequest(username, pass, responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);
            }
        });
    }
}
