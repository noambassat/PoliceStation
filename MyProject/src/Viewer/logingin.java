package Viewer;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controler.InformationSystem;


import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;


public class logingin extends JFrame {

	private JPanel contentPane;
	private JTextField ID_field;
	private JLabel lblWrongValues;
	private JPasswordField password_Field;
	//private ObservableView observableView = new ObservableView();



	// private ObservableView observableView = new ObservableView();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					logingin frame = new logingin();
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
	public logingin() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		ID_field = new JTextField();
		ID_field.setBounds(169, 30, 206, 35);
		contentPane.add(ID_field);
		ID_field.setColumns(10);

		JLabel lblId = new JLabel("ID");
		lblId.setBounds(85, 37, 69, 20);
		contentPane.add(lblId);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(70, 105, 69, 20);
		contentPane.add(lblPassword);

		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(141, 186, 115, 29);
		contentPane.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			InformationSystem IS = InformationSystem.getInformationSystem();

			@Override
			public void actionPerformed(ActionEvent e) {
				Long ID = Long.parseLong(ID_field.getText());

				String Password = (String) password_Field.getText();
				System.out.println("ID=" + ID + ", Pass= " + Password.toString());
				String job = IS.checkLogin((long) ID, (String) Password);
				// adding to check if existed, string job returned
				if (job != null) {
					if (job.equals("Dispatcher")) {
						DispatcherLoged D = new DispatcherLoged();
						D.setVisible(true);
					}
					if (job.equals("EventHandler")) {
						EventHandlerLoged EH = new EventHandlerLoged();
						EH.setVisible(true);;
					}
					if (job.equals("EventCommander")) {
						EventCommanderLoged EC = new EventCommanderLoged();
						EC.setVisible(true);
					}
					if (job.equals("Cop")) {
						
					}
					if(job.equals("PoliceStationManager")){
						PoliceStationManagerLoged PSM = new PoliceStationManagerLoged();
						PSM.setVisible(true);
					}
				} else
					lblWrongValues.setVisible(true);

			}

		});

		lblWrongValues = new JLabel("Wrong values");
		lblWrongValues.setVisible(false);
		lblWrongValues.setForeground(new Color(255, 0, 0));
		lblWrongValues.setBounds(225, 147, 108, 20);
		contentPane.add(lblWrongValues);

		password_Field = new JPasswordField();
		password_Field.setBounds(169, 102, 206, 35);
		contentPane.add(password_Field);
	}
}
