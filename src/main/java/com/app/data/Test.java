package com.app.data;


import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        CitiesService citiesService = CitiesService.getInstance();
        System.out.println(citiesService.getAveragePopulation());

    }
}
