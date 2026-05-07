//1.	Create a package com.math.operations and write a class to perform addition and subtraction.
package com.math.operations;

public class Calculator {
	
	public int add(int a, int b)
	{
		return a+b;
	}
	public int subtract(int a, int b)
	{
		return a-b;
	}

	public static void main(String[] args) {
		Calculator c=new Calculator();
		
		System.out.println("Addition: "+c.add(1, 4));
		System.out.println("Subtraction: "+c.subtract(5, 7));

	}

}
