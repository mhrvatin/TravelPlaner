package travelplanner;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class gui {
    private JTable table;
    private JPanel contentPane;
    private JFrame frame;
    private JTextField txtCardNr;
    private JTextField txtOrigin;
    private JTextField txtDestination;
    private JTextField usernameField;
    private JTextField passwordField;
    private JTextField nameField;
    private JTextField lastNameField;
    private JTextField emailField;
    private JTextField passwordConfirmField;
    private JTextField txtDepartureTime;
    private JTextField txtArrivalTime;
    private JTextField txtPricePerSeat;
    private final SystemController sc = new SystemController();

    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    gui window = new gui();
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
    public gui() {
    	frame = new JFrame();
        initialize(frame,false);
    }

    private void initialize(JFrame frame,boolean login) {
    	frame.setBounds(100, 100, 723, 540);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        if (login == false) {
            login_register(frame);
        } else {
            user_logout(frame);
        }
        
        txtOrigin = new JTextField();
        txtOrigin.setBounds(94, 107, 144, 20);
        frame.getContentPane().add(txtOrigin);
        txtOrigin.setColumns(10);

        txtDestination = new JTextField();
        txtDestination.setColumns(10);
        txtDestination.setBounds(376, 107, 144, 20);
        frame.getContentPane().add(txtDestination);
        
        JDateChooser dateOrigin = new JDateChooser();
        dateOrigin.setDateFormatString("yyyy-MM-dd");
        dateOrigin.setBounds(94, 159, 95, 20);
        frame.getContentPane().add(dateOrigin);
        Date dateString = new Date();
        Date todaysDate = new Date();
    	dateOrigin.setDate(dateString);

        JLabel lblOrigin = new JLabel("Origin");
        lblOrigin.setBounds(94, 82, 46, 14);
        frame.getContentPane().add(lblOrigin);

        JLabel lblDestination = new JLabel("Destination");
        lblDestination.setBounds(376, 82, 138, 14);
        frame.getContentPane().add(lblDestination);

        JButton btnSearch = new JButton("Search");
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String origin = txtOrigin.getText();
                String destination = txtDestination.getText();
                
                Date dateString = dateOrigin.getDate();
                if(dateString==null)
                {
                	JOptionPane.showMessageDialog(frame, "not valid search Params",
                            "Couldn't search", JOptionPane.ERROR_MESSAGE);
                }
                
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

                String formatedDate = format.format(dateString); 
                if(origin.equals("") || destination.equals("")) {
                    JOptionPane.showMessageDialog(frame, "not valid search Params",
                            "Couldn't search", JOptionPane.ERROR_MESSAGE);
                }
                else if(dateString.before(todaysDate)){
                	JOptionPane.showMessageDialog(frame, "You cannot search for old flights",
                            "Couldn't search", JOptionPane.ERROR_MESSAGE);                	
                }
                else{
                    String[][] flights = sc.getFlights(origin, destination, formatedDate);
                    frame.getContentPane().removeAll();
                    frame.getContentPane().revalidate();
                    search(frame, flights, origin, destination, dateString);
                    frame.getContentPane().repaint();
                }    
            }
        });
        btnSearch.setBounds(253, 304, 89, 23);
        frame.getContentPane().add(btnSearch);

        JCheckBox chckbxReturnFlight = new JCheckBox("Return Flight");
        chckbxReturnFlight.setBounds(376, 200, 100, 23);
        frame.getContentPane().add(chckbxReturnFlight);

        JDateChooser dateReturn = new JDateChooser();
        dateReturn.setEnabled(false);
        dateReturn.setBounds(376, 159, 95, 20);
        frame.getContentPane().add(dateReturn);

        JButton btnAdminTest = new JButton("Admin test");
        btnAdminTest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	frame.getContentPane().removeAll();
            	frame.getContentPane().revalidate();
            	adminMain(frame);
            	frame.getContentPane().repaint();
            }
        });
        btnAdminTest.setBounds(0, 0, 83, 23);
        frame.getContentPane().add(btnAdminTest);
        
        
        
        
    }
    
    public void login_register(JFrame frame){
    	JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.getContentPane().removeAll();
             	login(frame);
             	frame.getContentPane().revalidate();
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
             	frame.getContentPane().revalidate();
             	frame.getContentPane().repaint();
             }
         });
         btnRegister.setBounds(489, 11, 89, 21);
         frame.getContentPane().add(btnRegister);
    }
    
    public void user_logout(JFrame frame){
        JLabel lblUser = new JLabel("Welcome " + sc.userName);
        lblUser.setBounds(345, 11, 150, 21);
        frame.getContentPane().add(lblUser);

        JButton btnLogout = new JButton("Logout");
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
           	frame.getContentPane().removeAll();
            	initialize(frame,false);
            	frame.getContentPane().revalidate();
            	frame.getContentPane().repaint();
            	JOptionPane.showMessageDialog(frame, "You are now signed out",
                        "Signed out successfully", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        btnLogout.setBounds(500, 11, 89, 21);
        frame.getContentPane().add(btnLogout);
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
        lblPassword.setBounds(127, 150, 100, 14);
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
                        frame.getContentPane().removeAll();
                        initialize(frame,true);
                        frame.getContentPane().revalidate();
                        frame.getContentPane().repaint();
                        JOptionPane.showMessageDialog(frame, "You are now signed in",
                                "Signed in successfully", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Wrong username/password",
                            "Couldn't sign in", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btnLogin.setBounds(182, 250, 89, 23);
        frame.getContentPane().add(btnLogin);
        
        JButton btnHome = new JButton("Home");
        btnHome.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		frame.getContentPane().removeAll();
        		initialize(frame,false);
             	frame.getContentPane().revalidate();
             	frame.getContentPane().repaint();
        	}
        });
        btnHome.setBounds(0, 2, 70, 23);
        frame.getContentPane().add(btnHome);
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
                    String email= emailField.getText();
                    String pass= passwordField.getText();
                    String name= nameField.getText();
                    String lastName= lastNameField.getText();
                    if(!email.isEmpty() && !pass.isEmpty() && !name.isEmpty() && !lastName.isEmpty()) {
                        try {
                            boolean reg =sc.register(email, pass, name, lastName);
                            if(reg) {
                                frame.getContentPane().removeAll();
                                initialize(frame, false);
                                frame.getContentPane().validate();
                                frame.getContentPane().repaint();
                                JOptionPane.showMessageDialog(frame, "You are now registered",
                                        "Registered successfully", JOptionPane.INFORMATION_MESSAGE);
                            }else{
                                JOptionPane.showMessageDialog(frame, "email already exist",
                                        "Couldn't register", JOptionPane.ERROR_MESSAGE);

                            }
                        } catch (NoSuchAlgorithmException ex) {
                            Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else{
                        JOptionPane.showMessageDialog(frame, "params are not valid",
                                "Couldn't register", JOptionPane.ERROR_MESSAGE);

                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "passwords doesnt' match",
                            "Couldn't register", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnRegister.setBounds(208, 334, 89, 23);
        frame.getContentPane().add(btnRegister);
        
        JButton btnHome = new JButton("Home");
        btnHome.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		frame.getContentPane().removeAll();
        		initialize(frame,false);
             	frame.getContentPane().revalidate();
             	frame.getContentPane().repaint();
        	}
        });
        btnHome.setBounds(0, 2, 70, 23);
        frame.getContentPane().add(btnHome);
    }

    public void search(JFrame frame,String[][] flights, String origin, String destination ,Date date) {

        contentPane = new JPanel();
        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(contentPane);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(66, 82, 550, 321);
        frame.getContentPane().add(scrollPane);

        DefaultTableModel model = new DefaultTableModel();

        table = new JTable(model);

        model.addColumn("Origin");
        model.addColumn("Destination");
        model.addColumn("Date");
        

        scrollPane.setViewportView(table);

        txtOrigin = new JTextField(origin);
        txtOrigin.setBounds(66, 49, 161, 20);
        frame.getContentPane().add(txtOrigin);
        txtOrigin.setColumns(10);

        txtDestination = new JTextField(destination);
        txtDestination.setColumns(10);
        txtDestination.setBounds(237, 49, 164, 20);
        frame.getContentPane().add(txtDestination);

        JDateChooser dateOrigin = new JDateChooser();
        dateOrigin.setDate(date);
        dateOrigin.setBounds(411, 49, 95, 20);
        frame.getContentPane().add(dateOrigin);

        JLabel lblOrigin = new JLabel("Origin");
        lblOrigin.setBounds(66, 24, 46, 14);
        frame.getContentPane().add(lblOrigin);

        JLabel lblDestination = new JLabel("Destination");
        lblDestination.setBounds(237, 24, 100, 14);
        frame.getContentPane().add(lblDestination);

        JButton btnSearch = new JButton("Search");
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String origin = txtOrigin.getText();
                String destination = txtDestination.getText();

                Date dateString = dateOrigin.getDate();
                if(dateString==null)
                {
                	JOptionPane.showMessageDialog(frame, "not valid search Params",
                            "Couldn't search", JOptionPane.ERROR_MESSAGE);
                }
                
                
                
                
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String formatedDate = format.format(dateString); 
                if(origin.equals("") || destination.equals("")) {
                    JOptionPane.showMessageDialog(frame, "not valid search Params",
                            "Couldn't search", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    String[][] flights = sc.getFlights(origin, destination, formatedDate);
                    frame.getContentPane().removeAll();
                    frame.getContentPane().revalidate();
                    search(frame, flights, origin, destination, dateString);
                    frame.getContentPane().repaint();
                }
            }
        });
        btnSearch.setBounds(527, 48, 89, 23);
        frame.getContentPane().add(btnSearch);


        JButton btnBook = new JButton("Book");
        btnBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] flight = flights[table.getSelectedRow()];
                frame.getContentPane().removeAll();
                book(frame, flight);
                frame.getContentPane().revalidate();
                frame.getContentPane().repaint();
            }
        });
        btnBook.setBounds(280, 424, 89, 23);
        frame.getContentPane().add(btnBook);
        
        JButton btnHome = new JButton("Home");
        btnHome.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		frame.getContentPane().removeAll();
        		initialize(frame,false);
             	frame.getContentPane().revalidate();
             	frame.getContentPane().repaint();
        	}
        });
        btnHome.setBounds(0, 2, 70, 23);
        frame.getContentPane().add(btnHome);
        
        if (sc.user == null){
            btnBook.setVisible(false);
            login_register(frame);
        }else {
        	user_logout(frame);
        }
        
        if(flights[0][0] != null){
        	for (int i = 0; i <= 10; i++) {
                if (flights[i][0] != null) {
                	model.insertRow(i, new Object[]{flights[i][1], flights[i][2], flights[i][3]});
                }else{
                	i = 10;
                }
            }
        }else{
        	JOptionPane.showMessageDialog(frame, "No matches",
                    "No matches for your search", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    

    public void book(JFrame frame,String[] flight){
    	contentPane = new JPanel();
    	user_logout(frame);
    	
        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(contentPane);

        JLabel txtOrigin = new JLabel(flight[1]);
        txtOrigin.setBounds(81, 87, 176, 20);
        frame.getContentPane().add(txtOrigin);

        JLabel txtDestination = new JLabel(flight[2]);
        txtDestination.setBounds(81, 144, 176, 20);
        frame.getContentPane().add(txtDestination);

        JLabel txtPrice = new JLabel(flight[6]);
        txtPrice.setBounds(81, 261, 58, 20);
        frame.getContentPane().add(txtPrice);

        JLabel txtDate = new JLabel(flight[3]);
        txtDate.setBounds(399, 87, 86, 20);
        frame.getContentPane().add(txtDate);

        JLabel txtTime = new JLabel(flight[4]);
        txtTime.setBounds(559, 87, 86, 20);
        frame.getContentPane().add(txtTime);

        JLabel txtDate_2 = new JLabel(flight[3]);
        txtDate_2.setBounds(399, 144, 86, 20);
        frame.getContentPane().add(txtDate_2);
        

        String arrTime = flight[4].substring(0, 2);
        int time = Integer.parseInt(arrTime) + Integer.parseInt(flight[5].substring(0, 2));
        String arrivalTime = Integer.toString(time) + ":" + flight[4].substring(3, 5);
        
        JLabel txtTime_2 = new JLabel(arrivalTime);
        txtTime_2.setBounds(559, 144, 86, 20);
        frame.getContentPane().add(txtTime_2);

        JLabel lblOrigin = new JLabel("Origin");
        lblOrigin.setBounds(81, 62, 46, 14);
        frame.getContentPane().add(lblOrigin);

        JLabel lblDestination = new JLabel("Destination");
        lblDestination.setBounds(81, 118, 136, 14);
        frame.getContentPane().add(lblDestination);

        JLabel lblEnterPassengers = new JLabel("Enter Nr Of Passengers");
        lblEnterPassengers.setBounds(81, 179, 136, 14);
        frame.getContentPane().add(lblEnterPassengers);

        JLabel lblPrice = new JLabel("Price");
        lblPrice.setBounds(81, 235, 46, 14);
        frame.getContentPane().add(lblPrice);

        JLabel lblDate = new JLabel("Date");
        lblDate.setBounds(399, 62, 46, 14);
        frame.getContentPane().add(lblDate);

        JLabel lblDate_2 = new JLabel("Date");
        lblDate_2.setBounds(399, 118, 46, 14);
        frame.getContentPane().add(lblDate_2);

        JLabel lblTime = new JLabel("Time");
        lblTime.setBounds(559, 62, 46, 14);
        frame.getContentPane().add(lblTime);

        JLabel lblTime_2 = new JLabel("Time");
        lblTime_2.setBounds(559, 119, 46, 14);
        frame.getContentPane().add(lblTime_2);
        int max = 6;
        SpinnerNumberModel model1 = new SpinnerNumberModel(1, 1, max, 1);
        JSpinner spPassengers = new JSpinner(model1);
        spPassengers.setValue(1);
        spPassengers.addChangeListener(new ChangeListener() {
        	public void stateChanged(ChangeEvent arg0) {
        		int price = (Integer)spPassengers.getValue() * Integer.parseInt(flight[6]);
        		txtPrice.setText(Integer.toString(price));
        	}
        });
        spPassengers.setEnabled(true);

        spPassengers.setBounds(81, 204, 29, 20);
        frame.getContentPane().add(spPassengers);
        
        JButton btnBook = new JButton("Book");
        btnBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	int nrOfPassengers = (int)spPassengers.getValue();
            	
                frame.getContentPane().removeAll();
                
                pay(frame,flight,txtPrice.getText(), nrOfPassengers);
                frame.getContentPane().revalidate();
                frame.getContentPane().repaint();
            }
         });
        btnBook.setBounds(278, 362, 89, 23);
        frame.getContentPane().add(btnBook);
        
        JButton btnHome = new JButton("Home");
        btnHome.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		frame.getContentPane().removeAll();
        		initialize(frame,false);
             	frame.getContentPane().revalidate();
             	frame.getContentPane().repaint();
        	}
        });
        btnHome.setBounds(0, 2, 70, 23);
        frame.getContentPane().add(btnHome);

    }

    public void pay(JFrame frame,String[] flight,String price, int nrOfPassengers){
    	contentPane = new JPanel();
    	user_logout(frame);
		
        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(contentPane);

        JLabel lblPrice = new JLabel("Price:");
        lblPrice.setBounds(77, 126, 46, 14);
        frame.getContentPane().add(lblPrice);

        JLabel lblDisplayPrice = new JLabel(price);
        lblDisplayPrice.setBounds(161, 126, 162, 14);
        frame.getContentPane().add(lblDisplayPrice);

        JLabel lblCardNr = new JLabel("Card Nr:");
        lblCardNr.setBounds(77, 172, 46, 14);
        frame.getContentPane().add(lblCardNr);

        txtCardNr = new JTextField();
        txtCardNr.setBounds(161, 169, 342, 20);
        frame.getContentPane().add(txtCardNr);
        txtCardNr.setColumns(10);

        JLabel lblReceipt = new JLabel("Receipt sent to: ");
        lblReceipt.setBounds(77, 222, 150, 14);
        frame.getContentPane().add(lblReceipt);

        JLabel lblUserEmail = new JLabel(sc.user);
        lblUserEmail.setBounds(200, 222, 226, 14);
        frame.getContentPane().add(lblUserEmail);

        JButton btnPay = new JButton("Pay");
        btnPay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int id=Integer.parseInt(flight[0]);
            	String cardNr=txtCardNr.getText();
            	
            	if(cardNr.equals(""))
            	{
            		JOptionPane.showMessageDialog(frame, "Card number cannot be empty",
                            "No card number supplied", JOptionPane.ERROR_MESSAGE);
            	} else {
            		try{
						Long.parseLong(cardNr, 10);
	            		sc.bookFlight(id, nrOfPassengers, cardNr, Integer.parseInt(price));
	                	
	            		frame.getContentPane().removeAll(); 
	            		initialize(frame,true);
	            		frame.getContentPane().validate();
	            		frame.getContentPane().repaint();
	            		JOptionPane.showMessageDialog(frame, "Payment went successfully",
	                            "Payment successfully", JOptionPane.INFORMATION_MESSAGE);	
	                  
            		} catch (NumberFormatException ex) {
                		JOptionPane.showMessageDialog(frame, "cannot be string",
                                "Couldn't search", JOptionPane.ERROR_MESSAGE);
                	} 
            	}
            }
        });
        btnPay.setBounds(77, 328, 89, 23);
        frame.getContentPane().add(btnPay);
        
        JButton btnHome = new JButton("Home");
        btnHome.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		frame.getContentPane().removeAll();
        		initialize(frame,false);
             	frame.getContentPane().revalidate();
             	frame.getContentPane().repaint();
        	}
        });
        btnHome.setBounds(0, 2, 70, 23);
        frame.getContentPane().add(btnHome);
    }
    
    public void adminMain(JFrame frame){
    	contentPane = new JPanel();
    	user_logout(frame);
		
    	frame.getContentPane().setLayout(null);
        frame.getContentPane().add(contentPane);

        txtOrigin = new JTextField();
        txtOrigin.setColumns(10);
        txtOrigin.setBounds(35, 60, 161, 20);
        frame.getContentPane().add(txtOrigin);

        JLabel lblOrigin = new JLabel("Origin");
        lblOrigin.setBounds(35, 35, 46, 14);
        frame.getContentPane().add(lblOrigin);

        JLabel lblDestination = new JLabel("Destination");
        lblDestination.setBounds(206, 35, 100, 14);
        frame.getContentPane().add(lblDestination);

        txtDestination = new JTextField();
        txtDestination.setColumns(10);
        txtDestination.setBounds(206, 60, 164, 20);
        frame.getContentPane().add(txtDestination);

        JDateChooser dateOrigin = new JDateChooser();
        dateOrigin.setBounds(380, 60, 95, 20);
        frame.getContentPane().add(dateOrigin);

        JButton button = new JButton("Search");
        button.setBounds(496, 59, 89, 23);
        frame.getContentPane().add(button);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(35, 96, 550, 321);
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

        JButton btnAddFlight = new JButton("Add Flight");
        btnAddFlight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll(); 
                adminEditAdd(frame);
                frame.getContentPane().validate();
                frame.getContentPane().repaint();
            }
        });
        btnAddFlight.setBounds(606, 93, 89, 23);
        frame.getContentPane().add(btnAddFlight);

        JButton btnEdit = new JButton("Edit");
        btnEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll(); 
                adminEditAdd(frame);
                frame.getContentPane().validate();
                frame.getContentPane().repaint();		
            }
        });
        btnEdit.setBounds(606, 142, 89, 23);
        frame.getContentPane().add(btnEdit);

        JButton btnRemove = new JButton("Remove");
        btnRemove.setBounds(606, 190, 89, 23);
        frame.getContentPane().add(btnRemove);
    }
    
    public void adminEditAdd(JFrame frame){
    	contentPane = new JPanel();
    	user_logout(frame);
		
    	frame.getContentPane().setLayout(null);
        frame.getContentPane().add(contentPane);

        txtOrigin = new JTextField();
        txtOrigin.setBounds(119, 83, 178, 20);
        frame.getContentPane().add(txtOrigin);
        txtOrigin.setColumns(10);

        txtDestination = new JTextField();
        txtDestination.setColumns(10);
        txtDestination.setBounds(409, 83, 178, 20);
        frame.getContentPane().add(txtDestination);

        txtDepartureTime = new JTextField();
        txtDepartureTime.setColumns(10);
        txtDepartureTime.setBounds(119, 191, 178, 20);
        frame.getContentPane().add(txtDepartureTime);

        txtArrivalTime = new JTextField();
        txtArrivalTime.setColumns(10);
        txtArrivalTime.setBounds(409, 191, 178, 20);
        frame.getContentPane().add(txtArrivalTime);

        txtPricePerSeat = new JTextField();
        txtPricePerSeat.setColumns(10);
        txtPricePerSeat.setBounds(409, 245, 178, 20);
        frame.getContentPane().add(txtPricePerSeat);

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll(); 
                adminMain(frame);
                frame.getContentPane().validate();
                frame.getContentPane().repaint();
            }
        });
        btnSubmit.setBounds(304, 336, 89, 23);
        frame.getContentPane().add(btnSubmit);

        JDateChooser dateDeparture = new JDateChooser();
        dateDeparture.setBounds(119, 135, 178, 20);
        frame.getContentPane().add(dateDeparture);

        JDateChooser dateArrival = new JDateChooser();
        dateArrival.setBounds(409, 135, 178, 20);
        frame.getContentPane().add(dateArrival);

        JSpinner spNrOfSeats = new JSpinner();
        spNrOfSeats.setBounds(119, 245, 89, 20);
        frame.getContentPane().add(spNrOfSeats);

        JLabel lblOrigin = new JLabel("Origin");
        lblOrigin.setBounds(119, 61, 46, 14);
        frame.getContentPane().add(lblOrigin);

        JLabel lblDestination = new JLabel("Destination");
        lblDestination.setBounds(408, 61, 89, 14);
        frame.getContentPane().add(lblDestination);

        JLabel lblDepartureDate = new JLabel("Departure date");
        lblDepartureDate.setBounds(119, 114, 89, 14);
        frame.getContentPane().add(lblDepartureDate);

        JLabel lblArrivalDate = new JLabel("Arrival Date");
        lblArrivalDate.setBounds(409, 110, 151, 14);
        frame.getContentPane().add(lblArrivalDate);

        JLabel lblDepartureTime = new JLabel("Departure Time");
        lblDepartureTime.setBounds(119, 166, 124, 14);
        frame.getContentPane().add(lblDepartureTime);

        JLabel lblArrivalTime = new JLabel("Arrival Time");
        lblArrivalTime.setBounds(409, 166, 124, 14);
        frame.getContentPane().add(lblArrivalTime);

        JLabel lblSeats = new JLabel("Seats");
        lblSeats.setBounds(119, 222, 46, 14);
        frame.getContentPane().add(lblSeats);

        JLabel lblPricePerSeat = new JLabel("Price per seat");
        lblPricePerSeat.setBounds(409, 220, 96, 14);
        frame.getContentPane().add(lblPricePerSeat);
    }
}
