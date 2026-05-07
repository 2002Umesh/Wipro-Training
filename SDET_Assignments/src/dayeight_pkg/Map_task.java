package dayeight_pkg;

import java.util.*;

class Book {
    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    
}

public class Map_task {

	public static void main(String[] args) {
		// 1. Find the first non-repeating character in a string using HashMap.

		String str = "hello world";
		System.out.println("Input String: " + str);

		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (char ch : str.toCharArray()) {
			if (ch != ' ') {
				map.put(ch, map.getOrDefault(ch, 0) + 1);
			}

		}

		for (char ch : str.toCharArray()) {
			if (map.get(ch) == 1) {
				System.out.println("First non-repeating character: " + ch);
				break;
			}
		}

		System.out.println("*****************************");

		// 2. Use List for cart, Map for product-price mapping.

		Map<String, Integer> prodMap = Map.of("Laptop", 50000, "Phone", 20000, "Headphones", 2000, "Mouse", 500);
		System.out.println("Available products: \n" + prodMap);

		List<String> cart = new ArrayList<String>(Arrays.asList("Laptop", "Mouse", "Phone", "Mouse"));
		System.out.println("Cart items: \n" + cart);

		int total = 0;
		for (String item : cart) {
			total += prodMap.getOrDefault(item, 0);
		}

		System.out.println("Total Price: " + total);
		System.out.println("**************************");
		
		//3. Library management
		
		Map<Book, Boolean> library = new HashMap<>(Map.of(
				new Book("Java", "James"), true,
				new Book("Python", "Guido"), true,
				new Book("C++", "Bjarne"), true
				));
		
		System.out.println("Available books in the library: ");
		library.forEach((book,avail) -> System.out.println(book.title+ ", " +book.author + " -> " + (avail ? "Available" : "Issued")));
		
		
        Book b1 = new Book("Java", "James");
        System.out.println("Book for issue: "+b1.title);
        library.put(b1, false);
        System.out.println("Available books in the library after issue: ");
		library.forEach((book,avail) -> System.out.println(book.title+ ", " +book.author + " -> " + (avail ? "Available" : "Issued")));
 
		

	}

}
