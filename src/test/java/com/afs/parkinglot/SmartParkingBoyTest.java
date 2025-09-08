package com.afs.parkinglot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SmartParkingBoyTest {
    @Test
    public void should_park_to_parking_lot_with_more_available_positions_when_park_car_given_smart_parking_boy_manage_two_parking_lots_with_different_available_positions_and_car() {
        ParkingLot parkingLotA = new ParkingLot(2);
        ParkingLot parkingLotB = new ParkingLot(3);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLotA,parkingLotB);
        Car car = new Car("AAA1234");
        Ticket ticket = smartParkingBoy.park(car);
        assertNotNull(ticket);
        assertEquals(2, parkingLotA.getAvailablePositionCount());
        assertEquals(2, parkingLotB.getAvailablePositionCount());
    }

    @Test
    public void should_park_to_first_parking_lot_when_available_positions_are_equal() {
        ParkingLot parkingLotA = new ParkingLot(2);
        ParkingLot parkingLotB = new ParkingLot(2);
        SmartParkingBoy parkingBoy = new SmartParkingBoy(parkingLotA, parkingLotB);
        Car car = new Car("AAA1234");
        Ticket ticket = parkingBoy.park(car);
        assertNotNull(ticket);
        assertEquals(1, parkingLotA.getAvailablePositionCount());
        assertEquals(2, parkingLotB.getAvailablePositionCount());
    }
}
