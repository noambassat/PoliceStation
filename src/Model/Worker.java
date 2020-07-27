package Model;
import java.io.Serializable;


import Controler.InformationSystem;
//dsd

public class Worker implements Serializable{
	protected static final long serialVersionUID = 1L;
	protected String Name;
	protected String password;
	protected long id;
	protected String Job;
	protected InformationSystem IS;
	

	public Worker(String name, String password, long id, String Job) {
		if((!checkS(name))||(!checkId(id))){	
			return;
		}
		this.Name = name;
		this.password = password;
		this.id = id;
		this.Job = Job;
		InformationSystem IS = InformationSystem.getInformationSystem();
		IS.addOToFile(this);

	}
	
	public boolean checkS(String S){
		if (S.isEmpty()) return false;
		return true;
	}
	public boolean checkId(Long id){
		if(id>9999999||id<1) return false;
		return true;
	}

	public Worker(long id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		Name = name;
	}

	public void Workers(String name) {
		this.Name = name;
	
	}

	public String getName() {
		return Name;
	}

	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Worker other = (Worker) obj;
		if (Job == null) {
			if (other.Job != null)
				return false;
		} else if (!Job.equals(other.Job))
			return false;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		if (id != other.id)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	public String toString(){
		return "Name: " + Name +  " |id: " + id + " |Job: " + Job;
	}

	public String getJob() {
		return Job;
	}

	public void setJob(String job) {
		Job = job;
	}

	public void setId(long id) {
		this.id = id;
	}

}
