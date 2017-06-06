package duck;

import behavior.flight.FlightBehavior;
import behavior.sound.SoundBehavior;

public class Duck {

	private String name;
	private String colors;

	private FlightBehavior flight;
	private SoundBehavior sound;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColors() {
		return colors;
	}

	public void setColors(String colors) {
		this.colors = colors;
	}

	public FlightBehavior getFlight() {
		return flight;
	}

	public void setFlight(FlightBehavior flight) {
		this.flight = flight;
	}

	public SoundBehavior getSound() {
		return sound;
	}

	public void setSound(SoundBehavior sound) {
		this.sound = sound;
	}

}
