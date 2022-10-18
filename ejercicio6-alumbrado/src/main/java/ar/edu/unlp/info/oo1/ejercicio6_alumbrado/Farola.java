package ar.edu.unlp.info.oo1.ejercicio6_alumbrado;

import java.util.ArrayList;
import java.util.List;

public class Farola {

	boolean on;
	List<Farola> neighbors;
	
	public Farola () {
		this.on = false;
		this.neighbors = new ArrayList<Farola> ();
	}
	
	public boolean isOn() {
		return on;
	}

	public void setOn(boolean on) {
		this.on = on;
	}

	public List<Farola> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(List<Farola> neighbors) {
		this.neighbors = neighbors;
	}

	public void pairWithNeighbor (Farola unaFarola) {
		this.neighbors.add(unaFarola);
		unaFarola.getNeighbors().add(this);
	}
	
	public void turnOn() {
		if (!this.isOn()) {
			this.setOn(true);
			this.getNeighbors().forEach(farola -> {
				farola.turnOn();
			});
		}
	}
	
	public void turnOff() {
		if (this.isOn()) {
			this.setOn(false);
			this.getNeighbors().forEach(farola -> {
				farola.turnOff();
			});
		}
	}
	
	
}
