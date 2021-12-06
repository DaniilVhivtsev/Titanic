package com.example.titanic;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;


import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class BarChartDemo{

    public static void createBarChart() throws IOException {
        var dataset = new DefaultCategoryDataset();
        dataset.addValue(52733, "Мужчина", "Саутгемптон");
        dataset.addValue(64535, "Женщина" , "Саутгемптон");
        dataset.addValue(64535, "Мужчина" , "Шербург");
        dataset.addValue(51345, "Женщина", "Шербург");
        dataset.addValue(66896, "Мужчина" , "Куинстаун");
        dataset.addValue(66896, "Женщина" , "Куинстаун");

        var chart = ChartFactory.createBarChart(
                "Средние цены билета",
                null,
                "Цена",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                false,
                false);
        chart.setBackgroundPaint(Color.yellow);
        chart.getTitle().setPaint(Color.blue);
        var plot = chart.getCategoryPlot();
        var br = (BarRenderer) plot.getRenderer();
        br.setItemMargin(0);
        CategoryAxis domain = plot.getDomainAxis();
        domain.setLowerMargin(0.25);
        domain.setUpperMargin(0.25);

        ChartUtilities.saveChartAsPNG(new File("image.png"), chart, 600, 300);
    }
}