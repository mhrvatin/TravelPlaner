package travelplanner;

import java.awt.EventQueue;

import javax.swing.JFrame;
import com.toedter.calendar.JCalendar;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

public class main {
	private JTable table;
	private JPanel contentPane;
    private JFrame frame;
    private JTextField txtOrigin;
    private JTextField txtDestination;
    private JTextField usernameField;
    private JTextField passwordField;
    private JTextField nameField;
    private JTextField lastNameField;
    private JTextField emailField;
    private JTextField passwordConfirmField;
    private SystemController sc = new SystemController();

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
        frame.setBounds(100, 100, 723, 540);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        login_register(frame);

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


        JButton btnSearch = new JButton("Search");
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                //searchGUI test = new searchGUI();
                //test.main();
            	frame.getContentPane().removeAll();
            	login_register(frame);
            	search(frame);
            	frame.getContentPane().repaint();
            	//frame.repaint();
            	
            }
        });
        btnSearch.setBounds(253, 304, 89, 23);
        frame.getContentPane().add(btnSearch);

        JCheckBox chckbxReturnFlight = new JCheckBox("Return Flight");
        chckbxReturnFlight.setBounds(376, 304, 97, 23);
        frame.getContentPane().add(chckbxReturnFlight);

        JDateChooser dateOrigin = new JDateChooser();
        dateOrigin.setBounds(94, 159, 95, 20);
        frame.getContentPane().add(dateOrigin);

        JDateChooser dateReturn = new JDateChooser();
        dateReturn.setEnabled(false);
        dateReturn.setBounds(376, 159, 95, 20);
        frame.getContentPane().add(dateReturn);

        JButton btnAdminTest = new JButton("Admin test");
        btnAdminTest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adminMainGUI test = new adminMainGUI();
                test.main();
            }
        });
        btnAdminTest.setBounds(10, 10, 111, 23);
        frame.getContentPane().add(btnAdminTest);
    }
    
    
    public void login_register(JFrame frame){
    	 JButton btnLogin = new JButton("Login");
         btnLogin.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
            	frame.getContentPane().removeAll();
             	login(frame);
             	frame.getContentPane().repaint();
             }
         });
         btnLogin.setBounds(391, 11, 89, 21);
         frame.getContentPane().add(btnLogin);

         JButton btnRegister = new JButton("Register");
         btnRegister.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
            	frame.getContentPane().removeAll();
             	register(frame);
             	frame.getContentPane().repaint();
             }
         });
         btnRegister.setBounds(489, 11, 89, 21);
         frame.getContentPane().add(btnRegister);
    }
    
    public void login(JFrame frame){
    	
    	contentPane = new JPanel();
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(contentPane);

        usernameField = new JTextField();
        usernameField.setBounds(127, 107, 196, 20);
        frame.getContentPane().add(usernameField);
        usernameField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(127, 177, 196, 20);
        frame.getContentPane().add(passwordField);
        passwordField.setColumns(10);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(127, 150, 46, 14);
        frame.getContentPane().add(lblPassword);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(127, 74, 78, 14);
        frame.getContentPane().add(lblUsername);

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    boolean res = sc.login(usernameField.getText(), passwordField.getText());
                    
                    if (res) {
                        System.out.println("res true, successfully logged in");
                        frame.getContentPane().removeAll();
                        search(frame);
                    	frame.getContentPane().repaint();
                        
                    } else {
                        System.out.println("res false");
                        frame.getContentPane().removeAll();
                        search(frame);
                    	frame.getContentPane().repaint();
                    }
                    
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(loginGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btnLogin.setBounds(182, 250, 89, 23);
        frame.getContentPane().add(btnLogin);
    }
    
    public void register(JFrame frame){
    	contentPane = new JPanel();
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(contentPane);
        
        nameField = new JTextField();
        nameField.setBounds(173, 71, 156, 20);
        frame.getContentPane().add(nameField);
        nameField.setColumns(10);

        lastNameField = new JTextField();
        lastNameField.setColumns(10);
        lastNameField.setBounds(173, 121, 156, 20);
        frame.getContentPane().add(lastNameField);

        emailField = new JTextField();
        emailField.setColumns(10);
        emailField.setBounds(173, 175, 156, 20);
        frame.getContentPane().add(emailField);

        passwordField = new JPasswordField();
        passwordField.setColumns(10);
        passwordField.setBounds(173, 229, 156, 20);
        frame.getContentPane().add(passwordField);

        passwordConfirmField = new JPasswordField();
        passwordConfirmField.setColumns(10);
        passwordConfirmField.setBounds(173, 281, 156, 20);
        frame.getContentPane().add(passwordConfirmField);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(173, 48, 46, 14);
        frame.getContentPane().add(lblName);

        JLabel lblLastName = new JLabel("Last Name");
        lblLastName.setBounds(173, 102, 70, 14);
        frame.getContentPane().add(lblLastName);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(173, 150, 46, 14);
        frame.getContentPane().add(lblEmail);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(173, 206, 70, 14);
        frame.getContentPane().add(lblPassword);

        JLabel lblConfirmPassword = new JLabel("Confirm Password");
        lblConfirmPassword.setBounds(173, 260, 116, 14);
        frame.getContentPane().add(lblConfirmPassword);

        JButton btnRegister = new JButton("Register");
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (passwordField.getText().equals(passwordConfirmField.getText())) {
                    try {
                        sc.register(emailField.getText(), passwordField.getText(), nameField.getText(), lastNameField.getText());
                        frame.getContentPane().removeAll();
                        
                    	frame.getContentPane().repaint();
                    } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(registerGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    System.out.println("passwords doesn't match");
                }
            }
        });
        btnRegister.setBounds(208, 334, 89, 23);
        frame.getContentPane().add(btnRegister);
    }
    
    public void search(JFrame frame){
    	

		contentPane = new JPanel();
		
		
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(contentPane);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(527, 48, 89, 23);
		frame.getContentPane().add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(66, 82, 550, 321);
		frame.getContentPane().add(scrollPane);

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
		frame.getContentPane().add(txtOrigin);
		txtOrigin.setColumns(10);
		
		txtDestination = new JTextField();
		txtDestination.setColumns(10);
		txtDestination.setBounds(237, 49, 164, 20);
		frame.getContentPane().add(txtDestination);
		
		JDateChooser dateOrigin = new JDateChooser();
		dateOrigin.setBounds(411, 49, 95, 20);
		frame.getContentPane().add(dateOrigin);
		
		JLabel lblOrigin = new JLabel("Origin");
		lblOrigin.setBounds(66, 24, 46, 14);
		frame.getContentPane().add(lblOrigin);
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setBounds(237, 24, 100, 14);
		frame.getContentPane().add(lblDestination);
		
		JButton btnBook = new JButton("Book");
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnBook.setBounds(280, 424, 89, 23);
		frame.getContentPane().add(btnBook);
    }
}
