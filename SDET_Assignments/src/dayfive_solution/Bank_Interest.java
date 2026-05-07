//2.	Create an abstract class Bank with method getInterestRate() and implement it in different bank classes.
package dayfive_solution;

abstract class Bank {
	abstract double getInterestRate();
}

class SBI extends Bank {
	double getInterestRate() {
		return 6.5;
	}
}

class HDFC extends Bank {
	double getInterestRate() {
		return 7.0;
	}
}

class ICICI extends Bank {
	double getInterestRate() {
		return 6.8;
	}
}

public class Bank_Interest {

	public static void main(String[] args) {
		Bank b1 = new SBI();
		Bank b2 = new HDFC();
		Bank b3 = new ICICI();

		System.out.println("SBI Interest rate: " + b1.getInterestRate());
		System.out.println("HDFC Interest rate: " + b2.getInterestRate());
		System.out.println("ICICI Interest rate: " + b3.getInterestRate());
	}

}
