package hotelManagement;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.regex.Pattern;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

@SuppressWarnings("serial")
public class Viewroom extends JFrame {
	private JTable table;

	private String Rbtn;

	public Viewroom() {
		Initialize();
	}

	public void Initialize() {
		getContentPane().setLayout(null);

		JRadioButton singleRbtn = new JRadioButton("Single Room");
		singleRbtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		singleRbtn.setBounds(44, 93, 161, 23);

		getContentPane().add(singleRbtn);
		singleRbtn.setSelected(true);

		JRadioButton doubleRbtn = new JRadioButton("Double Room");
		doubleRbtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		doubleRbtn.setBounds(251, 93, 161, 23);

		ButtonGroup bG = new ButtonGroup();
		bG.add(doubleRbtn);
		bG.add(singleRbtn);
		this.setSize(733, 478);
		getContentPane().add(doubleRbtn);
		this.setVisible(true);

		JButton btnNewButton = new JButton("List Rooms");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
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
		btnNewButton.setBounds(44, 142, 170, 40);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_2 = new JButton("Back To Menu");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();

			}
		});
		btnNewButton_2.setBounds(418, 142, 170, 40);
		getContentPane().add(btnNewButton_2);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(44, 206, 544, 150);
		getContentPane().add(scrollPane_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JLabel lblSelectRoom = new JLabel("View Room");
		lblSelectRoom.setForeground(Color.WHITE);
		lblSelectRoom.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblSelectRoom.setBounds(172, 25, 214, 43);
		getContentPane().add(lblSelectRoom);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("images\\room2.jpg"));
		lblNewLabel.setBounds(0, 0, 717, 439);
		getContentPane().add(lblNewLabel);
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
