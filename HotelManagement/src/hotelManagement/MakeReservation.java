package hotelManagement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.regex.Pattern;
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
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class MakeReservation extends JFrame {
	private JTable table;
	private String Rbtn;
	int column = 0;
	int row;
	private static String edate = "01-01-2000";
	private static String ldate = "01-01-2000";
	private static String tdate = "";

	public MakeReservation(Customer cust) {
		getContentPane().setLayout(null);

		JRadioButton doubleRbtn = new JRadioButton("Double Room");
		doubleRbtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		doubleRbtn.setBounds(59, 66, 140, 23);
		getContentPane().add(doubleRbtn);

		JRadioButton singleRbtn = new JRadioButton("Single Room");
		singleRbtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		singleRbtn.setBounds(201, 66, 132, 23);
		getContentPane().add(singleRbtn);
		ButtonGroup bG = new ButtonGroup();
		bG.add(doubleRbtn);
		bG.add(singleRbtn);
		this.setSize(602, 468);
		getContentPane().add(doubleRbtn);
		this.setVisible(true);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
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
		getContentPane().add(dateChooser_1);
		dateChooser.setBounds(415, 93, 100, 20);
		getContentPane().add(dateChooser);

		JButton btnNewButton = new JButton("View Rooms");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Rooms> roomList = new ArrayList<Rooms>();
				if (getSelectedButtonText(bG).equals("Single Room")) {
					Rbtn = "single";
				} else {
					Rbtn = "double";
				}
				{
					BufferedReader br1;
					try {
						br1 = new BufferedReader(new FileReader("Rooms.txt"));
						String line = br1.readLine();
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
					table1.addColumn("Entering D");
					table1.addColumn("Leaving D");
					for (int i = 0; i < roomList.size(); i++) {
						table1.addRow(new Object[] { roomList.get(i).getRoomID(), roomList.get(i).getRoomType(),
								roomList.get(i).getEntDate(), roomList.get(i).getLeaDate(), });
					}
					table.setModel(table1);
					table.setAutoResizeMode(0);
					table.getColumnModel().getColumn(0).setPreferredWidth(100);
					table.getColumnModel().getColumn(1).setPreferredWidth(90);
					table.getColumnModel().getColumn(2).setPreferredWidth(90);
					table.getColumnModel().getColumn(3).setPreferredWidth(90);

				}
			}
		});
		btnNewButton.setBounds(47, 100, 127, 39);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Save & Submit");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				row = table.getSelectedRow();
				long totaldays = daysBetweenDates(dateChooser_1.getDateEditor().getDate(),
						dateChooser.getDateEditor().getDate());
				tdate = "" + totaldays + "";
				try {
					FileWriter serfw = new FileWriter("Rooms.txt", true);
					serfw.write(table.getModel().getValueAt(row, column).toString() + ":"
							+ table.getModel().getValueAt(row, 1).toString() + ":" + cust.getName() + ":"
							+ cust.getSurname() + ":" + edate + ":" + ldate + ":" + System.lineSeparator());
					serfw.close();
					JOptionPane.showMessageDialog(null, " Saved to Rooms successfully");

				} catch (IOException e1) { // TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					FileWriter customer = new FileWriter("Customers.txt", true);
					customer.write(cust.getUsername() + ":" + cust.getName() + ":" + cust.getSurname() + ":"
							+ cust.getPhone() + ":" + cust.getEmail() + ":" + edate + ":" + ldate + ":" + tdate + ":"
							+ System.lineSeparator());
					customer.close();
					JOptionPane.showMessageDialog(null, " Saved to Customer successfully");

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(47, 311, 149, 51);
		getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Cancel");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton_2.setBounds(414, 311, 145, 51);
		getContentPane().add(btnNewButton_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 150, 500, 150);
		getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("Make Reservation");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(163, 11, 260, 37);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("images\\room2.jpg"));
		lblNewLabel_1.setBounds(0, 0, 586, 429);
		getContentPane().add(lblNewLabel_1);

	}

	public static long daysBetweenDates(Date d1, Date d2) {
		Instant instant1 = d1.toInstant();
		Instant instant2 = d2.toInstant();
		long diff = ChronoUnit.DAYS.between(instant1, instant2);
		return diff;
	}

	public String getSelectedButtonText(ButtonGroup buttonGroup) {
		for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();

			if (button.isSelected()) {
				return button.getText();
			}
		}

		return null;
	}
}
