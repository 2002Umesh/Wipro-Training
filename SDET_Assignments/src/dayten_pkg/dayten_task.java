//1. Write a Java program to read a text file and count:
//• Number of lines
//• Number of words
//• Number of characters

//2. Buffered Reader Usage
//Write a Java program to read a file using BufferedReader and print only those lines that contain the
//word "Java".

//3. Count Specific Word in File
//Write a program to count how many times a specific word (e.g., "Java") appears in a file.

package dayten_pkg;

import java.io.*;
import java.util.*;

public class dayten_task {

	public static void main(String[] args) throws IOException {
		// create file
		File f1 = new File("ManyLines.txt");

		f1.createNewFile();

		// write file
		BufferedWriter bw = new BufferedWriter(new FileWriter("ManyLines.txt"));

		bw.write("Hello Welcome to SDET learning\n" + "Hello Welcome to java learning\n"
				+ "Hello Welcome to java learning\n" + "Hello Welcome to Selenium learning\n");

		bw.close();

		BufferedReader br = new BufferedReader(new FileReader("ManyLines.txt"));

		String l1;
		int count = 0;
		int c = 0;
		int wordCount = 0;
		int countSpecific = 0;
        List<String> wordSpecific = new ArrayList<String>();
		while ((l1 = br.readLine()) != null) {

			System.out.println(l1);

			c += 1;
			

			String[] words = l1.trim().split(" ");
			if (!l1.trim().isEmpty()) {
				wordCount += words.length;
			}
			
			for(String str: words)
			{
				if (str.equals("java"))
				{
					countSpecific+=1;
				}
			}
			for(String str: words)
			{
				if (str.equals("java"))
				{
					wordSpecific.add(l1);
					break;
				}
			}

			l1 = l1.replaceAll("\\s+", "");
			count += l1.length();
		}
		br.close();

		System.out.println("No of char: " + count);
		System.out.println("No of line: " + c);
		System.out.println("No of words: " + wordCount);
		System.out.println("No of line containing word java: ");
		
		for(String str : wordSpecific)
		{
			System.out.println(str);
		}
		
		System.out.println("No of times java seen: "+countSpecific);
	

	}

}
