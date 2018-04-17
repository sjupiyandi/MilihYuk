package com.example.sisco.ayomileh.Model;

/**
 * Created by LENOVO on 16/04/2018.
 */

public class MengajakModel {

    public String nama;
    public String alamat;
    public String pesan;
    public String type;

    public MengajakModel() {
    }

    public MengajakModel(String nama, String alamat, String pesan, String type) {
        this.nama = nama;
        this.alamat = alamat;
        this.pesan = pesan;
        this.type = type;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
