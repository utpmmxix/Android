package app.conoceme.myapplication_yens.Views.Interfaces;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import app.conoceme.myapplication_yens.R;

public class activity_configuracion extends AppCompatActivity  implements   View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);


        findViewById(R.id.btnCambiarClave).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnCambiarClave:
                startActivity(new Intent(activity_configuracion.this, activity_cambiar_clave.class));
                break;
        }
    }
}
