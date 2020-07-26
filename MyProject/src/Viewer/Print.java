package Viewer;

import java.awt.EventQueue;

import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Controler.*;


import javax.swing.JTextArea;
import java.awt.Font;

import java.awt.Choice;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Print extends JFrame {

	private JPanel contentPane;
	private static InformationSystem IS;
	private JTextArea textArea;
	private Choice choice;
	private Button remove;
	private Panel panel;
	private Choice urgency;
	private Choice area;
	private Choice vehicle;
	private Choice cops;
	private JTextField address;
	private JTextField status;
	private JLabel lblUrgency;
	private JLabel lblArea;
	private JLabel lblCops;
	private JLabel lblVehicle;
	private JButton btnSumbit;
	private JLabel lblAddress;
	private JLabel lblStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Print frame = new Print("","");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Print(String which, String who){
		start(which,who);
	}
	public void start(String which, String who) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 300, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(30, 300,300, 30));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textArea = new JTextArea();
		textArea.setFont(new Font("Century", Font.PLAIN, 20));
		textArea.setBounds(29, 16, 703, 147);
		contentPane.add(textArea);

		choice = new Choice();
		choice.setFont(new Font("Century", Font.PLAIN, 20));
		choice.setBounds(39, 169, 73, 26);
		contentPane.add(choice);

		remove = new Button("Remove");
		if(which.equals("ReadyEvent")) remove.setVisible(false);
		remove.setFont(new Font("Century", Font.PLAIN, 18));

		remove.setBounds(330, 169, 104, 31);
		contentPane.add(remove);
		
		panel = new Panel();
		panel.setBounds(118, 225, 539, 177);
		contentPane.add(panel);
		panel.setLayout(null);
		
		urgency = new Choice();
		urgency.setBounds(210, 10, 51, 26);
		panel.add(urgency);
		urgency.addItem("1");
		urgency.addItem("2");
		urgency.addItem("3");
		urgency.addItem("4");
		urgency.addItem("5");
		
		area = new Choice();
		area.setBounds(210, 48, 51, 26);
		panel.add(area);
		area.addItem("1");
		area.addItem("2");
		area.addItem("3");
		
		vehicle = new Choice();
		vehicle.setBounds(210, 119, 51, 26);
		panel.add(vehicle);
		vehicle.addItem("1");
		vehicle.addItem("2");
		
		cops = new Choice();
		cops.setBounds(210, 85, 51, 26);
		panel.add(cops);
		cops.addItem("2");
		cops.addItem("3");
		cops.addItem("4");
		cops.addItem("5");
		cops.addItem("6");
		cops.addItem("7");
		cops.addItem("8");
		cops.addItem("9");
		cops.addItem("10");
		
		address = new JTextField();
		address.setBounds(290, 32, 146, 26);
		panel.add(address);
		address.setColumns(10);
		
		status = new JTextField();
		status.setBounds(290, 85, 146, 26);
		panel.add(status);
		status.setColumns(10);
		
		lblUrgency = new JLabel("Urgency");
		lblUrgency.setBounds(103, 10, 69, 20);
		panel.add(lblUrgency);
		
		lblArea = new JLabel("area");
		lblArea.setBounds(103, 48, 69, 20);
		panel.add(lblArea);
		
		lblCops = new JLabel("Cops");
		lblCops.setBounds(103, 91, 69, 20);
		panel.add(lblCops);
		
		lblVehicle = new JLabel("Vehicle");
		lblVehicle.setBounds(103, 119, 69, 20);
		panel.add(lblVehicle);
		
		btnSumbit = new JButton("submit");
		btnSumbit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddEvent AE = new AddEvent();
				int Urgency = Integer.parseInt(urgency.getSelectedItem().toString());
				int Area = Integer.parseInt(area.getSelectedItem().toString());
				String Address = address.getText().toString();
				int Cops = Integer.parseInt(cops.getSelectedItem().toString());
				int Vehicle = Integer.parseInt(vehicle.getSelectedItem().toString());
				String status = lblStatus.getText().toString();

				AE.AddRE(Urgency, Area, Address, Cops, Vehicle, status);

			}
		});
		btnSumbit.setBounds(306, 116, 115, 29);
		panel.add(btnSumbit);
		
		lblAddress = new JLabel("Address");
		lblAddress.setBounds(324, 10, 69, 20);
		panel.add(lblAddress);
		
		lblStatus = new JLabel("Status");
		lblStatus.setBounds(335, 64, 69, 20);
		panel.add(lblStatus);

		getSet(which,who);

	}

	public boolean getSet(String which,String who) {
		if(who.equals("D")||which.equals("Cop")||which.equals("Vehicle")||(which.equals("ReadyEvent"))){
			panel.setVisible(false);
		}
		if(which.equals("ReadyEvent")){
			remove.setVisible(false);
			choice.setVisible(false);
		}
		IS = InformationSystem.getInformationSystem();
		Set<Object> set = IS.getSet(which);
		int i;
		for (i = 1; i <= set.size(); i++) {
			choice.add(String.valueOf(i));
		}
		i = 1;
		if((who.equals("PSM"))&&(which.equals("HandeledReadyEvent"))) textArea.append("Handeled Events:");
		if((who.equals("PSM"))&&(which.equals("ReadyEvent"))) textArea.append("Unhandeled Events:");
		for (Object O : set) {
			textArea.append(String.valueOf(i) + ". " + O.toString());
			textArea.append("\n");
			i++;
		}

		if(!which.equals("ReadyEvent"))remove.setVisible(true);
		remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(set.size()!=0){
				IS.RemoveIFromSet(Integer.parseInt(choice.getSelectedItem()), which);
				textArea.setText("");
				getSet(which,who);
				}
				
			}
			
		});

		return true;

	}
}
