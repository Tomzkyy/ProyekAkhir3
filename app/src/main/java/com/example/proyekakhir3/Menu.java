package com.example.proyekakhir3;

import com.google.gson.annotations.SerializedName;

public class Menu {

    @SerializedName("tier")
    private String tier;
    @SerializedName("harga")
    private String harga;
    @SerializedName("deskripsi")
    private String deskripsi;
    private Integer id_gambar;

    public Menu(String tier, String deskripsi, String harga, Integer id_gambar) {
        this.tier = tier;
        this.deskripsi = deskripsi;
        this.harga = harga;
        this.id_gambar = id_gambar;
    }

    public String getTier() {

        return tier;
    }

    public void setTier(String tier) {

        this.tier = tier;
    }

    public String getDeskripsi() {

        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {

        this.deskripsi = deskripsi;
    }

    public String getHarga() {

        return harga;
    }

    public void setHarga(String harga) {

        this.harga = harga;
    }

    public Integer getId_gambar() {

        return id_gambar;
    }

    public void setId_gambar(Integer id_gambar) {

        this.id_gambar = id_gambar;
    }
}

