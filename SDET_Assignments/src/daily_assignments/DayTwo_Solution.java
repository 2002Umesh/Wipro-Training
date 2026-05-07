package daily_assignments;

import java.util.Scanner;

public class DayTwo_Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 1
		int n1 = sc.nextInt();
		switch (n1 % 2) {
		case 0:
			System.out.println("Even");
			break;
		default:
			System.out.println("Odd");
		}

		// 2
		char ch = sc.next().charAt(0);
		switch (ch) {
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
		case 'A':
		case 'E':
		case 'I':
		case 'O':
		case 'U':
			System.out.println("Vowel");
			break;
		default:
			System.out.println("Consonant");
		}

		// 3
		char grade = sc.next().charAt(0);
		switch (grade) {
		case 'A':
			System.out.println("Excellent");
			break;
		case 'B':
			System.out.println("Good");
			break;
		case 'C':
			System.out.println("Average");
			break;
		case 'D':
			System.out.println("Poor");
			break;
		case 'F':
			System.out.println("Fail");
			break;
		default:
			System.out.println("Invalid");
		}

		// 4
		double balance = 1000;
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			System.out.println(balance);
			break;
		case 2:
			double dep = sc.nextDouble();
			balance += dep;
			System.out.println(balance);
			break;
		case 3:
			double wd = sc.nextDouble();
			balance -= wd;
			System.out.println(balance);
			break;
		case 4:
			System.out.println("Exit");
			break;
		default:
			System.out.println("Invalid");
		}

		// 5
		int item = sc.nextInt();
		switch (item) {
		case 1:
			System.out.println("Burger 100");
			break;
		case 2:
			System.out.println("Pizza 200");
			break;
		case 3:
			System.out.println("Pasta 150");
			break;
		default:
			System.out.println("Invalid");
		}

		// 6
		int n2 = sc.nextInt();
		switch (n2 % 2) {
		case 0:
			System.out.println("Even");
			break;
		default:
			System.out.println("Odd");
		}

		// 7
		int opt = sc.nextInt();
		double amt = sc.nextDouble();
		switch (opt) {
		case 1:
			System.out.println("INR to EUR" + amt * 0.0091);
			break;
		case 2:
			System.out.println("INR to USD" + amt * 0.011);
			break;
		default:
			System.out.println("Invalid");
		}

		// 8
		String role = sc.next();
		switch (role) {
		case "Admin":
			System.out.println("Full Access");
			break;
		case "User":
			System.out.println("Limited Access");
			break;
		case "Guest":
			System.out.println("View Only");
			break;
		default:
			System.out.println("Invalid");
		}

		// 9
		int n3 = sc.nextInt(), fact = 1, i = 1;
		while (i <= n3) {
			fact *= i;
			i++;
		}
		System.out.println(fact);

		// 10
		int num = sc.nextInt(), j = 1;
		while (j <= 10) {
			System.out.println(num * j);
			j++;
		}

		// 11
		int n4 = sc.nextInt(), count = 0;
		while (n4 != 0) {
			n4 /= 10;
			count++;
		}
		System.out.println(count);

		// 12
		int n5 = sc.nextInt(), rev = 0;
		while (n5 != 0) {
			rev = rev * 10 + n5 % 10;
			n5 /= 10;
		}
		System.out.println(rev);

		// 13
		int n6 = sc.nextInt(), temp = n6, rev2 = 0;
		while (n6 != 0) {
			rev2 = rev2 * 10 + n6 % 10;
			n6 /= 10;
		}
		if (temp == rev2)
			System.out.println("Palindrome");
		else
			System.out.println("Not");

		// 14
		int n7 = sc.nextInt(), sum = 0;
		while (n7 != 0) {
			sum += n7 % 10;
			n7 /= 10;
		}
		System.out.println(sum);

		// 15
		int n8 = sc.nextInt(), t = n8, s = 0;
		while (t != 0) {
			int d = t % 10;
			s += d * d * d;
			t /= 10;
		}
		if (s == n8)
			System.out.println("Armstrong");
		else
			System.out.println("Not");

		// 16
		int n9 = sc.nextInt(), k = 2, f = 1;
		while (k <= n9 / 2) {
			if (n9 % k == 0) {
				f = 0;
				break;
			}
			k++;
		}
		if (f == 1 && n9 > 1)
			System.out.println("Prime");
		else
			System.out.println("Not Prime");

		// 17
		int terms = sc.nextInt(), a = 0, b = 1, c, l = 1;
		while (l <= terms) {
			System.out.print(a + " ");
			c = a + b;
			a = b;
			b = c;
			l++;
		}

		sc.close();
	}
}
