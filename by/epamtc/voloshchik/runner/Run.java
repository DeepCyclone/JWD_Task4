package by.epamtc.voloshchik.runner;

import by.epamtc.voloshchik.beans.aircrafts.*;
import by.epamtc.voloshchik.beans.airline.*;
import by.epamtc.voloshchik.beans.engine.*;
import by.epamtc.voloshchik.dao.impl.*;
import by.epamtc.voloshchik.services.comparators.*;
import by.epamtc.voloshchik.services.*;
import by.epamtc.voloshchik.dao.*;

import java.io.File;

public class Run {
    public static void main(String[] args){
        AirlinesDAOFile FileDAO = new AirlinesDAOFile();
        AirlinesCompany belavia;
        try {
            belavia = FileDAO.read();
            System.out.println(belavia);
        }
        catch (DAOException e) {
            System.out.println(e.getMessage());
        }
//        AircraftEngine e = new AircraftEngine("Diesel",300,500,533461);
//        Aircraft a = new CargoPlane("Bla-bla car",35,5,5,e,3,700,346);
//        Aircraft b = new Helicopter("Soldier",75,5,5,e,3,900,346,5);
//        Aircraft c = new CommercialPlane("Flack",25,5,5,e,3,435,1000);
//        belavia.addPlane(a);
//        belavia.addPlane(b);
//        belavia.addPlane(c);
//        belavia.sort(new ModelsAndMaxSpeedComparator());
//        try {
//            FileDAO.write(belavia);
//        }
//        catch (DAOException ex) {
//            System.out.println(ex.getMessage());
//        }
        //System.out.println(AircraftServices.findPlaneByFuelConsumption(belavia,300,500).toString());
    }
}
