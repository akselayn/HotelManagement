package hotelManagement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class ViewOrder extends JFrame {
	private JTable table;
	int column = 0;
	int row;
	private Service serv;

	public ViewOrder() {

		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 430);

		JLabel lblNewLabel = new JLabel("View Orders");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(185, 11, 239, 44);
		getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("Back To Menu"); // When back to menu is clicked current frame is disposed.
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(462, 277, 150, 35);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Finish Order");
		btnNewButton_1.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { // When finish order button is clicked selected service in
															// table
				row = table.getSelectedRow(); // is deleted from orderedservices file and carriedservice file
				ArrayList<Service> servList = new ArrayList<Service>();
				BufferedReader br1;
				try {
					br1 = new BufferedReader(new FileReader("orderedservices.txt"));
					String line;
					while ((line = br1.readLine()) != null) {

						String[] pieces = line.split(Pattern.quote(":"));
						if (table.getModel().getValueAt(row, 0).equals(pieces[0])
								&& table.getModel().getValueAt(row, 2).equals(pieces[2])) {
							FileWriter serfw;
							try {
								serfw = new FileWriter("carriedservices.txt", true);

								serfw.write(pieces[0] + ":" + pieces[1] + ":" + pieces[2] + ":" + pieces[3] + ":"
										+ pieces[4] + ":" + "true" + ":" + System.lineSeparator());

								serfw.close();

							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						} else {
							serv = new Service(pieces[0], pieces[1], pieces[2], 1, Double.parseDouble(pieces[4]),
									Boolean.parseBoolean(pieces[5]));
							servList.add(serv);
						}

					}
					br1.close();
				}

				catch (IOException e1) {
					System.out.println(e1);
					e1.printStackTrace();
				}
				FileWriter serfw1;
				try {
					serfw1 = new FileWriter("orderedservices.txt", false);
					for (int i = 0; i < servList.size(); i++) {

						serfw1.write(servList.get(i).getCustName() + ":" + servList.get(i).getCustSName() + ":"
								+ servList.get(i).getServName() + ":" + servList.get(i).getNumOfServ() + ":"
								+ servList.get(i).getServFee() + ":" + servList.get(i).getStatus() + ":"
								+ System.lineSeparator());
					}
					serfw1.close();
					JOptionPane.showMessageDialog(null, " Saved successfully");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});
		btnNewButton_1.setBounds(37, 277, 150, 35);
		getContentPane().add(btnNewButton_1);

		JButton btnViewOrders = new JButton("View Orders");
		btnViewOrders.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnViewOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { // When view order button is clicked ordered services are
															// read
				DefaultTableModel table1 = new DefaultTableModel(); // from file and listed in table.
				table1.addColumn("C.Name");
				table1.addColumn("Surname");
				table1.addColumn("Service");
				table1.addColumn("Numbers");
				table1.addColumn("Fee");
				table1.addColumn("Carried Out");

				table.setModel(table1);
				table.setAutoResizeMode(0);
				table.getColumnModel().getColumn(0).setPreferredWidth(100);
				table.getColumnModel().getColumn(1).setPreferredWidth(90);
				table.getColumnModel().getColumn(2).setPreferredWidth(90);
				table.getColumnModel().getColumn(3).setPreferredWidth(90);
				table.getColumnModel().getColumn(4).setPreferredWidth(100);
				table.getColumnModel().getColumn(5).setPreferredWidth(80);
				BufferedReader br1;
				try {

					br1 = new BufferedReader(new FileReader("orderedservices.txt"));
					String line;
					while ((line = br1.readLine()) != null) {

						String[] pieces = line.split(Pattern.quote(":"));
						table1.addRow(
								new Object[] { pieces[0], pieces[1], pieces[2], pieces[3], pieces[4], pieces[5] });
					}
					br1.close();
				}

				catch (IOException e1) {
					System.out.println(e1);
					e1.printStackTrace();
				}
			}
		});
		btnViewOrders.setBounds(27, 50, 136, 35);
		getContentPane().add(btnViewOrders);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 100, 608, 166);
		getContentPane().add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("images\\hotel.jpg"));
		lblNewLabel_1.setBounds(0, 0, 664, 391);
		getContentPane().add(lblNewLabel_1);

	}

}
