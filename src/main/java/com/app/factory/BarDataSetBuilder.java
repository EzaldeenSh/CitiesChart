package com.app.factory;

import org.primefaces.model.charts.ChartDataSet;
import org.primefaces.model.charts.bar.BarChartDataSet;

import java.util.stream.Collectors;

public class BarDataSetBuilder implements DataSetBuilder{
    /**
     * BarDataSetBuilder is a class implemented to create the dataset for each requested chartInfo
     * Each Chart takes a different type of dataset
     * I couldn't use the super Dataset class since it does not have the "setData" method
     */
    @Override
    public ChartDataSet createDataSet(ChartInfo chartInfo){
        BarChartDataSet barChartDataSet = new BarChartDataSet();
        barChartDataSet.setLabel(chartInfo.label());
        barChartDataSet.setData(chartInfo.values().stream().map(o -> (Number) o ).collect(Collectors.toList()));

        return barChartDataSet;
    }
}
