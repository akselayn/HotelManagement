package hotelManagement;

public abstract class Rooms {
	private String RoomID,entDate,leaDate,roomType;
	private String custName;
	private String custSurname;

	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustSurname() {
		return custSurname;
	}
	public void setCustSurname(String custSurname) {
		this.custSurname = custSurname;
	}
	public String getEntDate() {
		return entDate;
	}
	public void setEntDate(String entDate) {
		this.entDate = entDate;
	}
	public String getLeaDate() {
		return leaDate;
	}
	public void setLeaDate(String leaDate) {
		this.leaDate = leaDate;
	}
	public String getRoomID() {
		return RoomID;
	}
	public void setRoomID(String roomID) {
		RoomID = roomID;
	}
	public void setRoomType(String type) {
		roomType=type;
	}
	public String getRoomType() {
		return roomType;
	}

}
class doubleRoom extends Rooms{
	public doubleRoom(String Id,String type,String n, String s, String ed, String ld) {
		this.setRoomID(Id);
		this.setRoomType(type);
		this.setCustName(n);
		this.setCustSurname(s);
		this.setEntDate(ed);
		this.setLeaDate(ld);	
	}
	
}
class singleRoom extends Rooms{
	public singleRoom(String Id,String n, String s, String ed, String ld) {
		this.setRoomID(Id);
		this.setCustName(n);
		this.setCustSurname(s);
		this.setEntDate(ed);
		this.setLeaDate(ld);	
	}
	
}
