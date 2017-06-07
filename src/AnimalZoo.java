class Animal{
	public void speak(){
		System.out.println("Can't speak");
	}
}

class Cat extends Animal{
	public void speak(){
		System.out.println("meow");
	}
}

class Dog extends Animal{
	public void speak(){
		System.out.println("woof");
	}
}

public class AnimalZoo{
	public static void main(String[] args){
		
		Animal[] a = {new Cat(), new Dog(), new Animal(), new Cat()};
		for(int i=0; i<a.length; i++){
			a[i].speak();
		}
		
	}
}