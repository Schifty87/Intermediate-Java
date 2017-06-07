
public class TwoDArray {

	public static void main(String[] args){
		
		int[][] a = new int[2][3];
		
		a[0][0] = 90;
		a[0][1] = 80;
		a[0][2] = 100;
		a[1][0] = 70;
		a[1][1] = 80;
		a[1][2] = 90;
		
		/*can also be written as.....
		a = {
			{90,80,100}
			{70,80,90}
			}
		*/
		
		for(int r=0; r<2;r++){
			int sum=0;//reset sum after every iteration
			for(int c=0; c<3; c++){
				System.out.print("\t"); //put space between numbers
				System.out.print(a[r][c]);
				sum +=a[r][c];
			}
			System.out.print("\t" + sum/3);
			System.out.println(); //return down a line
		}
	}
	
	
}
