package travelplanner;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPasswordField;

public class registerGUI extends JFrame {
    private JPanel contentPane;
    private JTextField nameField;
    private JTextField lastNameField;
    private JTextField emailField;
    private JTextField passwordField;
    private JTextField passwordConfirmField;
    private SystemController sc = new SystemController();

    /**
     * Launch the application.
     */
    public static void main() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    registerGUI frame = new registerGUI();
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
    public registerGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 528, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        nameField = new JTextField();
        nameField.setBounds(173, 71, 156, 20);
        contentPane.add(nameField);
        nameField.setColumns(10);

        lastNameField = new JTextField();
        lastNameField.setColumns(10);
        lastNameField.setBounds(173, 121, 156, 20);
        contentPane.add(lastNameField);

        emailField = new JTextField();
        emailField.setColumns(10);
        emailField.setBounds(173, 175, 156, 20);
        contentPane.add(emailField);

        passwordField = new JPasswordField();
        passwordField.setColumns(10);
        passwordField.setBounds(173, 229, 156, 20);
        contentPane.add(passwordField);

        passwordConfirmField = new JPasswordField();
        passwordConfirmField.setColumns(10);
        passwordConfirmField.setBounds(173, 281, 156, 20);
        contentPane.add(passwordConfirmField);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(173, 48, 46, 14);
        contentPane.add(lblName);

        JLabel lblLastName = new JLabel("Last Name");
        lblLastName.setBounds(173, 102, 70, 14);
        contentPane.add(lblLastName);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(173, 150, 46, 14);
        contentPane.add(lblEmail);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(173, 206, 70, 14);
        contentPane.add(lblPassword);

        JLabel lblConfirmPassword = new JLabel("Confirm Password");
        lblConfirmPassword.setBounds(173, 260, 116, 14);
        contentPane.add(lblConfirmPassword);

        JButton btnRegister = new JButton("Register");
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (passwordField.getText().equals(passwordConfirmField.getText())) {
                    try {
                        sc.register(emailField.getText(), passwordField.getText(), nameField.getText(), lastNameField.getText());
                    } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(registerGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    System.out.println("passwords doesn't match");
                }
            }
        });
        btnRegister.setBounds(208, 334, 89, 23);
        contentPane.add(btnRegister);
    }
}
