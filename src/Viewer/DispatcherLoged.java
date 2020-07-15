package Viewer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controler.AddEvent;
import Controler.InformationSystem;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Choice;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class DispatcherLoged extends JFrame {

	private JPanel contentPane;
	private JTextField address = null;
	private Panel EventPanel;
	private AddEvent AE;
	private JLabel lblEventAdded;
	private JButton btnCencelEvent;
	private InformationSystem IS;
	private EventHandlerLoged ActionListner;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					DispatcherLoged frame = new DispatcherLoged();
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
	public DispatcherLoged() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnReportAnEvent = new JButton("Report an Event");
		btnReportAnEvent.setFont(new Font("Century", Font.PLAIN, 18));
		btnReportAnEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnCencelEvent.setVisible(false);
				EventPanel.setVisible(true);
			}
		});
		btnReportAnEvent.setBackground(new Color(255, 255, 224));
		btnReportAnEvent.setForeground(new Color(139, 69, 19));
		btnReportAnEvent.setBounds(183, 28, 177, 55);
		contentPane.add(btnReportAnEvent);

		EventPanel = new Panel();
		EventPanel.setFont(new Font("Century", Font.PLAIN, 18));
		EventPanel.setVisible(false);
		EventPanel.setBounds(118, 144, 333, 251);
		contentPane.add(EventPanel);
		EventPanel.setLayout(null);

		Choice size = new Choice();
		size.setFont(new Font("Century", Font.PLAIN, 18));
		size.setBounds(121, 68, 162, 26);
		EventPanel.add(size);
		size.addItem("5");
		size.addItem("10");
		size.addItem("15");

		address = new JTextField();
		address.setFont(new Font("Century", Font.PLAIN, 18));
		address.setBounds(121, 110, 162, 26);
		EventPanel.add(address);
		address.setColumns(10);

		Choice area = new Choice();
		area.setFont(new Font("Century", Font.PLAIN, 18));
		area.setBounds(121, 152, 162, 26);
		EventPanel.add(area);
		area.addItem("1");
		area.addItem("2");
		area.addItem("3");

		JLabel lblSize = new JLabel("Size:");
		lblSize.setFont(new Font("Century", Font.PLAIN, 18));
		lblSize.setForeground(new Color(139, 69, 19));
		lblSize.setBounds(31, 68, 84, 26);
		EventPanel.add(lblSize);

		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setForeground(new Color(139, 69, 19));
		lblAddress.setFont(new Font("Century", Font.PLAIN, 18));
		lblAddress.setBounds(31, 110, 84, 26);
		EventPanel.add(lblAddress);

		JLabel lblArea = new JLabel("Area");
		lblArea.setFont(new Font("Century", Font.PLAIN, 18));
		lblArea.setForeground(new Color(139, 69, 19));
		lblArea.setBounds(31, 152, 84, 26);
		EventPanel.add(lblArea);

		JLabel lblArgency = new JLabel("Urgency");
		lblArgency.setFont(new Font("Century", Font.PLAIN, 18));
		lblArgency.setForeground(new Color(139, 69, 19));
		lblArgency.setBounds(31, 26, 75, 20);
		EventPanel.add(lblArgency);

		Choice urgency = new Choice();
		urgency.setBounds(121, 26, 162, 26);
		EventPanel.add(urgency);
		urgency.addItem("1");
		urgency.addItem("2");
		urgency.addItem("3");
		urgency.addItem("4");
		urgency.addItem("5");

		JButton btnSumbit = new JButton("Sumbit");
		btnSumbit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!address.toString().equals(null)) {

					int Size = Integer.parseInt(size.getSelectedItem().toString());
					int Urgency = Integer.parseInt(urgency.getSelectedItem().toString());
					int Area = Integer.parseInt(area.getSelectedItem().toString());
					String Address = address.getText().toString();
					AE = AddEvent.getAddEvent();
					JFrame frame = new JFrame();// check method
					if ((JOptionPane.showConfirmDialog(frame, "want to send the Event?", "Print System",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)) {
						ActionListner = new EventHandlerLoged();
						btnSumbit.addActionListener(ActionListner);
						AE.AddEvent(Urgency, Size, Area, Address);
						EventPanel.setVisible(false);
						btnCencelEvent.setVisible(true);
			
					}

				}
			}

		});
		btnSumbit.setBounds(101, 208, 115, 29);
		EventPanel.add(btnSumbit);

		lblEventAdded = new JLabel("Event added");
		lblEventAdded.setVisible(false);
		lblEventAdded.setBackground(new Color(139, 69, 19));
		lblEventAdded.setForeground(new Color(184, 134, 11));
		lblEventAdded.setFont(new Font("Century", Font.BOLD, 20));
		lblEventAdded.setBounds(222, 408, 128, 20);
		contentPane.add(lblEventAdded);

		btnCencelEvent = new JButton("Cancel Event");
		btnCencelEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Print p = new Print("CrimeEvent", "D");
				p.setVisible(true);
			}
		});
		btnCencelEvent.setFont(new Font("Century", Font.PLAIN, 18));
		btnCencelEvent.setForeground(new Color(139, 69, 19));
		btnCencelEvent.setBounds(183, 88, 177, 55);
		contentPane.add(btnCencelEvent);

	}

}
