package com.example.proyekakhir3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter <MenuAdapter.ViewHolder> {


    private Context context;
    private final ArrayList<Menu> menumabar;

    public MenuAdapter(ArrayList<Menu> menumabar, Context context) {

        this.context = context;
        this.menumabar = menumabar;
    }

    @NonNull
    @Override
    public MenuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewHolder holder = new ViewHolder(inflater.inflate(R.layout.activity_menu, parent, false));

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        Menu menu = menumabar.get(position);
        holder.t.setText(menu.getTier());
        holder.h.setText(menu.getHarga());
        holder.foto.setImageResource(menu.getId_gambar());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent((Context) context, Menu2.class);

                intent.putExtra("nama_tier", menu.getTier());
                intent.putExtra("harga_tier", menu.getHarga());
                intent.putExtra("deskripsi_tier", menu.getDeskripsi());
                intent.putExtra("foto_tier", menu.getId_gambar());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

        return menumabar.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView t, h;
        public ImageView foto;
        public ConstraintLayout itemView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            t = (TextView) itemView.findViewById(R.id.t);
            h = (TextView) itemView.findViewById(R.id.h);
            foto = (ImageView) itemView.findViewById(R.id.foto);
            this.itemView = (ConstraintLayout) itemView.findViewById(R.id.itemLayout);
        }
    }
}
