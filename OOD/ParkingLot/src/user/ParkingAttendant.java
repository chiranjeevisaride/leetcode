package user;

import parking.ParkingSpot;
import parking.ParkingSpotRepository;


public class ParkingAttendant extends User {

    public ParkingAttendant(String name) {
        this.name = name;
    }
    ParkingSpotRepository parkingSpotRepository = ParkingSpotRepository.getInstance();

    public boolean addParkingSpot(ParkingSpot parkingSpot) {
        return parkingSpotRepository.addNewParkingSpot(parkingSpot);
    }

    public boolean removeParkingSpot(ParkingSpot parkingSpot) {
        return parkingSpotRepository.removeParkingSpot(parkingSpot);
    }
}