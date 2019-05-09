package main;

import java.util.Stack;


public class Infix2Postfix {
	/*public static void main(String[] arg) {
		String exp = "7+2*(2+3)";
		String p = doConvert(exp);
		System.out.println(doCal(p));
				
	}*/
	private String expString = null;
	public double doCal(String postfixExp) throws Exception{
		expString = postfixExp;
		Stack<Double> stk = new Stack<Double>();
		while(expString.length() != 0) {
			String ntoken = nextToken();
			if(ntoken.charAt(0) == '.' || Character.isDigit(ntoken.charAt(0))) {
				stk.push(Double.valueOf(ntoken));
			}
			else {
				double op2 = stk.pop();
				double op1 = stk.pop();
				double tmp;
				if( ntoken.equals("+")) {
					tmp = op1 + op2;
				}
				else if( ntoken.equals("-")) {
					tmp = op1 - op2;
				}
				else if( ntoken.equals("^")) {
					tmp = Math.pow(op1, op2);
				}
				else if( ntoken.equals("*")) {
					tmp = op1 * op2;
				}
				else {
					tmp = op1 / op2;
				}
				stk.push(tmp);	
			}
		}
		return stk.pop();
	}
	
	public String doConvert(String exp) {
		expString = exp;
		
		Stack<String> stk = new Stack<String>();
		StringBuffer postfix = new StringBuffer();
		String ntoken = null;
		while(expString.length() != 0) {
			ntoken = nextToken();
			if(ntoken.equals("(")) {
				stk.push(ntoken);
			}
			else if (ntoken.equals(")") ){
				String tmp = null;
				while(!stk.empty()) {
					tmp = stk.pop();
					if(tmp.equals("(")) {
						break;
					}
					else {
						postfix.append(tmp + " ");
					}
				}
			}
			else if (ntoken.equals("+") || ntoken.equals("-")) {
				while(!stk.empty() && !stk.peek().equals("(")) {
					postfix.append(stk.pop() + " ");
				}
				stk.push(ntoken);	
			}
			else if (ntoken.equals("*") || ntoken.equals("/")) {
				while(!stk.empty() && !stk.peek().equals("(") && !stk.peek().equals("+") && !stk.peek().equals("-")) {
					postfix.append(stk.pop() + " ");
				}
				stk.push(ntoken);	
			}
			else if (ntoken.equals("^")) {
				while(!stk.empty() && !stk.peek().equals("(") && !stk.peek().equals("+") && !stk.peek().equals("-")
						              &&!stk.peek().equals("*")&&!stk.peek().equals("/")) {
					postfix.append(stk.pop() + " ");
				}
				stk.push(ntoken);	
			}
			else {
				stk.push(ntoken);
			}
		}
		while(!stk.empty()) {
			postfix.append(stk.pop() + " ");
		}
		return postfix.toString().trim();
	}
	
	private String nextToken() {
		String token = null;
		int i = 0;
		char tmp = expString.charAt(i);
		if( tmp != '.' && !Character.isDigit(tmp)) {
			token = tmp + "";
			expString = expString.substring(1).trim();
		}
		else {
			while(expString.charAt(i) == '.' || Character.isDigit(expString.charAt(i))) {
				i++;
				if( i == expString.length()) {
					break;
				}
			}
			token = expString.substring(0, i);
			expString = expString.substring(i).trim();
			}
		return token;
	}


}