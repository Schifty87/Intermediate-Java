package impl;

import java.io.Serializable;

import com.jsoftware.test.IShortAnswerQuestion;

public class ShortAnswerQuestion extends Question implements IShortAnswerQuestion, Serializable{
	
	private String[] keywords;
	
	ShortAnswerQuestion(String question, String[] keywords) {
		super(question);
		this.setKeywords(keywords);
	}

	@Override
	public boolean checkAnswer(String answer) {
		for(int i=0; i<keywords.length; i++){
			if(answer.contains(keywords[i])){
				return true;
			}
		}
		return false;
	}

	public String[] getKeywords() {
		return keywords;
	}

	public void setKeywords(String[] keywords) {
		this.keywords = keywords;
	}

}
