package Model;

import java.io.Serializable;
import java.util.Observable;

import Controler.InformationSystem;


public abstract class Event extends Observable implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int counter = 0;
	protected int Size;
	protected String Address;
	protected int Area;
	protected int Arrival;
	protected double Time;
	protected boolean Active;
	protected InformationSystem IS;

	protected Event(){}
	public Event(int Size, String address, int area) {
		this.Size = Size;
		this.Address = address;
		this.Area = area;
		InformationSystem IS = InformationSystem.getInformationSystem();
		this.IS = IS;
		IS.addOToFile(this);
		this.Active = true;
		
	}
	
	
	protected int getSize() {
		return Size;
	}

	protected void setSize(int Size) {
		this.Size = Size;
	}

	protected String getAddress() {
		return Address;
	}

	protected void setAddress(String address) {
		Address = address;
	}

	protected int getArea() {
		return Area;
	}

	protected void setArea(int area) {
		Area = area;
	}

	protected int getArrival() {
		return Arrival;
	}

	protected void setArrival(int arrival) {
		Arrival = arrival;
	}

	protected double getTime() {
		return Time;
	}

	protected void setTime(double time) {
		Time = time;
	}


	public boolean isActive() {
		return Active;
	}
	public void setActive(boolean active) {
		Active = active;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Address == null) ? 0 : Address.hashCode());
		result = prime * result + Area;
		result = prime * result + Arrival;
		result = prime * result + ((IS == null) ? 0 : IS.hashCode());
		result = prime * result + Size;
		long temp;
		temp = Double.doubleToLongBits(Time);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Event other = (Event) obj;
		if (Address == null) {
			if (other.Address != null)
				return false;
		} else if (!Address.equals(other.Address))
			return false;
		if (Area != other.Area)
			return false;
		if (Arrival != other.Arrival)
			return false;
		if (IS == null) {
			if (other.IS != null)
				return false;
		} else if (!IS.equals(other.IS))
			return false;
		if (Size != other.Size)
			return false;
		if (Double.doubleToLongBits(Time) != Double.doubleToLongBits(other.Time))
			return false;
		return true;
	}
	
	@Override
	public String toString(){
		return "address: " + Address+  " |arrival: " +Arrival+ " |time: " + Time;
	}
}