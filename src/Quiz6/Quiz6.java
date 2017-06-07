package Quiz6;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class Quiz6 extends JFrame implements ActionListener{

	
	JButton Button;
	JLabel Counter;
	int counter = 0;
	
	//constructor
	Quiz6(){
		super("Quiz6");
		setSize(400,400);
		setLayout(new FlowLayout());
		Button = new JButton("Button");  //create new Button
		Counter = new JLabel("Counter: ");  //create new Label
		
		//add to frame
		add(Button);
		add(Counter);
		Button.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource() == Button){
			counter++;
			String resultS = Integer.toString(counter);  //need to convert double in to string
			Counter.setText("Counter: " + resultS);
		}
	}
	public static void main(String[] args){
		Quiz6 L6 = new Quiz6();
		L6.setVisible(true);
	}
}