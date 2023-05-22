package com.app.factory;

import java.util.List;
import java.util.Objects;

public final class ChartInfo {
    private final List<String> labels;
    private final List<Object> values;
    private final String extender;
    private final String label;
    private final ChartType chartType;

    public ChartInfo(List<String> labels, List<Object> values, String extender, String label, ChartType chartType) {
        this.labels = labels;
        this.values = values;
        this.extender = extender;
        this.label = label;
        this.chartType = chartType;
    }

    public List<String> labels() {
        return labels;
    }

    public List<Object> values() {
        return values;
    }

    public String extender() {
        return extender;
    }

    public String label() {
        return label;
    }

    public ChartType chartType() {
        return chartType;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (ChartInfo) obj;
        return Objects.equals(this.labels, that.labels) &&
                Objects.equals(this.values, that.values) &&
                Objects.equals(this.extender, that.extender) &&
                Objects.equals(this.label, that.label) &&
                Objects.equals(this.chartType, that.chartType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(labels, values, extender, label, chartType);
    }

    @Override
    public String toString() {
        return "ChartInfo[" +
                "labels=" + labels + ", " +
                "values=" + values + ", " +
                "extender=" + extender + ", " +
                "label=" + label + ", " +
                "chartType=" + chartType + ']';
    }


}
