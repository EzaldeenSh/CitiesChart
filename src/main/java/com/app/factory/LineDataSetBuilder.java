package com.app.factory;
import org.primefaces.model.charts.ChartDataSet;
import org.primefaces.model.charts.line.LineChartDataSet;

public class LineDataSetBuilder implements DataSetBuilder{
    @Override
    public ChartDataSet createDataSet(ChartInfo chartInfo) {
        LineChartDataSet lineChartDataSet = new LineChartDataSet();

        lineChartDataSet.setLabel(chartInfo.label());
        lineChartDataSet.setData(chartInfo.values());

        return lineChartDataSet;
    }

}
