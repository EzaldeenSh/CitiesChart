package com.app.factory;

import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.ChartModel;
import org.primefaces.model.charts.bar.BarChartDataSet;
import org.primefaces.model.charts.bar.BarChartModel;

import java.util.List;
import java.util.stream.Collectors;

public class BarChartBuilder extends ChartBuilder{
    @Override
    ChartModel createChart(List<ChartInfo> chartInfoList) {
        BarChartModel barChartModel = new BarChartModel();
        ChartData data = new ChartData();]

        for(ChartInfo chartInfo : chartInfoList){
            BarChartDataSet barChartDataSet = new BarChartDataSet();
            barChartDataSet.setLabel(chartInfo.label());
            barChartDataSet.setData(chartInfo.values().stream().map(o -> (Number) o).collect(Collectors.toList()));
        }

        data.setLabels(chartInfoList.get(0).labels());
        barChartModel.setData(data);
        return barChartModel;
    }
}
