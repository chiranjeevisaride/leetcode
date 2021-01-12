package parking;

import java.util.*;

public class ParkingSpotRepository {

    private static ParkingSpotRepository parkingSpotRepository;
    private Map<ParkingSpotType, List<ParkingSpot>> parkingSpotsMap;

    private  ParkingSpotRepository() {
        parkingSpotsMap = new HashMap<>();
    }

    public static synchronized ParkingSpotRepository getInstance() {
        if(parkingSpotRepository == null) {
            parkingSpotRepository = new ParkingSpotRepository();
        }
        return parkingSpotRepository;
    }

    public List<ParkingSpot> getParkingSlotsByType(ParkingSpotType parkingSpotType) {
        return parkingSpotsMap.getOrDefault(parkingSpotType, new ArrayList<ParkingSpot>());
    }

    public boolean updateParkingSpots(ParkingSpot parkingSpot) {
        if (parkingSpotsMap.isEmpty()) return false;
        List<ParkingSpot> parkingSpotList = getParkingSlotsByType(parkingSpot.getParkingSpotType());
        if(parkingSpotList == null || parkingSpotList.size() == 0) {
            System.out.println("Failed to update Parking Spot " + parkingSpot.getNumber() + " not found");
            return false;
        }
        parkingSpotList.set(parkingSpotList.indexOf(parkingSpot.getNumber()), parkingSpot);
        parkingSpotsMap.put(parkingSpot.getParkingSpotType(), parkingSpotList);
        System.out.println("Parking Spot " + parkingSpot.getNumber() + " updated");
        return true;
     }

     public boolean addNewParkingSpot(ParkingSpot parkingSpot) {
         List<ParkingSpot> parkingSpotList  = parkingSpotsMap.getOrDefault(parkingSpot.getParkingSpotType(), new ArrayList<>());
         for(ParkingSpot spot : parkingSpotList) {
             if(spot.getNumber().equalsIgnoreCase(parkingSpot.getNumber())) {
                 System.out.println("Parking Spot " + parkingSpot.getNumber() + " already exits");
                 return false;
             }
         }
         parkingSpotList.add(parkingSpot);
         parkingSpotsMap.put(parkingSpot.getParkingSpotType(), parkingSpotList);
         System.out.println("Parking Spot " + parkingSpot.getNumber() + " added");
         return true;
     }

    public boolean removeParkingSpot(ParkingSpot parkingSpot) {
        List<ParkingSpot> parkingSpotList  = parkingSpotsMap.get(parkingSpot.getParkingSpotType());
        if(parkingSpotList == null || parkingSpotList.size() == 0) {
            System.out.println("Failed to remove Parking Spot " + parkingSpot.getNumber() + " not found");
            return false;
        }
        parkingSpotList.remove(parkingSpotList.indexOf(parkingSpot.getNumber()));
        System.out.println("Parking Spot " + parkingSpot.getNumber() + " removed");
        return true;
    }

    public ParkingSpot getFreeParkingSpot(ParkingSpotType parkingSpotType) {
        List<ParkingSpot> parkingSpotList  = parkingSpotsMap.get(parkingSpotType);
        for(ParkingSpot spot : parkingSpotList)
            if(spot.isFree()) return spot;
        return null;
    }

}