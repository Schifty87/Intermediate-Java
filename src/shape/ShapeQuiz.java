package shape;
class Shape{
	
	private String name;
	
	Shape(String name){
		this.name = name;
	}
	
	double getArea(){
		return 0;
	}
	
	public String toString(){
		return name + ":" + getArea();
	}
}

class Circle extends Shape{
	
	private double radius;
	
	Circle(double radius){
		super("Circle");  //super class must be invoked first
		this.radius = radius;
	}
	double getArea(){
		return 3.14*radius*radius;
	}
}

class Rectangle extends Shape{
	private double length, width;
	
	Rectangle(double length, double width){
		super("Rectangle");
		this.length = length;
		this.width = width;
	}
	
	double getArea(){
		return length*width;
	}
}

public class ShapeQuiz{
	public static void main(String[] args){
		
		Shape[] shapes = {new Circle(4), new Rectangle(4,5), new Rectangle(3,2), new Circle(1.0)};
			
		for(int i=0; i<shapes.length;i++){
			System.out.println(shapes[i].toString());
		}
		
		Object o = new Circle(5);
		
	}
}