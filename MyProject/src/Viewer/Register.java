package Viewer;

import java.awt.EventQueue;

import javax.swing.JFrame;


import Controler.SignNewWorker;

import javax.swing.JTextField;

import javax.swing.JLabel;
import java.awt.Choice;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;

public class Register extends JFrame {
	private JTextField NameField;
	private JTextField IDField;
	private JPasswordField passwordField;
	private JLabel idTaken;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(67, 64, 69, 20);
		getContentPane().add(lblId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(67, 28, 69, 20);
		getContentPane().add(lblName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(67, 110, 69, 20);
		getContentPane().add(lblPassword);
		
		Choice Job = new Choice();
		Job.setBounds(130, 156, 157, 26);
		getContentPane().add(Job);
		Job.addItem("Dispatcher");
		Job.addItem("EventHandler");
		Job.addItem("EventCommander");
		
		
		JButton btnAdd = new JButton("Create");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignNewWorker SW = SignNewWorker.getSignNewWorker();
				String Password = (String)passwordField.getText();
				String name = (String)NameField.getText();
				String job = Job.getSelectedItem().toString();
				long ID = Long.parseLong(IDField.getText());
				if(SW.addNewWorker(name, Password, job,ID)){
					System.out.println("Great! lets login now");
					logingin l = new logingin();
					l.setVisible(true);
				}
				else{
					idTaken.setVisible(true);
				}
				
			}
		});
		btnAdd.setBounds(149, 199, 115, 29);
		getContentPane().add(btnAdd);
		
		NameField = new JTextField();
		NameField.setBounds(151, 25, 157, 26);
		getContentPane().add(NameField);
		NameField.setColumns(10);
		
		IDField = new JTextField();
		IDField.setBounds(151, 64, 157, 26);
		getContentPane().add(IDField);
		IDField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(151, 107, 157, 26);
		getContentPane().add(passwordField);
		
		idTaken = new JLabel("Invalid ID!");
		idTaken.setVisible(false);
		idTaken.setForeground(Color.RED);
		idTaken.setBounds(316, 64, 112, 20);
		getContentPane().add(idTaken);
	}
}
