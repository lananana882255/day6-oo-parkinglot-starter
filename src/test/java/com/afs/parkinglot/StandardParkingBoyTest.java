package com.afs.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void should_return_null_when_fetch_car_given_parking_lot_with_parked_car_parking_boy_and_wrong_ticket() {
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car("AAA1234");
        parkingBoy.park(car);
        Ticket wrongTicket=new Ticket();
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> parkingLot.fetch(wrongTicket));
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    public void should_return_null_when_fetch_car_given_parking_lot_parking_boy_and_used_ticket() {
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car("AAA1234");
        Ticket ticket = parkingBoy.park(car);
        parkingBoy.fetch(ticket);
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> parkingLot.fetch(ticket));
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    public void should_return_error_message_when_park_car_given_parking_lot_without_any_position_parking_boy_and_car(){
        ParkingLot parkingLot = new ParkingLot(1);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        String carPlateA="AAA1234";
        String carPlateB="BBB1234";
        Car carA=new Car(carPlateA);
        Car carB=new Car(carPlateB);
        parkingBoy.park(carA);
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> parkingLot.park(carB));
        assertEquals("No available position.", exception.getMessage());
    }
}
