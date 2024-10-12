package AirlineBookingSystem;
public class Customer {
    private String name;
    private int seatNumber;

    public Customer(String name, int seatNumber) {
        this.name = name;
        this.seatNumber = seatNumber;
    }

    public String getName() {
        return name;
    }

    public int getSeatNumber() {
        return seatNumber;
    }
}
