package Model;

import java.io.Serializable;
import java.util.Date;

public class CrimeEvent extends Event implements Serializable {

	private static final long serialVersionUID = 1L;
	private int urgencyLevel;
	public CrimeEvent(int urgencyLevel, String address, int area) {
		super(urgencyLevel, address, area);
		this.SerialNumber = ++counter;
		this.urgencyLevel = urgencyLevel;
		this.setArrivalCallingTime(new Date(System.currentTimeMillis() - 3600 * 1000));//checkDate
		eventUploaded(this);
		IS.addOToFile(this);
	}


	protected CrimeEvent() {}


	public int SerialNumber;
	private Date ArrivalCallingTime;//checkDate
	
	public void eventUploaded(CrimeEvent event){//notify observers
		this.setChanged();
		this.notifyObservers(event);
		System.out.println("Event notify was sent to eventHandlers");
	}

	public Date getArrivalCallingTime() {
		return ArrivalCallingTime;
	}

	public void setArrivalCallingTime(Date arrivalCallingTime) {
		ArrivalCallingTime = arrivalCallingTime;
	}

	public int getUrgencyLevel() {
		return urgencyLevel;
	}

	public void setUrgencyLevel(int urgencyLevel) {
		this.urgencyLevel = urgencyLevel;
	}
	@Override
	public String toString(){
		return "address: " + this.getAddress()+  " |Area: " + this.getArea() +" |Size: "+ this.getSize() +
				" |Urgency: "+	this.getUrgencyLevel() ;
	}

}
