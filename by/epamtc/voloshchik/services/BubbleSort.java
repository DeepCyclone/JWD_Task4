package by.epamtc.voloshchik.services;

import by.epamtc.voloshchik.beans.aircrafts.Aircraft;

import java.util.ArrayList;
import java.util.Comparator;

public class BubbleSort{
    public static void sort(ArrayList<Aircraft> airlines, Comparator<Aircraft> cmp) {
        for(int i = 0;i < airlines.size() - 1;i++) {
            for(int j = 0; j < airlines.size() - i - 1;j++) {
                if(cmp.compare(airlines.get(j),airlines.get(j+1)) > 0) {
                    Aircraft temp = airlines.get(j);
                    airlines.set(j,airlines.get(j+1));
                    airlines.set(j+1,temp);
                }
            }
        }
    }
}
