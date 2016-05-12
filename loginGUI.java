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

public class loginGUI extends JFrame {
    private JPanel contentPane;
    private JTextField usernameField;
    private JTextField passwordField;
    private SystemController sc = new SystemController();

    /**
     * Launch the application.
     */
    public static void main() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    loginGUI frame = new loginGUI();
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
    public loginGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 460, 472);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        usernameField = new JTextField();
        usernameField.setBounds(127, 107, 196, 20);
        contentPane.add(usernameField);
        usernameField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(127, 177, 196, 20);
        contentPane.add(passwordField);
        passwordField.setColumns(10);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(127, 150, 46, 14);
        contentPane.add(lblPassword);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(127, 74, 78, 14);
        contentPane.add(lblUsername);

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    boolean res = sc.login(usernameField.getText(), passwordField.getText());
                    
                    if (res) {
                        System.out.println("res true, successfully logged in");
                        dispose(); // temp
                    } else {
                        System.out.println("res false");
                    }
                    
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(loginGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btnLogin.setBounds(182, 250, 89, 23);
        contentPane.add(btnLogin);
    }

}
