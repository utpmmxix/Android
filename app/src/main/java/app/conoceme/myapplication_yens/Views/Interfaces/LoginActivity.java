package app.conoceme.myapplication_yens.Views.Interfaces;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;



import app.conoceme.myapplication_yens.Presenters.Interfaces.ILoginPresenter;
import app.conoceme.myapplication_yens.Views.Implement.ILoginView;
import app.conoceme.myapplication_yens.Presenters.Implement.LoginPresenterImpl;
import app.conoceme.myapplication_yens.R;

public class LoginActivity extends AppCompatActivity implements ILoginView, View.OnClickListener{
    private EditText username;
    private EditText password;
    private ProgressBar progressBar;

    private ILoginPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //find view
        username = (EditText) this.findViewById(R.id.txtUsername);
        password = (EditText) this.findViewById(R.id.txtUserPassword);
        progressBar = (ProgressBar) this.findViewById(R.id.progress_login);

        findViewById(R.id.btnLogin).setOnClickListener(this);
        findViewById(R.id.btnRecuperar).setOnClickListener(this);
        findViewById(R.id.btnRegistrar).setOnClickListener(this);

        presenter = new LoginPresenterImpl(this);

    }


    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {
        username.setError("Campo obligatorio");
    }

    @Override
    public void setPasswordError() {
        password.setError("Campo obligatorio");
    }

    public void setLoginError() {
        Toast.makeText(this,"El Usuario o Clave ingresado no es válido!",Toast.LENGTH_LONG).show();
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(LoginActivity.this, PrincipalActivity.class));
    }

    @Override
    public void navigateToRecover() {
        startActivity(new Intent(LoginActivity.this, RecoverActivity.class));
    }

    @Override
    public void navigateToRegister() {
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
    }

    @Override
    public void setError() {
        Toast.makeText(this,"Connection failed",Toast.LENGTH_LONG).show();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogin:
                presenter.validateCredential(username.getText().toString(),password.getText().toString(),this);
                break;
            case R.id.btnRecuperar:
                navigateToRecover();
                break;
            case R.id.btnRegistrar:
                navigateToRegister();
                break;
        }

    }
}
