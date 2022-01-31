package vehiclerental;

import java.time.LocalDate;
import java.time.LocalTime;

public class Car implements Rentable {

    String ID;
    LocalTime rentingTime;
    int price;

    public Car(String ID, int price) {
        this.ID = ID;
        this.price = price;
    }

    @Override
    public int calculateSumPrice(long minutes) {
        return (int) (price * minutes);
    }

    @Override
    public LocalTime getRentingTime() {
        return LocalTime.now();
    }

    @Override
    public void rent(LocalTime time) {
        this.rentingTime = time;
    }

    @Override
    public void closeRent() {
        this.rentingTime = null;
    }
}
