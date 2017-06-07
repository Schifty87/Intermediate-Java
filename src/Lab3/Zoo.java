package Lab3;
public class Zoo {
	 //max capacity of zoo. the number of animals must not exceed it.  
	   public final static int CAPACITY = 30; 
	   //name of the zoo
	   private String name;
	   //set of animals in the zoo
	   private Animal animals[];  //array to store animals
	   //current number of animals in the zoo
	   private int animalCount;
	   
	   //constructor
	   Zoo(String name){  //is this supposed to be lower-case z?
	     this.name = name;
	     animals = new Animal[CAPACITY];
	   }
	   void setName(String name){
	      this.name = name;
	   }
	   String getName(){
	      return name;
	   }
	   int getAnimalCount(){
	      return animalCount;
	   }
	   //add animal to the zoo, do nothing if capacity is reached.
	   void addAnimal(Animal animal){
		   if(animalCount < CAPACITY){
			   animals[animalCount++] = animal;//create array object..animalCount is the index
		   }
	   }
	   //return animal at given array index 
	   Animal getAnimal(int index){        
		   return animals[index];
	   }
	   //visit animal at index, have it speak
	   // e.g. the cat says "meow."
	   void visitAnimal(int index){
		   //use animal index
		   animals[index].speak();  //.speak() comes from Animal class
		   
	   }
	   //visit all animals in the zoo, have each speak
	   void visitAllAnimals(){
		   for(int i=0; i< animalCount; i++){
			  visitAnimal(i);
		   }
	   }
}
