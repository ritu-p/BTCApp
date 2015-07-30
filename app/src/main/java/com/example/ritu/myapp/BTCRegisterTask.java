package com.example.ritu.myapp;

import android.os.AsyncTask;

/**
 * Created by ritu on 23-04-2015.
 */
public class BTCRegisterTask extends AsyncTask<String,Void,Void> {

    @Override
    protected Void doInBackground(String... params) {
      postData(params[0]);
        return null;
    }
    public void postData(String postdata) {

        String fullUrl = "https://docs.google.com/forms/d/1Pw_HU5BdR6qTfMAAeWTA1dhyjV0iIBMpFHSwqQC9Ts8/formResponse";
        HttpRequest mReq = new HttpRequest();

       /* String data = "entry.1722392132=" + URLEncoder.encode(col1) + "&" +
                "entry.643021367=" + URLEncoder.encode(col2)+ "&" +
        "entry.1698971865=" + URLEncoder.encode(col2)+ "&" +
        "entry.460325435=" + URLEncoder.encode(col2);*/
        String response = mReq.sendPost(fullUrl, postdata);
        //Logger log=    Logger.getLogger();
        // Log.i(myTag, response);
    }
}
