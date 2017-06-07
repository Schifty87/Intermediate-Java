package Lab3;

public class main {

	//create a random animal using the table above and return the created animal.

	static Animal makeRandomAnimal(){
		int index =(int)(Math.random()*17);
	    return new Animal(table[index][0], table[index][1]);
	}

	   static String table[][] ={
			      {"dog",  "woof"},
			      {"cow",  "moo"},
			      {"duck","quack"},
			      {"owl", "whoooo"},
			      {"cat",  "meow"},
			      {"bird","tweet"},
			      {"pig",  "oink"},
			      {"rat", "squeak"},
			      {"horse", "neigh"},
			      {"sheep","ba"},
			      {"person", "bla"},
			      {"snake", "hiss"},
			      {"chicken", "cluck"},
			      {"frog", "ribbit"},
			      {"donkey", "hee haw"},
			      {"bear", "grr"},
			      {"lion", "raaar"}
			   };
	
	public static void main(String[] args) {
		
		//TODO: Create three zoo objects with the following names : 	   
	    //Animal Haven Zoo, Milwaukee County Zoo, Bear Den Zoo
		
		Zoo z1 = new Zoo("Haven");
		Zoo z2 = new Zoo("Milwaukee");
		Zoo z3 = new Zoo("Bear");      
		      
	    //TODO: for each zoo, add random number of animals
	    //The number of animals in a zoo is between 1 and Zoo.CAPACITY
		
		int rand = (int)(Math.random()*Zoo.CAPACITY+1);
		for(int i=0;i<rand;i++){
			z1.addAnimal(makeRandomAnimal());
		}	
		System.out.println(z1.getName());
		z1.visitAllAnimals();
		
		
		int rand1 = (int)(Math.random()*Zoo.CAPACITY+1);		
		for(int i=0;i<rand1;i++){
			z2.addAnimal(makeRandomAnimal());
		}	
		System.out.println(z2.getName());
		z2.visitAllAnimals();
		
		
		int rand2 = (int)(Math.random()*Zoo.CAPACITY+1);		
		for(int i=0;i<rand2;i++){
			z3.addAnimal(makeRandomAnimal());
		}
		System.out.println(z3.getName());
		z3.visitAllAnimals();

	    //TODO: feed the first animal in each zoo
		Animal a1 = z1.getAnimal(0);
		a1.feed("hay");
		
		Animal a2 = z2.getAnimal(0);
		a1.feed("water");
		
		Animal a3 = z3.getAnimal(0);
		a1.feed("grass");
	
	
	}


}
