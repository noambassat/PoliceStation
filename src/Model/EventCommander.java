package Model;
import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

public class EventCommander extends Cop implements Serializable, Observer {
	private static final long serialVersionUID = 1L;
	private String job;
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public EventCommander(String name, String password, long id) {
		super(name, password, id);
		this.job = "EventCommander";
		// TODO Auto-generated constructor stub
	}
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("EventCommander with id=" + this.id + " got the re update, the detials are: " + o.toString());
		
	}
	

}