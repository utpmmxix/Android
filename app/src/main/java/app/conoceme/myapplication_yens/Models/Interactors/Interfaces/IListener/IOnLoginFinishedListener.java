package app.conoceme.myapplication_yens.Models.Interactors.Interfaces.IListener;

public interface IOnLoginFinishedListener {
    void onUsernameError();
    void onPasswordError();
    void onLoginError();
    void onSucces();
    void onError();

}
