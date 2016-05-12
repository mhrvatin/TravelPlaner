package travelplanner;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JCheckBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JTable;
import com.toedter.calendar.JCalendar;
import javax.swing.JLabel;

public class maingui extends JFrame {

	private JPanel contentPane;
	private JTextField txtOrigin;
	private JTextField txtDestination;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					maingui frame = new maingui();
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
	public maingui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnRegister = new JButton("Register");
		
		JButton btnLogin = new JButton("Login");
		
		JButton btnSearch = new JButton("Search");
		
		JCalendar calOriginDate = new JCalendar();
		calOriginDate.setWeekOfYearVisible(false);
		
		JCalendar calReturnDate = new JCalendar();
		calReturnDate.getDayChooser().getDayPanel().setEnabled(false);
		calReturnDate.getDayChooser().setAlwaysFireDayProperty(true);
		calReturnDate.getDayChooser().setEnabled(false);
		calReturnDate.setEnabled(false);
		calReturnDate.setWeekOfYearVisible(false);
		
		txtOrigin = new JTextField();
		txtOrigin.setColumns(10);
		
		txtDestination = new JTextField();
		txtDestination.setColumns(10);
		
		JCheckBox chbReturnFlight = new JCheckBox("Return flight");
		
		JLabel lblOrigin = new JLabel("Origin");
		
		JLabel lblDestination = new JLabel("Destination");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addComponent(btnLogin)
									.addGap(35))
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addGap(51)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(txtOrigin, Alignment.LEADING)
										.addComponent(calOriginDate, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblOrigin, Alignment.LEADING))
									.addPreferredGap(ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(calReturnDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtDestination, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
										.addComponent(chbReturnFlight)
										.addComponent(lblDestination, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addComponent(btnRegister))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(224)
							.addComponent(btnSearch)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRegister)
						.addComponent(btnLogin))
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOrigin)
						.addComponent(lblDestination))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtOrigin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDestination, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(calOriginDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(calReturnDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(53)
							.addComponent(btnSearch))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(34)
							.addComponent(chbReturnFlight)))
					.addContainerGap(31, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
