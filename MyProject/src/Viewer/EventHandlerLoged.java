package Viewer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controler.InformationSystem;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class EventHandlerLoged extends JFrame implements ActionListener {

	private JPanel contentPane;
	private InformationSystem IS;
	private JTextArea textArea;
	private JButton btnHandleIt;
	private JButton btnCencelRevent;
	private JButton btnLogout;
	protected Main M;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EventHandlerLoged frame = new EventHandlerLoged();
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
	public EventHandlerLoged() {
		IS = InformationSystem.getInformationSystem();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnHandleCrimeEvent = new JButton("Handle Crime Event");
		btnHandleCrimeEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Print P = new Print("CrimeEvent", "EH");
				P.setVisible(true);
			}
		});
		btnHandleCrimeEvent.setBounds(151, 63, 203, 48);
		contentPane.add(btnHandleCrimeEvent);
		
		textArea = new JTextArea();
		textArea.setVisible(false);
		textArea.setBounds(158, 185, 203, 62);
		contentPane.add(textArea);
		
		btnHandleIt = new JButton("Handle it!");
		btnHandleIt.setVisible(false);

		btnHandleIt.setBounds(201, 263, 115, 29);
		contentPane.add(btnHandleIt);
		
		btnCencelRevent = new JButton("Check ReadyEvents");
		btnCencelRevent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Print p = new Print("ReadyEvent", "EH");
				p.setVisible(true);
			}
		});
		btnCencelRevent.setBounds(151, 121, 203, 48);
		contentPane.add(btnCencelRevent);
		
		btnLogout = new JButton("LogOut");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				M = new Main();
				M.main(null);
			}
		});
		btnLogout.setBounds(0, 283, 115, 29);
		contentPane.add(btnLogout);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		textArea.setVisible(true);
		btnHandleIt.setVisible(true);
		textArea.append(e.toString());
		btnHandleIt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setVisible(false);
			}
		});
		
	}

}
