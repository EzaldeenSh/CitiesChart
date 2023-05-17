package com.app;

import org.primefaces.model.charts.bar.BarChartOptions;

import java.util.Arrays;
import java.util.List;

public class BarChartInfo extends ChartInfo {

    public BarChartInfo(List<String> labels, List<Number> values, String extender, String label, BarChartOptions barChartOptions) {
        super(labels, Arrays.asList(values.toArray()), extender, label, barChartOptions);
    }

    @Override
    public BarChartOptions getChartOptions() {
        return (BarChartOptions) super.getChartOptions();
    }


}
