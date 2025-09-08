package com.afs.parkinglot;

public class Car {
    private String carPlate;
    public Car(String carPlate){
        this.carPlate=carPlate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return carPlate.equals(car.carPlate);
    }

    @Override
    public int hashCode() {
        return carPlate.hashCode();
    }
}
