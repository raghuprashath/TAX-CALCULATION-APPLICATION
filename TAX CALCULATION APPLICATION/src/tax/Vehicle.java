package tax;

public class Vehicle {
	private int regNo;
	private String brand;
	private int velocity;
	private int capacity;
	private int type;
	private double cost;
	private double tax;
	public Vehicle(int regNo,String brand,int velocity,int capacity,int type, double cost) {
		this.regNo=regNo;
		this.brand=brand;
		this.velocity=velocity;
		this.capacity=capacity;
		this.type=type;
		this.cost=cost;
	}
	public int getRegNo() {
		return regNo;
	}
	public void setRegNo(int regNo) {
		this.regNo = regNo;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getVelocity() {
		return velocity;
	}
	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getType() {
		if(type==1) {
			return "PETROL";
		}
		if(type==1) {
			return "DISEL";
		}
		else {
			return "CNG\\LPG";
		}
	}
	public void setType(int type) {
		this.type = type;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public double calculatetax() {
		double tax=0;
		if(type==1) {
			tax=velocity+capacity+(0.10*cost);
		}
		else if(type==2){
			tax=velocity+capacity+(0.11*cost);
		}
		else{
			tax=velocity*capacity+(0.12*cost);
		}
		return tax;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
}
