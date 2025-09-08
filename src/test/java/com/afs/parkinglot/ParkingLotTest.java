package com.afs.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotTest {
    @Test
    public void Should_return_ticket_when_park_given_a_parkingLot_and_a_car(){
        String carPlate="AAA1234";
        ParkingLot parkingLot=new ParkingLot();
        Car car=new Car(carPlate);
        assertNotNull(parkingLot.park(car));
    }
}
