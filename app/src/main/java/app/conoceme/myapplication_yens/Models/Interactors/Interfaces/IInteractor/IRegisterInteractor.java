package app.conoceme.myapplication_yens.Models.Interactors.Interfaces.IInteractor;

import android.content.Context;

import app.conoceme.myapplication_yens.Models.Interactors.Interfaces.IListener.IOnRegisterFinishedListener;

public interface IRegisterInteractor {
    void registerAccount(String name, String lastName, String mail, String usuario, String password, String confirPassword, Context context, IOnRegisterFinishedListener listener);
}
