package hotelManagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class FoodBeverage extends JFrame {
	private JCheckBox friesCB;
	private JCheckBox hamburgerCB;
	private JCheckBox onionRingCB;
	private JCheckBox gSaladCB;
	private JCheckBox cSaladCB;
	private JCheckBox chickSandCB;
	private JCheckBox chesSandCB;
	private JCheckBox chocMufCB;
	private JCheckBox fishSandCB;
	private JCheckBox brownieCB;
	private JCheckBox lemChesCB;
	private JCheckBox berryChesCB;
	private JCheckBox pancakeCB;
	private JCheckBox teaCB;
	private JCheckBox coffeeCB;
	private JCheckBox colaCB;
	private JCheckBox orangeJuiceCB;
	private JCheckBox waterCB;
	private JCheckBox chocoShakeCB;
	private JCheckBox strawberryShakeCB;
	private JCheckBox bananaShakeCB;

	private JTextField lemChesTF;
	private JTextField berryChesTF;
	private JTextField pancakeTF;
	private JTextField friesTF;
	private JTextField hamburgerTF;
	private JTextField onionRingTF;
	private JTextField gSaladTF;
	private JTextField cSaladTF;
	private JTextField chickSandTF;
	private JTextField chesSandTF;
	private JTextField fishSandTF;
	private JTextField chocMufTF;
	private JTextField brownieTF;
	private JTextField teaTF;
	private JTextField coffeeTF;
	private JTextField colaTF;
	private JTextField orangeJuiceTF;
	private JTextField waterTF;
	private JTextField chocoShakeTF;
	private JTextField strawberryShakeTF;
	private JTextField bananaShakeTF;

	private JButton saveButton;
	private JButton cancelButton;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	ArrayList<Service> servList = new ArrayList<Service>();

	public FoodBeverage(Customer cust) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 778, 520);
		getContentPane().setLayout(null);

		friesCB = new JCheckBox("Fries");
		friesCB.setBounds(36, 89, 97, 23);
		getContentPane().add(friesCB);

		hamburgerCB = new JCheckBox("Hamburger");
		hamburgerCB.setBounds(36, 124, 97, 23);
		getContentPane().add(hamburgerCB);

		onionRingCB = new JCheckBox("Onion Rings");
		onionRingCB.setBounds(36, 160, 97, 23);
		getContentPane().add(onionRingCB);

		gSaladCB = new JCheckBox("Green Salad");
		gSaladCB.setBounds(36, 194, 97, 23);
		getContentPane().add(gSaladCB);

		cSaladCB = new JCheckBox("Ceasar Salad");
		cSaladCB.setBounds(36, 228, 97, 23);
		getContentPane().add(cSaladCB);

		friesTF = new JTextField();
		friesTF.setBounds(170, 90, 60, 20);
		getContentPane().add(friesTF);
		friesTF.setColumns(10);

		hamburgerTF = new JTextField();
		hamburgerTF.setColumns(10);
		hamburgerTF.setBounds(170, 125, 60, 20);
		getContentPane().add(hamburgerTF);

		onionRingTF = new JTextField();
		onionRingTF.setColumns(10);
		onionRingTF.setBounds(170, 160, 60, 20);
		getContentPane().add(onionRingTF);

		gSaladTF = new JTextField();
		gSaladTF.setColumns(10);
		gSaladTF.setBounds(170, 194, 60, 20);
		getContentPane().add(gSaladTF);

		cSaladTF = new JTextField();
		cSaladTF.setColumns(10);
		cSaladTF.setBounds(170, 228, 60, 20);
		getContentPane().add(cSaladTF);

		chickSandTF = new JTextField();
		chickSandTF.setBounds(170, 301, 60, 20);
		getContentPane().add(chickSandTF);
		chickSandTF.setColumns(10);

		chesSandTF = new JTextField();
		chesSandTF.setBounds(170, 338, 60, 20);
		getContentPane().add(chesSandTF);
		chesSandTF.setColumns(10);

		fishSandTF = new JTextField();
		fishSandTF.setBounds(170, 373, 60, 20);
		getContentPane().add(fishSandTF);
		fishSandTF.setColumns(10);

		chocMufTF = new JTextField();
		chocMufTF.setBounds(416, 90, 60, 20);
		getContentPane().add(chocMufTF);
		chocMufTF.setColumns(10);

		brownieTF = new JTextField();
		brownieTF.setBounds(416, 121, 60, 20);
		getContentPane().add(brownieTF);
		brownieTF.setColumns(10);

		chickSandCB = new JCheckBox("Chicken Sandwich");
		chickSandCB.setBounds(36, 300, 128, 23);
		getContentPane().add(chickSandCB);

		chesSandCB = new JCheckBox("Cheese Sandwich");
		chesSandCB.setBounds(36, 337, 128, 23);
		getContentPane().add(chesSandCB);

		chocMufCB = new JCheckBox("Chocolate Muffin");
		chocMufCB.setBounds(283, 90, 127, 23);
		getContentPane().add(chocMufCB);

		fishSandCB = new JCheckBox("Fish Sandwich");
		fishSandCB.setBounds(36, 372, 128, 23);
		getContentPane().add(fishSandCB);

		brownieCB = new JCheckBox("Brownie");
		brownieCB.setBounds(283, 120, 97, 23);
		getContentPane().add(brownieCB);

		lemChesTF = new JTextField();
		lemChesTF.setBounds(416, 152, 60, 20);
		getContentPane().add(lemChesTF);
		lemChesTF.setColumns(10);

		berryChesTF = new JTextField();
		berryChesTF.setBounds(416, 183, 60, 20);
		getContentPane().add(berryChesTF);
		berryChesTF.setColumns(10);

		pancakeTF = new JTextField();
		pancakeTF.setBounds(416, 214, 60, 20);
		getContentPane().add(pancakeTF);
		pancakeTF.setColumns(10);

		lemChesCB = new JCheckBox("Lemon Cheesecake");
		lemChesCB.setBounds(283, 151, 127, 23);
		getContentPane().add(lemChesCB);

		berryChesCB = new JCheckBox("Berry Cheesecake");
		berryChesCB.setBounds(283, 182, 127, 23);
		getContentPane().add(berryChesCB);

		pancakeCB = new JCheckBox("Pancake Mapel syr.");
		pancakeCB.setBounds(283, 213, 127, 23);
		getContentPane().add(pancakeCB);

		teaCB = new JCheckBox("Tea");
		teaCB.setBounds(537, 89, 97, 23);
		getContentPane().add(teaCB);

		teaTF = new JTextField();
		teaTF.setBounds(677, 90, 60, 20);
		getContentPane().add(teaTF);
		teaTF.setColumns(10);

		coffeeCB = new JCheckBox("Coffee");
		coffeeCB.setBounds(537, 120, 97, 23);
		getContentPane().add(coffeeCB);

		colaCB = new JCheckBox("Cola");
		colaCB.setBounds(537, 151, 97, 23);
		getContentPane().add(colaCB);

		orangeJuiceCB = new JCheckBox("Orange Juice");
		orangeJuiceCB.setBounds(537, 182, 97, 23);
		getContentPane().add(orangeJuiceCB);

		waterCB = new JCheckBox("Bottle Water");
		waterCB.setBounds(537, 213, 97, 23);
		getContentPane().add(waterCB);

		coffeeTF = new JTextField();
		coffeeTF.setColumns(10);
		coffeeTF.setBounds(677, 121, 60, 20);
		getContentPane().add(coffeeTF);

		colaTF = new JTextField();
		colaTF.setColumns(10);
		colaTF.setBounds(677, 152, 60, 20);
		getContentPane().add(colaTF);

		orangeJuiceTF = new JTextField();
		orangeJuiceTF.setColumns(10);
		orangeJuiceTF.setBounds(677, 183, 60, 20);
		getContentPane().add(orangeJuiceTF);

		waterTF = new JTextField();
		waterTF.setColumns(10);
		waterTF.setBounds(677, 214, 60, 20);
		getContentPane().add(waterTF);

		chocoShakeTF = new JTextField();
		chocoShakeTF.setColumns(10);
		chocoShakeTF.setBounds(677, 301, 60, 20);
		getContentPane().add(chocoShakeTF);

		strawberryShakeTF = new JTextField();
		strawberryShakeTF.setColumns(10);
		strawberryShakeTF.setBounds(677, 338, 60, 20);
		getContentPane().add(strawberryShakeTF);

		bananaShakeTF = new JTextField();
		bananaShakeTF.setColumns(10);
		bananaShakeTF.setBounds(677, 373, 60, 20);
		getContentPane().add(bananaShakeTF);

		chocoShakeCB = new JCheckBox("Chocolate M.Shake");
		chocoShakeCB.setBounds(537, 300, 134, 23);
		getContentPane().add(chocoShakeCB);

		strawberryShakeCB = new JCheckBox("Strawberry M.Shake");
		strawberryShakeCB.setBounds(537, 337, 134, 23);
		getContentPane().add(strawberryShakeCB);

		bananaShakeCB = new JCheckBox("Banana M.Shake");
		bananaShakeCB.setBounds(537, 372, 134, 23);
		getContentPane().add(bananaShakeCB);

		saveButton = new JButton("Save & Submit");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (friesCB.isSelected()) {
					if (friesTF.getText().isEmpty()) {
					} else {
						int numOfserv = Integer.parseInt(friesTF.getText());
						Service service = new Service(friesCB.getText(), numOfserv, 10.00, false);
						servList.add(service);
					}
				}
				if (hamburgerCB.isSelected()) {
					if (hamburgerTF.getText().isEmpty()) {
					} else {
						int numOfserv = Integer.parseInt(hamburgerTF.getText());
						Service service = new Service(hamburgerCB.getText(), numOfserv, 15.00, false);
						servList.add(service);
					}
				}
				if (onionRingCB.isSelected()) {
					if (onionRingTF.getText().isEmpty()) {
					} else {
						int numOfserv = Integer.parseInt(onionRingTF.getText());
						Service service = new Service(onionRingCB.getText(), numOfserv, 10.00, false);
						servList.add(service);
					}
				}
				if (gSaladCB.isSelected()) {
					if (gSaladTF.getText().isEmpty()) {
					} else {
						int numOfserv = Integer.parseInt(gSaladTF.getText());
						Service service = new Service(gSaladCB.getText(), numOfserv, 12.00, false);
						servList.add(service);
					}
				}
				if (cSaladCB.isSelected()) {
					if (cSaladTF.getText().isEmpty()) {
					} else {
						int numOfserv = Integer.parseInt(cSaladTF.getText());
						Service service = new Service(cSaladCB.getText(), numOfserv, 12.00, false);
						servList.add(service);
					}
				}
				if (chickSandCB.isSelected()) {
					if (chickSandTF.getText().isEmpty()) {
					} else {
						int numOfserv = Integer.parseInt(chickSandTF.getText());
						Service service = new Service(chickSandCB.getText(), numOfserv, 10.00, false);
						servList.add(service);
					}
				}
				if (chesSandCB.isSelected()) {
					if (chesSandTF.getText().isEmpty()) {
					} else {
						int numOfserv = Integer.parseInt(chesSandTF.getText());
						Service service = new Service(chesSandCB.getText(), numOfserv, 10.00, false);
						servList.add(service);
					}
				}
				if (chocMufCB.isSelected()) {
					if (chocMufTF.getText().isEmpty()) {
					} else {
						int numOfserv = Integer.parseInt(chocMufTF.getText());
						Service service = new Service(chocMufCB.getText(), numOfserv, 10.00, false);
						servList.add(service);
					}
				}
				if (fishSandCB.isSelected()) {
					if (fishSandTF.getText().isEmpty()) {
					} else {
						int numOfserv = Integer.parseInt(fishSandTF.getText());
						Service service = new Service(fishSandCB.getText(), numOfserv, 10.00, false);
						servList.add(service);
					}
				}
				if (brownieCB.isSelected()) {
					if (brownieTF.getText().isEmpty()) {
					} else {
						int numOfserv = Integer.parseInt(brownieTF.getText());
						Service service = new Service(brownieCB.getText(), numOfserv, 10.00, false);
						servList.add(service);
					}
				}
				if (lemChesCB.isSelected()) {
					if (lemChesTF.getText().isEmpty()) {
					} else {
						int numOfserv = Integer.parseInt(lemChesTF.getText());
						Service service = new Service(lemChesCB.getText(), numOfserv, 10.00, false);
						servList.add(service);
					}
				}
				if (berryChesCB.isSelected()) {
					if (berryChesTF.getText().isEmpty()) {
					} else {
						int numOfserv = Integer.parseInt(berryChesTF.getText());
						Service service = new Service(berryChesCB.getText(), numOfserv, 10.00, false);
						servList.add(service);
					}
				}
				if (pancakeCB.isSelected()) {
					if (pancakeTF.getText().isEmpty()) {
					} else {
						int numOfserv = Integer.parseInt(pancakeTF.getText());
						Service service = new Service(pancakeCB.getText(), numOfserv, 10.00, false);
						servList.add(service);
					}
				}
				if (teaCB.isSelected()) {
					if (teaTF.getText().isEmpty()) {
					} else {
						int numOfserv = Integer.parseInt(teaTF.getText());
						Service service = new Service(teaCB.getText(), numOfserv, 5.00, false);
						servList.add(service);
					}
				}
				if (coffeeCB.isSelected()) {
					if (coffeeTF.getText().isEmpty()) {
					} else {
						int numOfserv = Integer.parseInt(coffeeTF.getText());
						Service service = new Service(coffeeCB.getText(), numOfserv, 5.00, false);
						servList.add(service);
					}
				}
				if (colaCB.isSelected()) {
					if (colaTF.getText().isEmpty()) {
					} else {
						int numOfserv = Integer.parseInt(colaTF.getText());
						Service service = new Service(colaCB.getText(), numOfserv, 5.00, false);
						servList.add(service);
					}
				}
				if (orangeJuiceCB.isSelected()) {
					if (orangeJuiceTF.getText().isEmpty()) {
					} else {
						int numOfserv = Integer.parseInt(orangeJuiceTF.getText());
						Service service = new Service(orangeJuiceCB.getText(), numOfserv, 7.00, false);
						servList.add(service);
					}
				}
				if (waterCB.isSelected()) {
					if (waterTF.getText().isEmpty()) {
					} else {
						int numOfserv = Integer.parseInt(waterTF.getText());
						Service service = new Service(waterCB.getText(), numOfserv, 3.00, false);
						servList.add(service);
					}
				}
				if (chocoShakeCB.isSelected()) {
					if (chocoShakeTF.getText().isEmpty()) {
					} else {
						int numOfserv = Integer.parseInt(chocoShakeTF.getText());
						Service service = new Service(chocoShakeCB.getText(), numOfserv, 8.00, false);
						servList.add(service);
					}
				}
				if (strawberryShakeCB.isSelected()) {
					if (strawberryShakeTF.getText().isEmpty()) {
					} else {
						int numOfserv = Integer.parseInt(strawberryShakeTF.getText());
						Service service = new Service(strawberryShakeCB.getText(), numOfserv, 8.00, false);
						servList.add(service);
					}
				}
				if (bananaShakeCB.isSelected()) {
					if (bananaShakeTF.getText().isEmpty()) {
					} else {
						int numOfserv = Integer.parseInt(bananaShakeTF.getText());
						Service service = new Service(bananaShakeCB.getText(), numOfserv, 8.00, false);
						servList.add(service);
					}
				}
				for (int i = 0; i < servList.size(); i++) {
					try {
						FileWriter foodfw = new FileWriter("orderedservices.txt", true);
						foodfw.write(cust.getName() + ":" + cust.getSurname() + ":" + servList.get(i).getServName()
								+ ":" + servList.get(i).getNumOfServ() + ":" + servList.get(i).getServFee() + ":false:"
								+ System.lineSeparator());
						foodfw.close();

					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				JOptionPane.showMessageDialog(null, " Saved successfully");

			}
		});
		saveButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		saveButton.setBounds(283, 282, 215, 53);
		getContentPane().add(saveButton);

		cancelButton = new JButton("Cancel & Back To Menu");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cancelButton.setBounds(283, 363, 215, 53);
		getContentPane().add(cancelButton);

		lblNewLabel = new JLabel("Meals");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(73, 59, 110, 23);
		getContentPane().add(lblNewLabel);

		lblNewLabel_1 = new JLabel("Sandwiches");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(57, 263, 154, 27);
		getContentPane().add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Desserts");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(294, 59, 182, 34);
		getContentPane().add(lblNewLabel_2);

		lblNewLabel_4 = new JLabel("Shakes");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(563, 263, 131, 27);
		getContentPane().add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("Food & Beverage Services");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_5.setBounds(177, 11, 416, 34);
		getContentPane().add(lblNewLabel_5);

		panel = new JPanel();
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY, 3, true));
		panel.setBounds(27, 52, 225, 364);
		getContentPane().add(panel);

		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(192, 192, 192), 3, true));
		panel_1.setBounds(273, 52, 225, 211);
		getContentPane().add(panel_1);

		panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.LIGHT_GRAY, 3, true));
		panel_2.setBounds(519, 52, 238, 364);
		getContentPane().add(panel_2);

		lblNewLabel_3 = new JLabel("Drinks");
		panel_2.add(lblNewLabel_3);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("images\\hotel.jpg"));
		lblNewLabel.setBounds(0, 0, 762, 481);
		getContentPane().add(lblNewLabel);
	}
}
