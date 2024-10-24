package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;

    /**
     * create a mocklist for my citylist
     * @return CustomList
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    public CustomList MockCityList1() {
        ArrayList<City> cities = new ArrayList<>();
        cities.add(new City("Edmonton", "Alberta"));
        return new CustomList(null, cities);
    }

    public CustomList MockCityList2() {
        ArrayList<City> cities = new ArrayList<>();
        cities.add(new City("Calgary", "Alberta"));
        cities.add(new City("Red Deer", "Alberta"));
        return new CustomList(null, cities);
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    void testHasCity() {
        CustomList cityList = MockCityList();

        City city1 = new City("Edmonton", "Alberta");
        cityList.addCity(city1);
        assertTrue(cityList.hasCity(city1));

        City city2 = new City("Calgary", "Alberta");
        assertFalse(cityList.hasCity(city2));
    }

    @Test
    void testDeleteSuccessful() {
        CustomList cityList = MockCityList1();
        City city = new City("Edmonton", "Alberta");
        cityList.delete(city);
        assertEquals(cityList.getCities().size(), 0);
    }

    @Test
    void testDeleteFail() {
        CustomList cityList = MockCityList1();
        City city = new City("Calgary", "Alberta");

        Throwable thrown = assertThrows(RuntimeException.class, () -> {
            cityList.delete(city);
        });
        Assertions.assertEquals("City to be deleted must exist in the list!", thrown.getMessage());
    }

    @Test
    void testCountCities() {
        // List with 1 city
        CustomList cityList = MockCityList1();
        assertEquals(cityList.countCities(), 1);

        // List with 0 cities
        cityList = MockCityList();
        assertEquals(cityList.countCities(), 0);

        // List with 2 cities
        cityList = MockCityList2();
        assertEquals(cityList.countCities(), 2);
    }
}
