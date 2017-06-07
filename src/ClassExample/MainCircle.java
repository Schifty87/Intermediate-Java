package ClassExample;

public class MainCircle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int size = (int)(Math.random()*10+1);
		
		Circle[] circles = new Circle[size];
				
		for (int i=0;i<circles.length;i++){
			circles[i]= new Circle(Math.random()*5);
		}
		
		double totalArea = 0;
		
		for(int i=0; i<circles.length;i++){
			totalArea +=circles[i].computeArea();
		}
		
		System.out.println(totalArea);
	}

}
