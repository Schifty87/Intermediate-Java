package TempConverter;
import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.text.JTextComponent;

@SuppressWarnings("serial")
class TempConverter extends JFrame implements ActionListener{
	
	//make global variables
	JTextField input;
	JLabel farenheitLabel;
	
	//constructor
	TempConverter(){
		super("Temperature Converter");
		setSize(400,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		input = new JTextField(15);
		JLabel celsiusLabel = new JLabel("Celsius");
		JButton convertBtn = new JButton("Convert");
		farenheitLabel = new JLabel("Farenheit");
		setLayout(new FlowLayout());
		
		//add to frame
		add(input);
		add(celsiusLabel);
		add(convertBtn);
		add(farenheitLabel);
		convertBtn.addActionListener(new HandleConversion()); //this refers to the frame		
	}
	

class HandleConversion implements ActionListener{	
	
	public void actionPerformed(ActionEvent e){		
		double celsius = Double.parseDouble(input.getText());
		double farenheit = (9.0/5.0)*celsius+32.0;
		farenheitLabel.setText(farenheit + "Farenheit");
	}
}

	public static void main(String[] args){
		TempConverter TC = new TempConverter();
		TC.setVisible(true); //make it visible
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}