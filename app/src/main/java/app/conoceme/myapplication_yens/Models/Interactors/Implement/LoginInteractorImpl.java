package app.conoceme.myapplication_yens.Models.Interactors.Implement;

import android.content.Context;

import com.android.volley.VolleyError;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import app.conoceme.myapplication_yens.Models.Interactors.Interfaces.IInteractor.ILoginInteractor;
import app.conoceme.myapplication_yens.Models.Interactors.Interfaces.IListener.IOnLoginFinishedListener;
import app.conoceme.myapplication_yens.Models.Entity.User;
import app.conoceme.myapplication_yens.Models.Service.IOnStringListener;
import app.conoceme.myapplication_yens.Models.Service.StringModelImpl;


public class LoginInteractorImpl implements ILoginInteractor, IOnStringListener {

    private String result;
    private StringModelImpl model;
    private IOnLoginFinishedListener listener;
    private String username;
    private String password;
    @Override
    public void login(final String username, final String password, Context context, final IOnLoginFinishedListener listener) {
        this.listener=listener;
        this.username=username;
        this.password = password;

        Map<String, String> params = new HashMap<>();
        params.put("Usuario",username);
        params.put("Contrasenia",password);
        JSONObject jsonBody = new JSONObject(params);


        String endPoint ="http://api-social.control-zeta.net/api/Login";


        model = new StringModelImpl(context);
        model.metodo_post(endPoint,jsonBody,this);

    }

    @Override
        public void onSuccess(JSONObject result) {
        User entity;

        if(username.isEmpty() && password.isEmpty()) {
            listener.onPasswordError();
            listener.onUsernameError();
        }else if(username.isEmpty()){
            listener.onUsernameError();
        }else if(password.isEmpty()){
            listener.onPasswordError();
        }else{
            Gson gson = new Gson();
           // entity = gson.fromJson(result.toString(), User.class);
            entity=new User();
            if(entity==null){
                listener.onLoginError();
            }else{
                listener.onSucces();
            }

        }


    }

    @Override
    public void onError(VolleyError erro) {
        listener.onError();
    }
}
