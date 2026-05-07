
//2.Create a class Box with a variable length. Write a
//method that modifies the value of length by passing
//the Box object. Show that the original object is
//modified.
package daysix_sol;

class Box {
	int length;

	Box(int length) {
		this.length = length;
	}
}

public class TaskTwo {

	static void Modify(Box b) {
		b.length = 200;
	}

	public static void main(String[] args) {
		Box box = new Box(100);
		System.out.println("Before change: " + box.length);

		Modify(box);

		System.out.println("After change: " + box.length);

	}

}
