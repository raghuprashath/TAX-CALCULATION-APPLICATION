package tax;

class Property {
	private static int Nextid=0;
    private double baseValue;
    private int buildupArea;
    private int age;
    private char isCity;
    private int id;
    private double tax;
    public Property(double baseValue,int buildupArea, int age,char isCity) {
        this.baseValue = baseValue;
        this.buildupArea = buildupArea;
        this.age = age;
        this.isCity = isCity;
        this.id=++Nextid;
    }
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBaseValue() {
		return baseValue;
	}
	public void setBaseValue(int baseValue) {
		this.baseValue = baseValue;
	}
	public int getBuildupArea() {
		return buildupArea;
	}
	public void setBuildupArea(int buildupArea) {
		this.buildupArea = buildupArea; 
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getIsCity() {
		return isCity;
	}
	public void setIsCity(char isCity) {
		this.isCity = isCity;
	}
	public double calculatetax() {
		double tax=0;
		if(isCity=='y'||isCity=='Y') {
			tax=(baseValue*age*buildupArea)+(0.5*buildupArea);
		}
		else {
			tax=baseValue*age*buildupArea;
		}
		return tax;
	}
	public void settax(double propertytax) {
		this.tax=propertytax;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
}

