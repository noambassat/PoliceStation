package Controler;

import Model.*;
import java.io.Serializable;

public class AddEvent implements Serializable {
	private static final AddEvent AddEvent = new AddEvent();

	public static AddEvent getAddEvent() {
		return AddEvent;
	}

	
	public boolean AddEvent(int urgency, int size, int area, String address){
		CrimeEvent CE = new CrimeEvent(urgency,address, size);
		return true;
	}
	
	public boolean AddRE(int urgency, int area, String address, int Cops, int Vehicles, String status){
		ReadyEvent RE = new ReadyEvent(urgency,address, area, status);
		RE.setNumberOfCops(Cops);
		RE.setNumberOfVehicles(Vehicles);
		RE.setStatus(status, RE);
		return true;
	}
}