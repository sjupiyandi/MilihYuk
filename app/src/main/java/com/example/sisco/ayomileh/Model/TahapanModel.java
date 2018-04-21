package com.example.sisco.ayomileh.Model;

/**
 * Created by LENOVO on 21/04/2018.
 */

public class TahapanModel {
    public String judul;
    public String awal;
    public String akhir;

    public TahapanModel() {
    }

    public TahapanModel(String judul, String awal, String akhir) {
        this.judul = judul;
        this.awal = awal;
        this.akhir = akhir;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getAwal() {
        return awal;
    }

    public void setAwal(String awal) {
        this.awal = awal;
    }

    public String getAkhir() {
        return akhir;
    }

    public void setAkhir(String akhir) {
        this.akhir = akhir;
    }
}
