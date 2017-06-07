package test.impl;

import java.io.Serializable;

import com.jsoftware.test.IFillInBlanksQuestion;

public class FillInBlanks extends Question implements IFillInBlanksQuestion, Serializable{
	/** must use everything in IFillInBlanksQuestion 
	do not reuse everything from Question class**/

	private String[] answer;
	
	FillInBlanks(String question, String[] answer){
		super(question);
		this.answer = answer;
	}

	@Override
	public boolean checkAnswer(String[] keywords) {
		
		if(answer.length != keywords.length){
			return false;
		}
		
		for(int i = 0; i<answer.length; i++){
			if(keywords[i].equalsIgnoreCase(answer[i])){
				return true;
			}						
		}
		return false;
	}
	



}
