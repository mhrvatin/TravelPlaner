package travelplanner;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class adminMainGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtOrigin;
	private JTextField txtDestination;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminMainGUI frame = new adminMainGUI();
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
	public adminMainGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 786, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtOrigin = new JTextField();
		txtOrigin.setColumns(10);
		txtOrigin.setBounds(35, 60, 161, 20);
		contentPane.add(txtOrigin);
		
		JLabel lblOrigin = new JLabel("Origin");
		lblOrigin.setBounds(35, 35, 46, 14);
		contentPane.add(lblOrigin);
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setBounds(206, 35, 100, 14);
		contentPane.add(lblDestination);
		
		txtDestination = new JTextField();
		txtDestination.setColumns(10);
		txtDestination.setBounds(206, 60, 164, 20);
		contentPane.add(txtDestination);
		
		JDateChooser dateOrigin = new JDateChooser();
		dateOrigin.setBounds(380, 60, 95, 20);
		contentPane.add(dateOrigin);
		
		JButton button = new JButton("Search");
		button.setBounds(496, 59, 89, 23);
		contentPane.add(button);
		
		JButton btnLogout = new JButton("Log Out");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnLogout.setBounds(671, 11, 89, 21);
		contentPane.add(btnLogout);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(35, 96, 550, 321);
		contentPane.add(scrollPane);

		DefaultTableModel model = new DefaultTableModel();
		
		table = new JTable(model);
		
		model.addColumn("Origin");
		model.addColumn("Destination");
		model.addColumn("Date");
		
		for(int i = 0; i < 10; i++){
			model.insertRow(i,new Object[] {"test","test","test"});
		}
		
		scrollPane.setViewportView(table);
		
		JButton btnAddFlight = new JButton("Add Flight");
		btnAddFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminEditAddGUI test = new adminEditAddGUI();
				test.main();
			}
		});
		btnAddFlight.setBounds(606, 93, 89, 23);
		contentPane.add(btnAddFlight);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminEditAddGUI test = new adminEditAddGUI();
				test.main();
			}
		});
		btnEdit.setBounds(606, 142, 89, 23);
		contentPane.add(btnEdit);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(606, 190, 89, 23);
		contentPane.add(btnRemove);
		
		JLabel lblWelcomeAdmin = new JLabel("Welcome: Admin");
		lblWelcomeAdmin.setBounds(539, 14, 122, 14);
		contentPane.add(lblWelcomeAdmin);
		
	}
}
