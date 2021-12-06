package com.example.titanic.service;

import com.example.titanic.model.Female;
import com.example.titanic.model.Passenger;
import com.example.titanic.model.Ticket;
import com.example.titanic.repo.MaleRepository;
import com.example.titanic.repo.PassengersRepository;
import com.example.titanic.repo.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    @Autowired
    private PassengersRepository passengersRepository;

    @Autowired
    private MaleRepository maleRepository;

    @Autowired
    private TicketRepository ticketRepository;

    public void savePassenger (Passenger passenger){
        passengersRepository.save(passenger);
    }

    public List<Passenger> findAllPassengers(){
        return passengersRepository.findAll();
    }

    public void saveFemale(Passenger passenger){
        var female = new Female(passenger.getAge(), passenger.getFare(), passenger);
        maleRepository.save(female);
        passenger.setFemale(female);
        passengersRepository.save(passenger);
    }

    public void saveTicket(Passenger passenger){
        var ticket = new Ticket(passenger.getTicket(), passenger);
        ticketRepository.saveAndFlush(ticket);
        passenger.setTicketData(ticket);
        passengersRepository.saveAndFlush(passenger);
    }

    public List<Ticket> findAllTickets(){
        return ticketRepository.findAll();
    }

    public Float averageTicketPriceForFrom(String sex, String place){
        var count = 0;
        var sum = 0.0f;
        for (var person:findAllPassengers()) {
            if (person.getSex().equals(sex)
                    && person.getFare() != null
                    && person.getEmbarked() != null
                    && person.getEmbarked() == place.toCharArray()[0]){
                count++;
                sum += person.getFare();
            }
        }

        return sum / count;
    }
}
