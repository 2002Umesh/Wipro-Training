//Find first non-repeating character in a string
//Find element with maximum frequency.
//Sort a map by keys.
//Remove duplicate characters from string.

package dayeleven_pkg;

import java.util.*;

public class DayEleven_task1 {

	public static void main(String[] args) {
		
		String str = "aababcde";
		System.out.println("Input string: " + str);
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			char s = str.charAt(i);
			if (s == ' ')
				continue;
			map.put(s, map.getOrDefault(s, 0) + 1);
		}
        for (char ch : str.toCharArray()) {
            if (map.get(ch) == 1) {
                System.out.println("First non-repeating character is: " + ch);
                break;
            }
        }
        
        char maxFreqEle = '\0';
        int maxValue=-1;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxFreqEle = entry.getKey();
            }
        }
        
        System.out.println("Element with max frequency: "+maxFreqEle);
        
        System.out.println("Current map: "+map);
        
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        
        list.sort(Map.Entry.<Character,Integer>comparingByKey());
        System.out.println("Sorted values by key: "+list);
        
        Set<Character> set = new LinkedHashSet<>();

        for (char ch : str.toCharArray()) {
            set.add(ch);
        }

        StringBuilder result = new StringBuilder();
        for (char ch : set) {
            result.append(ch);
        }

        System.out.println("String after removed duplicates: "+result);
        
        

	}

}
