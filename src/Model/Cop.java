package Model;

public class Cop extends Worker{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  boolean availabe= true;
	
	public Cop(long id){
		super(id);
		
	}
	
	public Cop(String name, String password){
		super(name, password, serialVersionUID, "COP");
		this.availabe = true;
	}

	public Cop(String name, String password, long id) {
		super(name, password, serialVersionUID, "COP");
		this.availabe = true;
	}

	public boolean isAvailabe() {
		return availabe;
	}

	public void setAvailabe(boolean availabe) {
		this.availabe = availabe;
	}
	
	@Override
	public String toString(){
		return "Name: " + this.getName() +  " |id: " + this.getId() + " |Job: " + this.getJob() + " |available: "+ this.isAvailabe();
		
	}
	
}
