package com.app.factory;

import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.ChartModel;
import org.primefaces.model.charts.bar.BarChartModel;
import org.primefaces.model.charts.line.LineChartDataSet;

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
        for(List<ChartInfo> chartInfos: infos){
            BarChartModel barChartModel = new BarChartModel();
            ChartData chartData = new ChartData();

            for(ChartInfo chartInfo : chartInfos){
                switch (chartInfo.chartType()){
                    case BAR :
                        chartData.addChartDataSet(new BarDataSetBuilder().createDataSet(chartInfo));
                        break;

                    case LINE:
                        chartData.addChartDataSet(new LineDataSetBuilder().createDataSet(chartInfo));
                        break;
                }

            }


            chartData.setLabels(chartInfos.get(0).labels());
            barChartModel.setData(chartData);
            chartModels.add(barChartModel);
        }


        return chartModels;
    }



}
