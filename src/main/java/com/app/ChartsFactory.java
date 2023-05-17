package com.app;

import com.jk.core.util.JK;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.ChartDataSet;
import org.primefaces.model.charts.ChartModel;
import org.primefaces.model.charts.bar.BarChartDataSet;
import org.primefaces.model.charts.bar.BarChartModel;
import org.primefaces.model.charts.line.LineChartDataSet;
import org.primefaces.model.charts.line.LineChartModel;

import java.util.stream.Collectors;

public class ChartsFactory {

    public static ChartModel createCombinedChart(ChartInfo ...chartInfos) {


        if (chartInfos[0] instanceof LineChartInfo) {
            LineChartModel lineChartModel = new LineChartModel();
            ChartData data = new ChartData();
            addChartData(chartInfos , data);
            data.setLabels(chartInfos[0].getLabels());
            lineChartModel.setData(data);
            return lineChartModel;

        } else if (chartInfos[0] instanceof BarChartInfo) {
            BarChartModel barChartModel = new BarChartModel();
            ChartData data = new ChartData();
            data.setLabels(chartInfos[0].getLabels());
            addChartData(chartInfos , data);
            barChartModel.setData(data);

            return barChartModel;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private static void addChartData(ChartInfo[] chartInfos, ChartData data) {
        for (ChartInfo chartInfo : chartInfos) {
            data.addChartDataSet(createChartDataset(chartInfo));
        }
    }

    private static ChartDataSet createChartDataset(ChartInfo chartInfo) {
        if (chartInfo instanceof LineChartInfo) {
            return createLineChartDataSet((LineChartInfo) chartInfo);
        } else if (chartInfo instanceof BarChartInfo) {
            return createBarChartDataSet((BarChartInfo) chartInfo);
        } else {
            throw new IllegalArgumentException();
        }
    }


    public static BarChartModel createBarChartModel(BarChartInfo barChartInfo) {
        BarChartModel barChartModel = new BarChartModel();
        ChartData data = createChartData(barChartInfo);
        barChartModel.setData(data);
        barChartModel.setOptions(barChartInfo.getChartOptions());
        return barChartModel;
    }

    public static LineChartModel createLineChartModel(LineChartInfo chartInfo) {
        LineChartModel lineChartModel = new LineChartModel();
        ChartData data = createChartData(chartInfo);
        data.addChartDataSet(createLineChartDataSet(chartInfo));
        data.setLabels(chartInfo.getLabels());
        lineChartModel.setData(data);
        lineChartModel.setOptions(chartInfo.getChartOptions());



        return lineChartModel;
    }

    private static ChartData createChartData(ChartInfo chartInfo) {
        ChartData data = new ChartData();
        data.addChartDataSet(createChartDataset(chartInfo));
        data.setLabels(chartInfo.getLabels());
        return data;
    }


    private static LineChartDataSet createLineChartDataSet(LineChartInfo chartInfo) {
        LineChartDataSet dataSet = new LineChartDataSet();
        dataSet.setData(chartInfo.getValues());
        dataSet.setLabel(chartInfo.getLabel());
        return dataSet;
    }

    private static BarChartDataSet createBarChartDataSet(BarChartInfo chartInfo) {
        BarChartDataSet dataSet = new BarChartDataSet();
        dataSet.setData(chartInfo.getValues().stream().map(obj -> (Number) obj).collect(Collectors.toList()));
        dataSet.setLabel(chartInfo.getLabel());
        return dataSet;
    }

}


/*
awef=fwaef
awef=waefew
waefwef=waefwe
 */


