package app.conoceme.myapplication_yens.Views.Implement;

public interface ILoginView {
    void showProgress();
    void hideProgress();
    void setUsernameError();
    void setPasswordError();
    void setLoginError();
    void navigateToHome();
    void navigateToRegister();
    void navigateToRecover();
    void setError();
}
