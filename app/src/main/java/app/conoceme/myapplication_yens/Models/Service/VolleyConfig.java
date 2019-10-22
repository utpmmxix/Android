package app.conoceme.myapplication_yens.Models.Service;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleyConfig {

    private static VolleyConfig volleyConfig;
    private  RequestQueue requestQueue;

    private VolleyConfig(Context context){
        requestQueue = Volley.newRequestQueue(context.getApplicationContext());
    }

    public static synchronized VolleyConfig getVolleyConfigSingleton(Context context){
        if(volleyConfig == null){
            volleyConfig= new VolleyConfig(context);
        }
        return volleyConfig;
    }

    public RequestQueue getRequestQueue() {
        return this.requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> request){
        getRequestQueue().add(request);
    }
}
