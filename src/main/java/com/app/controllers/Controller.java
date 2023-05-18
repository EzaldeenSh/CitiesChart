package com.app.controllers;


import com.app.factory.ChartInfo;
import com.app.data.CitiesService;
import com.app.data.City;
import com.app.factory.ChartType;
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
    private final List<ChartInfo> chartsInfos;

    public Controller() {
        chartsInfos = new ArrayList<>();
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
                citiesService.getCitiesPopulations(), "extender","Label", ChartType.BAR);


//        BarChartInfo barChartInfo = new BarChartInfo(
//                citiesService.getCitiesNames(),
//                citiesService.getCitiesPopulations(),
//                "TEST",
//                "Cities"
//        );
//
//        LineChartInfo lineChartInfo = new LineChartInfo(citiesService.getCitiesNames(),
//                Arrays.asList(citiesService.getCitiesPopulations().toArray()),
//                "TEST2",
//                "MYLABEL"
//        );
//        chartsInfos.add(barChartInfo);
//        chartsInfos.add(lineChartInfo);


//        chartModel = ChartsFactory.createCombinedChart(lineChartInfo, barChartInfo);



//        barModel = new BarChartModel();
//        ChartData data = new ChartData();
//
//
//        BarChartDataSet barDataSet = new BarChartDataSet();
//        barDataSet.setLabel("Cities");
//        List<String> bgColors = generateBackGroundColors();
////        barDataSet.setBackgroundColor(bgColors);
//        List<Number> values = citiesService.getCitiesPopulations();
//
//        barDataSet.setData(values);
//        data.addChartDataSet(barDataSet);
//
//        LineChartDataSet averageLineDataSet = new LineChartDataSet();
//        List<Object> lineAverageValues = new ArrayList<>(values);
//
////        double averagePopulation = citiesService.getAveragePopulation();
////        for(int i = 0 ; i < values.size() ; i++){
////            lineAverageValues.add(averagePopulation);
////        }
//
//        averageLineDataSet.setData(lineAverageValues);
////        averageLineDataSet.setFill(false);
//        averageLineDataSet.setLabel("Average");
////        averageLineDataSet.setBorderColor("rgb(75, 192, 192)");
//        averageLineDataSet.setTension(0);
//
//        data.addChartDataSet(averageLineDataSet);
//
//        LineChartDataSet maxLineDataSet = new LineChartDataSet();
//        List<Object> lineMaxValues = new ArrayList<>();
//        int maxPopulation = citiesService.getMaxPopulation();
//        for(int i  = 0 ; i < values.size() ; i++){
//            lineMaxValues.add(maxPopulation);
//        }
//        maxLineDataSet.setData(lineMaxValues);
//        maxLineDataSet.setFill(false);
//        maxLineDataSet.setLabel("Max");
////        maxLineDataSet.setBorderColor("rgb(255, 0, 0)");
//        maxLineDataSet.setTension(0);
//
//
//        data.addChartDataSet(maxLineDataSet);
//
//        List<String> labels = citiesService.getCitiesNames();
//        data.setLabels(labels);
//
//        barModel.setData(data);
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