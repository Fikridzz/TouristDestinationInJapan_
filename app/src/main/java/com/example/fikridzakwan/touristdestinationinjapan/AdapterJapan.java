package com.example.fikridzakwan.touristdestinationinjapan;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class AdapterJapan extends RecyclerView.Adapter<AdapterJapan.ViewHolder> {

    Context context;
    String[] namaJapan,detailJapan;
    int[] gambarJapan;

    public AdapterJapan(Context context, String[] namaJapan, String[] detailJapan, int[] gambarJapan) {
        this.context = context;
        this.namaJapan = namaJapan;
        this.detailJapan = detailJapan;
        this.gambarJapan = gambarJapan;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_japan, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.txtNamaJapan.setText(namaJapan[i]);
        Glide.with(context).load(gambarJapan[i]).into(viewHolder.imgGambarJapan);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailJapan.class);
                intent.putExtra("NJ", namaJapan[i]);
                intent.putExtra("DJ", detailJapan[i]);
                intent.putExtra("GJ", gambarJapan[i]);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return gambarJapan.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgGambarJapan;
        TextView txtNamaJapan;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNamaJapan = itemView.findViewById(R.id.txtNamaJapan);
            imgGambarJapan = itemView.findViewById(R.id.imgGambarJapan);

        }
    }
}
