package com.app.factory;

import java.util.List;

public record ChartInfo(List<String> labels, List<Object> values, String extender, String label, ChartType chartType) {

}
