package by.epamtc.voloshchik.beans.aircrafts;

import by.epamtc.voloshchik.beans.engine.AircraftEngine;

import java.io.Serializable;

public class CargoPlane extends Aircraft implements Serializable {
    private double maxFreightWeight;

    public CargoPlane(){

    }

    public CargoPlane(String model, double maxSpeed, double maxFlightDistance, double unladenWeight, AircraftEngine engine, int flightCrew, double fuelConsumptionKgPerHour, double maxFreightWeight) {
        super(model, maxSpeed, maxFlightDistance, unladenWeight, engine, flightCrew, fuelConsumptionKgPerHour);
        this.maxFreightWeight = maxFreightWeight;
    }

    public double getMaxFreightWeight() {
        return maxFreightWeight;
    }

    public boolean equals(Object o) {
        if(!super.equals(o))return false;
        CargoPlane c = (CargoPlane) o;
        return Double.compare(maxFreightWeight,c.getMaxFreightWeight()) == 0;
    }

    public int hashCode() {
        int prime = 31;
        int result = super.hashCode();
        result = result * prime + Double.hashCode(maxFreightWeight);
        return result;
    }

    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append(super.toString());
        info.append("\n\tMaximal freight weight - " + maxFreightWeight);
        return info.toString();
    }
}
