package travelplanner;

import java.awt.EventQueue;

import javax.swing.JFrame;
import com.toedter.calendar.JCalendar;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class main {

	private JFrame frame;
	private JTextField txtOrigin;
	private JTextField txtDestination;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
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
	public main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 612, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JCalendar calOrigin = new JCalendar();
		calOrigin.setWeekOfYearVisible(false);
		calOrigin.setBounds(94, 161, 144, 153);
		frame.getContentPane().add(calOrigin);
		
		JCalendar calReturn = new JCalendar();
		calReturn.getDayChooser().getDayPanel().setEnabled(false);
		calReturn.getDayChooser().setEnabled(false);
		calReturn.getDayChooser().setAlwaysFireDayProperty(true);
		calReturn.setWeekOfYearVisible(false);
		calReturn.setEnabled(false);
		calReturn.setBounds(376, 161, 144, 153);
		frame.getContentPane().add(calReturn);
		
		txtOrigin = new JTextField();
		txtOrigin.setBounds(94, 107, 144, 20);
		frame.getContentPane().add(txtOrigin);
		txtOrigin.setColumns(10);
		
		txtDestination = new JTextField();
		txtDestination.setColumns(10);
		txtDestination.setBounds(376, 107, 144, 20);
		frame.getContentPane().add(txtDestination);
		
		JLabel lblOrigin = new JLabel("Origin");
		lblOrigin.setBounds(94, 82, 46, 14);
		frame.getContentPane().add(lblOrigin);
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setBounds(376, 82, 138, 14);
		frame.getContentPane().add(lblDestination);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(391, 11, 89, 21);
		frame.getContentPane().add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(489, 11, 89, 21);
		frame.getContentPane().add(btnRegister);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame = new searchGUI();
				
			}
		});
		btnSearch.setBounds(255, 362, 89, 23);
		frame.getContentPane().add(btnSearch);
		
		JCheckBox chckbxReturnFlight = new JCheckBox("Return Flight");
		chckbxReturnFlight.setBounds(411, 362, 97, 23);
		frame.getContentPane().add(chckbxReturnFlight);
	}
}
