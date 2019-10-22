package app.conoceme.myapplication_yens.Presenters.Interfaces;

import android.content.Context;

public interface ICambiarClavePresenter {
    void cambiarClave(int id, String claveActual,String claveNueva,String claveActualConfirmar, Context context);
    void onDestroy();
}
