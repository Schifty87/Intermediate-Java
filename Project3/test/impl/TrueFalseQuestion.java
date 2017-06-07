package test.impl;

import java.io.Serializable;

import com.jsoftware.test.ITrueFalseQuestion;

public class TrueFalseQuestion extends Question implements ITrueFalseQuestion, Serializable {

	private boolean answer;
	
	public TrueFalseQuestion(String question, boolean answer){
		super(question);
		this.answer = answer;		
	}
	
	void setAnswer(boolean answer){
		this.answer = answer;
	}
	
	boolean getAnswer(){
		return answer;
	}
	
	
	@Override
	public boolean checkAnswer(boolean answer) {
		// TODO Auto-generated method stub
		if(answer==(getAnswer())){
			return true;
		}
		return false;
	}

}
