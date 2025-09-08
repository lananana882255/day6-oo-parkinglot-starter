package com.afs.parkinglot;

import java.util.Optional;
import java.util.Comparator;

public class SmartParkingBoy extends StandardParkingBoy{
    public SmartParkingBoy(ParkingLot... parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket park(Car car) {
        Optional<ParkingLot> bestParkingLot = parkingLotList.stream()
                .filter(parkingLot -> parkingLot.getAvailablePositionCount() > 0)
                .max(Comparator.comparingInt(ParkingLot::getAvailablePositionCount));

        return bestParkingLot
                .orElseThrow(() -> new RuntimeException("No available position."))
                .park(car);
    }
}
