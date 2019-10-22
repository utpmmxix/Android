package app.conoceme.myapplication_yens.Views.Interfaces;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import app.conoceme.myapplication_yens.R;
import app.conoceme.myapplication_yens.Views.Otros.RecyclerAdapter;

public class activity_bandeja extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bandeja);

        recyclerView= (RecyclerView) findViewById(R.id.my_recycler_view);

        RecyclerAdapter adapter=new RecyclerAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
