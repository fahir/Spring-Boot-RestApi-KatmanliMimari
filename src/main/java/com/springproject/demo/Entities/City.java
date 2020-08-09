package com.springproject.demo.Entities;
import com.querydsl.core.annotations.QueryEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@QueryEntity
@Table(name="city")
public class City implements Serializable {
  @Id
  @Column(name = "Id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column(name = "name")
  private String name;
  @Column(name = "countrycode")
  private String countryCode;
  @Column(name = "district")
  private String district;
  @Column(name = "population")
  private int population;

  public String getAd() {
    return ad;
  }

  public void setAd(String ad) {
    this.ad = ad;
  }

  @Column(name = "ad")
  private String ad;


  public City() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public String getDistrict() {
    return district;
  }

  public void setDistrict(String district) {
    this.district = district;
  }

  public int getPopulation() {
    return population;
  }

  public void setPopulation(int population) {
    this.population = population;
  }



  public City(int id, String name, String countryCode, String district, int population, String ad) {
    this.id = id;
    this.name = name;
    this.countryCode = countryCode;
    this.district = district;
    this.population = population;
    this.ad = ad;
  }

}
