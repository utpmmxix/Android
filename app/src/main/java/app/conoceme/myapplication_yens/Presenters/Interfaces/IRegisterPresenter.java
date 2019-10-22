package app.conoceme.myapplication_yens.Presenters.Interfaces;

import android.content.Context;

public interface IRegisterPresenter {
    void registerAccount(String name, String lastName, String mail, String usuario, String password, String confirPassword, Context context);
    void onDestroy();
}
