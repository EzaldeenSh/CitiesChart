package com.app.factory;

import org.primefaces.model.charts.ChartModel;
import java.util.ArrayList;
import java.util.List;
public class ChartsFactory {
    private static ChartsFactory instance;
    private ChartsFactory(){}
    public static ChartsFactory getInstance(){
        if(instance == null) {
            instance = new ChartsFactory();
        }
        return instance;
    }

    public List<ChartModel> createCharts(List<List<ChartInfo>> infos){
        List<ChartModel> chartModels = new ArrayList<>();
        for(List<ChartInfo> info : infos){
            switch (info.get(0).chartType()){
                case LINE -> {
                    chartModels.add(new LineChartBuilder().createChart(info));
                }
                case BAR ->  {
                    chartModels.add(new BarChartBuilder().createChart(info));
                }
            }
        }
        return chartModels;
    }



}
