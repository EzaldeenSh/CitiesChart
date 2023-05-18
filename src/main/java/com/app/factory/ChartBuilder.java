package com.app.factory;

import org.primefaces.model.charts.ChartModel;

import java.util.List;

public abstract class ChartBuilder {
     abstract ChartModel createChart(List<ChartInfo> chartInfo);

}
