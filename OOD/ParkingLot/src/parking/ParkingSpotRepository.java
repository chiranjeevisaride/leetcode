public class ParkingSpotRepository {

    private Map<ParkingSpotType, List<ParkingSpot>> parkingSpotsMap = new HashMap<>();

    public List<ParkingSpot> getParkingSlotsByType(ParkingSpotType parkingSpotType) {
        return parkingSpotsMap.getOrDefault(parkingSpotType, new ArrayList<ParkingSpot>());
    }

    public boolean updateParkingSpots(ParkingSpotType parkingSpotType, List<ParkingSpot> parkingSpotList) {
            if(parkingSpotsMap.isEmpty()) return false;
            parkingSpotsMap.put(parkingSpotType, parkingSpotList);
            return true;
    }

}