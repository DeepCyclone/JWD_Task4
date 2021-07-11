package by.epamtc.voloshchik.beans.aircrafts;

import by.epamtc.voloshchik.beans.engine.AircraftEngine;

public class Helicopter extends Aircraft{
    private int bladesAmount;
    private int passengerSeats;

    public Helicopter(){

    }

    public Helicopter(String model, double maxSpeed, double maxFlightDistance, double unladenWeight, AircraftEngine engine, int flightCrew, double fuelConsumptionKgPerHour, int bladesAmount,int passengerSeats) {
        super(model, maxSpeed, maxFlightDistance, unladenWeight, engine, flightCrew, fuelConsumptionKgPerHour);
        this.bladesAmount = bladesAmount;
        this.passengerSeats = passengerSeats;
    }

    public int getPassengerSeats() {
        return passengerSeats;
    }

    public int getBladesAmount() {
        return bladesAmount;
    }

    public int hashCode() {
        int prime = 31;
        int result = super.hashCode();
        result = result * prime + bladesAmount;
        result = result * prime + passengerSeats;
        return result;
    }

    public boolean equals(Object o) {
        if(!super.equals(o))return false;
        Helicopter c = (Helicopter) o;
        return bladesAmount == c.getBladesAmount();
    }

    public String toString() {
        StringBuilder info = new StringBuilder(super.toString());
        info.append("\n\tblades amount - " + bladesAmount);
        info.append("\n\tpassenger seats - "+ passengerSeats);
        return info.toString();
    }
}
