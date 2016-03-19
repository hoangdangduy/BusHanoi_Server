package entities;

public class BusChedule_StopPlace {
	private BusStopPlace busStopPlace;
	private BusSchedule busSchedule;
	private int indexBusStop;
	private int directionBus; // chieu di hoac chieu ve

	public BusStopPlace getBusStopPlace() {
		return busStopPlace;
	}

	public void setBusStopPlace(BusStopPlace busStopPlace) {
		this.busStopPlace = busStopPlace;
	}

	public BusSchedule getBusSchedule() {
		return busSchedule;
	}

	public void setBusSchedule(BusSchedule busSchedule) {
		this.busSchedule = busSchedule;
	}

	public int getIndexBusStop() {
		return indexBusStop;
	}

	public void setIndexBusStop(int indexBusStop) {
		this.indexBusStop = indexBusStop;
	}

	public int getDirectionBus() {
		return directionBus;
	}

	public void setDirectionBus(int directionBus) {
		this.directionBus = directionBus;
	}

	public BusChedule_StopPlace(BusStopPlace busStopPlace, BusSchedule busSchedule, int indexBusStop,
			int directionBus) {
		super();
		this.busStopPlace = busStopPlace;
		this.busSchedule = busSchedule;
		this.indexBusStop = indexBusStop;
		this.directionBus = directionBus;
	}

	public BusChedule_StopPlace() {
		super();
	}

}
