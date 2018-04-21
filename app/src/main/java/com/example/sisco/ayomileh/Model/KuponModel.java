package com.example.sisco.ayomileh.Model;

import com.example.sisco.ayomileh.R;

import java.util.ArrayList;

/**
 * Created by Princhaa on /22Oct/17.
 */

public class KuponModel {
    int LogoKupon,nilaiKupon;
    String keteranganKupon,idKupon;

    public KuponModel(int logoKupon, int nilaiKupon, String keteranganKupon, String idKupon) {
        LogoKupon = logoKupon;
        this.nilaiKupon = nilaiKupon;
        this.keteranganKupon = keteranganKupon;
        this.idKupon = idKupon;
    }

    public String getIdKupon() {
        return idKupon;
    }

    public void setIdKupon(String idKupon) {
        this.idKupon = idKupon;
    }

    public int getLogoKupon() {
        return LogoKupon;
    }

    public void setLogoKupon(int logoKupon) {
        LogoKupon = logoKupon;
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

    public static ArrayList<KuponModel> createRedeem(){
        ArrayList<KuponModel> kuponModels = new ArrayList<>();

        kuponModels.add(new KuponModel(R.drawable.logo_infomaret,20,"Diskon Infomaret","123A"));

        return kuponModels;
    }
}
