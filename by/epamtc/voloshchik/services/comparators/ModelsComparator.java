package by.epamtc.voloshchik.services.comparators;

import by.epamtc.voloshchik.beans.aircrafts.Aircraft;

import java.util.Comparator;

public class ModelsComparator implements Comparator<Aircraft> {

    public int compare(Aircraft o1, Aircraft o2) {
        return o1.getModel().compareTo(o2.getModel());
    }
}
