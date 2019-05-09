package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class ButtonListener implements ActionListener {
	//Must have access to the text field int content pane
	//Must perform calculation
	Calculator cal = null;
	JTextField tField = null;
	StringBuilder input = null;
	public ButtonListener(JTextField field) {
		tField = field;
		cal = new Calculator();
		input = new StringBuilder();
	}
	
	public void actionPerformed(ActionEvent event) {
		String cmd = event.getActionCommand();
		switch (cmd) {
		/*{"AMT","TRM", "RT", "\u2190", "\u2191",
        "(", ")", "C", "\u00B1", "\u221A",
         "7", "8", "9", "/", "^",
          "4", "5", "6", "*", "1/x",
          "1", "2", "3", "-" , " =" ,
          "0",  ".", "+"  };*/
		case "(":
		case ")":
		case "7":
		case "8":
		case "9":
		case "/":
		case "4":
		case "5":
		case "6":
		case "*":
		case "1":
		case "2":
		case "3":
		case "-":
		case "0":
		case ".":
		case "+":
		case "^":
			input.append(cmd);
			tField.setText(input.toString());
			break;
		case " =":
			String re;
			try {
				re = cal.doCal(input.toString()) + "";
			}
			catch(Exception e) {
				re = "Error";
			}
			tField.setText(re);
			input.delete(0, input.length());
			break;
		case "1/x":
			StringBuilder lastNumber = new StringBuilder();
			if(input.length() == 0 && tField.getText().length()!=0) {
					input.append(tField.getText());
			}
			else {
				break;
			}
			
			int i = input.length()-1;
			char previous = input.charAt(i);
			while(Character.isDigit(previous)||previous == '.') {
				lastNumber.insert(0, previous);
				i--;
				if(i==-1) {
					break;
				}
				previous = input.charAt(i);
			}
			
			input.delete(i+1, input.length());
			input.append(1.0/Double.valueOf(lastNumber.toString())+"");
			tField.setText(input.toString());
			break;
		case "C":
			input.delete(0, input.length());
			tField.setText(input.toString());
			break;
		case "\u2190":
			if(input.length()!=0) {
				input.delete(input.length()-1, input.length());
				tField.setText(input.toString());
			}
			break;
		case "\u2191":
			String p = cal.getPrevious();
			input.delete(0, input.length());
			input.append(p);
			tField.setText(input.toString());
			break;
		}
		
	}

}