package com.app;

import org.primefaces.model.charts.ChartOptions;
import org.primefaces.model.charts.line.LineChartOptions;

import java.util.List;

public class LineChartInfo extends ChartInfo {
    public LineChartInfo(List<String> labels, List<Object> values, String extender, String label, LineChartOptions lineChartOptions) {
        super(labels, values, extender, label, lineChartOptions);


    }

    @Override
    public LineChartOptions getChartOptions() {
        return (LineChartOptions) super.getChartOptions();
    }
}
