package com.example.titanic.model;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long Id;

    private String name;

    @OneToOne(optional=true, fetch = FetchType.EAGER)
    private Passenger passenger;

    public Ticket() {
    }

    public Ticket(String name, Passenger passenger) {
        this.name = name;
        this.passenger = passenger;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    @Override
    public String toString() {
        return "Ticket: " + name + " " + "Passenger: " + passenger.getName() + " " + "Age: " + passenger.getAge();
    }
}
