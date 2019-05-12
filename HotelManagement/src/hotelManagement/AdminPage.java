package hotelManagement;

import java.awt.Button;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.SwingConstants;

public class AdminPage {

	private JFrame frame;
	static AddCustomer adc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPage window = new AdminPage();
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
	public AdminPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 524, 457);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblAdinistrationPage = new JLabel("Administration Page ");
		lblAdinistrationPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdinistrationPage.setForeground(Color.BLACK);
		lblAdinistrationPage.setBounds(123, 10, 237, 42);
		lblAdinistrationPage.setFont(new Font("Times New Roman", Font.BOLD, 19));
		frame.getContentPane().add(lblAdinistrationPage);

		JButton btnAddNewCustomer = new JButton("Add new customer");
		btnAddNewCustomer.setToolTipText("Add new customer info");
		btnAddNewCustomer.setBounds(39, 63, 151, 31);
		btnAddNewCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCustomer adc = new AddCustomer();
				adc.setVisible(true);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnAddNewCustomer);

		JButton btnNewButton = new JButton("View customer ");
		btnNewButton.setToolTipText("To view Customer info");
		btnNewButton.setBounds(39, 105, 151, 31);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewCustomer vwc = new ViewCustomer();
				vwc.setVisible(true);

			}
		});
		frame.getContentPane().add(btnNewButton);

		JButton btnAddUser = new JButton("Add User");
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddUser aur = new AddUser();
				aur.setVisible(true);
				frame.dispose();
			}
		});

		JButton btnNewButton_1 = new JButton("Search ");
		btnNewButton_1.setToolTipText("Search customer");
		btnNewButton_1.setBounds(39, 151, 151, 31);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchPage spg = new SearchPage();
				spg.setVisible(true);
			}
		});
		frame.getContentPane().add(btnNewButton_1);
		btnAddUser.setToolTipText("Adding new user ");
		btnAddUser.setBounds(39, 193, 151, 31);
		frame.getContentPane().add(btnAddUser);

		JButton btnCheckout = new JButton("check out");
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MakeBill mkb = new MakeBill();
				mkb.setVisible(true);
			}
		});
		btnCheckout.setBounds(39, 280, 151, 31);
		frame.getContentPane().add(btnCheckout);

		Button button = new Button("Cancel");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, " thank you");
				frame.dispose();
			}
		});
		button.setBounds(255, 121, 117, 31);
		frame.getContentPane().add(button);

		JButton btnViewroom = new JButton("View Room");
		btnViewroom.setToolTipText("viewing room details");
		btnViewroom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Viewroom vwr = new Viewroom();
				vwr.setVisible(true);

			}
		});
		btnViewroom.setBounds(39, 235, 151, 31);
		frame.getContentPane().add(btnViewroom);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("images\\hotel.jpg"));
		lblNewLabel.setBounds(0, 0, 508, 418);
		frame.getContentPane().add(lblNewLabel);
	}

	public void setVisible(boolean b) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPage window = new AdminPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
