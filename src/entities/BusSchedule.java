package entities;

public class BusSchedule {
	private int id;
	private String name;
	private String timeStart;
	private String timeFinish;
	private String frequence;
	private String description;

	public String getFrequence() {
		return frequence;
	}

	public void setFrequence(String frequence) {
		this.frequence = frequence;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

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

	public String getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}

	public String getTimeFinish() {
		return timeFinish;
	}

	public void setTimeFinish(String timeFinish) {
		this.timeFinish = timeFinish;
	}

	public BusSchedule(int id, String name, String timeStart, String timeFinish, String frequence, String description) {
		super();
		this.id = id;
		this.name = name;
		this.timeStart = timeStart;
		this.timeFinish = timeFinish;
		this.frequence = frequence;
		this.description = description;
	}

	public BusSchedule() {
		super();
	}

}
