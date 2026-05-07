package daysix_sol;

public class DayFiveTasks {

	public static void main(String[] args) {
		// 3. Check if char is digit
		char ch = '7';
		if (Character.isDigit(ch)) {
			System.out.println("Its a digit");
		} else {
			System.out.println("Not a digit");
		}

		// 4. Compare two string
		String s1 = "Hello";
		String s2 = "hello";

		System.out.println(s1.compareTo(s2));
		System.out.println(s1.compareToIgnoreCase(s2));

		// 5. Convert using valueOf method
		int num = 10;
		double d = 5.5;

		String str1 = String.valueOf(num);
		String str2 = String.valueOf(d);

		System.out.println(str1);
		System.out.println(str2);

		// 6. Create Boolean Wrapper usage

        Boolean b2 = Boolean.valueOf(false);//object creation
        System.out.println("b2: " + b2);
		
		String s3 = "true";
		Boolean b3 = Boolean.valueOf(s3);//string to boolean
		System.out.println("b3: "+b3);
		
		Boolean b4 = true;
		String s4 = b4.toString();//boolean to string
		System.out.println("s4: "+s4);
		
		// 7. Convert null to wrapper classes
		String str = null;
		
		try {
			Integer n = Integer.valueOf(str);
			System.out.println(n);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		Boolean bool = Boolean.valueOf(str);
		System.out.println(bool);

	}

}
