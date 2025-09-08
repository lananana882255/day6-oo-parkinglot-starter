package com.afs.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    @Test
    public void Should_return_ticket_when_park_given_a_parkingLot_and_a_car(){
        String carPlate="AAA1234";
        ParkingLot parkingLot=new ParkingLot();
        Car car=new Car(carPlate);
        assertNotNull(parkingLot.park(car));
    }

    @Test
    public void Should_return_parked_car_when_fetch_car_given_a_parkingLot_with_a_parked_car_and_a_parking_ticket(){
        String carPlate="AAA1234";
        ParkingLot parkingLot=new ParkingLot();
        Car car=new Car(carPlate);
        Ticket ticket=parkingLot.park(car);
        Car parkedCar=parkingLot.fetch(ticket);
        assertEquals(car,parkedCar);
    }

    @Test
    public void Should_return_parked_cars_when_fetch_car_given_a_parkingLot_with_a_parked_car_and_parking_tickets(){
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

    @Test
    public void should_return_null_when_fetch_car_given_parking_lot_with_parked_car_and_no_ticket() {
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car("AAA1234");
        parkingLot.park(car);
        Car parkedCar = parkingLot.fetch(null);
        assertNull(parkedCar);
    }

    @Test
    public void should_return_null_when_fetch_car_given_parking_lot_with_parked_car_and_wrong_ticket() {
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car("AAA1234");
        parkingLot.park(car);
        Ticket wrongTicket=new Ticket();
        Car parkedCar = parkingLot.fetch(wrongTicket);
        assertNull(parkedCar);
    }

    @Test
    public void should_return_null_when_fetch_car_given_parking_lot_and_used_ticket() {
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car("AAA1234");
        Ticket ticket = parkingLot.park(car);
        parkingLot.fetch(ticket);
        Car fetchedCar = parkingLot.fetch(ticket);
        assertNull(fetchedCar);
    }

    @Test
    public void should_return_null_when_park_car_given_parking_lot_without_any_position_and_car(){
        ParkingLot parkingLot= new ParkingLot(1);
        String carPlateA="AAA1234";
        String carPlateB="BBB1234";
        Car carA=new Car(carPlateA);
        Car carB=new Car(carPlateB);
        parkingLot.park(carA);
        assertNull(parkingLot.park(carB));
    }

    @Test
    public void should_return_error_message_when_fetch_car_given_parking_lot_and_unrecognized_ticket(){
        ParkingLot parkingLot = new ParkingLot();
        Ticket unrecognizedTicket= new Ticket();
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> parkingLot.fetch(unrecognizedTicket));
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }
}
