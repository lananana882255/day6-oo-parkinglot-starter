package com.afs.parkinglot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SuperParkingBoyTest {
    @Test
    public void should_park_to_parking_lot_with_higher_vacancy_rate_when_park_car_given_super_parking_boy_manage_two_parking_lots_with_different_vacancy_rates_and_car() {
        ParkingLot parkingLotA = new ParkingLot(2);
        ParkingLot parkingLotB = new ParkingLot(3);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(parkingLotA, parkingLotB);
        Car carA = new Car("AAA1234");
        Car carB = new Car("BBB1234");
        superParkingBoy.park(carA);
        Ticket ticket = superParkingBoy.park(carB);
        assertNotNull(ticket);
        assertEquals(1, parkingLotA.getAvailablePositionCount());
        assertEquals(2, parkingLotB.getAvailablePositionCount());
    }
}
