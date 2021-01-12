package vehicle;

import parking.ParkingTicket;

public class Vehicle {
    private String licenseNumber;
    private final VehicleType vehicleType;
    private ParkingTicket parkingTicket;

    public Vehicle(String licenseNumber, VehicleType vehicleType) {
        this.licenseNumber = licenseNumber;
        this.vehicleType = vehicleType;
    }

    public void assignTicket(ParkingTicket parkingTicket) {
        this.parkingTicket = parkingTicket;
    }

    public void removeTicket() {
        this.parkingTicket = null;
    }
    public VehicleType getVehicleType() {
        return vehicleType;
    }
}