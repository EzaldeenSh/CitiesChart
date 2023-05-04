package com.app.controllers;


import com.app.data.CitiesService;
import com.app.data.City;
import com.jk.web.faces.controllers.JKWebController;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.bar.BarChartDataSet;
import org.primefaces.model.charts.bar.BarChartModel;
import org.primefaces.model.charts.line.LineChartDataSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Named("controller")
@ViewScoped
public class Controller extends JKWebController {
    private CitiesService citiesService;
    private BarChartModel barModel;

    public Controller() {
        try {
            citiesService = CitiesService.getInstance();
        } catch (SQLException e) {
            // Handle the sql exception using JK framework;

            System.out.println("Invalid SQL connection!");
        }
    }
    @PostConstruct
    public void init() {
        createChart();
    }
    public void createChart() {
        barModel = new BarChartModel();
        ChartData data = new ChartData();


        BarChartDataSet barDataSet = new BarChartDataSet();
        barDataSet.setLabel("Cities");


        List<Number> values = citiesService.getCitiesPopulations();

//        Double average = values.stream().mapToDouble(val -> (double) val).average().orElse(0.0);

        barDataSet.setData(values);
        data.addChartDataSet(barDataSet);

        LineChartDataSet averageLineDataSet = new LineChartDataSet();
        List<Object> lineAverageValues = new ArrayList<>();

        double averagePopulation = citiesService.getAveragePopulation();
        for(int i = 0 ; i < values.size() ; i++){
            lineAverageValues.add(averagePopulation);
        }

        averageLineDataSet.setData(lineAverageValues);
        averageLineDataSet.setFill(false);
        averageLineDataSet.setLabel("Average");
        averageLineDataSet.setBorderColor("rgb(75, 192, 192)");
        averageLineDataSet.setTension(0.1);

        data.addChartDataSet(averageLineDataSet);

        LineChartDataSet maxLineDataSet = new LineChartDataSet();
        List<Object> lineMaxValues = new ArrayList<>();
        int maxPopulation = citiesService.getMaxPopulation();
        for(int i  = 0 ; i < values.size() ; i++){
            lineMaxValues.add(maxPopulation);
        }
        maxLineDataSet.setData(lineMaxValues);
        maxLineDataSet.setFill(false);
        maxLineDataSet.setLabel("Max");
        maxLineDataSet.setBorderColor("rgb(255, 0, 0)");
        maxLineDataSet.setTension(0.1);


        data.addChartDataSet(maxLineDataSet);

        List<String> labels = citiesService.getCitiesNames();
        data.setLabels(labels);

        barModel.setData(data);


    }
    public List<City> getCities(){
        return citiesService.getFirst12Cities();
    }
    public BarChartModel getBarModel() {
        return barModel;
    }
    public void setBarModel(BarChartModel barModel) {
        this.barModel = barModel;
    }
}