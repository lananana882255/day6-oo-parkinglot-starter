package com.afs.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StandardParkingBoyTest {
    @Test
    public void should_return_ticket_when_park_car_given_parking_lot_standard_parking_boy_and_car(){
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        String carPlate ="AAA1234";
        Car car = new Car(carPlate);
        Ticket ticket = parkingBoy.park(car);
        assertNotNull(ticket);
    }
}
