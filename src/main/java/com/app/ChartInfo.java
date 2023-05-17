package com.app;

import org.primefaces.model.charts.ChartOptions;

import java.util.List;

public abstract class ChartInfo {

    private final List<Object> values;
    private final String extender;
    private final List<String> labels;

    private final String label;
    private final ChartOptions chartOptions;

    public ChartInfo(List<String> labels, List<Object> values, String extender, String label, ChartOptions chartOptions) {
        this.values = values;
        this.extender = extender;
        this.labels = labels;
        this.label = label;
        this.chartOptions = chartOptions;

    }

    public String getLabel() {
        return label;
    }

    public String getExtender() {
        return extender;
    }

    public List<String> getLabels() {

        return labels;
    }

    public List<Object> getValues() {
        return values;
    }

    public ChartOptions getChartOptions() {
        return chartOptions;
    }




}
