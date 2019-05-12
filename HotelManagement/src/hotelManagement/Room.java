package hotelManagement;

public class Room {
    private int  RoomID ;
	private String custName;
	private String custSurname;
	private String entDate;
	private String leaDate;	

public Room(int id,String n, String s, String ed, String ld) {
	this.RoomID=id;
	this.custName=n;
	this.custSurname=s;
	this.entDate=ed;
	this.leaDate=ld;	
}
public void  setRoomID(int n) {
	this.RoomID=n;
	
}
public int  getRoomID() {
	 return this.RoomID;
	
}
public void  setCustName(String n) {
	this.custName=n;
	
}
public String  getCustName() {
	 return this.custName;
	
}
public void  setCustSurname(String n) {
	this.custSurname=n;
	
}
public String  getCustSurname() {
	 return this.custSurname;
	
}
public void  setenteringDate(String n) {
	this.entDate=n;
	
}
public String getEnteringDate() {
	 return this.entDate;
	
}
public void  setLeavingDate(String n) {
	this.entDate=n;
	
}
public String getLDate() {
	 return this.leaDate;
	
}
}
