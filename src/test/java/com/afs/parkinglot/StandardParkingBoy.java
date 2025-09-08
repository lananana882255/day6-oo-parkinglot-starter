package com.afs.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class StandardParkingBoy {
    private ParkingLot parkingLot;

    public StandardParkingBoy(ParkingLot parkingLot) {
        this.parkingLot=parkingLot;
    }

    public Ticket park(Car car) {
        return this.parkingLot.park(car);
    }
}
