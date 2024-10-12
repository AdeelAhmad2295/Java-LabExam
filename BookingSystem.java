package AirlineBookingSystem;

import java.util.ArrayList;


public class BookingSystem {
    private Flight flight;
    private ArrayList<Customer> Customers;

    public BookingSystem(Flight flight) {
        this.flight = flight;
        this.Customers = new ArrayList<>();
    }

    // Booking a ticket and informing user
    public void bookTicket(String name, int seatNumber) {
        try {
            if (flight.isSeatAvailable(seatNumber)) {
                Customer Customer = new Customer(name, seatNumber);
                flight.bookSeat(seatNumber);
                Customers.add(Customer);
                System.out.println("Seat " + seatNumber + " booked successfully for " + name + ".");
            } else {
                throw new Exception("Seat " + seatNumber + " is not available.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Canceling a ticket
    public void cancelTicket(String name) {
        try {
            Customer CustomerToCancel = null;
            for (Customer Customer : Customers) {
                if (Customer.getName().equals(name)) {
                    CustomerToCancel = Customer;
                    break;
                }
            }

            if (CustomerToCancel != null) {
                flight.cancelSeat(CustomerToCancel.getSeatNumber());
                Customers.remove(CustomerToCancel);
                System.out.println("Booking canceled for " + name + ".");
            } else {
                throw new Exception("No booking found for " + name + ".");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Display available seats
    public void displayAvailableSeats() {
        System.out.println("Available seats for flight " + flight.getFlightNumber() + ":");
        boolean hasAvailableSeats = false;
        for (int i = 1; i <= flight.getTotalSeats(); i++) {
            if (flight.isSeatAvailable(i)) {
                System.out.print(i + " ");
                hasAvailableSeats = true;
            }
        }
        if (!hasAvailableSeats) {
            System.out.println("No available seats.");
        } else {
            System.out.println();
        }
    }

    // Display booking history
    public void displayBookingHistory() {
        if (Customers.isEmpty()) {
            System.out.println("No bookings made yet.");
        } else {
            System.out.println("Booking History:");
            for (Customer Customer : Customers) {
                System.out.println("Customer Name: " + Customer.getName() + ", Seat Number: " + Customer.getSeatNumber());
            }
        }
    }

    // Method to generate receipt for a specific Customer
    public void generateReceipt(String name) {
        Customer CustomerForReceipt = null;
        for (Customer Customer : Customers) {
            if (Customer.getName().equals(name)) {
                CustomerForReceipt = Customer;
                break;
            }
        }

        if (CustomerForReceipt != null) {
            System.out.println("\n--- Booking Receipt ---");
            System.out.println("Flight Number: " + flight.getFlightNumber());
            System.out.println("Customer Name: " + CustomerForReceipt.getName());
            System.out.println("Seat Number: " + CustomerForReceipt.getSeatNumber());
            System.out.println("Ticket Price: $" + flight.getTicketPrice());
            System.out.println("Booking Status: Confirmed");
            System.out.println("------------------------\n");
        } else {
            System.out.println("No booking found for " + name + ".");
        }
    }
}
