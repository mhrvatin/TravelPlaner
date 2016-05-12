package travelplanner;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class bookGUI extends JFrame {
    private JPanel contentPane;
    private JTextField txtOrigin;
    private JTextField txtPrice;
    private JTextField txtDate;
    private JTextField txtTime;
    private JTextField txtDate_2;
    private JTextField txtTime_2;

    /**
     * Launch the application.
     */
    public static void main() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    bookGUI frame = new bookGUI();
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
    public bookGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 810, 508);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        txtOrigin = new JTextField();
        txtOrigin.setBounds(81, 87, 176, 20);
        contentPane.add(txtOrigin);
        txtOrigin.setColumns(10);

        JTextField txtDestination = new JTextField();
        txtDestination.setColumns(10);
        txtDestination.setBounds(81, 144, 176, 20);
        contentPane.add(txtDestination);

        txtPrice = new JTextField();
        txtPrice.setColumns(10);
        txtPrice.setBounds(81, 261, 58, 20);
        contentPane.add(txtPrice);

        txtDate = new JTextField();
        txtDate.setBounds(399, 87, 86, 20);
        contentPane.add(txtDate);
        txtDate.setColumns(10);

        txtTime = new JTextField();
        txtTime.setColumns(10);
        txtTime.setBounds(559, 87, 86, 20);
        contentPane.add(txtTime);

        txtDate_2 = new JTextField();
        txtDate_2.setColumns(10);
        txtDate_2.setBounds(399, 144, 86, 20);
        contentPane.add(txtDate_2);

        txtTime_2 = new JTextField();
        txtTime_2.setColumns(10);
        txtTime_2.setBounds(559, 144, 86, 20);
        contentPane.add(txtTime_2);

        JLabel lblOrigin = new JLabel("Origin");
        lblOrigin.setBounds(81, 62, 46, 14);
        contentPane.add(lblOrigin);

        JLabel lblDestination = new JLabel("Destination");
        lblDestination.setBounds(81, 118, 136, 14);
        contentPane.add(lblDestination);

        JLabel lblEnterPassengers = new JLabel("Enter Nr Of Passengers");
        lblEnterPassengers.setBounds(81, 179, 136, 14);
        contentPane.add(lblEnterPassengers);

        JLabel lblPrice = new JLabel("Price");
        lblPrice.setBounds(81, 235, 46, 14);
        contentPane.add(lblPrice);

        JLabel lblDate = new JLabel("Date");
        lblDate.setBounds(399, 62, 46, 14);
        contentPane.add(lblDate);

        JLabel lblDate_2 = new JLabel("Date");
        lblDate_2.setBounds(399, 118, 46, 14);
        contentPane.add(lblDate_2);

        JLabel lblTime = new JLabel("Time");
        lblTime.setBounds(559, 62, 46, 14);
        contentPane.add(lblTime);

        JLabel lblTime_2 = new JLabel("Time");
        lblTime_2.setBounds(559, 119, 46, 14);
        contentPane.add(lblTime_2);

        JSpinner spPassengers = new JSpinner();
        spPassengers.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent arg0) {
                txtPrice.setText("Funkar");
            }
        });
        spPassengers.setBounds(81, 204, 29, 20);
        contentPane.add(spPassengers);

        JButton btnBook = new JButton("Book");
        btnBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                payGUI test = new payGUI();
                test.main();
                dispose();
            }
        });
        btnBook.setBounds(278, 362, 89, 23);
        contentPane.add(btnBook);
    }
}
