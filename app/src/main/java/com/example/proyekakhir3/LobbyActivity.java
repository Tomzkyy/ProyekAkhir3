package com.example.proyekakhir3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LobbyActivity extends AppCompatActivity {

    Button masuk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);

        masuk = findViewById(R.id.masuk);
    }

    public void masuk(View view){

        Intent intent = new Intent(LobbyActivity.this, MainActivity.class);
        startActivity(intent);
    }
}