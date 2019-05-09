package main;

import javax.swing.JFrame;

public class MainPane extends JFrame {
	MyContentPane cp = null;
	public MainPane(String name) {
		super(name);
		cp = new MyContentPane();
		this.setContentPane(cp);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		setVisible(true);
	}
	
	public static void main(String[] arg) {
		new MainPane("Test");
	}
	
	

}