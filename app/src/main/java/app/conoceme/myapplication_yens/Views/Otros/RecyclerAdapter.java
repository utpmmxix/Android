package app.conoceme.myapplication_yens.Views.Otros;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.conoceme.myapplication_yens.R;
import app.conoceme.myapplication_yens.Views.Interfaces.activity_conversacion;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{

    String [] name={"Jose Perez","Ana Maria","Jessica Maria","Juliet Antonella",
            "Marcos Alonso","Julian Paz","Miguel del Pozo","Ayleen","Dannison Jr.","Carguancho"};
    String [] desc={"Hola, como estas?","Me llamo Maroa","De que parte eres?","Estudio ing. Software",
            "vivo por el centro de lima","Estoy cursando el 5 ciclo","Hola, como estas?","Como te llamas?","Como estas?","Estas???"};
    Context context;
    LayoutInflater inflater;
    public RecyclerAdapter(Context context) {
        this.context=context;
        inflater=LayoutInflater.from(context);
    }
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=inflater.inflate(R.layout.item_conversacion, parent, false);

        RecyclerViewHolder viewHolder=new RecyclerViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        holder.tv1.setText(name[position]);
        holder.tv2.setText(desc[position]);
        holder.imageView.setOnClickListener(clickListener);
        holder.imageView.setTag(holder);
    }

    View.OnClickListener clickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            RecyclerViewHolder vholder = (RecyclerViewHolder) v.getTag();
            int position = vholder.getPosition();

            //Toast.makeText(context,"This is position "+position,Toast.LENGTH_LONG ).show();

            context.startActivity(new Intent(context, activity_conversacion.class));
        }
    };



    @Override
    public int getItemCount() {
        return name.length;
    }
}
