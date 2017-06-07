package test.impl;

import java.util.Scanner;

import com.jsoftware.test.IQuestionFactory;
import com.jsoftware.test.IQuestionSet;

public class TestTaker {
	public static void main(String[]args){
	
		IQuestionFactory QuestionF = new QuestionFactory();
	
		Scanner s = new Scanner(System.in);
		boolean tf;
		int answer;
		int correct = 0;
		int question = 0;
		String FIB, SA;
		
		//all questions are stored within IQuestionSet (parent class of QuestionSet)
		IQuestionSet QuestionS = QuestionF.load("question.ser");
		
		System.out.print("Enter 1 to take a whole test or 2 to take a sample test" + "\nYour choice: ");
		int choice = s.nextInt();
		
		
		if(choice==1){
			for(int i=0; i<QuestionS.size(); i++){
				System.out.println(i + ") " + QuestionS.getQuestion(i).getQuestion());
				question++;
				
				if(QuestionS.getQuestion(i) instanceof FillInBlanks){
					System.out.println("\nFill in blank question\n");
					System.out.print("Your answer: ");
					s.nextLine();
					FIB = s.nextLine();
					String[] keywords = (FIB.split(" "));
					
					if(((FillInBlanks)QuestionS.getQuestion(i)).checkAnswer(keywords)==true){
						correct++;
						System.out.println("correct!");
					}
					else{
						System.out.println("Incorrect!");
					}
				}
				
				
				if(QuestionS.getQuestion(i) instanceof MultipleChoice){
					System.out.println("\nMultiple Choice Question\n");
					
					
					//cast QuestionSet to Multiple Choice.  QuestionSet used to be IQuestionSet
					System.out.println(((MultipleChoice) QuestionS.getQuestion(i)).getQuestion());
					
					String[] name = ((MultipleChoice) QuestionS.getQuestion(i)).getChoices(); 
					
					for(int i1=0; i1<4; i1++){
						System.out.println(i1 + ")" + name[i1]);
					
					
					}
					System.out.print("What is your answer? ");
					answer = s.nextInt();
					if(((MultipleChoice)QuestionS.getQuestion(i)).checkAnswer(answer)==true){
						correct++;
						System.out.println("correct!");
					}
					else{
						System.out.println("Incorrect!");
					}
					
				}
				
				if(QuestionS.getQuestion(i) instanceof ShortAnswerQuestion){
					System.out.println("\nShort Answer question\n");
					System.out.println(((ShortAnswerQuestion) QuestionS.getQuestion(i)).getQuestion());
					System.out.print("Short answer: ");
					s.nextLine();
					SA = s.nextLine();
					
					
					if(((ShortAnswerQuestion)QuestionS.getQuestion(i)).checkAnswer(SA)==true){
						correct++;
						System.out.println("correct!");
					}	
					else{
						System.out.println("Incorrect!");
					}
				}
				
				if(QuestionS.getQuestion(i) instanceof TrueFalseQuestion){
					System.out.println("\ntrue/false question\n");
					tf = s.nextBoolean();
					if(((TrueFalseQuestion)QuestionS.getQuestion(i)).checkAnswer(tf)==true){
						correct++;
						System.out.println("correct!");
					}
					else{
						System.out.println("Incorrect!");
					}
				}		
			}
		}
		
/*&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&*/		
		
		if(choice==2){
			System.out.print("How many questions would you like? There are " + QuestionS.size() + " total questions: ");
			int option = s.nextInt();
			s.nextLine();
			System.out.println("Test");
			
			for(int i=0; i<option; i++){
				IQuestionSet X = QuestionS.randomSample(option);
				System.out.println(i + ") " + X.getQuestion(i));
				question++;
				
				
				if(X instanceof FillInBlanks){
					System.out.println("Fill in blank question");
					System.out.println(X.getQuestion(i));
					System.out.print("Your answer: ");
					FIB = s.nextLine();
					String[] keywords = (FIB.split(" "));
					
					if(((FillInBlanks) X).checkAnswer(keywords)==true){
						correct++;
						System.out.println("correct!");
					}
					else{
						System.out.println("Incorrect!");
					}
				}
				
				
				if(X instanceof MultipleChoice){
					System.out.println("Multiple Choice");
					
					
					//cast QuestionSet to Multiple Choice.  QuestionSet used to be IQuestionSet
					//must be MultipleChoice type in order to retrieve items within it					
					String[] name = (((MultipleChoice) X).getChoices()); 
					
					for(int i1=0; i1<4; i1++){
						System.out.println(i1 + ")" + name[i1]);				
					}
					
					System.out.print("What is your answer? ");
					answer = s.nextInt();
					if(((MultipleChoice) X).checkAnswer(answer)==true){
						correct++;
						System.out.println("correct!");
					}	
					else{
						System.out.println("Incorrect!");
					}
				}
				
				if(X instanceof ShortAnswerQuestion){
					System.out.println("Short Answer question");
					System.out.print("Short answer: ");
					s.nextLine();
					SA = s.nextLine();
										
					if(((ShortAnswerQuestion) X).checkAnswer(SA)==true){
						correct++;
						System.out.println("correct!");
					}	
					else{
						System.out.println("Incorrect!");
					}
				}
				
				if(X instanceof TrueFalseQuestion){
					System.out.println("true/false");
					tf = s.nextBoolean();
					if(((TrueFalseQuestion) X).checkAnswer(tf)==true){
						correct++;
						System.out.println("correct!");
					}
					else{
						System.out.println("Incorrect!");
					}
				}		
			}
		}
/*&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&*/
		System.out.println("Total amount correct: " + correct);
		System.out.println("Total amount of questions: " + question);
		
		
	}//end main

}//end class

	


