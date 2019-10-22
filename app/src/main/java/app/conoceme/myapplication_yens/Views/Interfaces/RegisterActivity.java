package app.conoceme.myapplication_yens.Views.Interfaces;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import app.conoceme.myapplication_yens.Presenters.Interfaces.IRegisterPresenter;
import app.conoceme.myapplication_yens.Views.Implement.IRegisterView;
import app.conoceme.myapplication_yens.Presenters.Implement.RegisterPresenterImpl;
import app.conoceme.myapplication_yens.R;

public class RegisterActivity extends AppCompatActivity implements IRegisterView , View .OnClickListener{

    private EditText nombre;
    private EditText apellido;
    private EditText correoElectronico;
    private EditText usuario;
    private EditText clave;
    private EditText confirmarClave;
    private TextView mensaje;
    private ProgressBar progressBar;

    private IRegisterPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        //obtecion de los controles
        nombre = (EditText) this.findViewById(R.id.txtNombre);
        apellido = (EditText) this.findViewById(R.id.txtApellidos);
        correoElectronico = (EditText) this.findViewById(R.id.txtEmail);
        usuario = (EditText) this.findViewById(R.id.txtUsuario);
        clave = (EditText) this.findViewById(R.id.txtClave);
        confirmarClave = (EditText) this.findViewById(R.id.txtConfirmar);
        mensaje = (TextView) this.findViewById(R.id.tvMensaje);
        progressBar = (ProgressBar) this.findViewById(R.id.progress_registrar);

        //set on click envet
        findViewById(R.id.btnCrear).setOnClickListener(this);
        findViewById(R.id.tvLogin).setOnClickListener(this);

        presenter = new RegisterPresenterImpl(this);

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
    public void setNameError() {
        nombre.setError("Campo obligatorio");
    }

    @Override
    public void setLastNameError() {
        apellido.setError("Campo obligatorio");
    }

    @Override
    public void setCorreoError() {
        correoElectronico.setError("Campo obligatorio");
    }

    @Override
    public void setUsernameError() {
        usuario.setError("Campo obligatorio");
    }

    @Override
    public void setPasswordError() {
        clave.setError("Campo obligatorio");
    }

    @Override
    public void setConfirmPasswordError() {
        confirmarClave.setError("Campo obligatorio");
    }

    @Override
    public void setError() {
        Toast.makeText(this,"Connection failed",Toast.LENGTH_LONG).show();
    }

    @Override
    public void showMensaje(String mensaje) {
        this.mensaje.setText(mensaje);
        this.mensaje.setVisibility(View.VISIBLE);
    }
    public void hideMensaje() {
        mensaje.setText("");
        mensaje.setVisibility(View.GONE);
    }
    @Override
    public void navigateToLogin() {
        startActivity(new Intent(this, LoginActivity.class));
    }

    @Override
    public void navigateToSuccessful() {
        startActivity(new Intent(this, SuccessfulActivity.class));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnCrear:
                presenter.registerAccount(nombre.getText().toString(),
                        apellido.getText().toString(),
                        correoElectronico.getText().toString(),
                        usuario.getText().toString(),
                        clave.getText().toString(),
                        confirmarClave.getText().toString(),this);
                break;
            case R.id.tvLogin:
                navigateToLogin();
                break;
        }
    }
}
