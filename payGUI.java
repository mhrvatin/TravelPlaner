package travelplanner;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class payGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtCardNr;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					payGUI frame = new payGUI();
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
	public payGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setBounds(77, 126, 46, 14);
		contentPane.add(lblPrice);
		
		JLabel lblDisplayPrice = new JLabel("Displaying Price");
		lblDisplayPrice.setBounds(161, 126, 162, 14);
		contentPane.add(lblDisplayPrice);
		
		JLabel lblCardNr = new JLabel("Card Nr:");
		lblCardNr.setBounds(77, 172, 46, 14);
		contentPane.add(lblCardNr);
		
		txtCardNr = new JTextField();
		txtCardNr.setBounds(161, 169, 342, 20);
		contentPane.add(txtCardNr);
		txtCardNr.setColumns(10);
		
		JLabel lblReceipt = new JLabel("Receipt sent to:");
		lblReceipt.setBounds(77, 222, 77, 14);
		contentPane.add(lblReceipt);
		
		JLabel lblUserEmail = new JLabel("User Email");
		lblUserEmail.setBounds(161, 222, 226, 14);
		contentPane.add(lblUserEmail);
		
		JButton btnPay = new JButton("Pay");
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  dispose();
			}
		});
		btnPay.setBounds(77, 328, 89, 23);
		contentPane.add(btnPay);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(331, 11, 89, 21);
		contentPane.add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(429, 11, 89, 21);
		contentPane.add(btnRegister);
	}

}
