package com.example.photosearch;


import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class SingleTonClass {
    private static SingleTonClass singletonClass;
    private RequestQueue requestQueue;
    private Context mContext;

    private SingleTonClass(Context context) {
        mContext = context;
        requestQueue = getRequestQueue();
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null)
            requestQueue = Volley.newRequestQueue(mContext);
        return requestQueue;
    }

    public static SingleTonClass getInstance(Context context) {
        if (singletonClass == null)
            singletonClass = new SingleTonClass(context);
        return singletonClass;
    }

    public <T> void addToRequestQueue(Request<T> request) {

        requestQueue.add(request);
    }

}
