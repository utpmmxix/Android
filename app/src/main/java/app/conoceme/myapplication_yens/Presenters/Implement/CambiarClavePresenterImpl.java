package app.conoceme.myapplication_yens.Presenters.Implement;

import android.content.Context;

import app.conoceme.myapplication_yens.Models.Interactors.Implement.CambiarClaveInteractorImpl;
import app.conoceme.myapplication_yens.Models.Interactors.Interfaces.IInteractor.ICambiarClaveInteractor;
import app.conoceme.myapplication_yens.Presenters.Interfaces.ICambiarClavePresenter;
import app.conoceme.myapplication_yens.Views.Implement.ICambiarClaveView;
import app.conoceme.myapplication_yens.Models.Interactors.Interfaces.IListener.IOnCambiarClaveFinishedListener;

public class CambiarClavePresenterImpl implements ICambiarClavePresenter, IOnCambiarClaveFinishedListener {

    private ICambiarClaveView view;
    private ICambiarClaveInteractor interactor;

    public CambiarClavePresenterImpl(ICambiarClaveView view) {
        this.view = view;
        this.interactor = new CambiarClaveInteractorImpl();
        //this.interactor =
    }

    @Override
    public void cambiarClave(int id, String claveActual, String claveNueva, String claveActualConfirmar, Context context) {
        if(view != null){
            view.showProgress();
        }
        interactor.login(id,claveActual,claveNueva,claveActualConfirmar,context,this);
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onClaveActual() {
        if(view != null){
            view.setClaveActual();
            view.hideProgress();
        }
    }

    @Override
    public void onNuevaClave() {
        if(view != null){
            view.setNuevaClave();
            view.hideProgress();
        }
    }

    @Override
    public void onNuevaClaveConfirmar() {
        if(view != null){
            view.setNuevaClaveConfirmar();
            view.hideProgress();
        }
    }

    @Override
    public void onMensaje(String mensaje) {
        if(view != null){
            view.hideProgress();
            //view.navigateToHome();
        }
    }

    @Override
    public void onSucces() {
        if(view != null){
            view.hideProgress();
            view.setMensaje();
        }
    }

    @Override
    public void onError() {
        if(view != null){
            view.hideProgress();
            view.setError();
        }
    }
}
