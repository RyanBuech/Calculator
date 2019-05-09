package main;


import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;


import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyContentPane extends JPanel{
	JTextField text = null;
	JPanel buttonPanel = null;
	/*Two ways to get the unicode characters:
	String sqrt = new String(Character.toChars(0x0000221A)); 
	//Same String sqrt = new String("\U221A");
	
	String plus_minus = new String(Character.toChars(0x000000B1));
	//Same String plus_over_minus = new String("\U00B1");
	//String left_arrow = new String(Character.toChars(0x2190));
	String left_arrow = new String("\u2190");
	String up_arrow = new String(Character.toChars(0x00002191));
	*/
	String[] bLabels =  {"AMT","TRM", "RT", "\u2190", "\u2191",
	                     "(", ")", "C", "\u00B1", "\u221A",
	                      "7", "8", "9", "/", "^",
			               "4", "5", "6", "*", "1/x",
			               "1", "2", "3", "-" , " =" ,
			               "0",  ".", "+"  };
	
	JButton[] butns = new JButton[28];
	
	ButtonListener listener = null;
	
	public MyContentPane() {
		super();
		setLayout(new GridBagLayout());
		
		this.setMinimumSize(new Dimension(600,600));
		
		text = new JTextField("");
		listener = new ButtonListener(text);
		
		for(int i = 0; i < bLabels.length; i++) {
			butns[i] = new JButton(bLabels[i]);
			butns[i].addActionListener(listener);
		}
		
		
		text.setColumns(30);
		text.setHorizontalAlignment(JTextField.RIGHT);
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.gridheight = 4;
		c.ipady = 20;
		c.fill = GridBagConstraints.HORIZONTAL;
		add(text, c);
		
		c.insets = new Insets(5,5,5,5);
		
		//The first row of the buttons
		c.gridy = 5;
		c.gridwidth = 1;
		c.gridheight = 3;
		c.weightx = 0.5;
		for(int i = 0; i < 5; i++) {
			c.gridx = i;
			add(butns[i], c);
		}
		
		//The second row of the buttons	
		c.gridy = c.gridy+c.gridheight; 
		for(int i = 0; i < 5; i++) {
			c.gridx = i;
			add(butns[i+5], c);
		}
		//The third row
		c.gridy = c.gridy+c.gridheight; 
		for(int i = 0; i < 5; i++) {
			c.gridx = i;
			add(butns[i+2*5], c);
		}
		//The third row
		c.gridy = c.gridy+c.gridheight; 
		for(int i = 0; i < 5; i++) {
			c.gridx = i;
			add(butns[i+3*5], c);
		}
		//The forth row
		c.gridy = c.gridy+c.gridheight; 
		for(int i = 0; i < 4; i++) {
			c.gridx = i;
			add(butns[i+4*5], c);
		}
		
		
		int temp = c.gridheight;
		c.gridheight = GridBagConstraints.REMAINDER;
		c.fill = GridBagConstraints.VERTICAL;
		c.gridwidth = 2;
		c.gridx = 4;
		c.ipadx=10;
		add(butns[4+4*5], c);
		
		c.ipadx = 0;
		c.gridheight = temp;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridy = c.gridy+c.gridheight; 
		c.gridx = 0;
		c.gridwidth = 2;
		add(butns[0+5*5], c);
		
		c.gridx = c.gridx+c.gridwidth;
		c.gridwidth = 1;
		add(butns[1+5*5], c);
		
		c.gridx = c.gridx+1;
		add(butns[2+5*5], c);
		
	}
}