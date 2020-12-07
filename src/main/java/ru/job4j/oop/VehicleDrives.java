package ru.job4j.oop;

public class VehicleDrives {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0] = new Bus();
        vehicles[1] = new Plane();
        vehicles[2] = new Train();
        for(Vehicle vehicle : vehicles){
            vehicle.move();
        }
    }
}
