package by.epamtc.voloshchik.beans.aircrafts;

import by.epamtc.voloshchik.beans.engine.AircraftEngine;

import java.io.Serializable;

public abstract class Aircraft implements Serializable {
    private String model;
    private double maxSpeed;
    private double maxFlightDistance;
    private double unladenWeight;
    private AircraftEngine engine;
    private int flightCrew;
    private double fuelConsumptionKgPerHour;

    public Aircraft() {

    }

    public Aircraft(String model, double maxSpeed, double maxFlightDistance, double unladenWeight, AircraftEngine engine, int flightCrew, double fuelConsumptionKgPerHour) {
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.maxFlightDistance = maxFlightDistance;
        this.unladenWeight = unladenWeight;
        this.engine = engine;
        this.flightCrew = flightCrew;
        this.fuelConsumptionKgPerHour = fuelConsumptionKgPerHour;
    }

    public String getModel() {
        return model;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public double getMaxFlightDistance() {
        return maxFlightDistance;
    }

    public double getUnladenWeight() {
        return unladenWeight;
    }

    public AircraftEngine getEngine() {
        return engine;
    }

    public int getFlightCrew() {
        return flightCrew;
    }

    public double getFuelConsumptionKgPerHour() {
        return fuelConsumptionKgPerHour;
    }

    public boolean equals(Object o) {
        if(o == null || this != o)return false;
        if(o.getClass() != getClass())return false;
        Aircraft aircraft = (Aircraft) o;
        return model.equals(aircraft.getModel()) &&
                Double.compare(maxSpeed,aircraft.getMaxSpeed()) == 0 &&
                Double.compare(maxFlightDistance,aircraft.getMaxFlightDistance()) == 0 &&
                Double.compare(unladenWeight,aircraft.getUnladenWeight()) == 0 &&
                engine.equals(aircraft.getEngine()) &&
                flightCrew == aircraft.getFlightCrew() &&
                Double.compare(fuelConsumptionKgPerHour,aircraft.getFuelConsumptionKgPerHour()) == 0;
    }

    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = result * prime + model.hashCode();
        result = result * prime + Double.hashCode(maxSpeed);
        result = result * prime + Double.hashCode(maxFlightDistance);
        result = result * prime + Double.hashCode(unladenWeight);
        result = result * prime + engine.hashCode();
        result = result * prime + flightCrew;
        result = result * prime + Double.hashCode(fuelConsumptionKgPerHour);
        return result;
    }
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append(getClass().getSimpleName() + ":\n");
        info.append("\tmodel:" + model);
        info.append("\n\tmax speed (km/h):" + maxSpeed);
        info.append("\n\tmax flight distance (km):" + maxFlightDistance);
        info.append("\n\tunladen weight (kg):"+unladenWeight);
        info.append("\n\tflight crew:" + flightCrew);
        info.append("\n\tfuel consumption (Kg per hour):"+fuelConsumptionKgPerHour);
        info.append("\n" + engine.toString());
        return info.toString();
    }
}
