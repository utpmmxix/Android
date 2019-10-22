package app.conoceme.myapplication_yens.Views.Implement;

public interface IRegisterView {
    void showProgress();
    void hideProgress();

    void setNameError();
    void setLastNameError();
    void setCorreoError();
    void setUsernameError();
    void setPasswordError();
    void setConfirmPasswordError();

    void setError();

    void showMensaje(String mensaje);
    void hideMensaje();
    void navigateToLogin();
    void navigateToSuccessful();

}
