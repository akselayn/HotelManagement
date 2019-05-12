package hotelManagement;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.ImageIcon;

public class AddUser extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField userName;
	private JTextField passWord;
	private String usertype = "user";

	public void setUserType(String n) {
		this.usertype = n;
	}

	public String getUsertype() {
		return this.usertype;
	}

	public AddUser() {
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 478, 320);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Add New User");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(59, 11, 200, 25);
		getContentPane().add(lblNewLabel);

		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUserName.setForeground(Color.WHITE);
		lblUserName.setBounds(40, 99, 81, 14);
		getContentPane().add(lblUserName);

		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(40, 124, 81, 14);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("User Type");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(47, 152, 81, 14);
		getContentPane().add(lblNewLabel_2);

		userName = new JTextField();
		userName.setBounds(138, 96, 156, 20);
		getContentPane().add(userName);
		userName.setColumns(10);

		passWord = new JTextField();
		passWord.setBounds(138, 121, 156, 20);
		getContentPane().add(passWord);
		passWord.setColumns(10);

		String[] items = new String[] { "admin", "customer", "staff" };
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox comboBox = new JComboBox(items);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboBox.setBounds(138, 148, 156, 26);
		getContentPane().add(comboBox);

		comboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					setUserType(comboBox.getSelectedItem().toString());

				}
			}
		});

		JButton btnNewButton = new JButton("Save");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FileWriter customer = new FileWriter("Login.txt", true);
					customer.write(userName.getText() + ":" + passWord.getText() + ":" + usertype + ":"
							+ System.lineSeparator());
					customer.close();
					JOptionPane.showMessageDialog(null, " Saved successfully");

				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(40, 196, 150, 30);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Back To Menu");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AdminPage adm = new AdminPage();
				adm.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(233, 196, 150, 30);
		getContentPane().add(btnNewButton_1);

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("images\\hotel.jpg"));
		lblNewLabel_3.setBounds(0, 0, 462, 281);
		contentPane.add(lblNewLabel_3);
	}
}
