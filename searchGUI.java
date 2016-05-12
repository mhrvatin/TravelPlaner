package travelplanner;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.JLayeredPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class searchGUI extends JFrame {

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
					searchGUI frame = new searchGUI();
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
	public searchGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(527, 48, 89, 23);
		contentPane.add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(66, 82, 550, 321);
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
		
		
		txtOrigin = new JTextField();
		txtOrigin.setBounds(66, 49, 161, 20);
		contentPane.add(txtOrigin);
		txtOrigin.setColumns(10);
		
		txtDestination = new JTextField();
		txtDestination.setColumns(10);
		txtDestination.setBounds(237, 49, 164, 20);
		contentPane.add(txtDestination);
		
		JDateChooser dateOrigin = new JDateChooser();
		dateOrigin.setBounds(411, 49, 95, 20);
		contentPane.add(dateOrigin);
		
		JLabel lblOrigin = new JLabel("Origin");
		lblOrigin.setBounds(66, 24, 46, 14);
		contentPane.add(lblOrigin);
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setBounds(237, 24, 100, 14);
		contentPane.add(lblDestination);
		
		JButton btnBook = new JButton("Book");
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookGUI test = new bookGUI();
				test.main();
				dispose();
			}
		});
		btnBook.setBounds(280, 424, 89, 23);
		contentPane.add(btnBook);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(505, 0, 89, 21);
		contentPane.add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(603, 0, 89, 21);
		contentPane.add(btnRegister);
	}
}
