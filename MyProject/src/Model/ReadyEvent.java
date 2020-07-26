package Model;

import java.io.Serializable;
import java.util.Vector;

public class ReadyEvent extends CrimeEvent implements Serializable {
	public static int REcounter = 0;

	private int distance;
	private int SerialNumber;
	private Vector<Cop> Cops = new Vector<Cop>();
	private Vector<Vehicle> Vehicles = new Vector<Vehicle>();
	private int numberOfCops;
	private int numberOfVehicles;
	private String status;
	
	

	private static final long serialVersionUID = 1L;
	
	protected ReadyEvent(){}
	public ReadyEvent(int urgencyLevel, String address, int area){
		super(urgencyLevel, address, area);
		this.status = "arrived";
		this.SerialNumber = ++REcounter;
		eventUploaded(this);
	}
	public void eventUploaded(ReadyEvent event){//notify observers
		this.setChanged();
		this.notifyObservers(event);
		System.out.println("ReadyEvent notify was sent to EventCommanders");
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
		if(status.equals("Handeled"))
			IS.CheckHandeled();
	}
	public int getNumberOfCops() {
		return numberOfCops;
	}
	public void setNumberOfCops(int numberOfCops) {
		this.numberOfCops = numberOfCops;
	}
	public int getNumberOfVehicles() {
		return numberOfVehicles;
	}
	public void setNumberOfVehicles(int numberOfVehicles) {
		this.numberOfVehicles = numberOfVehicles;
	}
	public Vector<Cop> getCops() {
		return Cops;
	}
	public void setCops(Vector<Cop> cops) {
		Cops = cops;
	}
	public Vector<Vehicle> getVehicles() {
		return Vehicles;
	}
	public void setVehicles(Vector<Vehicle> vehicles) {
		Vehicles = vehicles;
	}


	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public int getSerialNumber() {
		return SerialNumber;
	}
	public void setSerialNumber(int serialNumber) {
		SerialNumber = serialNumber;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + SerialNumber;
		result = prime * result + distance;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReadyEvent other = (ReadyEvent) obj;
		if (SerialNumber != other.SerialNumber)
			return false;
		if (distance != other.distance)
			return false;
		return true;
	}

	@Override
	public String toString(){
		return "address: " + this.getAddress()+  " |Area: " +this.getArea()+" |serNum: "+ this.getSerialNumber() +
				" |Status:  "+ this.getStatus() + " |NumberOfCops: "+ this.getNumberOfCops()+ " |NumberOfVehicles: "+
				this.getNumberOfVehicles();
	}

}
