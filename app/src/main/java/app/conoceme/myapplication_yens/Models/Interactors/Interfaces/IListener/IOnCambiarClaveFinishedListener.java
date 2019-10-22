package app.conoceme.myapplication_yens.Models.Interactors.Interfaces.IListener;

public interface IOnCambiarClaveFinishedListener {

    void onClaveActual();
    void onNuevaClave();
    void onNuevaClaveConfirmar();
    void onMensaje(String mensaje);
    void onSucces();
    void onError();
}
