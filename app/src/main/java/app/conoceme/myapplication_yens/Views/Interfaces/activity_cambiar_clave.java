package app.conoceme.myapplication_yens.Views.Interfaces;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import app.conoceme.myapplication_yens.Presenters.Interfaces.ICambiarClavePresenter;
import app.conoceme.myapplication_yens.Views.Implement.ICambiarClaveView;
import app.conoceme.myapplication_yens.Presenters.Implement.CambiarClavePresenterImpl;
import app.conoceme.myapplication_yens.R;

public class activity_cambiar_clave extends AppCompatActivity implements ICambiarClaveView, View.OnClickListener {

    EditText claveActual;
    EditText claveNueva;
    EditText claveNuevaConfirmar;
    ProgressBar progressBar;
    private ICambiarClavePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiar_clave);

        claveActual = (EditText) this.findViewById(R.id.txtClaveActual_c);
        claveNueva = (EditText) this.findViewById(R.id.txtClaveNueva_c);
        claveNuevaConfirmar = (EditText) this.findViewById(R.id.txtConfirmarClave_c);
        progressBar = (ProgressBar) this.findViewById(R.id.progress_cambiar);

        findViewById(R.id.btnCambiarClave_c).setOnClickListener(this);
        presenter = new CambiarClavePresenterImpl(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnCambiarClave_c:
                presenter.cambiarClave(1,claveActual.getText().toString(),claveNueva.getText().toString(),claveNuevaConfirmar.getText().toString(),this);
                break;

        }
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
    public void setClaveActual() {
        claveActual.setError("");
    }

    @Override
    public void setNuevaClave() {
        claveNueva.setError("");
    }

    @Override
    public void setNuevaClaveConfirmar() {
        claveNuevaConfirmar.setError("");
    }

    @Override
    public void setError() {
        Toast.makeText(this,"Connection failed",Toast.LENGTH_LONG).show();
    }

    @Override
    public void setMensaje() {
        Toast.makeText(this,"La contraseña a sido cambiada.",Toast.LENGTH_LONG).show();
    }
}
