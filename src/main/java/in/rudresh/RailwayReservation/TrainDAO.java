package in.rudresh.RailwayReservation;

import java.sql.*;
import java.util.*;

public class TrainDAO {

	public void addTrain(String name, int seats) {
		String sql = "INSERT INTO trains(name, seats) VALUES (?, ?)";
		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, name);
			ps.setInt(2, seats);
			ps.executeUpdate();
			System.out.println("Train added successfully!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Train> getAllTrains() {
		List<Train> list = new ArrayList<>();
		String sql = "SELECT * FROM trains";

		try (Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				list.add(new Train(rs.getInt("id"), rs.getString("name"), rs.getInt("seats")));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean reduceSeat(int trainId) {
		String check = "SELECT seats FROM trains WHERE id = ?";
		String update = "UPDATE trains SET seats = seats - 1 WHERE id = ?";

		try (Connection con = DBConnection.getConnection()) {

			PreparedStatement psCheck = con.prepareStatement(check);
			psCheck.setInt(1, trainId);
			ResultSet rs = psCheck.executeQuery();

			if (rs.next() && rs.getInt("seats") > 0) {
				PreparedStatement psUpdate = con.prepareStatement(update);
				psUpdate.setInt(1, trainId);
				psUpdate.executeUpdate();
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
