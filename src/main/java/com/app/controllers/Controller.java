package com.app.controllers;


import com.app.factory.ChartInfo;
import com.app.data.CitiesService;
import com.app.data.City;
import com.app.factory.ChartType;
import com.app.factory.ChartsFactory;
import com.jk.web.faces.controllers.JKWebController;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.primefaces.PrimeFaces;
import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.charts.ChartModel;
import org.primefaces.model.charts.bar.BarChartModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


@Named("controller")
@ViewScoped
public class Controller extends JKWebController {
    private CitiesService citiesService;
    private BarChartModel barModel;
    private List<City> cities;
    private City selectedCity;
    private ChartModel chartModel;

    public Controller() {
        try {
            citiesService = CitiesService.getInstance();
            cities = citiesService.getFirst12Cities();
//            selectedCity = cities.get(0);
        } catch (SQLException e) {
            // Handle the sql exception using JK framework;

            System.out.println("Invalid SQL connection!");
        }
    }

    public City getSelectedCity() {
        return selectedCity;
    }

    public ChartModel getChartModel() {
        return chartModel;
    }

    @PostConstruct
    public void init() {
        createChart();

    }

    public void displayInfo(ItemSelectEvent event) {

        int index = event.getItemIndex();
        PrimeFaces current = PrimeFaces.current();
        setSelectedCity(cities.get(index));
        current.executeScript("PF('cityInfo').show();");

    }

    public void setSelectedCity(City SelectedCity) {
        this.selectedCity = SelectedCity;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public void createChart() {

        ChartInfo chartInfo = new ChartInfo(citiesService.getCitiesNames(),
                citiesService.getCitiesPopulations(), "extender","Label", ChartType.LINE);


        ChartInfo chartInfoBar = new ChartInfo(citiesService.getCitiesNames(),
                citiesService.getCitiesPopulations(), "extender","N", ChartType.BAR);


        List<ChartInfo> chartInfos = new ArrayList<>();
        chartInfos.add(chartInfo);
        chartInfos.add(chartInfoBar);
        List<List<ChartInfo>> chartsInfos = new ArrayList<>();
        chartsInfos.add(chartInfos);
        chartModel = ChartsFactory.getInstance().createCharts(chartsInfos).get(0);


    }


    public List<City> getCities() {
        return citiesService.getFirst12Cities();
    }

    private List<String> generateBackGroundColors() {
        Random random = new Random();
        List<String> colors = new ArrayList<>();
        for (int i = 0; i < citiesService.getListSize(); i++) {
            int red = random.nextInt(255);
            int green = random.nextInt(255);
            int blue = random.nextInt(255);
            colors.add("rgb(" + red + ", " + green + ", " + blue + ")");
        }

        return colors;
    }


    public BarChartModel getBarModel() {
        return barModel;
    }

    public void setBarModel(BarChartModel barModel) {
        this.barModel = barModel;
    }
}