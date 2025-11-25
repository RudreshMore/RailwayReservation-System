package in.rudresh.RailwayReservation;

public class Booking {
	private int id;
	private int trainId;
	private String passenger;

	public Booking(int id, int trainId, String passenger) {
		this.id = id;
		this.trainId = trainId;
		this.passenger = passenger;
	}

	public int getId() {
		return id;
	}

	public int getTrainId() {
		return trainId;
	}

	public String getPassenger() {
		return passenger;
	}
}
