package ClassExample;

class Circle {

	private double radius;
	
	Circle(double aradius){
		this.radius = aradius;
	}
	
	Circle(){
		radius = 0;		
	}
	
	double computeArea(){
		return Math.PI*Math.pow(radius, 2.0);
	}

}
