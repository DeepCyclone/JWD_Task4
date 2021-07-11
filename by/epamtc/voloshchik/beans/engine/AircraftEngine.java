package by.epamtc.voloshchik.beans.engine;

import java.io.Serializable;

public class AircraftEngine implements Serializable {
    private String type;
    private double power;
    private double traction;
    private int serialID;

    public AircraftEngine(String type, double power, double traction,int serialID) {
        this.type = type;
        this.power = power;
        this.traction = traction;
        this.serialID = serialID;
    }

    public String getType() {
        return type;
    }

    public double getPower() {
        return power;
    }

    public double getTraction() {
        return traction;
    }

    public int getSerialID() {
        return serialID;
    }

    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = result * prime + type.hashCode();
        result = result * prime + Double.hashCode(power);
        result = result * prime + Double.hashCode(traction);
        result = result * prime + serialID;
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ":" +
                "Type - " + type +
                "| Maximal power(HP) - " + power +
                "| Maximal traction (KgF) - " + traction +
                "| Serial ID - "+ serialID;
    }
}
