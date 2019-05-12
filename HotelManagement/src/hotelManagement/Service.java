package hotelManagement;

public class Service {
	private String servName;
	private String custName;
	private String custSName;
	private double servFee;
	private int numOfserv;
	private boolean status;
	public Service(String n, double f,boolean s) {
		this.servName=n;
		this.servFee=f;
		this.status=s;
		
}
	public Service(String n, int k,double f ,boolean s) {
		this.servName=n;
		this.servFee=f;
		this.numOfserv=k;
		this.status=s;
		
}
	public String getServName() {
		return this.servName;}
	public double getServFee() {
		return this.servFee;}
	public boolean getStatus() {
		return this.status;
	}
	public Service(String a, String b,String n, int k,double f ,boolean s) {
		this.custName=a;
		this.custSName=b;
		this.servName=n;
		this.servFee=f;
		this.numOfserv=k;
		this.status=s;
		
}

public int getNumOfServ() {
	return this.numOfserv;}

public String getCustName() {
	return this.custName;}
public String getCustSName() {
	return this.custSName;}
}


