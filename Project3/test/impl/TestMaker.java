package test.impl;

import java.util.Scanner;

import com.jsoftware.test.IQuestion;
import com.jsoftware.test.IQuestionFactory;
import com.jsoftware.test.IQuestionSet;

public class TestMaker {
	public static void main(String [] args){
				
		//IFactory and ISet are parents.  That is where everything is stored
		//Classes just utilize them.  Interfaces don't have the actual bodys to methods....the classes have that
		IQuestionFactory QuestionF = new QuestionFactory();
		IQuestionSet Question = new QuestionSet(); //create new array to store questions into
		boolean X;
		String r0, r1, r2, r3, q1, a1;
		int choice, answer, number;
		Scanner s = new Scanner(System.in);
		
/*&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&*/		
		
		do{
			
			System.out.println();
				
			System.out.print("What type of question would you like to make? \n1) Multiple Choice \n2) True/False"
					+ "\n3) Fill in the Blank \n4) Short Answer \n5) Remove a Question \n6) End program "
					+ "\n\nWhat is your choice? ");
			
			choice = s.nextInt();
	
			/*&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&*/			
			
			if(choice==1){
				System.out.print("What is your multiple choice question? ");
				s.nextLine();
				q1 = s.nextLine();
				
				//create new string to hold multiple choices
				String[] a = new String[4];
				System.out.print("What is your first choice? ");
				r0=s.nextLine();
				a[0] = (r0);
				
				System.out.print("What is your second choice? ");
				r1=s.nextLine();
				a[1] = (r1);
				
				System.out.print("What is your third choice? ");
				r2=s.nextLine();
				a[2] = (r2);
				
				System.out.print("What is your fourth choice? ");
				r3=s.nextLine();
				a[3] = (r3);
				
				System.out.print("What choice was the answer? (Enter #1-4) ");
				answer=s.nextInt();
				answer = answer - 1;  //because the array really starts at zero
				
				//send this in to QuestionFactory to make the multiple choice object
				//IQuestion is the parent class/type
				IQuestion I = QuestionF.makeMultipleChoice(q1, a, answer);
				//add the question to question set
				Question.add(I);				
			}
			
/*&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&*/				
					
			if(choice==2){
				System.out.print("What is your true/false question? ");
				s.nextLine();
				q1 = s.nextLine();
				
				System.out.print("What is the answer (enter true or false): ");
				
				X = s.nextBoolean();
				
				//go into question factory to make the question
				IQuestion I = QuestionF.makeTrueFalse(q1,X);				
				Question.add(I);
			}
			
/*&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&*/								
					
			if(choice==3){
				System.out.print("What is your fill in the blank question? ");
				s.nextLine();
				q1 = s.nextLine();
						
				System.out.print("What are the answers (please space between words): ");
						
				a1 = s.nextLine();
										
				String[] keywords = (a1.split(" "));					
						
				IQuestion I = QuestionF.makeFillInBlank(q1,keywords);
				Question.add(I);
			}
			
/*&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&*/				
			
			if(choice==4){
				System.out.print("What is your short answer question? ");
				s.nextLine();
				q1=s.nextLine();
				
				System.out.print("what are the keywords (please space between words: ");
				a1 = s.nextLine();
				
				String[] keywords = (a1.split(" "));
						
				IQuestion I = QuestionF.makeShortAnswer(q1, keywords);
				Question.add(I);
				
			}
			
/*&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&*/	
			
			if(choice==5){
				
				
				for(int i=0; i<Question.size();i++){
					System.out.println(i + ") " + Question.getQuestion(i).getQuestion());	
				}
				
				System.out.print("Enter number for question that is to be removed? "
						+ "(enter -1 to do nothing): ");
				choice = s.nextInt();
				
				if(choice != -1){
					Question.remove(choice);
				}
				
				else{
					continue;
				}
			}

/*&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&*/				
			
		}while(choice !=6);

		QuestionF.save(Question, "question.ser");
		System.out.println("Test has been saved");
		
	}//end main
}//end class
