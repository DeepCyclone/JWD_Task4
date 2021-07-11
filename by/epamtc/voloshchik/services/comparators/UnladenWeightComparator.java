package by.epamtc.voloshchik.services.comparators;

import by.epamtc.voloshchik.beans.aircrafts.Aircraft;

import java.util.Comparator;

public class UnladenWeightComparator implements Comparator<Aircraft> {
    @Override
    public int compare(Aircraft o1, Aircraft o2) {
        return Double.compare(o1.getUnladenWeight(),o2.getUnladenWeight());
    }
}
