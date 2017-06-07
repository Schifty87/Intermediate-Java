package impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.jsoftware.test.IQuestion;
import com.jsoftware.test.IQuestionFactory;
import com.jsoftware.test.IQuestionSet;

public class QuestionFactory implements IQuestionFactory, Serializable{
	
	//question factory is not a necessary class, but allows for better organization and only one
	//instance of a class (QuestionFactory) to be used when creating questions

	@Override
	//by making this public, it can be used outside of the class (i.e. QuestionFactory)
	//IQuestion is the type
	public IQuestion makeMultipleChoice(String question, String[] choices, int answer){		
		IQuestion q = new MultipleChoice(question, choices, answer);
		//must return type IQueston
		return q;
	}

	@Override
	public IQuestion makeTrueFalse(String question, boolean answer) {		
		IQuestion q = new TrueFalseQuestion(question,answer);	
		return q;
	}

	@Override
	public IQuestion makeFillInBlank(String question, String[] answers) {
		IQuestion q = new FillInBlanks(question,answers);
		return q;
	}

	@Override
	public IQuestion makeShortAnswer(String question, String[] keywords) {
		IQuestion q = new ShortAnswerQuestion(question,keywords);
		return q;
	}

	@Override
	public IQuestionSet load(String file) {
			
		try{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(file)));
			Object o = in.readObject();
			if (o instanceof IQuestionSet) return (IQuestionSet) o;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	
	}

	@Override
	public boolean save(IQuestionSet testSet, String file) {
		
		try{
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(file)));
			out.writeObject(testSet);
			out.close();	
		}catch(Exception e){
			e.printStackTrace();
		}		
		return true;
	}

	@Override
	public IQuestionSet makeEmptyTestSet() {
		// TODO Auto-generated method stub
		return null;
	}

}
