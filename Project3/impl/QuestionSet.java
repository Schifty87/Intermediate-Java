package impl;

import java.io.Serializable;
import java.util.ArrayList;

import com.jsoftware.test.IQuestion;
import com.jsoftware.test.IQuestionSet;


public class QuestionSet implements IQuestionSet, Serializable{

	/**
	 * 
	 */
	ArrayList<IQuestion> list = new ArrayList<>();  //research ArrayList<>
	
	@Override
	public IQuestionSet emptyTestSet() {
		list.clear();
		return this;
	}

	@Override
	public IQuestionSet randomSample(int size) {
		
		
		IQuestionSet QS = new QuestionSet();
		
		int[] x = new int[size];
		int i = 0;
		
		{while(i<size);
		
			int R = (int)(Math.random()*size());			
			for(int j=0; j<size;j++){
				if(R != x[j]){
					QS.add(getQuestion((int)(Math.random()*size())));  //getQuestion inside of .add function
					i++;
				}	
			
			}		
		}//end while
		
		return QS;
	}

	@Override
	public boolean add(IQuestion question) {		
		list.add(question);
		return true;		
	}

	@Override
	public boolean remove(int index) {
		list.remove(index);
		return true;
	}

	@Override
	public IQuestion getQuestion(int index) {		
		return list.get(index);
	}

	@Override
	public int size() {
		return list.size();
	}

}
