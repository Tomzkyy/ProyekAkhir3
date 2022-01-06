package com.example.proyekakhir3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class Menu2 extends AppCompatActivity {
    ImageView foto2;
    TextView t2,d2,h2;
    String tier, harga, deskripsi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Detail Tier: ");


        tier = getIntent().getStringExtra("nama_tier");
        harga = getIntent().getStringExtra("harga_tier");
        deskripsi = getIntent().getStringExtra("deskripsi_tier");

        setTitle("Detail Tier: "+ tier);
        foto2 = findViewById(R.id.foto2);
        foto2.setImageResource(getIntent().getIntExtra("foto_tier" , 0));
        t2 = findViewById(R.id.t2); t2.setText(tier);
        h2 = findViewById(R.id.h2); h2.setText("Harga: " + harga);
        d2 = findViewById(R.id.d2); d2.setText(deskripsi);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(intent, 0);
        return true;
    }
}