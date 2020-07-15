package Model;

import java.io.Serializable;

import Controler.InformationSystem;

public class Vehicle implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idV;
	public String type;
	private int year;
	private int Capacity;
	private boolean available;
	protected InformationSystem IS;

	public Vehicle(int idV, String type, int Capacity) {
		this.idV = idV;
		this.type = type;
		this.Capacity = Capacity;
		this.available = true;
		InformationSystem IS = InformationSystem.getInformationSystem();
		this.IS = IS;
		IS.addOToFile(this);
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public int getCapacity() {
		return Capacity;
	}

	public void setCapacity(int capacity) {
		Capacity = capacity;
	}

	public int getidV() {
		return idV;
	}

	public void setidV(int idV) {
		this.idV = idV;
	}

	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idV;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (idV != other.idV)
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	
	public String toString(){
		return "id: " + idV + "|type: " + type;
	}
	
	
}
