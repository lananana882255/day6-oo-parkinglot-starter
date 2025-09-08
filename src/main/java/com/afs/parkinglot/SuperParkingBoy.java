package com.afs.parkinglot;
import java.util.Comparator;
import java.util.Optional;

public class SuperParkingBoy extends StandardParkingBoy{
    public SuperParkingBoy(ParkingLot... parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket park(Car car) {
        Optional<ParkingLot> bestParkingLot = parkingLotList.stream()
                .filter(parkingLot -> parkingLot.getAvailablePositionCount() > 0)
                .max(Comparator.comparingDouble(ParkingLot::getVacancyRate));

        return bestParkingLot
                .orElseThrow(() -> new RuntimeException("No available position."))
                .park(car);
    }
}
