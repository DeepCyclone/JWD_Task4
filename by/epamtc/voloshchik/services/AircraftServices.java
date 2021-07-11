package by.epamtc.voloshchik.services;

import by.epamtc.voloshchik.beans.aircrafts.CargoPlane;
import by.epamtc.voloshchik.beans.aircrafts.CommercialPlane;
import by.epamtc.voloshchik.beans.aircrafts.Helicopter;
import by.epamtc.voloshchik.beans.airline.AirlinesCompany;
import by.epamtc.voloshchik.beans.aircrafts.Aircraft;

public class AircraftServices {

    public static double calculateTotalCapacity(AirlinesCompany company){
        double totalCapacity = 0;
        for(Aircraft aircraft : company) {
            if(aircraft.getClass() == CommercialPlane.class) {
                CommercialPlane cp = (CommercialPlane) aircraft;
                totalCapacity += cp.getTypicalPassengersSeats();
            }
            if(aircraft.getClass() == Helicopter.class) {
                Helicopter hp = (Helicopter) aircraft;
                totalCapacity += hp.getPassengerSeats();
            }
        }
        return totalCapacity;
    }
    public static double calculateTotalFreightWeight(AirlinesCompany company){
        double totalCapacity = 0;
        for(Aircraft aircraft : company) {
            if(aircraft.getClass() == CargoPlane.class) {
                CargoPlane cp = (CargoPlane) aircraft;
                totalCapacity += cp.getMaxFreightWeight();
            }
        }
        return totalCapacity;
    }
    public static Aircraft findPlaneByFuelConsumption(AirlinesCompany company, double minConsumption, double maxConsumption) {
        Aircraft suitableAircraft = null;
        //incorrect bounds check
        for(Aircraft aircraft:company) {
            if (aircraft.getFuelConsumptionKgPerHour() >= minConsumption &&
                    aircraft.getFuelConsumptionKgPerHour() <= maxConsumption) {
                suitableAircraft = aircraft;
                break;
            }
        }
        return suitableAircraft;
    }

}
