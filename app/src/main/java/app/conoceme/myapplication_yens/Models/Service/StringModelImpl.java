package app.conoceme.myapplication_yens.Models.Service;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

public class StringModelImpl {

    private Context context;

    public StringModelImpl(Context context) {
        this.context = context;
    }

    public void metodo_post( final String endPoint, final JSONObject  jsonBody, final IOnStringListener listener){

        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.POST, endPoint,
                jsonBody, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                listener.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                //error.printStackTrace();
                listener.onError(volleyError);
            }
        });

        VolleyConfig.getVolleyConfigSingleton(context).addToRequestQueue(jsonRequest);
    }

    public void metodo_put( final String endPoint, final JSONObject  jsonBody, final IOnStringListener listener){

        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.PUT, endPoint,
                jsonBody, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                listener.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                //error.printStackTrace();
                listener.onError(volleyError);
            }
        });

        VolleyConfig.getVolleyConfigSingleton(context).addToRequestQueue(jsonRequest);
    }

}
