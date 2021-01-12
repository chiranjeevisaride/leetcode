package parking;

import vehicle.Vehicle;

import java.util.Random;

public class ParkingSpot {
    private String number;
    private static ParkingSpotType parkingSpotType;
    private Vehicle vehicle;
    private boolean free = true;

    public ParkingSpot(ParkingSpotType parkingSpotType) {
        Random rand = new Random();
        this.number = String.valueOf(rand.nextInt());
        this.parkingSpotType = parkingSpotType;
    }

    public ParkingSpotType getParkingSpotType() {
        return parkingSpotType;
    }

    public boolean isFree() { return free; }

    public String getNumber() {
        return number;
    }

    public void setFree(boolean free) { this.free = free; };

    public void assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.free = false;
    }

    public void removeVehicle() {
        this.vehicle = null;
        this.free = true;
    }

}