package AirlineBookingSystem;
import java.util.ArrayList;

public class Flight {
    private String flightNumber;
    private int totalSeats;
    private double ticketPrice;  // Added ticket price
    private ArrayList<Integer> bookedSeats;

    public Flight(String flightNumber, int totalSeats, double ticketPrice) {
        this.flightNumber = flightNumber;
        this.totalSeats = totalSeats;
        this.ticketPrice = ticketPrice;
        this.bookedSeats = new ArrayList<>();
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public boolean isSeatAvailable(int seatNumber) {
        return !bookedSeats.contains(seatNumber) && seatNumber <= totalSeats && seatNumber > 0;
    }

    public void bookSeat(int seatNumber) {
        bookedSeats.add(seatNumber);
    }

    public void cancelSeat(int seatNumber) {
        bookedSeats.remove((Integer) seatNumber);
    }
}
