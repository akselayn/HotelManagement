package hotelManagement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;

public class Customer {
	static ArrayList<Customer> CustList= new ArrayList<Customer>();
	
	private String username,name,surname,phone,email,edate,ldate;
	private int totaldays;
	double toBePaid;
	public Customer() {
	
	}
	
public Customer(String username,String name,String surname,String Phone,String email,String edate,String ldate,int tdays) {
		this.username=username;
		this.name=name;
		this.surname=surname;
		this.phone=Phone;
		this.email=email;
		this.edate=edate;
		this.ldate=ldate;
		this.totaldays=tdays;
		}
public Customer(String name,String surname,String Phone,String email,String edate,String ldate,int tdays) {

	this.name=name;
	this.surname=surname;
	this.phone=Phone;
	this.email=email;
	this.edate=edate;
	this.ldate=ldate;
	this.totaldays=tdays;
	}

	public void setUsername(String n) {this.username=n;		}
	public void setName(String n) {this.name=n;		}
	public void setSurname(String s) {this.surname=s;		}
	public void setPhone(String p) {this.phone=p;		}
	public void setEmail(String email) {this.email=email;		}
	public void setEDate(String n) {this.edate=n;		}
	public void setLDate(String n) {this.ldate=n;		}
	
	public String getUsername() {return this.username;		}
	public String getName() {return this.name;		}
	public String getSurname() {return this.surname;		}
	public String getPhone() {return this.phone;		}
	public String getEmail() {return this.email;		}
	public String getEDate() {return this.edate;		}
	public String getLDate() {return this.ldate;		}
	public int getTDays() {return this.totaldays;		}
	public String getRoomtype(){
		String roomtype="";
		BufferedReader br1;
		try {
			br1 = new BufferedReader(new FileReader("Rooms.txt"));
			String line = br1.readLine();
			while ((line = br1.readLine()) != null) {

				String[] pieces = line.split(Pattern.quote(":"));
				
				String name = pieces[2];
				if (name.equals(this.name))
					{roomtype=pieces[1];}
			}
			br1.close();
		}

		catch (IOException e1) {
			System.out.println(e1);
			e1.printStackTrace();
		}
		return roomtype;
	}
	
	public int calcDays(Customer customer) throws ParseException {
		Date date1= new SimpleDateFormat("dd-MM-yyyy").parse(customer.getEDate());
		Date date2= new SimpleDateFormat("dd-MM-yyyy").parse(customer.getLDate());
		long tdays = AddCustomer.daysBetweenDates(date1,date2);
		int days=(int)tdays;
		return days;
	}
	
	
}
