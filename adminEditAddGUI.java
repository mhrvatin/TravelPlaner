package travelplanner;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class adminEditAddGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtOrigin;
	private JTextField txtDestination;
	private JTextField txtDepartureTime;
	private JTextField txtArrivalTime;
	private JTextField txtPricePerSeat;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminEditAddGUI frame = new adminEditAddGUI();
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
	public adminEditAddGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 806, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtOrigin = new JTextField();
		txtOrigin.setBounds(119, 83, 178, 20);
		contentPane.add(txtOrigin);
		txtOrigin.setColumns(10);
		
		txtDestination = new JTextField();
		txtDestination.setColumns(10);
		txtDestination.setBounds(409, 83, 178, 20);
		contentPane.add(txtDestination);
		
		txtDepartureTime = new JTextField();
		txtDepartureTime.setColumns(10);
		txtDepartureTime.setBounds(119, 191, 178, 20);
		contentPane.add(txtDepartureTime);
		
		txtArrivalTime = new JTextField();
		txtArrivalTime.setColumns(10);
		txtArrivalTime.setBounds(409, 191, 178, 20);
		contentPane.add(txtArrivalTime);
		
		txtPricePerSeat = new JTextField();
		txtPricePerSeat.setColumns(10);
		txtPricePerSeat.setBounds(409, 245, 178, 20);
		contentPane.add(txtPricePerSeat);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSubmit.setBounds(304, 336, 89, 23);
		contentPane.add(btnSubmit);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnLogout.setBounds(662, 11, 89, 23);
		contentPane.add(btnLogout);
		
		JLabel lblWelcomeAdmin = new JLabel("Welcome Admin");
		lblWelcomeAdmin.setBounds(517, 15, 96, 14);
		contentPane.add(lblWelcomeAdmin);
		
		JDateChooser dateDeparture = new JDateChooser();
		dateDeparture.setBounds(119, 135, 178, 20);
		contentPane.add(dateDeparture);
		
		JDateChooser dateArrival = new JDateChooser();
		dateArrival.setBounds(409, 135, 178, 20);
		contentPane.add(dateArrival);
		
		JSpinner spNrOfSeats = new JSpinner();
		spNrOfSeats.setBounds(119, 245, 89, 20);
		contentPane.add(spNrOfSeats);
	}
}
