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

    @Test
    public void Should_return_parked_car_when_fetch_given_a_parkingLot_with_a_parked_car_and_a_parking_ticket(){
        String carPlate="AAA1234";
        ParkingLot parkingLot=new ParkingLot();
        Car car=new Car(carPlate);
        Ticket ticket=parkingLot.park(car);
        Car parkedCar=parkingLot.fetch(ticket);
        assertEquals(car,parkedCar);
    }

    @Test
    public void Should_return_parked_cars_when_fetch_given_a_parkingLot_with_a_parked_car_and_parking_tickets(){
        String carPlateA="AAA1234";
        String carPlateB="BBB1234";
        ParkingLot parkingLot=new ParkingLot();
        Car carA=new Car(carPlateA);
        Car carB=new Car(carPlateB);
        Ticket ticketA=parkingLot.park(carA);
        Ticket ticketB=parkingLot.park(carB);
        Car parkedCarA=parkingLot.fetch(ticketA);
        Car parkedCarB=parkingLot.fetch(ticketB);
        assertEquals(carA,parkedCarA);
        assertEquals(carB,parkedCarB);
    }
}
