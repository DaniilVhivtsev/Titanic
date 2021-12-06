package com.example.titanic.model;

import javax.persistence.*;

@Entity
@Table(name = "passengers")
public class Passenger {

    @Id
    private Long passengerId;

    private boolean survived;

    private Short pClass;

    private String name;

    private String sex;

    private Float age;

    private Integer sibSp;

    private Integer parch;

    private String ticket;

    private Float fare;

    private String cabin;

    private Character embarked;

    @OneToOne(mappedBy="passenger", fetch = FetchType.LAZY)
    private Female female;

    @OneToOne(mappedBy="passenger", fetch = FetchType.LAZY)
    private Ticket ticketData;

    public Passenger() {
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }

    public boolean isSurvived() {
        return survived;
    }

    public void setSurvived(boolean survived) {
        this.survived = survived;
    }

    public Short getpClass() {
        return pClass;
    }

    public void setpClass(Short pClass) {
        this.pClass = pClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Float getAge() {
        return age;
    }

    public void setAge(Float age) {
        this.age = age;
    }

    public Integer getSibSp() {
        return sibSp;
    }

    public void setSibSp(Integer sibSp) {
        this.sibSp = sibSp;
    }

    public Integer getParch() {
        return parch;
    }

    public void setParch(Integer parch) {
        this.parch = parch;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Float getFare() {
        return fare;
    }

    public void setFare(Float fare) {
        this.fare = fare;
    }

    public String getCabin() {
        return cabin;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin;
    }

    public Character getEmbarked() {
        return embarked;
    }

    public void setEmbarked(Character embarked) {
        this.embarked = embarked;
    }

    public Female getFemale() {
        return female;
    }

    public void setFemale(Female female) {
        this.female = female;
    }

    public Ticket getTicketData() {
        return ticketData;
    }

    public void setTicketData(Ticket ticketData) {
        this.ticketData = ticketData;
    }

    @Override
    public String toString() {
        return passengerId + "," + survived + "," + pClass + "," + name + "," + sex
                + "," + age + "," + sibSp + "," + parch + "," + ticket + "," + fare + "," + cabin + "," + embarked;
    }
}

