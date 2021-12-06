package com.example.titanic.model;

import javax.persistence.*;

@Entity
@Table(name = "female")
public class Female {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private Float age;

    private Float ticketCost;

    @OneToOne(optional=true, fetch = FetchType.EAGER)
    private Passenger passenger;

    public Female() {
    }

    public Female(Float age, Float ticketCost, Passenger passenger) {
        this.age = age;
        this.ticketCost = ticketCost;
        this.passenger = passenger;
    }

    public Float getAge() {
        return age;
    }

    public void setAge(Float age) {
        this.age = age;
    }

    public Float getTicketCost() {
        return ticketCost;
    }

    public void setTicketCost(Float ticketCost) {
        this.ticketCost = ticketCost;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}
