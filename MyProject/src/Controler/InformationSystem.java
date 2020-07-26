package Controler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

import java.util.HashSet;
import java.util.Iterator;

import java.util.Observer;
import java.util.Set;
import java.util.Vector;

import Model.*;


public class InformationSystem implements Serializable {
	
	private static final long serialVersionUID = 1L;


	private final String WorkersFile = "Workers";
	private final String CEFile = "CrimeEvents";
	private final String REFile = "ReadyEvents";
	private final String VehiclesFile = "Vehicls";

	private Set<Cop> CopsSet = new HashSet<Cop>();// Available Cops
	private Set<Worker> workerSet = new HashSet<Worker>();
	private Set<CrimeEvent> CrimeEventSet = new HashSet<CrimeEvent>();
	private Set<ReadyEvent> ReadyEventSet = new HashSet<ReadyEvent>();
	private Set<ReadyEvent> HandeledReadyEventSet = new HashSet<ReadyEvent>();
	private Set<Vehicle> VehicleSet = new HashSet<Vehicle>();// Available
																// Vehicles
	private Vector<EventHandler> CEListeners = new Vector<EventHandler>();
	private Vector<EventCommander> REListeners = new Vector<EventCommander>();
	private Vector<Dispatcher> Dis = new Vector<Dispatcher>();

	private static final InformationSystem IS = new InformationSystem();

	public static InformationSystem getInformationSystem() {
		return IS;
	}


	@SuppressWarnings("unused")
	public void start() {
		Cop c = new Cop("Daniel", "1990", 308276592);
		Vehicle V = new Vehicle(123, "mazda", 5);
		EventHandler EH = new EventHandler("kobi", "11", 11);
		CrimeEvent CE = new CrimeEvent(2, "afula", 3);
		ReadyEvent RE = new ReadyEvent(1, "Holon", 1);
		ReadyEvent RE1 = new ReadyEvent(3, "haifa", 2);
		RE1.setStatus("Handeled");
	}

	@SuppressWarnings("unchecked")
	public <T> Set<T> getSet(String str) {
		if (str == "Worker")
			return (Set<T>) workerSet;
		if (str == "Cop")
			return (Set<T>) CopsSet;
		if (str == "CrimeEvent")
			return (Set<T>) CrimeEventSet;
		if (str == "ReadyEvent")
			return (Set<T>) ReadyEventSet;
		if (str == "Vehicle")
			return (Set<T>) VehicleSet;
		if(str == "HandeledReadyEvent")
			return (Set<T>)  HandeledReadyEventSet;
		return null;
	}

	public String whitch(Object O) {

		if (O instanceof Worker)
			return WorkersFile;
		if (O instanceof ReadyEvent)
			return REFile;
		if (O instanceof CrimeEvent)
			return CEFile;
		if (O instanceof Vehicle)
			return VehiclesFile;
		return null;
	}

	private boolean addObjectToFile(Object O) {
		synchronized (O) {
			if (O instanceof Worker) {
				System.out.println("adding worker:" + ((Worker) O).toString());
				return workerSet.add((Worker) O);

			}
			if (O instanceof ReadyEvent)
				if(((ReadyEvent)O).getStatus()!=("Handeled"))
					return ReadyEventSet.add((ReadyEvent) O);
			if (O instanceof CrimeEvent)
				return CrimeEventSet.add((CrimeEvent) O);
			if (O instanceof Vehicle && ((Vehicle) O).isAvailable())
				return VehicleSet.add((Vehicle) O);
			return false;
		}
	}

	public boolean addOToFile(Object O) {
		synchronized (O) {
			boolean addOToFile = addObjectToFile(O);
			String whichObj = whitch(O);
			boolean writeToFile = false;

			try (OutputStream fileOutputStream = new FileOutputStream(whichObj);
					ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
				if (O instanceof Worker) {
					objectOutputStream.writeObject(workerSet);
					workerSet.add((Worker) O);
					if (O instanceof Cop) {
						objectOutputStream.writeObject(CopsSet);
						CopsSet.add((Cop) O);
						((Cop) O).setAvailabe(true);
					}
					if (O instanceof EventCommander)
						REListeners.add((EventCommander) O);

					if (O instanceof EventHandler)
						CEListeners.add((EventHandler) O);

					if (O instanceof Dispatcher)
						Dis.add((Dispatcher) O);
					writeToFile = true;
				}
				if (O instanceof Event) {

					if (O instanceof ReadyEvent) {
						objectOutputStream.writeObject(ReadyEventSet);
						writeToFile = true;
						for (int i = 0; i < REListeners.size(); i++)
							((CrimeEvent) O).addObserver((Observer) REListeners.elementAt(i));
						// notify all RElisteners (eventCommanders)
						//

					}

					else if (O instanceof CrimeEvent) {

						objectOutputStream.writeObject(CrimeEventSet);
						writeToFile = true;
						for (int i = 0; i < CEListeners.size(); i++)
							((CrimeEvent) O).addObserver((Observer) CEListeners.elementAt(i));
						// notify all CElisteners (even handlers)
						//
					}
				}

				if (O instanceof Vehicle) {
					objectOutputStream.writeObject(VehicleSet);
					VehicleSet.add((Vehicle)O);
					writeToFile = true;
				}

			} catch (IOException e) {
				e.printStackTrace();
				writeToFile = false;
			}

			return writeToFile && addOToFile;

		}
	}

	@SuppressWarnings("unchecked")
	public Set<Worker> getWFromFile() {
		File file = new File(WorkersFile);
		if (file.length() == 0) {
			return workerSet;
		}

		try (InputStream fileInputStream = new FileInputStream(WorkersFile);
				ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

			workerSet = (Set<Worker>) objectInputStream.readObject();

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Exception happened while reading from workers file");
		}
		return workerSet;

	}

	@SuppressWarnings("unchecked")
	public Set<CrimeEvent> getEFromFile() {
		File file = new File(CEFile);
		if (file.length() == 0) {
			System.out.println("File is empty");
			return CrimeEventSet;
		}

		try (InputStream fileInputStream = new FileInputStream(CEFile);
				ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

			CrimeEventSet = (Set<CrimeEvent>) objectInputStream.readObject();

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Exception happened while reading crimeEvents from file");
		}
		return CrimeEventSet;

	}

	@SuppressWarnings("unchecked")
	public Set<ReadyEvent> getRFromFile() {
		File file = new File(REFile);
		if (file.length() == 0) {
			System.out.println("File is empty");
			return ReadyEventSet;
		}

		try (InputStream fileInputStream = new FileInputStream(REFile);
				ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

			ReadyEventSet = (Set<ReadyEvent>) objectInputStream.readObject();

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Exception happened while reading crimeEvents from file");
		}
		return ReadyEventSet;

	}

	@SuppressWarnings("unchecked")
	public Set<Vehicle> getVFromFile() {
		File file = new File(VehiclesFile);
		if (file.length() == 0) {
			System.out.println("File is empty");
			return VehicleSet;
		}

		try (InputStream fileInputStream = new FileInputStream(VehiclesFile);
				ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

			VehicleSet = (Set<Vehicle>) objectInputStream.readObject();

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Exception happened while reading crimeEvents from file");
		}
		return VehicleSet;

	}

	
	public String checkLogin(long Id, String Password) {
		for (Worker W : workerSet)
			if (W.getPassword().equals(Password) && ((long) W.getId()) == Id){
				W.setPassword(Password);
				W.setId(Id);
			
				return W.getJob();
			}
		return "false";
	}


	public void RemoveIFromSet(int index, String which) {
		int i = 1;
		if (which.equals("Worker")) {
			for (Iterator<Worker> it = workerSet.iterator(); it.hasNext() && i <= index;) {
				Object O = it.next();
				if (i == index) {
					workerSet.remove(O);
					break;
				}
				i++;
			}

		}

		if (which.equals("Cop")) {
			for (Iterator<Cop> it = CopsSet.iterator(); it.hasNext() && i <= index;) {
				Object O = it.next();
				if (i == index) {
					CopsSet.remove(O);
					break;
				}
				i++;
			}
		}

		if (which.equals("CrimeEvent")) {
			for(Iterator<CrimeEvent> it = CrimeEventSet.iterator(); it.hasNext()&&i<=index;){
				Object O = it.next();
				if (i==index){
					CrimeEventSet.remove(O);
					break;
				}
				i++;
		
			}
		}
		if (which.equals("ReadyEvent")) {
			for(Iterator<ReadyEvent> it = ReadyEventSet.iterator(); it.hasNext()&&i<=index;){
				Object O = it.next();
				if (i==index){
					ReadyEventSet.remove((ReadyEvent)O);
					((ReadyEvent) O).setStatus("Done");
					HandeledReadyEventSet.add((ReadyEvent)O);
					
					break;
				}
				i++;
		
			}
		}
		if (which.equals("Vehicle")) {
			for (Iterator<Vehicle> it = VehicleSet.iterator(); it.hasNext() && i <= index;) {
				Object O = it.next();
				if (i == index) {
					VehicleSet.remove(O);
					break;
				}
				i++;
			}
		}
	}


	public boolean newWorker(long id) {
		for (Iterator<Worker> it = workerSet.iterator(); it.hasNext();){
			if (id==it.next().getId()) return false; 
			//if(!(it.next().checkId(id))) return false;
		}
		return true;
	}


}
