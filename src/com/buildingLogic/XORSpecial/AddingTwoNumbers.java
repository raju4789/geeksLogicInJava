package com.buildingLogic.XORSpecial;

/*
 * Write a function Add() that returns sum of two integers. The function 
 * should not use any of the arithmetic operators (+, ++, �, -, .. etc).

Sum of two bits can be obtained by performing XOR (^) of the two bits. 
Carry bit can be obtained by performing AND (&) of two bits.
Above is simple Half Adder logic that can be used to add 2 single bits.
We can extend this logic for integers. If x and y don�t have set bits at 
same position(s), then bitwise XOR (^) of x and y gives the sum of x and y. 
To incorporate common set bits also, bitwise AND (&) is used. Bitwise AND of x and y gives
all carry bits. We calculate (x & y) << 1 and add it to x ^ y to get the required result.
*/
public class AddingTwoNumbers {

	public static void main(String[] args) {
		int firstNumber=-456;
		int secondNumber=-200;
		int sum;
		
		if(secondNumber==0){
			sum=firstNumber;
			System.out.println("Sum of two numbers is "+sum);
		}
		else if(firstNumber==0){
			sum=secondNumber;
			System.out.println("Sum of two numbers is "+sum);
		}
		else{
			sum=addTwoNumbers(firstNumber, secondNumber);
			System.out.println("Sum of two numbers is "+sum);
		}				
	}	
	static int addTwoNumbers(int x, int y){
		while (y != 0)
	    {
	        // carry now contains common set bits of x and y
	        int carry = x & y;  
	 
	        // Sum of bits of x and y where at least one of the bits is not set
	        x = x ^ y; 
	 
	        // Carry is shifted by one so that adding it to x gives the required sum
	        y = carry << 1;
	    }		
		return x;
	}

}
