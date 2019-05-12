package hotelManagement;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class SearchPage extends JFrame {

	private JPanel contentPane;
	private JTextField Data;
	private JTable table;
	private String searchby = "Name";

	public SearchPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 462);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Data = new JTextField();
		Data.setBounds(235, 69, 94, 26);
		contentPane.add(Data);
		Data.setColumns(10);

		JLabel lblCustomerId = new JLabel("Enter");
		lblCustomerId.setForeground(Color.WHITE);
		lblCustomerId.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCustomerId.setBounds(183, 72, 46, 20);
		contentPane.add(lblCustomerId);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 202, 504, 188);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JLabel lblSearchPage = new JLabel("Search Page");
		lblSearchPage.setForeground(Color.WHITE);
		lblSearchPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchPage.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblSearchPage.setBounds(160, 11, 197, 42);
		contentPane.add(lblSearchPage);

		String[] items = new String[] { "Name", "Surname" };
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox comboBox = new JComboBox(items);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboBox.setBounds(99, 69, 69, 26);
		contentPane.add(comboBox);

		comboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					searchby = comboBox.getSelectedItem().toString();

				}
			}
		});

		JLabel lblNewLabel = new JLabel("search By");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(27, 72, 69, 20);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("Back");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
			}
		});
		btnNewButton.setBounds(416, 160, 115, 29);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Customer> CustList = new ArrayList<Customer>();
				String search = Data.getText();

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

				table.setModel(table1);
				table.setAutoResizeMode(0);
				table.getColumnModel().getColumn(0).setPreferredWidth(100);
				table.getColumnModel().getColumn(1).setPreferredWidth(90);
				table.getColumnModel().getColumn(2).setPreferredWidth(90);
				table.getColumnModel().getColumn(3).setPreferredWidth(90);
				table.getColumnModel().getColumn(4).setPreferredWidth(90);
				table.getColumnModel().getColumn(5).setPreferredWidth(90);

				for (int i = 0; i < CustList.size(); i++) {
					Customer cust1 = new Customer();
					cust1 = CustList.get(i);
					if (searchby.equals("Name")) {
						if (search.equals(cust1.getName()))
							table1.addRow(new Object[] { cust1.getName(), cust1.getSurname(), cust1.getPhone(),
									cust1.getEmail(), cust1.getEDate(), cust1.getLDate(), cust1.getTDays() });
					}
					if (searchby.equals("Surname")) {
						if (search.equals(cust1.getSurname()))
							table1.addRow(new Object[] { cust1.getName(), cust1.getSurname(), cust1.getPhone(),
									cust1.getEmail(), cust1.getEDate(), cust1.getLDate(), cust1.getTDays() });
					}
				}

			}
		});
		btnNewButton_1.setBounds(44, 158, 115, 29);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("images\\room2.jpg"));
		lblNewLabel_1.setBounds(0, 0, 552, 423);
		contentPane.add(lblNewLabel_1);
	}
}
