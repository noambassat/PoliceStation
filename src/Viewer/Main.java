package Viewer;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import Controler.InformationSystem;
import Controler.SignNewWorker;

public class Main {

	private JFrame frame;
	private JTextField txtWelcomToPolice;
	private InformationSystem IS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		IS = InformationSystem.getInformationSystem();
		SignNewWorker s = new SignNewWorker();
		s.addNewWorker("Officer", "123", "PoliceStationManager", 123);
		IS.start();
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Ink Free", Font.BOLD, 18));
		frame.getContentPane().setForeground(new Color(240, 230, 140));
		frame.getContentPane().setLayout(null);
		
		txtWelcomToPolice = new JTextField();
		txtWelcomToPolice.setFont(new Font("Ink Free", Font.BOLD, 20));
		txtWelcomToPolice.setForeground(new Color(139, 69, 19));
		txtWelcomToPolice.setHorizontalAlignment(SwingConstants.CENTER);
		txtWelcomToPolice.setBackground(new Color(245, 245, 220));
		txtWelcomToPolice.setText("Welcome to Police Station");
		txtWelcomToPolice.setBounds(74, 16, 281, 44);
		frame.getContentPane().add(txtWelcomToPolice);
		txtWelcomToPolice.setColumns(10);
		
		JButton btnLogin = new JButton("LogIn");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logingin lg = new logingin();
				lg.setVisible(true);
			}
		});
		btnLogin.setFont(new Font("Lucida Handwriting", Font.PLAIN, 18));
		btnLogin.setForeground(new Color(184, 134, 11));
		btnLogin.setBackground(new Color(238, 232, 170));
		btnLogin.setBounds(155, 86, 125, 35);
		frame.getContentPane().add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Lucida Handwriting", Font.PLAIN, 18));
		btnRegister.setForeground(new Color(184, 134, 11));
		btnRegister.setBackground(new Color(238, 232, 170));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Register r = new Register();
				r.setVisible(true);
				
			}
		});
		btnRegister.setBounds(155, 137, 125, 35);
		frame.getContentPane().add(btnRegister);
		frame.setBackground(new Color(139, 69, 19));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
