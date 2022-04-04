package com.example.boredapp;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.appcompat.app.AppCompatActivity;

public class display1 extends AppCompatActivity {
    EditText type;
    String activity;
    TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
        type = (EditText) findViewById(R.id.type);
    }
    public void todo(View view){
        String url = "http://www.boredapi.com/api/activity?type="+type.getText();
        RequestQueue queue = Volley.newRequestQueue(display1.this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.POST, url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try{
                            JSONObject obj = response.getJSONObject("data");
                            activity = obj.getString("activity");

                        }catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Tag", "response is error"+error);
                        Toast.makeText(display1.this, "Failed to get response", Toast.LENGTH_SHORT).show();

                    }

                });

        queue.add(jsonObjectRequest);
        text1.setText(activity);
    }
}
