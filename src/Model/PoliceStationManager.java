package Model;
import java.io.Serializable;


public class PoliceStationManager extends EventCommander implements Serializable {

	private static final PoliceStationManager INSANCE = new PoliceStationManager("name","123" ,123);
	private String job;
	private PoliceStationManager(String name, String password, long id) {
		super(name, password, id);
		this.job = "PoliceStationManager";
		this.password = "123";
		this.id = 123;

	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public static PoliceStationManager getInstance(){//Singleton
		return INSANCE;
	}
	

}
