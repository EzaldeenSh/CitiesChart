package com.app.data;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CitiesService {

    private static CitiesService instance;

    private final List<City> first12Cities;
    private double averagePopulation =0;
    private int maxPopulation = 0;

    private CitiesService() throws SQLException {
        first12Cities = CityDaoImplementation.getInstance().getAllCities();
    }
    public static CitiesService getInstance() throws SQLException {
        if(instance == null)
            instance = new CitiesService();
        return instance;
    }
    public int getListSize(){
        return first12Cities.size();
    }

    public List<City> getFirst12Cities() {
        return first12Cities;
    }

    public List<Object> getCitiesPopulations(){
        List<Object> populations = new ArrayList<>();
        for(City city : first12Cities){
            populations.add(city.getPopulation());
        }
        return populations;
    }
    public List<String> getCitiesNames(){
        List<String> names = new ArrayList<>();
        for(City city:first12Cities){
            names.add(city.getName());
        }
        return names;
    }

    public int getMaxPopulation(){
        if(maxPopulation == 0)
            maxPopulation = calculateMaxPopulation();
        return maxPopulation;
    }
    private int calculateMaxPopulation(){
        int max = first12Cities.get(0).getPopulation();
        for(int i = 1 ; i < first12Cities.size() ; i++){
            if(first12Cities.get(i).getPopulation() > max)
                max = first12Cities.get(i).getPopulation();
        }
        return max;
    }
    public double getAveragePopulation(){
        if(averagePopulation ==0)
            averagePopulation = calculateAveragePopulation();
        return averagePopulation;
    }
    private double calculateAveragePopulation(){
        double sum = 0;
        for(City city : first12Cities){
            sum+= city.getPopulation();
        }
        return sum/first12Cities.size();
    }
}
