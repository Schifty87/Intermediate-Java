package Quiz4;


class Cylinder{
	
	private int height, radius;//local to only class Cylinder
	
	Cylinder(int height, int radius){
		this.height = height;
		this.radius = radius;
	}
	
	int getHeight(){
		return height;
	}
	
	int getRadius(){
		return radius;
	}
	
	void setHeight(int height){
		this.height = height;
	}
	
	void setRadius(int radius){
		this.radius = radius;
	}
		
	public double Volume(){
		return height * radius*radius*3.14;
	}
	
}
	
public class quiz4{
	public static void main(String[] args){
		Cylinder c1 = new Cylinder(4,4);
		Cylinder c2 = new Cylinder(9,7);	
		
		System.out.println("c1 volume: " + c1.Volume());
		System.out.println("c2 volume: " + c2.Volume());
		
		c1.setHeight(20);
		System.out.println("c1 volume: " + c1.Volume());
	}
}
