package app.conoceme.myapplication_yens.Models.Interactors.Interfaces.IInteractor;

import android.content.Context;

import app.conoceme.myapplication_yens.Models.Interactors.Interfaces.IListener.IOnCambiarClaveFinishedListener;

public interface ICambiarClaveInteractor {
    void login(int id, String claveActual,String claveNueva,String claveActualConfirmar,
               Context context, IOnCambiarClaveFinishedListener listener);
}
