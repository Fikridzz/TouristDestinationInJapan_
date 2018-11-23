package com.example.fikridzakwan.touristdestinationinjapan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailJapan extends AppCompatActivity {

    @BindView(R.id.imgLogo)
    ImageView imgLogo;
    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.txtDetail)
    TextView txtDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_japan);
        ButterKnife.bind(this);

        txtTitle.setText(getIntent().getStringExtra("NJ"));
        txtDetail.setText(getIntent().getStringExtra("DJ"));
        Glide.with(this).load(getIntent().getIntExtra("GJ",0)).into(imgLogo);
    }
}
