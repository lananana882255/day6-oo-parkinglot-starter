package com.afs.parkinglot;

import java.util.HashMap;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int capacity;
    private Map<Ticket, Car> parkedCars = new HashMap<>();

    public ParkingLot() {
        this.capacity=10;
    }

    public ParkingLot(int capacity) {
        this.capacity=capacity;
    }

    public Ticket park(Car car) {
        if(parkedCars.size()>=this.capacity){
            return null;
        }
        Ticket ticket=new Ticket();
        this.parkedCars.put(ticket,car);
        return ticket;
    }

    public Car fetch(Ticket ticket) {
        if (ticket == null) {
            return null;
        }
        Car fetchCar = parkedCars.remove(ticket);
        if(fetchCar==null){
            throw new RuntimeException("Unrecognized parking ticket.");
        }
        return fetchCar;
    }
}
