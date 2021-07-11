package by.epamtc.voloshchik.beans.aircrafts;

import by.epamtc.voloshchik.beans.engine.AircraftEngine;

import java.io.Serializable;

public class CommercialPlane extends Aircraft implements Serializable {
    private int typicalPassengersSeats;

    public CommercialPlane(){

    }

    public CommercialPlane(String model, double maxSpeed, double maxFlightDistance, double unladenWeight, AircraftEngine engine, int flightCrew, double fuelConsumptionKgPerHour,int typicalPassengersSeats) {
        super(model, maxSpeed, maxFlightDistance, unladenWeight, engine, flightCrew, fuelConsumptionKgPerHour);
        this.typicalPassengersSeats = typicalPassengersSeats;
    }

    public int getTypicalPassengersSeats() {
        return typicalPassengersSeats;
    }

    public boolean equals(Object o) {
        if(!super.equals(o))return false;
        CommercialPlane c = (CommercialPlane) o;
        return typicalPassengersSeats == c.getTypicalPassengersSeats();
    }

    public int hashCode() {
        int prime = 31;
        int result = super.hashCode();
        result = result * prime + typicalPassengersSeats;
        return result;
    }

    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append(super.toString());
        info.append("\n\tAvailable passengers seats - " + typicalPassengersSeats);
        return info.toString();
    }
}
