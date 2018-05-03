package com.example.sisco.ayomileh.Model;

import com.example.sisco.ayomileh.R;

import java.util.ArrayList;

/**
 * Created by Princhaa on /22Oct/17.
 */

public class KuponModel {
    public int nilaiKupon;
    public String keteranganKupon,idKupon,status;

    public KuponModel() {
    }

    public KuponModel(int nilaiKupon, String keteranganKupon, String idKupon, String status) {
        this.nilaiKupon = nilaiKupon;
        this.keteranganKupon = keteranganKupon;
        this.idKupon = idKupon;
        this.status = status;
    }

    public String getIdKupon() {
        return idKupon;
    }

    public void setIdKupon(String idKupon) {
        this.idKupon = idKupon;
    }


    public int getNilaiKupon() {
        return nilaiKupon;
    }

    public void setNilaiKupon(int nilaiKupon) {
        this.nilaiKupon = nilaiKupon;
    }

    public String getKeteranganKupon() {
        return keteranganKupon;
    }

    public void setKeteranganKupon(String keteranganKupon) {
        this.keteranganKupon = keteranganKupon;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
