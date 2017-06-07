package inheretance;

class Main{
	private String name;
	
	public Main(String name){
		this.name = name;
	}
	
	void setName(String name){
		this.name = name;
	}
	
	String getName(){
		return name;
	}
}

class SalariedEmployee extends Main{
	private double salary;
	
	//constructor
	public SalariedEmployee(String name, int salary){
		super(name);
		this.salary = salary;
	}
	void setSalary(double salary){
		this.salary = salary;
	}
	
	double getSalary(){
		return salary;
	}	
}


class HourlyWageEmployee extends Main{
	private double rate;
	
	//constructor
	public HourlyWageEmployee(String name, double rate){
		super(name);
		this.rate = rate;
	}
	
	void setRate(double rate){
		this.rate = rate;
	}
	
	double getRate(){
		return rate *40*50;
	}
}


public class MainEmployee {
	public static void main(String[] args){
		
		SalariedEmployee e1 = new SalariedEmployee("Joe", 50000);
		HourlyWageEmployee e2 = new HourlyWageEmployee("Moe", 16.75);
		
		System.out.println(e1.getName() + " makes " + e1.getSalary() + " per year");
		System.out.println(e2.getName() + " makes " + e2.getRate() + " per year");
		
	}
}
