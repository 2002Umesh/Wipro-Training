package dayseven_assignment;

import java.util.*;

public class Assignment_sol {

	public static void main(String[] args) {
		// 1. Second Largest Element
		List<Integer> list = Arrays.asList(4, 7, 8, 2, 4);
		System.out.println("Input list: " + list);
		int l = -1, sl = -2;
		for (Integer val : list) {
			if (val > l) {
				int temp = l;
				l = val;
				sl = temp;
			} else {
				if (val > sl)
					sl = val;
			}

		}
		System.out.println("Second Largest: " + sl);
		System.out.println("**************************");

		// 2. Common elements between two Sets
		Set<Integer> set1 = new HashSet<Integer>();
		Set<Integer> set2 = new HashSet<Integer>();
		Set<Integer> set3 = new HashSet<Integer>();

		set1.addAll(Arrays.asList(2, 5, 7, 9));
		set2.addAll(Arrays.asList(2, 8, 3, 9));
		System.out.println("Input set 1: " + set1);
		System.out.println("Input set 2: " + set2);
		for (Integer val : set1) {
			if (set2.contains(val))
				set3.add(val);
		}
		System.out.println("Common elements: " + set3);
		System.out.println("**************************");

		// 3. Find elements present in either of the sets but not both
		Set<Integer> set4 = new HashSet<Integer>();
		Set<Integer> set5 = new HashSet<Integer>();
		Set<Integer> set6 = new HashSet<Integer>(set4);

		set4.addAll(Arrays.asList(2, 5, 7, 9));
		set5.addAll(Arrays.asList(2, 8, 3, 9));
		System.out.println("Input set 1: " + set4);
		System.out.println("Input set 2: " + set5);
		for (Integer val : set4) {
			if (!set5.contains(val))
				set6.add(val);
		}
		for (Integer val : set5) {
			if (!set4.contains(val))
				set6.add(val);
		}
		System.out.println("Elements present in either of the set: " + set6);

	}

}
