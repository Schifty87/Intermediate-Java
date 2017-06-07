package inheretance;

class Person {
	private String name;
	
	Person(String name){
		this.name = name;
	}
		
	void setName(String name){
		this.name = name;
	}
	
	String getName(){
		return name;
	}
}

class Student extends Person{
	String studentID;
		
	Student(String studentID, String name){
		super(name); //call super class (person)
		this.studentID = studentID;
		setName(name);
	}
	void setstudentID(String studentID){
		this.studentID = studentID;
	}
	String getStudentID(){
		return studentID;
	}
}

public class InheritanceExample{
	public static void main(String[] args){		
		Student s1 = new Student("123", "joe");
		Person s2 = new Person("mike");
		System.out.println(s1.getStudentID() + " " + s1.getName());
		System.out.println(s2.getName());
	}

}