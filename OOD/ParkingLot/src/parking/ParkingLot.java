public class ParkingLot {
    private ParkingSpotRepository parkingSpotRepository;

    public boolean assignParkingSpot(Vehicle vehicle, ParkingSpot parkingSpot) {
        parkingSpot.assignVehicle(vehicle);
        parkingSpot.setFree(false);
        List<ParkingSpot>  parkingSpotList = parkingSpotRepository.getParkingSlotsByType(parkingSpot.parkingSpotType);
        parkingSpotList.add(parkingSpot);
        return parkingSpotRepository.updateParkingSpots(parkingSpot.parkingSpotType, parkingSpotList);
    }

    public boolean freeSpot(ParkingSpot parkingSpot) {
        List<ParkingSpot>  parkingSpotList = parkingSpotRepository.getParkingSlotsByType(parkingSpot.parkingSpotType);
        parkingSpotList.remove(parkingSpot);
        parkingSpot.removeVehicle();
        return parkingSpotRepository.updateParkingSpots(parkingSpot.parkingSpotType, parkingSpotList);
    }
}