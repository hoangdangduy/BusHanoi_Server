package entities;

public class PlaceSellTicket {
	private int id;
	private String name;
	private float longitude; // kinh do
	private float latitude; // vi do
	private String hourOpen;
	private String hourClose;

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

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public String getHourOpen() {
		return hourOpen;
	}

	public void setHourOpen(String hourOpen) {
		this.hourOpen = hourOpen;
	}

	public String getHourClose() {
		return hourClose;
	}

	public void setHourClose(String hourClose) {
		this.hourClose = hourClose;
	}

	public PlaceSellTicket(int id, String name, float longitude, float latitude, String hourOpen, String hourClose) {
		super();
		this.id = id;
		this.name = name;
		this.longitude = longitude;
		this.latitude = latitude;
		this.hourOpen = hourOpen;
		this.hourClose = hourClose;
	}

	public PlaceSellTicket() {
		super();
	}

}
