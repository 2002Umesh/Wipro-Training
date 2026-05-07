//1.Write a program where a method accepts an
//integer parameter and tries to change its value.
//Print the value before and after the method call.
package daysix_sol;

public class TaskOne {
	
	static void changeValue(int a)
	{
		a=100;
	}

	public static void main(String[] args) {
		int val=50;
		System.out.println("Value before change: "+val);
		changeValue(val);
        System.out.println("Value after change: "+val);

	}

}
