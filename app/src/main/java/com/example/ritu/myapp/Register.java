package com.example.ritu.myapp;

import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.URLEncoder;
import java.util.logging.Logger;


public class Register extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);
       /* if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }*/
        Button button = (Button) findViewById(R.id.btnOK);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                String data = "entry.1722392132=" + URLEncoder.encode(((EditText)findViewById(R.id.editName)).getText().toString()) + "&" +
                        "entry.643021367=" + URLEncoder.encode(((EditText)findViewById(R.id.editEmail)).getText().toString())+ "&" +
                        "entry.1698971865=" + URLEncoder.encode(((EditText)findViewById(R.id.editMobNumber)).getText().toString())+ "&" +
                        "entry.460325435=" + URLEncoder.encode(((EditText)findViewById(R.id.editDOB)).getText().toString());
                postData(data);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void postData(String postdata) {

        String fullUrl = "https://docs.google.com/forms/d/1Pw_HU5BdR6qTfMAAeWTA1dhyjV0iIBMpFHSwqQC9Ts8/formResponse";
        HttpRequest mReq = new HttpRequest();
        String col1 = "Hello";
        String col2 = "World";

       /* String data = "entry.1722392132=" + URLEncoder.encode(col1) + "&" +
                "entry.643021367=" + URLEncoder.encode(col2)+ "&" +
        "entry.1698971865=" + URLEncoder.encode(col2)+ "&" +
        "entry.460325435=" + URLEncoder.encode(col2);*/
        String response = mReq.sendPost(fullUrl, postdata);
    //Logger log=    Logger.getLogger();
       // Log.i(myTag, response);
    }
}
