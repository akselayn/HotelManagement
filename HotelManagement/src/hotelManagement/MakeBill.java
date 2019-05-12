package hotelManagement;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class MakeBill extends JFrame {
	private JTable table;
	int row;
	private JTextArea textArea;
	private static String formattedDate;
	private ArrayList<String> lines = new ArrayList<String>();;
	private String servlines = "";
	private double RoomFee;
	private double servtotal;

	public MakeBill() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 478, 583);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 95, 442, 73);
		getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 213, 442, 256);
		getContentPane().add(scrollPane_1);

		textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);

		JButton btnListCustomers = new JButton("List  Customers");
		btnListCustomers.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnListCustomers.addActionListener(new ActionListener() {
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
		btnListCustomers.setBounds(10, 61, 442, 23);
		getContentPane().add(btnListCustomers);

		JButton button_1 = new JButton("Back to Menu");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setBounds(10, 496, 444, 23);
		getContentPane().add(button_1);

		JButton btnViewSelectedCustomers = new JButton("View Selected Customers Bill");
		btnViewSelectedCustomers.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnViewSelectedCustomers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				row = table.getSelectedRow();
				Customer cust = new Customer(table.getValueAt(row, 0).toString(), table.getValueAt(row, 1).toString(),
						table.getValueAt(row, 2).toString(), table.getValueAt(row, 3).toString(),
						table.getValueAt(row, 4).toString(), table.getValueAt(row, 5).toString(),
						Integer.parseInt(table.getValueAt(row, 6).toString()));
				String rtype = cust.getRoomtype();
				if (rtype.equals("single")) {
					RoomFee = cust.getTDays() * 170.00;
				} else {
					RoomFee = cust.getTDays() * 220.00;
				}
				BufferedReader br1;
				try {

					br1 = new BufferedReader(new FileReader("carriedservices.txt"));
					String line;

					while ((line = br1.readLine()) != null) {

						String[] pieces = line.split(Pattern.quote(":"));
						if (pieces[0].equals(cust.getName()) && pieces[1].equals(cust.getSurname())) {
							double linetotal = Integer.parseInt(pieces[3]) * Double.parseDouble(pieces[4]);
							lines.add("" + pieces[2] + "\t" + pieces[3] + "\t" + pieces[4] + "\t" + linetotal);
							servtotal += linetotal;

						}
					}
					br1.close();
				}

				catch (IOException e1) {
					System.out.println(e1);
					e1.printStackTrace();
				}
				for (int i = 0; i < lines.size(); i++) {

					servlines += "\n" + lines.get(i);
				}

				getCurrentTimeUsingCalendar();
				textArea.append("\t Billing Information\n " + "\t\t\tDate:" + formattedDate
						+ "\n==========================================\t" + "\n Name:" + cust.getName() + "\tSurname: "
						+ cust.getSurname() + "\n_________________________________________________"
						+ "\n__________________Room Details______________________" + "\nEntering Date:"
						+ cust.getEDate() + "\t Leaving Date:" + cust.getLDate() + "\nTotal Days:" + cust.getTDays()
						+ "\t" + cust.getRoomtype() + "\t\t\t" + RoomFee
						+ "\n__________________Service Details______________________\nDescription\tUnits\tU.Price\tTotal\n"
						+ servlines + "\n_________________________________________________"
						+ "\n TOTAL to be paid:\t\t\t" + (servtotal + RoomFee));

			}
		});
		btnViewSelectedCustomers.setBounds(10, 179, 442, 23);
		getContentPane().add(btnViewSelectedCustomers);

		JLabel lblBillCustomer = new JLabel("Bill Customer");
		lblBillCustomer.setHorizontalAlignment(SwingConstants.CENTER);
		lblBillCustomer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBillCustomer.setBounds(10, 11, 423, 33);
		getContentPane().add(lblBillCustomer);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("images\\hotel.jpg"));
		lblNewLabel.setBounds(0, 0, 462, 544);
		getContentPane().add(lblNewLabel);
	}

	public static void getCurrentTimeUsingCalendar() {
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		DateFormat dateFormat = new SimpleDateFormat("dd:MM:YYYY");
		formattedDate = dateFormat.format(date);
	}
}
