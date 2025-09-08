package com.afs.parkinglot;

import java.util.HashMap;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int capacity=10;
    private Map<Ticket, Car> parkedCars = new HashMap<>();
    public Ticket park(Car car) {
        Ticket ticket=new Ticket();
        this.parkedCars.put(ticket,car);
        return ticket;
    }
}
