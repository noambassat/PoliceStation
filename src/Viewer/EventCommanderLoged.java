package Viewer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Choice;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;

public class EventCommanderLoged extends JFrame {

	private JPanel contentPane;
	private Choice available;
	private Button check;
	private JButton btnCheckEvents;
	private Button checkE;
	private Choice event;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EventCommanderLoged frame = new EventCommanderLoged();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public EventCommanderLoged() {
		start();
	}
	public boolean start(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCheckAvailable = new JButton("Check available");

		btnCheckAvailable.setBounds(38, 28, 166, 29);
		contentPane.add(btnCheckAvailable);
		
		available = new Choice();
		available.setVisible(false);
		available.setBounds(73, 63, 92, 29);
		contentPane.add(available);
		
		check = new Button("Check");
		check.setVisible(false);
		check.setBounds(73, 95, 91, 24);
		contentPane.add(check);
		
		btnCheckEvents = new JButton("Check Events");

		btnCheckEvents.setBounds(219, 28, 166, 29);
		contentPane.add(btnCheckEvents);
		
		checkE = new Button("Check");
		checkE.setVisible(false);

		checkE.setBounds(254, 95, 91, 24);
		contentPane.add(checkE);
		
		event = new Choice();
		event.setVisible(false);
		event.setBounds(254, 63, 92, 26);
		
		event.addItem("CrimeEvent");
		event.addItem("ReadyEvent");
		contentPane.add(event);
		available.addItem("Cop");
		available.addItem("Vehicle");
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Print p = new Print(available.getSelectedItem().toString(),"EC");
				p.setVisible(true);
			}
		});

		btnCheckEvents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkE.setVisible(true);
				event.setVisible(true);
			}
		});
		checkE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Print p = new Print(event.getSelectedItem(), "EC");
				p.setVisible(true);

			}
		});
		btnCheckAvailable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				available.setVisible(true);
				check.setVisible(true);
			}
		});
		return true;
	}
}
