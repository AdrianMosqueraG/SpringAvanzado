package com.example.SA2.SubirBajarFicheros.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "city")
public class City {
    private Integer id;
    private String name;
    private String countryCode;
    private String district;
    private Integer population;
    @JsonManagedReference
    private Country countryByCountryCode;

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "CountryCode")
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Basic
    @Column(name = "District")
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Basic
    @Column(name = "Population")
    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (id != null ? !id.equals(city.id) : city.id != null) return false;
        if (name != null ? !name.equals(city.name) : city.name != null) return false;
        if (countryCode != null ? !countryCode.equals(city.countryCode) : city.countryCode != null) return false;
        if (district != null ? !district.equals(city.district) : city.district != null) return false;
        if (population != null ? !population.equals(city.population) : city.population != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (countryCode != null ? countryCode.hashCode() : 0);
        result = 31 * result + (district != null ? district.hashCode() : 0);
        result = 31 * result + (population != null ? population.hashCode() : 0);
        return result;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CountryCode", referencedColumnName = "Code", nullable = false, updatable = false,insertable = false)
    public Country getCountryByCountryCode() {
        return countryByCountryCode;
    }

    public void setCountryByCountryCode(Country countryByCountryCode) {
        this.countryByCountryCode = countryByCountryCode;
    }
}
