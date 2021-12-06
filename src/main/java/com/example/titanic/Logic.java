package com.example.titanic;

import com.example.titanic.model.Passenger;
import com.example.titanic.service.PassengerService;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;

@Component
public class Logic {

    private PassengerService passengerService;

    public Logic(PassengerService passengerService) {
        this.passengerService = passengerService;
    }


    public void main() throws IOException, SQLException {
        var filePath = "src/main/resources/Пассажиры Титаника.csv";
//        parseProductCsv(filePath);
//        writePassengers();
//        makeTableWithMale();
//        makeTableWithTickets();

       BarChartDemo.createBarChart();

    }

    private void parseProductCsv(String filePath) throws IOException {
        //Загружаем строки из файла
        List<String> fileLines = Files.readAllLines(Paths.get(filePath));
        fileLines.remove(0);
        for (String fileLine : fileLines) {
            var firstIndex = fileLine.indexOf("\"");
            var lastIndex = fileLine.lastIndexOf("\"");
            var name = fileLine.substring(firstIndex + 1, lastIndex - 1);
            fileLine = fileLine.substring(0, firstIndex - 1) + fileLine.substring(lastIndex + 1);

            var splitLine = fileLine.split(",");
            try{
                var passenger = new Passenger();
                passenger.setPassengerId(Long.parseLong(splitLine[0]));
                passenger.setSurvived(Short.parseShort(splitLine[1]) != 0);
                passenger.setpClass(Short.parseShort(splitLine[2]));
                passenger.setName(name);
                passenger.setSex(splitLine[3]);
                passenger.setAge(splitLine[4].length() != 0 ? Float.parseFloat(splitLine[4]) : null);
                passenger.setSibSp(Integer.parseInt(splitLine[5]));
                passenger.setParch(Integer.parseInt(splitLine[6]));
                passenger.setTicket(splitLine[7]);
                passenger.setFare(Float.parseFloat(splitLine[8]));
                passenger.setCabin(splitLine[9]);
                if (splitLine.length == 10)
                    passenger.setEmbarked(null);
                else passenger.setEmbarked(splitLine[10].toCharArray()[0]);
                /*var passenger1 = new Passenger(
                        Long.parseLong(splitLine[0]),
                        Short.parseShort(splitLine[1]) != 0,
                        Short.parseShort(splitLine[2]),
                        name,
                        splitLine[3],
                        splitLine[4] != null ? Integer.parseInt(splitLine[4]) : null,
                        Integer.parseInt(splitLine[5]),
                        Integer.parseInt(splitLine[6]),
                        splitLine[7],
                        Float.parseFloat(splitLine[8]),
                        splitLine[9],
                        splitLine[10].toCharArray()[0]
                );*/

                passengerService.savePassenger(passenger);
            } catch (Exception exception){
                var nam = splitLine[4];
                var ar = splitLine[4].length();

                exception.getMessage();
            }
        }
    }
    
    public void writePassengers(){
        for (var passenger: passengerService.findAllPassengers()) {
            System.out.println(passenger.toString());
        }
    }

    public void makeTableWithMale(){
        var min = Float.MAX_VALUE;
        var max = 0f;

        for (var passenger:passengerService.findAllPassengers()) {
            if (passenger.getSex().equals("female") && passenger.getAge() != null && passenger.getAge() >= 15 && passenger.getAge() <= 30){
                if (passenger.getFare() < min)
                    min = passenger.getFare();
                if (passenger.getFare() > max)
                    max = passenger.getFare();
                passengerService.saveFemale(passenger);
            }
        }

        System.out.println(max - min);
    }

    public void makeTableWithTickets(){
        for (var passenger:passengerService.findAllPassengers()){
            if(passenger.getAge() != null && (passenger.getSex().equals("male") && ( passenger.getAge() >= 45.0 && passenger.getAge() <= 60.0)
                    || passenger.getSex().equals("female") && (passenger.getAge() >= 20 && passenger.getAge() <= 25))){
                passengerService.saveTicket(passenger);
            }
        }

        for (var ticket:passengerService.findAllTickets()) {
            System.out.println(ticket);
        }
    }
}

