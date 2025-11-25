package in.rudresh.RailwayReservation;

/**
 *
 * @author Your name
 */

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TrainDAO trainDAO = new TrainDAO();
		BookingDAO bookingDAO = new BookingDAO();

		while (true) {
			System.out.println("\n====== RAILWAY RESERVATION ======");
			System.out.println("1. Add Train");
			System.out.println("2. View Trains");
			System.out.println("3. Book Ticket");
			System.out.println("4. Cancel Booking");
			System.out.println("5. Exit");
			System.out.print("Enter choice: ");

			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				System.out.print("Enter Train Name: ");
				String name = sc.next();
				System.out.print("Enter Seats: ");
				int seats = sc.nextInt();
				trainDAO.addTrain(name, seats);
				break;

			case 2:
				for (Train t : trainDAO.getAllTrains()) {
					System.out.println(t.getId() + "  " + t.getName() + "  Seats: " + t.getSeats());
				}
				break;

			case 3:
				System.out.print("Enter Train ID: ");
				int trainId = sc.nextInt();
				System.out.print("Enter Passenger Name: ");
				String passenger = sc.next();

				if (trainDAO.reduceSeat(trainId)) {
					bookingDAO.bookTicket(trainId, passenger);
				} else {
					System.out.println("No seats available!");
				}
				break;

			case 4:
				System.out.print("Enter Booking ID to cancel: ");
				int bid = sc.nextInt();
				bookingDAO.cancelBooking(bid);
				break;

			case 5:
				System.out.println("Thank you! Goodbye.");
				return;

			default:
				System.out.println("Invalid Choice!");
			}
		}
	}
}
