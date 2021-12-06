package com.example.titanic;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.*;

public class BarChartDemo{


    public static JFreeChart createBarChart() throws SQLException {
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

        JFrame f = new JFrame("TreeEditorDemo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ChartPanel cp = new ChartPanel(chart) {

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(300, 300);
            }
        };
        f.add(cp);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        return chart;
    }

    /*public BarChartDemo() {
        createDemoPanel().setVisible(true);
    }
    public JPanel createDemoPanel() {
        CategoryDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);
        chart.setPadding(new RectangleInsets(4, 8, 2, 2));
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setFillZoomRectangle(true);
        chartPanel.setMouseWheelEnabled(true);
        chartPanel.setPreferredSize(new Dimension(500, 500));
        return chartPanel;
    }

    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(52733, "Мужчина", "Саутгемптон");
        dataset.addValue(64535, "Женщина" , "Саутгемптон");
        dataset.addValue(64535, "Мужчина" , "Шербург");
        dataset.addValue(51345, "Женщина", "Шербург");
        dataset.addValue(66896, "Мужчина" , "Куинстаун");
        dataset.addValue(66896, "Женщина" , "Куинстаун");
        return dataset;
    }

    private JFreeChart createChart(CategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart(
                "Семейный доход за текущий год",
                "Место отправления",                    // x-axis label
                "Средние цены билетов у пассажиров",                 // y-axis label
                dataset);
        chart.setBackgroundPaint(Color.white);
        CategoryPlot plot = (CategoryPlot) chart.getPlot();

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);
        chart.getLegend().setFrame(BlockBorder.NONE);
        return chart;
    }*/
}