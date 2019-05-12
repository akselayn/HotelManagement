package hotelManagement;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.regex.Pattern;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;

@SuppressWarnings("serial")
public class ViewBill extends JFrame {
	private JTextArea textArea;
	private static String formattedDate;
	private ArrayList<String> lines = new ArrayList<String>();;
	private String servlines = "";
	private double RoomFee;
	private double servtotal;

	public static void getCurrentTimeUsingCalendar() {
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		DateFormat dateFormat = new SimpleDateFormat("dd:MM:YYYY");
		formattedDate = dateFormat.format(date);
	}

	public ViewBill(Customer cust) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 470);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 118, 450, 262);
		getContentPane().add(scrollPane);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		JButton btnNewButton = new JButton("Back To Menu");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(335, 72, 163, 35);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Calculate Bill");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		btnNewButton_1.setBounds(48, 72, 163, 35);
		getContentPane().add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("View Bill");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(94, 25, 365, 29);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("images\\hotel.jpg"));
		lblNewLabel_1.setBounds(0, 0, 562, 431);
		getContentPane().add(lblNewLabel_1);

	}
}
