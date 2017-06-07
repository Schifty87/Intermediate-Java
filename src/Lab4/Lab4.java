package Lab4;


abstract class Animal{
	
	private String name;
	private static int numAnimal=0;
	
	Animal(String name){
		this.name = name;
		//for every new animal, count goes up
		numAnimal++;
	}
	
	void setName(String name){
		this.name = name;	
	}
	
	String getName(){
		return name;
	}
	
	//cannot be used if simply creating "animal"
	abstract void speak();
	
	void feed(String food){
		System.out.println(getName() + " is feeding on " + food);		
	}
	
	public static int getNumAnimal(){
		return numAnimal;
	}			
}//end Animal class

class Cat extends Animal{
	
	//constructor
	Cat(String name){
		super(name);
	}
	
	void speak(){
		System.out.println(getName() + " says meow");
	}
	
	void stalk(Lizard lizard){
		System.out.println(getName() + " is stalking " + lizard.getName());
	}	
}//end Cat class
	
class Dog extends Animal{
		
	Dog(String name){
		super(name);
	}
		
	void speak(){
		System.out.println(getName() + " says woof");
	}				
}//end Dog class
	
class Lizard extends Animal{
		
	Lizard(String name){
		super(name);
	}
		
	void speak(){
		System.out.println(getName() + " says hiss");
	}
}//end Lizard class
	
public class Lab4 {

	public static void main(String[] args) {

		Animal[] animals = {new Lizard("echo"), new Cat("Minnie"), new Cat("Gracie"), new Dog("Boomer")};
				
		System.out.println(Animal.getNumAnimal());
		
		//make the animals do their thing
		for(int i=0; i<animals.length; i++){	//can also write for loop as: for(Animal a:animals)
			if(animals[i] instanceof Dog){
				animals[i].speak();
			}
			
			if(animals[i] instanceof Lizard){
				animals[i].feed("mice");
			}
			
			if(animals[i] instanceof Cat){
				for(int j=0; j<animals.length;j++){
					if((animals[j] instanceof Lizard)){
						if(animals[j].getName().equals("echo")){
							Lizard X = new Lizard(animals[j].getName());
							//cast animals[i] to cat class.  X is already type Lizard
							((Cat) animals[i]).stalk(X);
						}
					}
				}
			}
		}		
	}	
}
