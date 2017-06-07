package Quiz5;

interface IPair{
	Object getFirst();
	Object getSecond();
}

class VarPair implements IPair{
	private Object first;
	private Object second;
	
	VarPair(Object first, Object second){
		this.first = first;
		this.second = second;
	}
	
	public Object getFirst(){
		return first;
	}
	
	public Object getSecond(){
		return second;
	}
	
	public String toString(){
		return "[" + getFirst() + "," + getSecond() + "]";
	}
}

abstract class ArrayPair implements IPair{
	
	private Object[] array = new Object[2];
	
	ArrayPair(Object first, Object second){
		array[0] = first;
		array[1] = second;
	}
	
	public Object getFirst(){
		return array[0];
	}
	
	public Object setSecond(){
		return array[1];
	}
	
	public String toString(){
		return "[" + getFirst() + "," + getSecond() + "]";
	}
}


public class Quiz5{
	public static void main(String[] args){
		
		IPair p1 = new VarPair("Apple", "Sweet");
		System.out.println(p1.getFirst() + "," + p1.getSecond());
		
		//IPair p2 = new ArrayPair("Apple", "Sweet");
		//System.out.println(p1.getFirst() + "," + p1.getSecond());
		
	}
}
