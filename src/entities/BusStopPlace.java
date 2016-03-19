package entities;

public class BusStopPlace {
	private int id;
	private String name;
	private String description;
	private double longitude; // kinh do
	private double latitude; // vi do

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public BusStopPlace(int id, String name, String description, double longitude, double latitude) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public BusStopPlace() {
		super();
	}

}
