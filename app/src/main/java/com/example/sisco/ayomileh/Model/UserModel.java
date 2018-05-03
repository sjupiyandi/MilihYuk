package com.example.sisco.ayomileh.Model;

/**
 * Created by Princhaa on /23Oct/17.
 */

public class UserModel {
    public String nama;
    public String no_ktp;
    public String no_kk;
    public String no_tps;
    public String no_hp;
    public String alamat;
    public String status;
    public String point;
    public String jenis_kelamin;
    public String ajak;
    public String kupon;

    public UserModel() {
    }

    public UserModel(String nama, String no_ktp, String no_kk, String no_tps, String no_hp, String alamat, String status, String point, String jenis_kelamin, String ajak, String kupon) {
        this.nama = nama;
        this.no_ktp = no_ktp;
        this.no_kk = no_kk;
        this.no_tps = no_tps;
        this.no_hp = no_hp;
        this.alamat = alamat;
        this.status = status;
        this.point = point;
        this.jenis_kelamin = jenis_kelamin;
        this.ajak = ajak;
        this.kupon = kupon;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNo_ktp() {
        return no_ktp;
    }

    public void setNo_ktp(String no_ktp) {
        this.no_ktp = no_ktp;
    }

    public String getNo_kk() {
        return no_kk;
    }

    public void setNo_kk(String no_kk) {
        this.no_kk = no_kk;
    }

    public String getNo_tps() {
        return no_tps;
    }

    public void setNo_tps(String no_tps) {
        this.no_tps = no_tps;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getAjak() {
        return ajak;
    }

    public void setAjak(String ajak) {
        this.ajak = ajak;
    }

    public String getKupon() {
        return kupon;
    }

    public void setKupon(String kupon) {
        this.kupon = kupon;
    }
}