import parking.ParkingSpot;
import parking.ParkingSpotType;
import user.Customer;
import user.ParkingAttendant;
import vehicle.Vehicle;
import vehicle.VehicleType;

public class ParkingLotSystem {
    public static void main(String[] args) {
        ParkingSpot spot1 = new ParkingSpot(ParkingSpotType.LARGE);
        ParkingSpot spot2 = new ParkingSpot(ParkingSpotType.SMALL);
        ParkingSpot spot3 = new ParkingSpot(ParkingSpotType.COMPACT);
        ParkingAttendant attendant = new ParkingAttendant("Mark");
        attendant.addParkingSpot(spot1);
        attendant.addParkingSpot(spot2);
        attendant.addParkingSpot(spot3);

        Vehicle hondaAccord = new Vehicle("1234", VehicleType.CAR);
        Customer user1 = new Customer("Chris");

        user1.getNewParkingTicket(hondaAccord);
        user1.payParkingTicket(hondaAccord);
    }
}