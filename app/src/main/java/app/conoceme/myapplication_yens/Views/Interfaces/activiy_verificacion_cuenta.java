package app.conoceme.myapplication_yens.Views.Interfaces;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import app.conoceme.myapplication_yens.R;

public class activiy_verificacion_cuenta extends AppCompatActivity implements  View.OnClickListener{
//btnContinuar
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activiy_verificacion_cuenta);

        findViewById(R.id.btnContinuar).setOnClickListener(this);
        findViewById(R.id.tv_ver_iniciar).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnContinuar:
                startActivity(new Intent(activiy_verificacion_cuenta.this, PrincipalActivity.class));
                break;
            case R.id.tv_ver_iniciar:
                startActivity(new Intent(activiy_verificacion_cuenta.this, LoginActivity.class));
                break;
        }
    }
}
