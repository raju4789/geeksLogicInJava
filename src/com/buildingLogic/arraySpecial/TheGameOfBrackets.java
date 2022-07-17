package com.buildingLogic.arraySpecial;

import java.util.Stack;

/**
 *  Problem: The problem is based on real life scenario our Team at Dcoder faced during development of 
 *  this IDE, In a code editor you need to indent the code and color the closing parenthesis of a 
 *  selected parenthesis, to know the code block and if there are unequal number of parenthesis, there 
 *  must be something wrong, i.e every opening parenthesis should be having closing parenthesis. This 
 *  problem is scaled down version, you are given a string and you need to tell is it valid or not, 
 *  based on the fact stated above.
	Input: Input contains a string
	Output: Print "Yes" for a valid string,else "No" , without quotes.
	Examples:
	(())() : Yes
	(()() : No
	Constraints: 0≤string length≤100
	Ps: Parenthesis for this problem includes "()"
	Sample Input: (((()))())
	Sample Output: 
	Yes
	
 * @author Raju Rockzz :P
 *
 */
public class TheGameOfBrackets {

	public static void main(String[] args) {
		String inputString=")(((()))())";
		if(isValidString(inputString)){
			System.out.println("Yes");
		}
		else{
			System.out.println("No");
		}
	}
	
	static boolean isValidString(String inputString){
		int inputStringLength=inputString.length();
		Stack<Character> s= new Stack<Character>();
		for (int i = 0; i < inputStringLength; ++i) {
			if(inputString.charAt(i) == '('){
				s.push(inputString.charAt(i));
			}
			else if(inputString.charAt(i) == ')'){
				if(s.isEmpty()){
					return false;
				}
				s.pop();
			}
		}
		if(s.isEmpty()){
			return true;
		}
		return false;
	}

}
