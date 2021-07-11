package by.epamtc.voloshchik.beans.airline;

import by.epamtc.voloshchik.beans.aircrafts.Aircraft;
import by.epamtc.voloshchik.services.AircraftServices;
import by.epamtc.voloshchik.services.BubbleSort;
import by.epamtc.voloshchik.services.Sorter;
import by.epamtc.voloshchik.services.comparators.ModelsComparator;
import by.epamtc.voloshchik.validation.Validator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class AirlinesCompany implements Iterable<Aircraft>, Serializable {
    private int personnel;
    private String name;
    private ArrayList<Aircraft> aircrafts;

    public AirlinesCompany(int personnel, String name) {
        this.personnel = personnel;
        this.name = name;
        aircrafts = new ArrayList<>();
    }

    public boolean addPlane(Aircraft aircraft) {
        if(Validator.isNullReference(aircraft)) {
            return false;
        }
        return aircrafts.add(aircraft);
    }

    public boolean removePlane(Aircraft aircraft) {
        if(Validator.isNullReference(aircraft)){
            return false;
        }
        return aircrafts.remove(aircraft);
    }
    public void sort(Comparator<Aircraft> cmp) {
        BubbleSort.sort(aircrafts,cmp);
    }

    @Override
    public Iterator<Aircraft> iterator() {
        return new Iterator<Aircraft>() {
            int counter = 0;
            @Override
            public boolean hasNext() {
                return counter < aircrafts.size();
            }

            @Override
            public Aircraft next() {
                Aircraft element = aircrafts.get(counter);
                ++counter;
                return element;
            }
        };
    }

    public int getPersonnel() {
        return personnel;
    }

    public void setPersonnel(short personnel) {
        this.personnel = personnel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(getClass().getSimpleName() + " " + name + "\n");
        result.append("List of aircrafts located down below \n");
        for(Aircraft a:aircrafts) {
            result.append(a.toString());
            result.append("\n=========================\n");
        }
        return result.toString();
    }
}
