package com.springproject.demo.Entities;

import com.querydsl.core.annotations.QueryEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@QueryEntity
@Table(name="city")
public class Adres implements Serializable {
    public Adres() {
    }

    public Adres(int id, String ad) {
        this.id = id;
        this.ad = ad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Ad")
    private String ad;
}
