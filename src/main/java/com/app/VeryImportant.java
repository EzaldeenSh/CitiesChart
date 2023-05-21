package com.app;

import com.app.data.CitiesService;
import com.app.factory.ChartInfo;
import com.app.factory.ChartType;
import com.app.factory.ChartsFactory;
import com.jk.core.util.JK;
import org.primefaces.model.charts.ChartModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VeryImportant {
    public static void main(String[] args) throws SQLException {
        JK.print("Hello", "Uncle", "Jalal");

        CitiesService citiesService = CitiesService.getInstance();
        List<List<ChartInfo>> chartsInfos = new ArrayList<>();
        List<ChartInfo> chartInfos = new ArrayList<>();
        ChartInfo chartInfo = new ChartInfo(citiesService.getCitiesNames()  ,citiesService.getCitiesPopulations().stream().map(o -> (Number) o ).collect(Collectors.toList()), "null"
        ,"TEST LABEL" ,ChartType.BAR);
        chartInfos.add(chartInfo);
        chartsInfos.add(chartInfos);
        ChartsFactory chartsFactory = ChartsFactory.getInstance();
        List<ChartModel> chartModels = chartsFactory.createCharts(chartsInfos);
        System.out.println("Done");




    }

}
