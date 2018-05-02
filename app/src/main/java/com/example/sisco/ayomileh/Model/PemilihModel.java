package com.example.sisco.ayomileh.Model;

/**
 * Created by LENOVO on 01/05/2018.
 */

public class PemilihModel {

    public String nama;
    public String nik;
    public String kk;
    public String no_tps;
    public String alamat;
    public String jk;
    public String app;

    public PemilihModel() {
    }

    public PemilihModel(String nama, String nik, String kk, String no_tps, String alamat, String jk, String app) {
        this.nama = nama;
        this.nik = nik;
        this.kk = kk;
        this.no_tps = no_tps;
        this.alamat = alamat;
        this.jk = jk;
        this.app = app;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getKk() {
        return kk;
    }

    public void setKk(String kk) {
        this.kk = kk;
    }

    public String getNo_tps() {
        return no_tps;
    }

    public void setNo_tps(String no_tps) {
        this.no_tps = no_tps;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }
}
