package com.example.proyekakhir3;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText edtNama, edtWa, edtCatatan;
    SharedPreferences pref;
    MenuInterface menuInterface;

    private RecyclerView recApl;
    private ArrayList<Menu> menumabar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNama = findViewById(R.id.edtNama);
        edtWa = findViewById(R.id.edtWa);
        edtCatatan = findViewById(R.id.edtCatatan);
        pref = this.getSharedPreferences(getString(R.string.shared_key), Context.MODE_PRIVATE);

        menuInterface = ApiClient.getClient().create(MenuInterface.class);
        getAllMabar();
        recApl = findViewById(R.id.m);
        initData();

        recApl.setAdapter(new MenuAdapter(menumabar, this));
        recApl.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getAllMabar(){
        Call<List<Menu>> getMenu = menuInterface.getMenu();
        getMenu.enqueue(new Callback<List<Menu>>() {
            @Override
            public void onResponse(Call<List<Menu>> call, Response<List<Menu>> response) {
                ArrayList<Menu> listMenu = (ArrayList<Menu>) response.body();
                Log.d("list_menu : ", response.raw().body().toString());

            }

            @Override
            public void onFailure(Call<List<Menu>> call, Throwable t) {
                Log.e("error_menu : ", t.getMessage());

            }
        });
    }

    public void simpan(View view){

        String namalengkap = edtNama.getText().toString();
        String nomorwa = edtWa.getText().toString();
        String catatan = edtCatatan.getText().toString();

        pref.edit().putString(getString(R.string.nama_key), namalengkap).apply();
        pref.edit().putString(getString(R.string.wa_key), nomorwa).apply();
        pref.edit().putString(getString(R.string.catatan_key), catatan).apply();

        Toast.makeText(MainActivity.this,"Biodata dan orderanmu telah tersimpan", Toast.LENGTH_SHORT).show();
    }

    private void initData(){
        this.menumabar = new ArrayList<>();
        menumabar.add(new Menu("Mythical Glory",
                "Untuk menyelesaikan Tier tertinggi yaitu Mythical Glory membutuhkan waktu permainan selama 90 hari, karena hingga akhir season.",
                "25000",
                R.drawable.glory));

        menumabar.add(new Menu("Mythic",
                "Untuk menuntaskan Tier Mythic ini membutuhkan waktu permainan selama 1-4 hari.",
                "15000",
                R.drawable.mythic));

        menumabar.add(new Menu("Legend",
                "Untuk menuntaskan Tier Legend ini membutuhkan waktu permainan selama 1-3 hari.",
                "10000",
                R.drawable.legend));

        menumabar.add(new Menu("Epic",
                "Untuk menuntaskan Tier Epic ini membutuhkan waktu permainan selama 1-4 hari.",
                "8000",
                R.drawable.epic));

        menumabar.add(new Menu("Grand Master",
                "Untuk menuntaskan Tier Grand Master ini membutuhkan waktu permainan selama 1-4 hari.",
                "5000",
                R.drawable.grandmaster));
    }
}