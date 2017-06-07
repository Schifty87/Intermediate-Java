package impl;

import java.io.Serializable;

import com.jsoftware.test.IQuestion;

public class Question implements IQuestion, Serializable {

	private String question;
	
	Question(String question){
		this.setQuestion(question);
	}
	
	private void setQuestion(String question) {
		this.question = question;
		
	}

	public String getQuestion() {
		return question;
	}

	public boolean checkAnswer(boolean b) {
		// TODO Auto-generated method stub
		return false;
	}
}
