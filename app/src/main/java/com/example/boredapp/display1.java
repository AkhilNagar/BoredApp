package com.example.boredapp;


import static android.content.ContentValues.TAG;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class display1 extends AppCompatActivity {
    String type="education";
    EditText participants;
    String activity;
    TextView text1;
    Spinner dropdown;


    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);

        participants = (EditText) findViewById(R.id.participants);
        text1 = (TextView) findViewById(R.id.text1);
        dropdown = findViewById(R.id.spinner2);
        String[] items = new String[]{"education", "recreation", "social", "charity", "cooking","relaxation","busywork","diy"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
    }

    public void todo(View view) {
        setContentView(R.layout.display);
        text1 = (TextView) findViewById(R.id.text1);
        participants = (EditText) findViewById(R.id.participants);
        dropdown = findViewById(R.id.spinner2);
        String[] items = new String[]{"education", "recreation", "social", "charity", "cooking","relaxation","busywork","diy"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                //Toast.makeText(display1.this, dropdown.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
                //type = dropdown.getSelectedItem().toString();
                type = parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });

        Log.i("TAG","aaaa"+type);
        Log.i("TAG","bbbb"+participants.getText());
        String postUrl= "https://still-temple-97961.herokuapp.com/hello-servlet";
        String postBody="{\n" +
                "    \"type\": \""+type+"\",\n" +
                "    \"participants\": \""+participants.getText()+"\"\n" +
                "}";
        Log.i("TAG","111111"+postBody);
        try {
            postRequest(postUrl,postBody);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void postRequest(String postUrl,String postBody) throws IOException {

        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(JSON, postBody);

        Request request = new Request.Builder()
                .url(postUrl)
                .post(body)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                call.cancel();
                text1.setText("No activity found!");
            }

            @Override
            public void onResponse(Call call, okhttp3.Response response) throws IOException {
                activity=response.body().string();
                text1.setText(activity);

                Log.i("TAG","Works"+activity);

            }


        });
    }
}


