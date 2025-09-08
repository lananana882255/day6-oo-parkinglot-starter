package com.afs.parkinglot;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StandardParkingBoy {
    private ParkingLot parkingLot;
    private List<ParkingLot> parkingLotList;

    public StandardParkingBoy(ParkingLot parkingLot) {
        this.parkingLot=parkingLot;
    }

    public StandardParkingBoy(ParkingLot... parkingLots) {
        this.parkingLotList= Arrays.asList(parkingLots);
    }

    public Ticket park(Car car) {
        for(ParkingLot parkingLot: parkingLotList){
            try {
                return parkingLot.park(car);
            } catch (RuntimeException e) {
            }
        }
        return null;
    }

    public Car fetch(Ticket ticket) {
        return this.parkingLot.fetch(ticket);
    }


}
