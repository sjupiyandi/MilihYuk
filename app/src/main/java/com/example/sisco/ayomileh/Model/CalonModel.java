package com.example.sisco.ayomileh.Model;

import java.util.List;

/**
 * Created by LENOVO on 18/04/2018.
 */

public class CalonModel {

    public String nama1;
    public String nama2;
    public String ttl1;
    public String ttl2;
    public String pekerjaan1;
    public String pekerjaan2;
    public String visi;
    public String misi;
    public String program;

    public CalonModel() {
    }

    public CalonModel(String nama1, String nama2, String ttl1, String ttl2, String pekerjaan1, String pekerjaan2, String visi, String misi, String program) {
        this.nama1 = nama1;
        this.nama2 = nama2;
        this.ttl1 = ttl1;
        this.ttl2 = ttl2;
        this.pekerjaan1 = pekerjaan1;
        this.pekerjaan2 = pekerjaan2;
        this.visi = visi;
        this.misi = misi;
        this.program = program;
    }

    public String getNama1() {
        return nama1;
    }

    public void setNama1(String nama1) {
        this.nama1 = nama1;
    }

    public String getNama2() {
        return nama2;
    }

    public void setNama2(String nama2) {
        this.nama2 = nama2;
    }

    public String getTtl1() {
        return ttl1;
    }

    public void setTtl1(String ttl1) {
        this.ttl1 = ttl1;
    }

    public String getTtl2() {
        return ttl2;
    }

    public void setTtl2(String ttl2) {
        this.ttl2 = ttl2;
    }

    public String getPekerjaan1() {
        return pekerjaan1;
    }

    public void setPekerjaan1(String pekerjaan1) {
        this.pekerjaan1 = pekerjaan1;
    }

    public String getPekerjaan2() {
        return pekerjaan2;
    }

    public void setPekerjaan2(String pekerjaan2) {
        this.pekerjaan2 = pekerjaan2;
    }

    public String getVisi() {
        return visi;
    }

    public void setVisi(String visi) {
        this.visi = visi;
    }

    public String getMisi() {
        return misi;
    }

    public void setMisi(String misi) {
        this.misi = misi;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }
}
