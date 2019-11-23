package com.example.decocioapp.Customer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.decocioapp.R;

public class Wedding extends AppCompatActivity {
    ImageView imgWedding, imgHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wedding);

        imgWedding = findViewById(R.id.img_wedding);
        imgWedding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),DetailWedding.class);
                startActivity(intent);
            }
        });

        imgHelp = findViewById(R.id.help_wed);
        imgHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),HelpUser.class);
                startActivity(intent);
            }
        });
    }
}
