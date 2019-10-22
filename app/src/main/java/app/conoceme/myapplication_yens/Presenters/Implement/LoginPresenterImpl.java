package app.conoceme.myapplication_yens.Presenters.Implement;

import android.content.Context;

import app.conoceme.myapplication_yens.Models.Interactors.Implement.LoginInteractorImpl;
import app.conoceme.myapplication_yens.Models.Interactors.Interfaces.IInteractor.ILoginInteractor;
import app.conoceme.myapplication_yens.Presenters.Interfaces.ILoginPresenter;
import app.conoceme.myapplication_yens.Views.Implement.ILoginView;
import app.conoceme.myapplication_yens.Models.Interactors.Interfaces.IListener.IOnLoginFinishedListener;

public class LoginPresenterImpl implements ILoginPresenter, IOnLoginFinishedListener {
    private ILoginView loginView;
    private ILoginInteractor loginInteractor;

    public LoginPresenterImpl(ILoginView loginView) {
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void validateCredential(String name, String password, Context context) {
        if(loginView != null){
            loginView.showProgress();
        }
        loginInteractor.login(name,password,context,this);
    }

    @Override
    public void onDestroy() {
        loginView = null;
    }

    @Override
    public void onUsernameError() {
        if(loginView != null){
            loginView.setUsernameError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onPasswordError() {
        if(loginView != null){
            loginView.setPasswordError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onSucces() {
        if(loginView != null){
            loginView.hideProgress();
            loginView.navigateToHome();
        }
    }

    @Override
    public void onError() {
        if(loginView != null){
            loginView.hideProgress();
            loginView.setError();
        }
    }

    @Override
    public void onLoginError() {
        if(loginView != null){
            loginView.hideProgress();
            loginView.setLoginError();
        }
    }
}
