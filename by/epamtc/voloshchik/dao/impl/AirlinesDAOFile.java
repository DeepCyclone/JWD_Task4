package by.epamtc.voloshchik.dao.impl;

import by.epamtc.voloshchik.beans.aircrafts.Aircraft;
import by.epamtc.voloshchik.beans.aircrafts.CargoPlane;
import by.epamtc.voloshchik.beans.aircrafts.CommercialPlane;
import by.epamtc.voloshchik.beans.aircrafts.Helicopter;
import by.epamtc.voloshchik.beans.airline.AirlinesCompany;
import by.epamtc.voloshchik.beans.engine.AircraftEngine;
import by.epamtc.voloshchik.dao.AirlinesDAO;
import by.epamtc.voloshchik.dao.DAOException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class AirlinesDAOFile implements AirlinesDAO {
    private static String filePath = "src" + File.separator + "resources" + File.separator + "planes.txt";
    private static String delimiter = "=";
    @Override
    public AirlinesCompany read() throws DAOException {
        AirlinesCompany company = new AirlinesCompany(2500,"belavia");
        File file = new File(filePath);
        Scanner scanner = null;
        if(file.exists()) {
            try {
                scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] aircraftSpecs = line.split(delimiter);
                    String model = aircraftSpecs[1];
                    double maxSpeed = Double.parseDouble(aircraftSpecs[2]);
                    double maxFlightDistance = Double.parseDouble(aircraftSpecs[3]);
                    double unladenWeight = Double.parseDouble(aircraftSpecs[4]);
                    String engineType = aircraftSpecs[5];
                    double enginePower = Double.parseDouble(aircraftSpecs[6]);
                    double engineTraction = Double.parseDouble(aircraftSpecs[7]);
                    int engineSerialID = Integer.parseInt(aircraftSpecs[8]);
                    int flightCrew = Integer.parseInt(aircraftSpecs[9]);
                    double fuelConsumption = Double.parseDouble(aircraftSpecs[10]);
                    AircraftEngine e = new AircraftEngine(engineType, enginePower, engineTraction, engineSerialID);
                    if (aircraftSpecs[0].equals("CargoPlane")) {
                        double maxFreightWeight = Double.parseDouble(aircraftSpecs[11]);
                        company.addPlane(new CargoPlane(model, maxSpeed, maxFlightDistance, unladenWeight, e, flightCrew, fuelConsumption, maxFreightWeight));
                    } else if (aircraftSpecs[0].equals("CommercialPlane")) {
                        int passengerSeats = Integer.parseInt(aircraftSpecs[11]);
                        company.addPlane((new CommercialPlane(model, maxSpeed, maxFlightDistance, unladenWeight, e, flightCrew, fuelConsumption, passengerSeats)));
                    } else if (aircraftSpecs[0].equals("Helicopter")) {
                        int bladesAmount = Integer.parseInt(aircraftSpecs[11]);
                        int passengerSeats = Integer.parseInt(aircraftSpecs[12]);
                        company.addPlane((new Helicopter(model, maxSpeed, maxFlightDistance, unladenWeight, e, flightCrew, fuelConsumption, bladesAmount, passengerSeats)));
                    }
                    else {
                        throw new DAOException("Undefined type of aircraft");
                    }
                }
            }
            catch (FileNotFoundException | NumberFormatException |
                    NullPointerException | NoSuchElementException | IllegalStateException e){
                throw new DAOException(e.getMessage(),e);
            }
            finally {
                if(scanner != null) {
                    scanner.close();
                }
            }
        }
        return company;
    }

    @Override
    public void write(AirlinesCompany airlinesCompany) throws DAOException {
        File file = new File(filePath);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            if (!file.exists()) {
                file.createNewFile();
            }
            for (Aircraft aircraft : airlinesCompany) {
                fileWriter.write(aircraft.getClass().getSimpleName());
                fileWriter.write(delimiter + aircraft.getModel());
                fileWriter.write(delimiter + aircraft.getMaxSpeed());
                fileWriter.write(delimiter + aircraft.getMaxFlightDistance());
                fileWriter.write(delimiter + aircraft.getUnladenWeight());
                fileWriter.write(delimiter + aircraft.getEngine().getType());
                fileWriter.write(delimiter + aircraft.getEngine().getPower());
                fileWriter.write(delimiter + aircraft.getEngine().getTraction());
                fileWriter.write(delimiter + aircraft.getEngine().getSerialID());
                fileWriter.write(delimiter + aircraft.getFlightCrew());
                fileWriter.write(delimiter + aircraft.getFuelConsumptionKgPerHour());

                if (aircraft.getClass() == CargoPlane.class) {
                    fileWriter.write(delimiter + ((CargoPlane) aircraft).getMaxFreightWeight());
                }
                if (aircraft.getClass() == CommercialPlane.class) {
                    fileWriter.write(delimiter + ((CommercialPlane) aircraft).getTypicalPassengersSeats());
                }
                if (aircraft.getClass() == Helicopter.class) {
                    fileWriter.write(delimiter + ((Helicopter) aircraft).getBladesAmount());
                    fileWriter.write(delimiter + ((Helicopter) aircraft).getPassengerSeats());
                }
                else {
                    throw new DAOException("Undefined type of aircraft");
                }
                fileWriter.write("\n");
            }
        }
        catch (IOException | NullPointerException e) {
            throw new DAOException(e.getMessage(),e);
        }
        finally {
            if(fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    throw new DAOException(e.getMessage(),e);
                }
            }
        }
    }

    @Override
    public void deleteAll() {
        File file = new File(filePath);
        if(file.exists()){
            file.delete();
        }
    }
}
