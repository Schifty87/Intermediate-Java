package test.impl;

import java.io.Serializable;

import com.jsoftware.test.IMultipleChoiceQuestion;

public class MultipleChoice extends Question implements IMultipleChoiceQuestion,Serializable {

	private int answer;
	private String[] choices;
	
	MultipleChoice(String question, String[] choices, int answer){
		super(question);
		this.answer = answer;
		this.choices = choices;
	}

	@Override
	public boolean checkAnswer(int index) {
		
		if(answer == index){
			return true;
		}		
		return false;
	}

	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}
	
	public String[] getChoices() {
		return choices;
	}

	public void setChoices(String[] choices) {
		this.choices = choices;
	}

}
