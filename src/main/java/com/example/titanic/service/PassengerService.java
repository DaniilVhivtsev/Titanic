package com.example.titanic.service;

import com.example.titanic.model.Female;
import com.example.titanic.model.Passenger;
import com.example.titanic.model.Ticket;
import com.example.titanic.repo.MaleRepo;
import com.example.titanic.repo.PassengersRepo;
import com.example.titanic.repo.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    @Autowired
    private PassengersRepo passengersRepo;

    @Autowired
    private MaleRepo maleRepo;

    @Autowired
    private TicketRepo ticketRepo;

    public void savePassenger (Passenger passenger){
        passengersRepo.save(passenger);
    }

    public List<Passenger> findAllPassengers(){
        return passengersRepo.findAll();
    }

    public void saveFemale(Passenger passenger){
        var female = new Female(passenger.getAge(), passenger.getFare(), passenger);
        maleRepo.save(female);
        passenger.setFemale(female);
        passengersRepo.save(passenger);
    }

    public void saveTicket(Passenger passenger){
        var ticket = new Ticket(passenger.getTicket(), passenger);
        ticketRepo.saveAndFlush(ticket);
        passenger.setTicketData(ticket);
        passengersRepo.saveAndFlush(passenger);
    }

    public List<Ticket> findAllTickets(){
        return ticketRepo.findAll();
    }
}
