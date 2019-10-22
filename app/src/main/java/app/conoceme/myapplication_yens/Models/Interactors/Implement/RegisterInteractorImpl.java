package app.conoceme.myapplication_yens.Models.Interactors.Implement;

import android.content.Context;

import com.android.volley.VolleyError;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import app.conoceme.myapplication_yens.Models.Interactors.Interfaces.IListener.IOnRegisterFinishedListener;
import app.conoceme.myapplication_yens.Models.Interactors.Interfaces.IInteractor.IRegisterInteractor;
import app.conoceme.myapplication_yens.Models.Service.IOnStringListener;
import app.conoceme.myapplication_yens.Models.Service.StringModelImpl;

public class RegisterInteractorImpl implements IRegisterInteractor, IOnStringListener {
    private String nombre;
    private String apellido;
    private String correoElectronico;
    private String usuario ;
    private String clave ;
    private String confirmarClave;

    String result;

    private StringModelImpl model;
    private IOnRegisterFinishedListener listener;

    @Override
    public void registerAccount(String nombre, String apellido, String correoElectronico, String usuario, String clave, String confirmarClave, Context context, final IOnRegisterFinishedListener listener) {
        this.nombre = nombre;
        this.apellido =apellido;
        this.correoElectronico =correoElectronico;
        this.usuario =usuario;
        this.clave=clave;
        this.confirmarClave=confirmarClave;
        this.listener=listener;

        Map<String, String> params = new HashMap<>();
        params.put("CorreoElectronico",correoElectronico);
        params.put("Usuario",usuario);
        params.put("Contrasenia",clave);
        params.put("Nombre",nombre);
        params.put("Apellido",apellido);
        JSONObject jsonBody = new JSONObject(params);

        if (isValidData()) {
            String endPoint ="http://api-social.control-zeta.net/api/Usuario";
            model = new StringModelImpl(context);
            model.metodo_post(endPoint,jsonBody,this);
        }
    }

    @Override
    public void onSuccess(JSONObject result) {
        this.result=result.toString();

        String procesadoOk=result.optString("ProcesadoOk");
        String ListaError=result.optString("ListaError");
        String IdGenerado=result.optString("IdGenerado");

        if(procesadoOk.equals("true")){
            listener.onSucces();
        }else {
            listener.onError();
        }
    }

    @Override
    public void onError(VolleyError erro) {
        listener.onError();

    }

    public boolean isValidData() {
        boolean state = true;

        if (nombre.isEmpty()) {
            state = false;
            listener.onNameError();
        }
        if (apellido.isEmpty()) {
            state = false;
            listener.onLastNameError();
        }
        if (correoElectronico.isEmpty()) {
            state = false;
            listener.onCorreoError();
        }
        if (usuario.isEmpty()) {
            state = false;
            listener.onUsernameError();
        }
        if (clave.isEmpty()) {
            state = false;
            listener.onPasswordError();
        }
        if(confirmarClave.isEmpty()){
            state = false;
            listener.onConfirmPasswordError();
        }

        if(state){
            if(!clave.equals(confirmarClave)){
                state=false;
                listener.onMensaje("El password ingresado no coincide con el password confirmado.");
            }else if(clave.length()<8){
                state = false;
                listener.onMensaje("El password debe tener al menos 8 caracteres");
            }
        }

        return state;
    }
}
