package app.conoceme.myapplication_yens.Models.Interactors.Implement;

import android.content.Context;

import com.android.volley.VolleyError;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import app.conoceme.myapplication_yens.Models.Interactors.Interfaces.IInteractor.ICambiarClaveInteractor;
import app.conoceme.myapplication_yens.Models.Interactors.Interfaces.IListener.IOnCambiarClaveFinishedListener;
import app.conoceme.myapplication_yens.Models.Service.IOnStringListener;
import app.conoceme.myapplication_yens.Models.Service.StringModelImpl;

public class CambiarClaveInteractorImpl implements ICambiarClaveInteractor, IOnStringListener {

    private String result;
    private StringModelImpl model;
    private IOnCambiarClaveFinishedListener listener;

    private String claveActual;
    private String claveNueva;
    private String claveNuevaConfirmar;

    @Override
    public void login(int id, String claveActual, String claveNueva, String claveActualConfirmar, Context context, IOnCambiarClaveFinishedListener listener) {
        this.listener=listener;
        this.claveActual=claveActual;
        this.claveNueva = claveNueva;
        this.claveNuevaConfirmar = claveActualConfirmar;

        Map<String, String> params = new HashMap<>();
        params.put("IdUsuario","1");
        params.put("Contrasenia",claveNueva);
        JSONObject jsonBody = new JSONObject(params);

        String endPoint ="http://api-social.control-zeta.net/api/Usuario/ModificarContrasenia";
        if (isValidData()){
            model = new StringModelImpl(context);
            model.metodo_put(endPoint,jsonBody,this);
        }

    }

    @Override
    public void onSuccess(JSONObject result) {
            listener.onSucces();
    }

    @Override
    public void onError(VolleyError erro) {
        listener.onError();
    }

    public boolean isValidData() {
        boolean state = true;

        if (claveNuevaConfirmar.isEmpty()) {
            state = false;
            listener.onNuevaClaveConfirmar();
        }
        if (claveNueva.isEmpty()) {
            state = false;
            listener.onNuevaClave();
        }
        if (claveActual.isEmpty()) {
            state = false;
            listener.onClaveActual();
        }

        if(state){
            if(!claveNuevaConfirmar.equals(claveNueva)){
                state=false;
                listener.onMensaje("El password ingresado no coincide con el password confirmado.");
            }else if(claveNueva.length()<8){
                state = false;
                listener.onMensaje("El password debe tener al menos 8 caracteres");
            }
        }

        return state;
    }

}
