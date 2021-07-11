package by.epamtc.voloshchik.services.comparators;

import by.epamtc.voloshchik.beans.aircrafts.Aircraft;

import java.util.Comparator;

public class ModelsAndMaxSpeedComparator implements Comparator<Aircraft> {
    @Override
    public int compare(Aircraft o1, Aircraft o2) {
        int mainComparationKey = o1.getModel().compareTo(o2.getModel());
        if(mainComparationKey != 0){
            return mainComparationKey;
        } else {
          return Double.compare(o1.getMaxSpeed(),o2.getMaxSpeed());
        }
    }
}
