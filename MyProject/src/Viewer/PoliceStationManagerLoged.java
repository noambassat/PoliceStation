package Viewer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PoliceStationManagerLoged extends JFrame {

	private JPanel contentPane;
	protected Main M;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PoliceStationManagerLoged frame = new PoliceStationManagerLoged();
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
	public PoliceStationManagerLoged() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSystemMenu = new JButton("System Menu");

		btnSystemMenu.setBounds(122, 42, 141, 36);
		contentPane.add(btnSystemMenu);
		
		JButton btnDailyReport = new JButton("Daily Report");

		btnDailyReport.setBounds(122, 99, 139, 36);
		contentPane.add(btnDailyReport);
		
		JButton btnHandeledEvent = new JButton("UnHandeled Event");
		btnHandeledEvent.setVisible(false);

		btnHandeledEvent.setBounds(35, 150, 154, 36);
		contentPane.add(btnHandeledEvent);
		
		JButton btnUnhandeledEvent = new JButton("Handeled Event");
		btnUnhandeledEvent.setVisible(false);

		btnUnhandeledEvent.setBounds(204, 151, 154, 36);
		contentPane.add(btnUnhandeledEvent);
		
		JButton btnLogout = new JButton("LogOut");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				M = new Main();
				M.main(null);
			}
		});
		btnLogout.setBounds(0, 215, 115, 29);
		contentPane.add(btnLogout);
		
		
		
		btnDailyReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnHandeledEvent.setVisible(true);
				btnUnhandeledEvent.setVisible(true);
	
			}
		});
		
		btnHandeledEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Print p = new Print("ReadyEvent", "PSM");
				p.setVisible(true);
			}
		});
		

		
		btnUnhandeledEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Print p = new Print("HandeledReadyEvent", "PSM");
				p.setVisible(true);
			}
		});
		
		btnSystemMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventCommanderLoged EC = new EventCommanderLoged();
				EC.setVisible(true);
			}
		});
	}

}
