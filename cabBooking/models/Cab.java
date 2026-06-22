package cabBooking.models;

import cabBooking.enums.CabType;

public class Cab {
    private String cabNumber;
    private CabType cabType;

    public Cab(String cabNumber, CabType cabType) {
        this.cabNumber = cabNumber;
        this.cabType = cabType;
    }

    public String getCabNumber() {
        return cabNumber;
    }

    public CabType getCabType() {
        return cabType;
    }

    @Override
    public String toString() {
        return "Cab{" +
                "cabNumber='" + cabNumber + '\'' +
                ", cabType=" + cabType +
                '}';
    }
}