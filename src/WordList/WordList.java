package WordList;

public class WordList {
	
	private String[] words = new String[100];
	private int count = 0;
	
	boolean add(String word){
		if(count == 100)
			return false;
		words[count++] = word;
			return true;
	}
	
	void display(){
		System.out.println("Words: ");
		for(int i=0; i<count; i++)
			System.out.print(words[i]);
		System.out.println();
	}
	void remove(String word){
		int target = -1;  //this means word has not been found
		for(int i=0;i<count;i++){
			if(word.equals(words[i])){
				target = i;
				break;  //index of word has been found - end the search
			}
		}
		if(target == -1)
			return;  //nothing to remove
		for(int i=target; i<count;i++){
			words[i] = words[i+1];  //move to the left
		}
		count--;
	}
}
