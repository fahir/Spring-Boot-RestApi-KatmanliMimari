package com.springproject.demo.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "countrylanguage")
public class Countrylanguage {
  @Column(name = "countrycode")

  private String countryCode;
  @Id
  @Column(name = "Language")
  private String language;
  @Column(name = "isofficial")

  private String isOfficial;

  public Countrylanguage(String countryCode, String language, String isOfficial, double percentage) {
    this.countryCode = countryCode;
    this.language = language;
    this.isOfficial = isOfficial;
    this.percentage = percentage;
  }

  @Column(name = "percentage")

  private double percentage;

  public Countrylanguage() {
  }


  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }


  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }


  public String getIsOfficial() {
    return isOfficial;
  }

  public void setIsOfficial(String isOfficial) {
    this.isOfficial = isOfficial;
  }


  public double getPercentage() {
    return percentage;
  }

  public void setPercentage(double percentage) {
    this.percentage = percentage;
  }

}
