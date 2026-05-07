package daily_assignments;

import java.util.Scanner;

public class DayOne_Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 1
		int n1 = sc.nextInt();
		if (n1 >= 0)
			System.out.println("Positive");
		else
			System.out.println("Negative");

		// 2
		int n2 = sc.nextInt();
		if (n2 % 2 == 0)
			System.out.println("Even");
		else
			System.out.println("Odd");

		// 3
		int a = sc.nextInt(), b = sc.nextInt();
		if (a > b)
			System.out.println(a);
		else
			System.out.println(b);

		// 4
		int x = sc.nextInt(), y = sc.nextInt(), z = sc.nextInt();
		if (x > y && x > z)
			System.out.println(x);
		else if (y > z)
			System.out.println(y);
		else
			System.out.println(z);

		// 5
		int year = sc.nextInt();
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
			System.out.println("Leap Year");
		else
			System.out.println("Not Leap Year");

		// 6
		char ch = sc.next().charAt(0);
		if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I'
				|| ch == 'O' || ch == 'U')
			System.out.println("Vowel");
		else
			System.out.println("Consonant");

		// 7
		int age = sc.nextInt();
		if (age >= 18)
			System.out.println("Eligible");
		else
			System.out.println("Not Eligible");

		// 8
		int n3 = sc.nextInt();
		if (n3 % 5 == 0 && n3 % 11 == 0)
			System.out.println("Divisible");
		else
			System.out.println("Not Divisible");

		// 9
		int marks = sc.nextInt();
		if (marks < 0 || marks > 100)
			System.out.println("Invalid");
		else if (marks >= 90)
			System.out.println("A");
		else if (marks >= 75)
			System.out.println("B");
		else if (marks >= 60)
			System.out.println("C");
		else if (marks >= 50)
			System.out.println("D");
		else
			System.out.println("F");

		// 10
		int n4 = sc.nextInt();
		if (n4 > 0)
			System.out.println("Positive");
		else if (n4 < 0)
			System.out.println("Negative");
		else
			System.out.println("Zero");

		// 11
		int p = sc.nextInt(), q = sc.nextInt(), r = sc.nextInt();
		if (p < q && p < r)
			System.out.println(p);
		else if (q < r)
			System.out.println(q);
		else
			System.out.println(r);

		// 12
		int age2 = sc.nextInt();
		double salary = sc.nextDouble();
		if (age2 >= 21 && salary >= 25000)
			System.out.println("Eligible");
		else
			System.out.println("Not Eligible");

		// 13
		int n5 = sc.nextInt();
		if (n5 % 3 == 0 || n5 % 7 == 0)
			System.out.println("Divisible");
		else
			System.out.println("Not Divisible");

		// 14
		int num1 = sc.nextInt(), num2 = sc.nextInt();
		char op = sc.next().charAt(0);
		switch (op) {
		case '+':
			System.out.println(num1 + num2);
			break;
		case '-':
			System.out.println(num1 - num2);
			break;
		case '*':
			System.out.println(num1 * num2);
			break;
		case '/':
			System.out.println(num1 / num2);
			break;
		default:
			System.out.println("Invalid");
		}

		// 15
		int day = sc.nextInt();
		switch (day) {
		case 1:
			System.out.println("Monday");
			break;
		case 2:
			System.out.println("Tuesday");
			break;
		case 3:
			System.out.println("Wednesday");
			break;
		case 4:
			System.out.println("Thursday");
			break;
		case 5:
			System.out.println("Friday");
			break;
		case 6:
			System.out.println("Saturday");
			break;
		case 7:
			System.out.println("Sunday");
			break;
		default:
			System.out.println("Invalid");
		}

		sc.close();
	}

}
