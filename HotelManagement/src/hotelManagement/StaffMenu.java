package hotelManagement;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class StaffMenu extends JFrame {
	public StaffMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 478, 520);
		getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("Search page");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchPage src = new SearchPage();
				src.setVisible(true);

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(25, 145, 170, 55);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_2 = new JButton("View Bill");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MakeBill mkb = new MakeBill();
				mkb.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBounds(25, 295, 170, 55);
		getContentPane().add(btnNewButton_2);

		JButton btnFooddrinkServices = new JButton("<html>View Order<br> Room Services");
		btnFooddrinkServices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewOrder vor = new ViewOrder();
				vor.setVisible(true);

			}
		});
		btnFooddrinkServices.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnFooddrinkServices.setBounds(25, 70, 170, 55);
		getContentPane().add(btnFooddrinkServices);

		JButton btnNewButton_3 = new JButton("EXIT");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_3.setBounds(279, 329, 140, 55);
		getContentPane().add(btnNewButton_3);

		JLabel lblUserPage = new JLabel("Staff Page");
		lblUserPage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUserPage.setBounds(146, 11, 197, 40);
		getContentPane().add(lblUserPage);

		JButton btnNewButton_1 = new JButton("View Rooms");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Viewroom vwr = new Viewroom();
				vwr.setVisible(true);

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
