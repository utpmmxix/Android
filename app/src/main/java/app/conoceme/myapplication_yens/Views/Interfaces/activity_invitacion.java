package app.conoceme.myapplication_yens.Views.Interfaces;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import app.conoceme.myapplication_yens.R;

public class activity_invitacion extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invitacion);

        findViewById(R.id.ibtn_perfil_otro).setOnClickListener(this);
        findViewById(R.id.btn_otroContinuar).setOnClickListener(this);
        findViewById(R.id.btn_otroRechazar).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ibtn_perfil_otro:
                startActivity(new Intent(activity_invitacion.this, activity_perfil_otro.class));
                break;
            case R.id.btn_otroContinuar:
                startActivity(new Intent(activity_invitacion.this, activity_conversacion.class));
                break;
            case R.id.btn_otroRechazar:

                break;
        }
    }
}
