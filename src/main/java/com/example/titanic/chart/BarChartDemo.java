package com.example.titanic.chart;

import com.example.titanic.service.PassengerService;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.io.File;
import java.io.IOException;

@Component
public class BarChartDemo{

    private static PassengerService passengerService;

    public BarChartDemo(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    public static void createBarChart() throws IOException {
        var dataset = new DefaultCategoryDataset();
        dataset.addValue(passengerService.averageTicketPriceForFrom("male", "S"), "Мужчина", "Саутгемптон");
        dataset.addValue(passengerService.averageTicketPriceForFrom("female", "S"), "Женщина" , "Саутгемптон");
        dataset.addValue(passengerService.averageTicketPriceForFrom("male", "C"), "Мужчина" , "Шербург");
        dataset.addValue(passengerService.averageTicketPriceForFrom("female", "C"), "Женщина", "Шербург");
        dataset.addValue(passengerService.averageTicketPriceForFrom("male", "Q"), "Мужчина" , "Куинстаун");
        dataset.addValue(passengerService.averageTicketPriceForFrom("female", "Q"), "Женщина" , "Куинстаун");

        var chart = ChartFactory.createBarChart(
                "График средних цен", null, "Средняя цена", dataset,
                PlotOrientation.VERTICAL, true, false, false);
        chart.setBackgroundPaint(Color.yellow);
        chart.getTitle().setPaint(Color.blue);
        var plot = chart.getCategoryPlot();
        ((BarRenderer) plot.getRenderer()).setItemMargin(0);
        CategoryAxis domain = plot.getDomainAxis();
        domain.setUpperMargin(0.25);
        domain.setLowerMargin(0.25);

        ChartUtilities.saveChartAsPNG(new File("image.png"), chart, 1000, 600);
    }
}