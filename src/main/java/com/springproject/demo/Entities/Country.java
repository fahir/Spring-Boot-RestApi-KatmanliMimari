package com.springproject.demo.Entities;
import com.querydsl.core.annotations.QueryEntity;
import javax.persistence.*;

@Entity
@QueryEntity
@Table(name = "country")
public class Country {
  @Id
@Column(name = "code")
  private String code;
  @Column(name = "name")
  private String name;
  @Column(name = "continent")
  private String continent;

  @Column(name = "region")
  private String region;
  @Column(name = "surfacearea")
  private double surfaceArea;
  @Column(name = "indepyear")
  private Long indepYear;
  @Column(name = "population")
  private Long population;
  @Column(name = "lifeexpectancy")
  private Double lifeExpectancy;
  @Column(name = "gnp")
  private Double gnp;
  @Column(name = "gnpold")

  private Double gnpOld;
  @Column(name = "localname")

  private String localName;
  @Column(name = "governmentform")

  private String governmentForm;
  @Column(name = "headofstate")

  private String headOfState;
  @Column(name = "capital")

  private Long capital;
  @Column(name = "code2")

  private String code2;

  public Country(String code, String name, String continent, String region, double surfaceArea, long indepYear, long population, double lifeExpectancy, double gnp, double gnpOld, String localName, String governmentForm, String headOfState, long capital, String code2) {
    this.code = code;
    this.name = name;
    this.continent = continent;
    this.region = region;
    this.surfaceArea = surfaceArea;
    this.indepYear = indepYear;
    this.population = population;
    this.lifeExpectancy = lifeExpectancy;
    this.gnp = gnp;
    this.gnpOld = gnpOld;
    this.localName = localName;
    this.governmentForm = governmentForm;
    this.headOfState = headOfState;
    this.capital = capital;
    this.code2 = code2;
  }

  public Country() {
  }


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getContinent() {
    return continent;
  }

  public void setContinent(String continent) {
    this.continent = continent;
  }


  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }


  public double getSurfaceArea() {
    return surfaceArea;
  }

  public void setSurfaceArea(double surfaceArea) {
    this.surfaceArea = surfaceArea;
  }


  public long getIndepYear() {
    return indepYear;
  }

  public void setIndepYear(long indepYear) {
    this.indepYear = indepYear;
  }


  public long getPopulation() {
    return population;
  }

  public void setPopulation(long population) {
    this.population = population;
  }


  public double getLifeExpectancy() {
    return lifeExpectancy;
  }

  public void setLifeExpectancy(double lifeExpectancy) {
    this.lifeExpectancy = lifeExpectancy;
  }


  public double getGnp() {
    return gnp;
  }

  public void setGnp(double gnp) {
    this.gnp = gnp;
  }


  public double getGnpOld() {

    return gnpOld;
  }

  public void setGnpOld(double gnpOld) {
    this.gnpOld = gnpOld;
  }


  public String getLocalName() {
    return localName;
  }

  public void setLocalName(String localName) {
    this.localName = localName;
  }


  public String getGovernmentForm() {
    return governmentForm;
  }

  public void setGovernmentForm(String governmentForm) {
    this.governmentForm = governmentForm;
  }


  public String getHeadOfState() {
    return headOfState;
  }

  public void setHeadOfState(String headOfState) {
    this.headOfState = headOfState;
  }


  public long getCapital() {
    return capital;
  }

  public void setCapital(long capital) {
    this.capital = capital;
  }


  public String getCode2() {
    return code2;
  }

  public void setCode2(String code2) {
    this.code2 = code2;
  }

}
