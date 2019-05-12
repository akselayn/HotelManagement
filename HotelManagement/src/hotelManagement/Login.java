package hotelManagement;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login {
	private JFrame frame;
	private JPasswordField passwordField;
	public Customer cust;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		Initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void Initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblUsername = new JLabel("username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setBounds(28, 92, 88, 14);
		frame.getContentPane().add(lblUsername);

		JLabel lblPassword = new JLabel("password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(28, 147, 67, 14);
		frame.getContentPane().add(lblPassword);

		JTextField username = new JTextField();
		username.setBounds(126, 87, 160, 29);
		frame.getContentPane().add(username);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				String username1 = username.getText();

				@SuppressWarnings("deprecation")
				String password1 = passwordField.getText();
				BufferedReader br1;
				try {
					br1 = new BufferedReader(new FileReader("Login.txt"));
					boolean notFound = true;
					String line;
					while (notFound && (line = br1.readLine()) != null) {

						String[] pices = line.split(Pattern.quote(":"));

						if (pices[0].equals(username1) && pices[1].equals(password1)) {
							JOptionPane.showMessageDialog(null, "Login successfully");
							if (pices[2].equals("admin")) {
								this.setVisible(false);
								AdminPage adm = new AdminPage();
								adm.setVisible(true);

							} else if (pices[2].equals("user")) {
								BufferedReader br2;
								try {
									br2 = new BufferedReader(new FileReader("Customers.txt"));
									String line1;
									while ((line1 = br2.readLine()) != null) {

										String[] pieces = line1.split(Pattern.quote(":"));

										String username = pieces[0];
										String name = pieces[1];
										String surname = pieces[2];
										String phone = pieces[3];
										String email = pieces[4];
										String edate = pieces[5];
										String ldate = pieces[6];
										int totaldays = Integer.parseInt(pieces[7]);
										if (username1.equals(username)) {
											cust = new Customer(username, name, surname, phone, email, edate, ldate,
													totaldays);
										}

									}
									br2.close();
								} catch (IOException e1) {
									System.out.println(e1);
									e1.printStackTrace();
								}
								this.setVisible(false);
								UserMenu usm = new UserMenu(cust);
								usm.setVisible(true);

							} else if (pices[2].contentEquals("staff")) {
								this.setVisible(false);
								StaffMenu stm = new StaffMenu();
								stm.setVisible(true);
							}
							notFound = false;

						}
					}
					br1.close();
					if (notFound) {
						JOptionPane.showMessageDialog(null, " your information is wrong");
					}
				}

				catch (IOException e) {
					System.out.println(e);
					e.printStackTrace();
				}
			}

			private void setVisible(boolean b) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Login window = new Login();
							window.frame.setVisible(false);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton.setBounds(76, 203, 89, 23);
		frame.getContentPane().add(btnNewButton);

		JButton btnLogout = new JButton("Cancel");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnLogout.setBounds(213, 203, 89, 23);
		frame.getContentPane().add(btnLogout);

		passwordField = new JPasswordField();
		passwordField.setBounds(126, 144, 160, 20);
		frame.getContentPane().add(passwordField);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("images\\hotel.jpg"));
		lblNewLabel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(lblNewLabel);

	}
}
