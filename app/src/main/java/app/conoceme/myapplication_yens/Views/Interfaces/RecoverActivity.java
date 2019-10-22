package app.conoceme.myapplication_yens.Views.Interfaces;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import app.conoceme.myapplication_yens.R;

public class RecoverActivity extends AppCompatActivity implements  View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_clave);

        findViewById(R.id.btnEnviarCorreo).setOnClickListener(this);
        findViewById(R.id.tv_rc_iniciar).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnEnviarCorreo:
                startActivity(new Intent(RecoverActivity.this, activiy_verificacion_cuenta.class));
                break;
            case R.id.tv_rc_iniciar:
                startActivity(new Intent(RecoverActivity.this, LoginActivity.class));
                break;

        }
    }
}
