package app.conoceme.myapplication_yens.Views.Otros;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import app.conoceme.myapplication_yens.R;

public class RecyclerViewHolder extends  RecyclerView.ViewHolder {
        TextView tv1,tv2;
        ImageView imageView;

public RecyclerViewHolder(View itemView) {
        super(itemView);

        tv1= (TextView) itemView.findViewById(R.id.list_title);
        tv2= (TextView) itemView.findViewById(R.id.list_desc);
        imageView= (ImageView) itemView.findViewById(R.id.list_avatar);

        }
}
