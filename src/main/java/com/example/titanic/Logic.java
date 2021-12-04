package com.example.titanic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Component
public class Logic {

    private static PassengersRepo passengersRepo;

    public Logic(PassengersRepo passengersRepo) {
        this.passengersRepo = passengersRepo;
    }


    public static void main() throws IOException {
        var filePath = "src/main/resources/Пассажиры Титаника.csv";
        parseProductCsv(filePath);
        System.out.println("Hello world!");
    }

    private static void parseProductCsv(String filePath) throws IOException {
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

                passengersRepo.save(passenger);
            } catch (Exception exception){
                var nam = splitLine[4];
                var ar = splitLine[4].length();

                exception.getMessage();
            }
        }
    }
}

