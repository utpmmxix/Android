package app.conoceme.myapplication_yens.Presenters.Implement;

import android.content.Context;

import app.conoceme.myapplication_yens.Models.Interactors.Implement.RegisterInteractorImpl;
import app.conoceme.myapplication_yens.Models.Interactors.Interfaces.IListener.IOnRegisterFinishedListener;
import app.conoceme.myapplication_yens.Models.Interactors.Interfaces.IInteractor.IRegisterInteractor;
import app.conoceme.myapplication_yens.Presenters.Interfaces.IRegisterPresenter;
import app.conoceme.myapplication_yens.Views.Implement.IRegisterView;

public class RegisterPresenterImpl implements IRegisterPresenter, IOnRegisterFinishedListener {
    private IRegisterView registerView;
    private IRegisterInteractor registerInteractor;

    public RegisterPresenterImpl(IRegisterView registerView) {
        this.registerView = registerView;
        this.registerInteractor = new RegisterInteractorImpl();
    }

    @Override
    public void registerAccount(String name, String lastName, String mail, String usuario, String password, String confirPassword, Context context) {
        if(registerView != null){
            registerView.showProgress();
        }
        registerInteractor.registerAccount(name,lastName,mail,usuario,password,confirPassword,context,this);
    }

    @Override
    public void onDestroy() {
        registerView =null;
    }

    @Override
    public void onNameError() {
        if(registerView != null){
            registerView.setNameError();
            registerView.hideProgress();
        }
    }

    @Override
    public void onLastNameError() {
        if(registerView != null){
            registerView.setLastNameError();
            registerView.hideProgress();
        }
    }

    @Override
    public void onCorreoError() {
        if(registerView != null){
            registerView.setCorreoError();
            registerView.hideProgress();
        }
    }

    @Override
    public void onUsernameError() {
        if(registerView != null){
            registerView.setUsernameError();
            registerView.hideProgress();
        }
    }

    @Override
    public void onPasswordError() {
        if(registerView != null){
            registerView.setPasswordError();
            registerView.hideProgress();
        }
    }

    @Override
    public void onConfirmPasswordError() {
        if(registerView != null){
            registerView.setConfirmPasswordError();
            registerView.hideProgress();
        }
    }

    @Override
    public void onMensaje(String mensaje) {
        if(registerView != null){
            if (!mensaje.isEmpty()){
                registerView.showMensaje(mensaje);

            }else{
                registerView.hideMensaje();
            }
            registerView.hideProgress();
        }
    }

    @Override
    public void onSucces() {
        if(registerView != null){
            registerView.hideProgress();
            onMensaje("La cuenta ha sido creada satisfactoriamente!");
            //registerView.navigateToSuccessful();
        }
    }

    @Override
    public void onError() {
        if(registerView != null){
            registerView.hideProgress();
            registerView.setError();
        }
    }
}
