package in.rudresh.RailwayReservation;

import java.sql.*;
import java.util.*;

public class BookingDAO {

	public void bookTicket(int trainId, String passenger) {
		String sql = "INSERT INTO bookings(train_id, passenger) VALUES (?, ?)";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, trainId);
			ps.setString(2, passenger);
			ps.executeUpdate();
			System.out.println("Ticket booked successfully!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void cancelBooking(int bookingId) {
		String sql = "DELETE FROM bookings WHERE id = ?";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, bookingId);
			ps.executeUpdate();
			System.out.println("Booking cancelled!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
