
package hotelManagement;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.Color;

@SuppressWarnings("serial")
public class ServicesFrame extends JFrame {

	private JPanel contentPane;
	private static JCheckBox cb1;
	private static JCheckBox cb2;
	private static JCheckBox cb3;
	public static Customer customer;
	public JLabel lblNewLabel;

	public ServicesFrame(Customer cust) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 597, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ArrayList<Service> servList = new ArrayList<Service>();

		JButton btnNewButton = new JButton("Save & Submit");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (cb1.isSelected()) {
					Service service1 = new Service("Room Cleaning", 1, 10.00, false);
					servList.add(service1);
				}
				if (cb2.isSelected()) {
					Service service2 = new Service("Laundry", 1, 12.00, false);
					servList.add(service2);

				}
				if (cb3.isSelected()) {
					Service service3 = new Service("Airport Transport", 1, 25.00, false);
					servList.add(service3);

				}

				for (int i = 0; i < servList.size(); i++) {
					try {
						FileWriter serfw = new FileWriter("orderedservices.txt", true);
						serfw.write(cust.getName() + ":" + cust.getSurname() + ":" + servList.get(i).getServName() + ":"
								+ servList.get(i).getNumOfServ() + ":" + servList.get(i).getServFee() + ":"
								+ servList.get(i).getStatus() + ":" + System.lineSeparator());
						serfw.close();
						JOptionPane.showMessageDialog(null, " Saved successfully");

					} catch (IOException e1) { // TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		});

		btnNewButton.setBounds(52, 330, 175, 55);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		btnNewButton_1.setBounds(315, 330, 175, 55);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("Extra Services");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(147, 0, 174, 55);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel(
				"<html>Every room is cleaned at 11:00 am<br> regularly if you need extra room cleaning it's  fee is10.00$");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setBounds(237, 81, 216, 55);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("<html>Laundry fee is 12,00 $ upto 3 kgs");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(237, 172, 216, 23);
		contentPane.add(lblNewLabel_2);

		JLabel lblAirportServiceFee = new JLabel("Airport service fee is 25.00 $");
		lblAirportServiceFee.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAirportServiceFee.setForeground(Color.WHITE);
		lblAirportServiceFee.setBounds(241, 251, 199, 23);
		contentPane.add(lblAirportServiceFee);

		cb1 = new JCheckBox("Room Clean");
		cb1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cb1.setBounds(52, 99, 149, 23);
		contentPane.add(cb1);

		cb2 = new JCheckBox("Laundry");
		cb2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cb2.setBounds(52, 172, 160, 23);
		contentPane.add(cb2);

		cb3 = new JCheckBox("Airport Transport");
		cb3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cb3.setBounds(52, 251, 149, 23);
		contentPane.add(cb3);

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setIcon(new ImageIcon("images\\room2.jpg"));
		lblNewLabel_3.setBounds(0, 0, 581, 481);
		contentPane.add(lblNewLabel_3);

	}

	public static void saveservice() {

	}
}
