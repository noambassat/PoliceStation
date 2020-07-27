package Model;
import java.io.Serializable;
import Controler.InformationSystem;



public class Dispatcher extends Worker implements Serializable {

	private static final long serialVersionUID = 1L;
	public InformationSystem IS = new InformationSystem();


	public Dispatcher( String name, String password, long id) {
		super(name, password, id, "Dispatcher");
		
	}
}