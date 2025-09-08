package com.afs.parkinglot;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StandardParkingBoy {
    private ParkingLot parkingLot;
    private List<ParkingLot> parkingLotList;

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
        throw new RuntimeException("No available position.");
    }

    public Car fetch(Ticket ticket) {
        for(ParkingLot parkingLot: parkingLotList){
            try {
                return parkingLot.fetch(ticket);
            } catch (RuntimeException e) {
            }
        }
        throw new RuntimeException("Unrecognized parking ticket.");
    }


}
