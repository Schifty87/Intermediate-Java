

class Point{
	private double x,y;
	
	Point(double x, double y){
		this.x=x;
		this.y=y;
	}
	
	double getX(){
		return x;
	}
	double getY(){
		return y;
	}
	
	void setX(double x){
		this.x=x;
	}
	
	void setY(double y){
		this.y=y;
	}
	
	static double distance(Point p1, Point p2){
		return p1.x-p2.x;
	}
}

class Circle{
	static double PI = 3.14; //store number for use at any point
	private Point center;
	private double radius;
	
	Circle(Point center, double radius){
		this.center = center;
		this.radius = radius;
	}
	
	double getArea(){
		return PI*radius*radius;
	}
}

public class ShapeExample{
	public static void main(String[] args){
		System.out.println(Circle.PI); //prints out value of PI
		Circle c = new Circle(new Point(0,0), 5);
		System.out.println(c.getArea());
		
		Point p1 = new Point(5,5);
		Point p2 = new Point(2,5);
		
		double distance = Point.distance(p1, p2);
		System.out.println(distance);
	}
}

