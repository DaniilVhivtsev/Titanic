package com.example.titanic.controller;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//@Controller
//@RequestMapping("/main")
public class MainController {

//    @GetMapping()
//    public void drawPieChart(HttpServletResponse response){
//        response.setContentType("image/png");
//        var pdSet = createDataSet();
//
//        var chart = createChart(pdSet, "My Pie Chart");
//        try{
//            ChartUtilities.writeChartAsPNG(response.getOutputStream(), chart, 750, 400);
//            response.getOutputStream().close();
//        } catch (IOException ioException) {
//            ioException.printStackTrace();
//        }
//    }
//
//    private PieDataset createDataSet(){
//        var dpd = new DefaultPieDataset();
//        dpd.setValue("Mac", 21);
//        dpd.setValue("Linux", 30);
//        dpd.setValue("Windows", 40);
//        dpd.setValue("Others", 9);
//        return dpd;
//    }
//
//    private JFreeChart createChart(PieDataset pdSet, String chartTitle){
//        var chart = ChartFactory.createPieChart3D(chartTitle, pdSet, true, true, false);
//        var plot = (PiePlot3D) chart.getPlot();
//        plot.setStartAngle(290);
//        plot.setDirection(Rotation.CLOCKWISE);
//        plot.setForegroundAlpha(0.5f);
//        return chart;
//    }
}
