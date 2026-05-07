//3.	Write a program where an interface is implemented and exception handling is used inside the method.
package dayfive_solution;

interface Exception_Handling
{
	void DividedbyZero();
}
class Division implements Exception_Handling
{
	int a, b;
	Division(int a, int b) 
	{
		this.a=a;
		this.b=b;
	}
	public void DividedbyZero()
	{
		try {
			int c=a/b;
			System.out.println(c);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

public class Exception_handling_sol {

	public static void main(String[] args) {
		Division d=new Division(4, 0);
		d.DividedbyZero();

	}

}
