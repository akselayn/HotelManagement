package hotelManagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class AddCustomer extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField surname;
	private JTextField phone;
	private JTextField email;
	private JTextField tdate;
	private static String edate = "01-01-2000";
	private static String ldate = "01-01-2000";
	private JTable table;
	private String Rbtn;
	private JTextField username;

	public static long daysBetweenDates(Date d1, Date d2) {// Method for calculating days between two dates.
		Instant instant1 = d1.toInstant();
		Instant instant2 = d2.toInstant();
		long diff = ChronoUnit.DAYS.between(instant1, instant2);
		return diff;
	}

	@SuppressWarnings("deprecation")
	public AddCustomer() {
		setBackground(new Color(128, 128, 128));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 420);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);

		JLabel lblCustomerInformation = new JLabel("Customer Information");
		lblCustomerInformation.setForeground(Color.WHITE);
		lblCustomerInformation.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCustomerInformation.setBounds(212, 22, 164, 19);
		contentPane.add(lblCustomerInformation);

		name = new JTextField();
		name.setBounds(125, 58, 124, 20);
		contentPane.add(name);
		name.setColumns(10);
		name.setNextFocusableComponent(surname);

		surname = new JTextField();
		surname.setColumns(10);
		surname.setBounds(125, 87, 124, 20);
		contentPane.add(surname);
		surname.setNextFocusableComponent(phone);

		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(125, 115, 124, 20);
		contentPane.add(phone);
		phone.setNextFocusableComponent(email);

		email = new JTextField();
		email.setColumns(10);
		email.setBounds(125, 143, 124, 20);
		contentPane.add(email);
		email.setNextFocusableComponent(tdate);
		;

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) { // Getting date if it is selected from datechooser
				if ("date".equals(evt.getPropertyName())) {
					// Get Date
					Date date = dateChooser.getDateEditor().getDate();
					SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
					// Define the format of Date
					String mydate = sf.format(date);
					ldate = mydate;

				} else {
					ldate = null;
				}
			}
		});

		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		dateChooser_1.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if ("date".equals(evt.getPropertyName())) {
					// Get Date
					Date date = dateChooser_1.getDateEditor().getDate();
					SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
					// Define the format of Date
					String mydate = sf.format(date);
					edate = mydate;

				} else {
					edate = null;

				}
			}
		});
		dateChooser_1.setBounds(415, 58, 100, 20);
		contentPane.add(dateChooser_1);
		dateChooser.setBounds(415, 93, 100, 20);
		contentPane.add(dateChooser);

		JButton btnCalculateDays = new JButton("Calculate Days");
		btnCalculateDays.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long totaldays = daysBetweenDates(dateChooser_1.getDateEditor().getDate(),
						dateChooser.getDateEditor().getDate());
				tdate.setText("" + totaldays + "");
			}
		});
		btnCalculateDays.setBounds(415, 120, 100, 23);
		contentPane.add(btnCalculateDays);

		tdate = new JTextField();
		tdate.setColumns(10);
		tdate.setBounds(415, 150, 100, 20);
		contentPane.add(tdate);
		JRadioButton singleRbtn = new JRadioButton("Single Room");
		singleRbtn.setForeground(Color.WHITE);
		singleRbtn.setBackground(Color.LIGHT_GRAY);
		singleRbtn.setBounds(40, 212, 109, 23);
		contentPane.add(singleRbtn);

		JRadioButton doubleRbtn = new JRadioButton("Double Room");
		doubleRbtn.setForeground(Color.WHITE);
		doubleRbtn.setBackground(Color.LIGHT_GRAY);
		doubleRbtn.setBounds(151, 212, 109, 23);
		contentPane.add(doubleRbtn);
		ButtonGroup bG = new ButtonGroup();
		bG.add(doubleRbtn);
		bG.add(singleRbtn);
		this.setSize(588, 509);
		getContentPane().add(doubleRbtn);
		this.setVisible(true);

		JButton btnavlRoom = new JButton("Available Room");
		btnavlRoom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnavlRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // If Available room button is clicked
				ArrayList<Rooms> roomList = new ArrayList<Rooms>(); // Reads Room details from file and store to
																	// Arraylist according to
				if (getSelectedButtonText(bG).equals("Single Room")) { // user's selection made by radiobuttons.
					Rbtn = "single";
				} else {
					Rbtn = "double";
				}
				{
					BufferedReader br1;
					try {
						br1 = new BufferedReader(new FileReader("Rooms.txt"));
						String line;
						while ((line = br1.readLine()) != null) {

							String[] pieces = line.split(Pattern.quote(":"));

							String RoomID = pieces[0];
							String rtype = pieces[1];
							String name = pieces[2];
							String surname = pieces[3];
							String edate = pieces[4];
							String ldate = pieces[5];

							Rooms room1 = new doubleRoom(RoomID, rtype, name, surname, edate, ldate);
							if (rtype.equals(Rbtn))
								roomList.add(room1);

						}
						br1.close();
					}

					catch (IOException e1) {
						System.out.println(e1);
						e1.printStackTrace();
					}
					DefaultTableModel table1 = new DefaultTableModel();

					table1.addColumn("RoomID");
					table1.addColumn("Type");
					table1.addColumn("Name");
					table1.addColumn("Surname");
					table1.addColumn("Entering D");
					table1.addColumn("Leaving D");
					for (int i = 0; i < roomList.size(); i++) {
						table1.addRow(new Object[] { roomList.get(i).getRoomID(), roomList.get(i).getRoomType(),
								roomList.get(i).getCustName(), roomList.get(i).getCustSurname(),
								roomList.get(i).getEntDate(), roomList.get(i).getLeaDate(), });
					}
					table.setModel(table1);
					table.setAutoResizeMode(0);
					table.getColumnModel().getColumn(0).setPreferredWidth(100);
					table.getColumnModel().getColumn(1).setPreferredWidth(90);
					table.getColumnModel().getColumn(2).setPreferredWidth(90);
					table.getColumnModel().getColumn(3).setPreferredWidth(90);
					table.getColumnModel().getColumn(4).setPreferredWidth(90);

				}
			}
		});
		btnavlRoom.setBounds(345, 212, 170, 23);
		contentPane.add(btnavlRoom);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 242, 469, 100);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSave.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) { // Saving entered customer information to the file
				try {
					FileWriter customer = new FileWriter("Customers.txt", true);
					customer.write(username.getText() + ":" + name.getText() + ":" + surname.getText() + ":"
							+ phone.getText() + ":" + email.getText() + ":" + edate + ":" + ldate + ":"
							+ tdate.getText() + ":" + System.lineSeparator());
					customer.close();
					JOptionPane.showMessageDialog(null, " Saved successfully");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSave.setBounds(46, 369, 175, 23);
		contentPane.add(btnSave);

		JButton btnBackToMenue = new JButton("Back to menu");
		btnBackToMenue.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBackToMenue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { // Disposing current frame if back to menu button is
															// clicked.
				AdminPage adm = new AdminPage();
				adm.setVisible(true);
				dispose();
			}
		});
		btnBackToMenue.setBounds(345, 369, 170, 23);
		contentPane.add(btnBackToMenue);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblName.setForeground(Color.WHITE);
		lblName.setBounds(40, 64, 69, 14);
		contentPane.add(lblName);

		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSurname.setForeground(Color.WHITE);
		lblSurname.setBounds(40, 91, 69, 14);
		contentPane.add(lblSurname);

		JLabel lblPhone = new JLabel("Phone ");
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPhone.setForeground(Color.WHITE);
		lblPhone.setBounds(40, 121, 69, 14);
		contentPane.add(lblPhone);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBounds(40, 149, 69, 14);
		contentPane.add(lblEmail);

		JLabel lblDate = new JLabel("EDate");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDate.setForeground(Color.WHITE);
		lblDate.setBounds(325, 64, 69, 14);
		contentPane.add(lblDate);

		JLabel lblLdate = new JLabel("LDate");
		lblLdate.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLdate.setForeground(Color.WHITE);
		lblLdate.setBounds(325, 99, 69, 14);
		contentPane.add(lblLdate);

		JLabel lblTotalDays = new JLabel("Total Days");
		lblTotalDays.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTotalDays.setForeground(Color.WHITE);
		lblTotalDays.setBounds(325, 152, 80, 14);
		contentPane.add(lblTotalDays);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setIcon(new ImageIcon("images\\room2.jpg"));
		lblNewLabel.setBounds(0, 0, 572, 470);
		contentPane.add(lblNewLabel);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUsername.setBounds(40, 175, 69, 14);
		contentPane.add(lblUsername);

		username = new JTextField();
		username.setColumns(10);
		username.setBounds(125, 173, 124, 20);
		contentPane.add(username);
	}

	public static String getEdate() {
		return edate;
	}

	public static String getLdate() {
		return ldate;
	}

	public String getSelectedButtonText(ButtonGroup buttonGroup) { // Establishing relation between radiobuttons by
																	// using buttonGroup.
		for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();

			if (button.isSelected()) {
				return button.getText();
			}
		}
		return null;
	}
}
