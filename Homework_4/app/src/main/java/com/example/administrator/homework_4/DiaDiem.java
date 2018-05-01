package com.example.administrator.homework_4;

import java.io.Serializable;

/**
 * Created by trinh.diep on 4/30/2018.
 */

public class DiaDiem implements Serializable {
    private String ten;
    private String link;
    private double kinhDo;
    private double viDo;

    public DiaDiem(String ten, String link, double kinhDo, double viDo) {
        this.ten = ten;
        this.link = link;
        this.kinhDo = kinhDo;
        this.viDo = viDo;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public double getKinhDo() {
        return kinhDo;
    }

    public void setKinhDo(double kinhDo) {
        this.kinhDo = kinhDo;
    }

    public double getViDo() {
        return viDo;
    }

    public void setViDo(double viDo) {
        this.viDo = viDo;
    }
}
