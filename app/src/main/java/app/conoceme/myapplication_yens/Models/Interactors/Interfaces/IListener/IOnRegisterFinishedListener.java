package app.conoceme.myapplication_yens.Models.Interactors.Interfaces.IListener;

public interface IOnRegisterFinishedListener {

    void onNameError();
    void onLastNameError();
    void onCorreoError();
    void onUsernameError();
    void onPasswordError();
    void onConfirmPasswordError();
    void onMensaje(String mensaje);
    void onSucces();
    void onError();
}
