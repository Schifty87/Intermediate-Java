package WordList;
import java.util.Scanner;

public class wordListMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WordList list = new WordList();
		Scanner s = new Scanner(System.in);
		
		loop: while(true){  //stupid way to do this......do/while loop
			list.display();
			System.out.print("1)Add, 2)Remove, 3)Quit: ");
			int choice = s.nextInt();
			
			switch(choice){
			case 1:
				System.out.print("Word to add");
				String word = s.next();
				list.add(word);
				break;
			case 2:
				System.out.print("Word to remove");
				String word2 = s.next();
				list.remove(word2);
				break;
			case 3:
				break loop;
			}
		}
	}

}
