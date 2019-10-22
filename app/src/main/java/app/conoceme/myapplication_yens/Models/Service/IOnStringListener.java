package app.conoceme.myapplication_yens.Models.Service;

import com.android.volley.VolleyError;

import org.json.JSONObject;

public interface IOnStringListener {
    void onSuccess(JSONObject result);
    void onError(VolleyError erro);
}
