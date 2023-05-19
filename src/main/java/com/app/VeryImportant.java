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

public class VeryImportant {
    public static void main(String[] args) throws SQLException {
        JK.print("Hello", "Uncle", "Jalal");

        CitiesService citiesService = CitiesService.getInstance();
        List<List<ChartInfo>> chartsInfos = new ArrayList<>();
        List<ChartInfo> chartInfos = new ArrayList<>();
        ChartInfo chartInfo = new ChartInfo(citiesService.getCitiesNames(),citiesService.getCitiesPopulations(),"","myChart", ChartType.BAR);
        System.out.println(chartInfo.values());
        chartInfos.add(chartInfo);
        chartsInfos.add(chartInfos);
        ChartsFactory chartsFactory = ChartsFactory.getInstance();
        List<ChartModel> chartModels = chartsFactory.createCharts(chartsInfos);
        for(ChartModel chartModel : chartModels){
            System.out.println(chartModel.getData().getDataSet());
        }

        System.out.println("Done");













    }

}
