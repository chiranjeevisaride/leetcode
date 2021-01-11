public class ParkingSpot {
    private String number;
    private static ParkingSpotType parkingSpotType;
    private Vehicle vehicle;
    private static ParkingStatus parkingStatus;
    private boolean free = true;

    public ParkingSpot(ParkingSpotType parkingSpotType) {
        this.parkingSpotType = parkingSpotType;
    }

    public boolean isFree() { return free; }

    public void setFree(boolean free) { this.free = free };

    public boolean assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        free = false;
    }

    public boolean removeVehicle() {
        this.vehicle = null;
        free = true;
    }

}