//4. Append Data to File
//Write a program to:
//• Take user input
//• Append that data into an existing file without deleting previous content


package dayten_pkg;

import java.io.*;

import java.util.*;

public class dayten_tasks {

	public static void main(String[] args) throws IOException {
		//create file
		File f1 = new File("Texts.txt");
		f1.createNewFile();
		
		//write file
		BufferedWriter bw = new BufferedWriter(new FileWriter("Texts.txt"));
		bw.write("Hello Welcome to SDET learning");
		bw.close();
		
		
		
		//read file
		BufferedReader br = new BufferedReader(new FileReader("Texts.txt"));
		BufferedReader br1 = new BufferedReader(new FileReader("Texts.txt"));
		
		String l1;
		System.out.println("File before append: ");
		while((l1=br.readLine())!=null)
		{
			System.out.println(l1);
		}
		br.close();
		
		//append file
		FileWriter wt = new FileWriter("Texts.txt", true);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Text to append: ");
		String inp = sc.nextLine();
		
		wt.write("\n"+inp);
		wt.close();
		System.out.println("File after append: ");
		while((l1=br1.readLine())!=null)
		{
			System.out.println(l1);
		}
		br1.close();
		sc.close();

	}

}
