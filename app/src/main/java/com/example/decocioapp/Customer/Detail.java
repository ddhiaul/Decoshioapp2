package com.example.decocioapp.Customer;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.decocioapp.Model.DetailCateModel;
import com.example.decocioapp.R;

public class Detail extends AppCompatActivity {
    private TextView detailItemName, detailLokasi, detailDesc;
    private ImageView detailImage;
    private Button btnFav, btnChat;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_item);

        detailItemName = findViewById(R.id.tv_item_name);
        detailLokasi = findViewById(R.id.tv_lokasi);
        detailDesc = findViewById(R.id.tv_desc_item);
        detailImage = findViewById(R.id.img_item);

        final DetailCateModel data = (DetailCateModel)getIntent().getSerializableExtra("EXTRA_DATA");

        Glide.with(this).load(data.getPhoto()).apply(new RequestOptions()
        .override(550,550)).into(detailImage);
        detailItemName.setText(data.getName());
        detailLokasi.setText(data.getLokasi());
        detailDesc.setText(data.getDesc());
    }
}
