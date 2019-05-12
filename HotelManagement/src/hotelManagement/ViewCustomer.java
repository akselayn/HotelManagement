package hotelManagement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.Color;

@SuppressWarnings("serial")
public class ViewCustomer extends JFrame {
	private JTable table;

	public ViewCustomer() {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setBounds(100, 100, 568, 520);
		getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("View Customers");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Customer> CustList = new ArrayList<Customer>();

				BufferedReader br1;
				try {
					br1 = new BufferedReader(new FileReader("Customers.txt"));
					String line;
					while ((line = br1.readLine()) != null) {

						String[] pieces = line.split(Pattern.quote(":"));

						String username = pieces[0];
						String name = pieces[1];
						String surname = pieces[2];
						String phone = pieces[3];
						String email = pieces[4];
						String edate = pieces[5];
						String ldate = pieces[6];
						int totaldays = Integer.parseInt(pieces[7]);

						Customer cust = new Customer(username, name, surname, phone, email, edate, ldate, totaldays);
						CustList.add(cust);

					}
					br1.close();
				}

				catch (IOException e1) {
					System.out.println(e1);
					e1.printStackTrace();
				}
				DefaultTableModel table1 = new DefaultTableModel();

				table1.addColumn("Name");
				table1.addColumn("Surname");
				table1.addColumn("Phone");
				table1.addColumn("Email");
				table1.addColumn("Entering D");
				table1.addColumn("Leaving D");
				table1.addColumn("Total Days");
				for (int i = 0; i < CustList.size(); i++) {
					table1.addRow(new Object[] { CustList.get(i).getName(), CustList.get(i).getSurname(),
							CustList.get(i).getPhone(), CustList.get(i).getEmail(), CustList.get(i).getEDate(),
							CustList.get(i).getLDate(), "" + CustList.get(i).getTDays() + "", });
				}
				table.setModel(table1);
				table.setAutoResizeMode(0);
				table.getColumnModel().getColumn(0).setPreferredWidth(100);
				table.getColumnModel().getColumn(1).setPreferredWidth(90);
				table.getColumnModel().getColumn(2).setPreferredWidth(90);
				table.getColumnModel().getColumn(3).setPreferredWidth(90);
				table.getColumnModel().getColumn(4).setPreferredWidth(90);
				table.getColumnModel().getColumn(5).setPreferredWidth(90);

			}
		});
		btnNewButton.setBounds(31, 77, 170, 23);
		getContentPane().add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 113, 490, 358);
		getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JButton btnNewButton_1 = new JButton("Back to Menu");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
			}
		});
		btnNewButton_1.setBounds(344, 77, 170, 23);
		getContentPane().add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("View Customers");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(184, 11, 170, 31);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("images\\hotel.jpg"));
		lblNewLabel_1.setBounds(0, 0, 552, 481);
		getContentPane().add(lblNewLabel_1);
	}
}
