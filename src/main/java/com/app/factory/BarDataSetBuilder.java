package com.app.factory;

import org.primefaces.model.charts.ChartDataSet;
import org.primefaces.model.charts.bar.BarChartDataSet;

import java.util.stream.Collectors;

public class BarDataSetBuilder implements DataSetBuilder{
    @Override
    public ChartDataSet createDataSet(ChartInfo chartInfo){
        BarChartDataSet barChartDataSet = new BarChartDataSet();
        barChartDataSet.setLabel(chartInfo.label());
        barChartDataSet.setData(chartInfo.values().stream().map(o -> (Number) o ).collect(Collectors.toList()));

        return barChartDataSet;
    }
}
