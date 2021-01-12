package parking;

import vehicle.Vehicle;
import vehicle.VehicleType;


public class ParkingLot {

    private ParkingSpotRepository parkingSpotRepository = ParkingSpotRepository.getInstance();


    public boolean assignParkingSpot(Vehicle vehicle, ParkingSpot parkingSpot) {
        parkingSpot.assignVehicle(vehicle);
        parkingSpot.setFree(false);
        return parkingSpotRepository.updateParkingSpots(parkingSpot);
    }

    public boolean freeSpot(ParkingSpot parkingSpot) {
        parkingSpot.removeVehicle();
        parkingSpot.setFree(true);
        return parkingSpotRepository.updateParkingSpots(parkingSpot);
    }

    public ParkingSpotType getParkingSpotType(Vehicle vehicle) {
        ParkingSpotType parkingSpotType;
        if(vehicle.getVehicleType().equals(VehicleType.CAR))
            parkingSpotType = ParkingSpotType.COMPACT;
        else if(vehicle.getVehicleType().equals(VehicleType.BICYCLE))
            parkingSpotType = ParkingSpotType.SMALL;
        else if(vehicle.getVehicleType().equals(VehicleType.VAN) || vehicle.getVehicleType().equals(VehicleType.TRUCK))
            parkingSpotType = ParkingSpotType.LARGE;
        else
            parkingSpotType = ParkingSpotType.HANDICAPPED;
        return parkingSpotType;
    }

}