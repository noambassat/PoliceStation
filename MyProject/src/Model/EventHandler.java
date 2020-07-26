package Model;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;



import java.util.Set;

import Controler.InformationSystem;

public class EventHandler extends Worker implements Serializable, Observer {
	private static final long serialVersionUID = 1L;
	private InformationSystem IS = new InformationSystem();

	public EventHandler(String name, String password, long id) {
		super(name, password, id, "EventHandler");


	}

	@Override
	public void update(Observable o, Object arg) {

		System.out.println("eventHandler with id=" + this.id + " got the ce update, the detials are: " + o.toString());

	}
	
	@SuppressWarnings("unchecked")
	public Set<CrimeEvent> getAvail(String witch){
		IS = IS.getInformationSystem();
		Set<Cop> Avail = (Set)IS.getSet(witch);
		return (Set)Avail;
	}

}
