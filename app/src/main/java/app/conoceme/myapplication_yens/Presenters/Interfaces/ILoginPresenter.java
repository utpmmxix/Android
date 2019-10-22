package app.conoceme.myapplication_yens.Presenters.Interfaces;

import android.content.Context;

public interface ILoginPresenter {
    void validateCredential(String name, String password, Context context);
    void onDestroy();
}
