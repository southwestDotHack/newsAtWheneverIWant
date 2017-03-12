package com.example.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.volley.*;
import android.util.*;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

import static com.android.volley.toolbox.Volley.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class NewsReadExample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView sometextview = (TextView)findViewById(R.id.textview);
        sometextview.setText("DOES THIS WORK?");

       // JsonObject obj1 = convertFileToJSON("C:\\Users\\sinty\\AndroidStudioProjects/MyFirstApp/app/src/main/assets/news.json");
        try {
            JSONArray arr1 = new JSONArray(loadJSONFromAsset());
            double output = (double)arr1.getJSONObject(0).getJSONObject("geometry").getJSONArray("coordinates").get(0);
            sometextview.setText(output + "");
        }catch (Exception e)
        {
            sometextview.setText(e.getMessage());
        }

//        String url = " http://date.jsontest.com";

//        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.GET, url, null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        TextView sometextview = (TextView)findViewById(R.id.textview);
//                        sometextview.setText("THIS REALLY WORKS");
//                        try{
//                            sometextview.setText(response.toString());
//                        }
//                        catch(Exception e) {
//                            sometextview.setText("FAIL");
//                        }
//                    }
//                },
//
//                new Response.ErrorListener(){
//                    @Override
//                    public void onErrorResponse(VolleyError error)
//                    {
//                        TextView sometextview = (TextView)findViewById(R.id.textview);
//                        sometextview.setText("ERROR");
//                        sometextview.setText(error.getMessage());
//                    }
//                });
//
//        Volley.newRequestQueue(this).add(jsonRequest);
    }

    public String loadJSONFromAsset(){

        // Read from File to String
        String json = null;
        try {
            InputStream is = getAssets().open("news.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (FileNotFoundException e) {
            Log.e("FiLeNoTfOuNd", e.getMessage());
        } catch (IOException ioe){
            Log.e("IoExCePtIoN", ioe.getMessage());
        } catch (Exception e) {
            Log.e("OtHeReXcEpTiOn", e.getMessage());
        }

        return json;
    }
}
