package AirlineBookingSystem;

import java.util.Scanner;


public class AirlineBookingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Flight flight = new Flight("AI101", 10, 5000.0); // Ticket amount is now included
        BookingSystem bookingSystem = new BookingSystem(flight);

        while (true) {
            System.out.println("\nAirline Booking System");
            System.out.println("1. Book a Ticket");
            System.out.println("2. Cancel a Ticket");
            System.out.println("3. Display Available Seats");
            System.out.println("4. View Booking History");
            System.out.println("5. Generate Receipt");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();

                switch (choice) {
                case 1:
                    System.out.print("Enter passenger name: ");
                    String name = scanner.next();
                    System.out.print("Enter seat number to book (1-10): ");
                    int seatNumber = scanner.nextInt();
                    bookingSystem.bookTicket(name, seatNumber);
                    break;

                case 2:
                    System.out.print("Enter passenger name to cancel: ");
                    String cancelName = scanner.next();
                    bookingSystem.cancelTicket(cancelName);
                    break;

                case 3:
                    bookingSystem.displayAvailableSeats();
                    break;

                case 4:
                    bookingSystem.displayBookingHistory();
                    break;

                case 5:
                    System.out.print("Enter passenger name for receipt: ");
                    String receiptName = scanner.next();
                    bookingSystem.generateReceipt(receiptName);
                    break;

                case 6:
                    System.out.println("Exiting the system...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice, please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.next(); // Clear invalid input
            }
        }
    }
}
