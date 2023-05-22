package com.app.factory;

import org.primefaces.model.charts.ChartDataSet;

public interface DataSetBuilder {
    ChartDataSet createDataSet(ChartInfo chartInfo);


}
