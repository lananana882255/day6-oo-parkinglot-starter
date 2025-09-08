package com.afs.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @Test
    public void Should_return_parked_car_when_fetch_car_given_a_parkingLot_with_a_parked_car_parking_boy_and_a_parking_ticket(){
        ParkingLot parkingLot=new ParkingLot();
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        String carPlate="AAA1234";
        Car car=new Car(carPlate);
        Ticket ticket=parkingBoy.park(car);
        Car parkedCar=parkingBoy.fetch(ticket);
        assertEquals(car,parkedCar);
    }

    @Test
    public void Should_return_parked_cars_when_fetch_car_given_a_parkingLot_with_a_parked_car_parking_boy_and_parking_tickets(){
        String carPlateA="AAA1234";
        String carPlateB="BBB1234";
        ParkingLot parkingLot=new ParkingLot();
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        Car carA=new Car(carPlateA);
        Car carB=new Car(carPlateB);
        Ticket ticketA=parkingBoy.park(carA);
        Ticket ticketB=parkingBoy.park(carB);
        Car parkedCarA=parkingBoy.fetch(ticketA);
        Car parkedCarB=parkingBoy.fetch(ticketB);
        assertEquals(carA,parkedCarA);
        assertEquals(carB,parkedCarB);
    }
}
