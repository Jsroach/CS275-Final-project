package com.example.crime;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    List<Crime> crimes;
    Context context;

    public CustomAdapter(Context context, List<Crime> crimes) {
        this.context = context;
        this.crimes = crimes;

    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        // set the data in items
        holder.c_id.setText(crimes.get(position).getDate());
        holder.c_type.setText(crimes.get(position).getCrime_type());




        // implement setOnClickListener event on item view.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(context,Display.class);
                i.putExtra("id",crimes.get(position).getId());
                i.putExtra("date", crimes.get(position).getDate());
                i.putExtra("type", crimes.get(position).getCrime_type());
                i.putExtra("weapon", crimes.get(position).getWeapon());
                i.putExtra("lat", crimes.get(position).getLattitude()+"");
                i.putExtra("lon", crimes.get(position).getLongitude()+"");

                context.startActivity(i);



            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {




                return true;
            }
        });


    }






    @Override
    public int getItemCount() {
        return crimes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView c_id, c_type;

        public MyViewHolder(View itemView) {
            super(itemView);

            // get the reference of item view's

            c_id =  itemView.findViewById(R.id.c_id);
            c_type =  itemView.findViewById(R.id.c_type);
        }
    }
}