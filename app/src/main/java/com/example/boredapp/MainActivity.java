package com.example.boredapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public void page1 (View view){

        Intent intent = new Intent(getApplicationContext(), display1.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
//RequestQueue mRequestQueue = Volley.newRequestQueue(this);

//String Request initialized
        /*StringRequest mStringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject obj = new JSONObject(response);
                    activity=obj.getString("activity");
                    Log.i("Hey","H1"+obj.getString("activity"));
                    text1.setText(activity);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Toast.makeText(getApplicationContext(),"Response :" + activity, Toast.LENGTH_LONG).show();//display the response on screen

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.i("hi", "Error :" + error.toString());
            }
        });

        mRequestQueue.add(mStringRequest);*/

        /*String tag_json_obj = "activity";


        ProgressDialog pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...PLease wait");
        pDialog.show();

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST, url, null,
                new Response.Listener() {

                    @Override
                    public void onResponse(Object response) {
                        Log.d(TAG, response.toString());
                        pDialog.hide();
                    }

                },
                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        VolleyLog.d(TAG, "Error: "
                                + error.getMessage());
                        pDialog.hide();
                    }
                }) {

            @Override
            protected Map getParams()
            {
                Map params = new HashMap();
                params.put("type", "social");
                params.put("participants", "2");


                return params;
            }

        };

        AppController.getInstance(this).addToRequestQueue(jsonObjReq);


    }
    }
     class AppController extends display1{
         private static AppController mInstance;

         private RequestQueue mRequestQueue;

         private static Context mCtx;

         private AppController(Context context){
             mCtx = context;
             mRequestQueue = getRequestQueue();
         }

         public static synchronized AppController getInstance(Context context) {
             if (mInstance == null) {
                 mInstance = new AppController(context);
             }
             return mInstance;
         }

         public RequestQueue getRequestQueue() {
             if (mRequestQueue == null) {
                 mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
             }
             return mRequestQueue;
         }

         public <T> void addToRequestQueue(@NonNull final Request<T> request) {
             getRequestQueue().add(request);
         }

         public <T> void addToRequestQueueWithTag(@NonNull final Request<T> request, String tag) {
             request.setTag(tag);
             getRequestQueue().add(request);
         }

    }*/