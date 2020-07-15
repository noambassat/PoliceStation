package Controler;
import java.io.Serializable;

import Model.*;


public class SignNewWorker implements Serializable {
	private static final SignNewWorker SW = new SignNewWorker();

	public static SignNewWorker getSignNewWorker() {
		return SW;
	}

	
	public boolean addNewWorker(String name, String password,String job, long id){
		Worker W = new Worker(name, password, id, job);
		
		return true;
	}
}
