package com.example.lab8;

import java.util.Objects;

public class
City {

    private String city;
    private String province;

    public City(String city, String province){
        this.city = city;
        this.province = province;
    }

    String getCityName(){
        return this.city;
    }

    String getProvinceName(){
        return this.province;
    }

    /**
     * Checks if the city is equal to another city.
     * @param o
     *     the other city
     * @return
     *     true if the cities have the same city and province names. false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city1 = (City) o;
        return Objects.equals(city, city1.city) && Objects.equals(province, city1.province);
    }

    /**
     * Generates a hash code for the city
     * @return
     *    the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(city, province);
    }
}
