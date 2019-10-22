package app.conoceme.myapplication_yens.Models.Interactors.Interfaces.IInteractor;

import android.content.Context;

import app.conoceme.myapplication_yens.Models.Interactors.Interfaces.IListener.IOnLoginFinishedListener;

public interface ILoginInteractor {
    void login(String username, String password, Context context, IOnLoginFinishedListener listener);
}
