package hotelManagement;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class UserMenu extends JFrame {

	public UserMenu(Customer cust) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 478, 520);
		getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("Other Services");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ServicesFrame srv = new ServicesFrame(cust);
				srv.setVisible(true);

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(25, 145, 170, 55);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_2 = new JButton("View Bill");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewBill vwb = new ViewBill(cust);
				vwb.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBounds(25, 295, 170, 55);
		getContentPane().add(btnNewButton_2);

		JButton btnFooddrinkServices = new JButton("<html>Food&Beverage<br> Services");
		btnFooddrinkServices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FoodBeverage fdbv = new FoodBeverage(cust);
				fdbv.setVisible(true);
			}
		});
		btnFooddrinkServices.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnFooddrinkServices.setBounds(25, 70, 170, 55);
		getContentPane().add(btnFooddrinkServices);

		JButton btnNewButton_3 = new JButton("EXIT");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_3.setBounds(279, 329, 140, 55);
		getContentPane().add(btnNewButton_3);

		JLabel lblUserPage = new JLabel("User Page");
		lblUserPage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUserPage.setBounds(146, 11, 197, 40);
		getContentPane().add(lblUserPage);

		JButton btnNewButton_1 = new JButton("Make Reservation");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MakeReservation mrv = new MakeReservation(cust);
				mrv.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(25, 223, 170, 55);
		getContentPane().add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("images\\hotel.jpg"));
		lblNewLabel.setBounds(0, 0, 462, 481);
		getContentPane().add(lblNewLabel);
	}
}
