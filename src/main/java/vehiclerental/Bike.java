package vehiclerental;

import java.time.LocalTime;

public class Bike implements Rentable{
    String ID;
    LocalTime rentingTime;

    public Bike(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    @Override
    public int calculateSumPrice(long minutes) {
        return (int)(15*minutes);
    }

    @Override
    public LocalTime getRentingTime() {
        return rentingTime;
    }

    @Override
    public void rent(LocalTime time) {
        this.rentingTime = time;
    }

    @Override
    public void closeRent() {

    }


}
