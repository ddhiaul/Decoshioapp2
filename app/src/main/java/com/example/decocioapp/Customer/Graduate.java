package com.example.decocioapp.Customer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.decocioapp.R;


public class Graduate extends AppCompatActivity {
    ImageView imgHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graduate);

        imgHelp = findViewById(R.id.help_grad);
        imgHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HelpUser.class);
                startActivity(intent);
            }
        });
    }
}
