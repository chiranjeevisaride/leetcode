package user;

import parking.*;
import vehicle.Vehicle;
import vehicle.VehicleType;

public class Customer extends User {

    ParkingSpotRepository parkingSpotRepository = ParkingSpotRepository.getInstance();
    ParkingTicket parkingTicket;
    ParkingSpotType parkingSpotType;
    ParkingLot parkingLot = new ParkingLot();
    ParkingSpot parkingSpot;

    public Customer(String name) {
        this.name = name;
    }

    public void getNewParkingTicket(Vehicle vehicle) {
        parkingTicket = new ParkingTicket(20.0);
        vehicle.assignTicket(parkingTicket);

        parkingSpotType = parkingLot.getParkingSpotType(vehicle);
        parkingSpot = parkingSpotRepository.getFreeParkingSpot(parkingSpotType);
        parkingLot.assignParkingSpot(vehicle, parkingSpot);
    }

    public void payParkingTicket(Vehicle vehicle) {
        parkingTicket = null;
        vehicle.removeTicket();
        parkingLot.freeSpot(parkingSpot);
    }

}