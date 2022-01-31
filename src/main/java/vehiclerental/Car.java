package vehiclerental;

import java.time.LocalDate;
import java.time.LocalTime;

public class Car implements Rentable {

    String ID;
    LocalTime rentingTime;
    int price;

    public String getID() {
        return ID;
    }

    public int getPrice() {
        return price;
    }

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
        return rentingTime;
    }

    @Override
    public void rent(LocalTime time) {
        this.rentingTime = time;
    }

    @Override
    public void closeRent() {
        this.rentingTime = null;
    }

    @Override
    public String toString() {
        return "Car{" +
                "ID='" + ID + '\'' +
                ", rentingTime=" + rentingTime +
                ", price=" + price +
                '}';
    }
}
