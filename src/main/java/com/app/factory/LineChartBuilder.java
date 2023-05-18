package com.app.factory;

import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.ChartModel;
import org.primefaces.model.charts.line.LineChartDataSet;
import org.primefaces.model.charts.line.LineChartModel;

import java.util.List;

public class LineChartBuilder extends ChartBuilder{
    @Override
    ChartModel createChart(List<ChartInfo> chartInfos) {
        LineChartModel lineChartModel = new LineChartModel();
        ChartData data = new ChartData();
        for(ChartInfo chartInfo : chartInfos){
            LineChartDataSet lineChartDataSet = new LineChartDataSet();
            lineChartDataSet.setLabel(chartInfo.label());
            lineChartDataSet.setData(chartInfo.values());
        }
        data.setLabels(chartInfos.get(0).labels());
        lineChartModel.setData(data);

        return lineChartModel;
    }
}
