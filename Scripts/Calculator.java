package main;

public class Calculator {
	private Infix2Postfix i2p = null;
	private String[] history = null;
	int current;
	private final int histSize = 10;
	
    int iter = -1;
	
	public Calculator() {
		i2p = new Infix2Postfix();
		history = new String[histSize];
		for(int i = 0; i < histSize; i++) {
			history[i] = null;
		}
		current = 0;
	}
	
	public double doCal(String exp) throws Exception {
		history[current] = exp;
		iter = current;
		//System.out.println(history[current] + "   " + current + "  " + iter);
		current = ( current + 1 ) % histSize;
		return i2p.doCal(i2p.doConvert(exp));
	}
	
	public int previous() {
		int tmp = iter--;
		//iter--;
		if(iter == -1) {
			if(history[histSize - 1] != null) {
				iter = histSize - 1;
			}
			else {
				iter = 0;
			}
		}
		return tmp;
	}
	
	public String getPrevious() {
		return history[previous()];
	}
}