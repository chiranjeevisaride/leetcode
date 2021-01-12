package parking;

import java.util.Random;

public class ParkingTicket {
    private int tokenNumber;
    private double amount;

    public ParkingTicket(double amount) {
        this.amount = amount;
        Random rand = new Random();
        this.tokenNumber = rand.nextInt();
    }

}
