package daily_assignments;


public class DayThree_Solution {

	public static void main(String[] args) {

		// 1.Sort an array in ascending and descending order.
		int[] arr1 = { 4, 3, 7, 1, 5, 3, 9 };

		System.out.println("Input array ");
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < arr1.length; i++) {
			for (int j = i + 1; j < arr1.length; j++) {
				if (arr1[i] > arr1[j]) {
					int temp = arr1[i];
					arr1[i] = arr1[j];
					arr1[j] = temp;
				}
			}

		}
		System.out.println("Output ascending array ");
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < arr1.length; i++) {
			for (int j = i + 1; j < arr1.length; j++) {
				if (arr1[i] < arr1[j]) {
					int temp = arr1[i];
					arr1[i] = arr1[j];
					arr1[j] = temp;
				}
			}

		}
		System.out.println("Output descending array ");
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
		System.out.println();
		System.out.println("**************************");
		
		//2.Remove duplicate elements from an array.
		int[] arr2= {3,5,6,3,2,3,2,6,7};
		int[] temp1=new int[arr2.length];
		int k1=0;
		
		System.out.println("Input array ");
		for (int i = 0; i < arr2.length; i++) 
		{
			System.out.print(arr2[i] + " ");
		}
		System.out.println();
		
		for (int i = 0; i < arr2.length; i++) 
		{
			boolean isDup=false;
			for (int j = i + 1; j < arr2.length; j++) 
			{
				if (arr2[i] == arr2[j]) 
				{
					isDup = true;
				}
			}
			if(!isDup)
				{
				temp1[k1]=arr2[i];
				k1++;
				}

		}
		System.out.println("Output array ");
		for (int i = 0; i < temp1.length; i++) {
			System.out.print(temp1[i] + " ");
		}
		System.out.println();
		System.out.println("**************************");
		
		//3.Find largest element in each row.
		int[][] arr3= {{2,3,1},{4,5,6},{9,7,8}};
		
		System.out.println("Input array ");
		for (int i = 0; i < arr3.length; i++) 
		{
			for (int j = 0; j < arr3[i].length; j++) 
			{
				System.out.print(arr3[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("Output ");
		
		for (int i = 0; i < arr3.length; i++) 
		{
			int temp=0;
			for (int j = 0; j < arr3[i].length; j++) 
			{
				if(arr3[i][j]>temp)temp=arr3[i][j];
			}
			System.out.println(temp);
			
		}
		System.out.println("**************************");
		
		//4.Check if array is palindrome.
		int[] arr4 = {1,2,3,4,3,2,1};
		
		System.out.println("Input array ");
		for (int i = 0; i < arr4.length; i++) 
		{
			System.out.print(arr4[i] + " ");
		}
		System.out.println();
		int len1=arr4.length;
		System.out.println("Output ");
		for (int i=0;i<len1;i++)
		{
			if(i==len1-i-1)
				{
				System.out.println("palindrome");break;
				}
			if(arr4[i]!=arr4[len1-i-1])
				{
				System.out.println("Not palindrome");break;
				}
		}
		System.out.println("**************************");
		
		//5.Rotate matrix by 90 degrees.
		int[][] arr5= {{2,3,1},{4,5,6},{9,7,8}};
		int[][] arr6= new int[arr5[0].length][arr5.length];
		
		System.out.println("Input array ");
		for (int i = 0; i < arr5.length; i++) 
		{
			for (int j = 0; j < arr5[i].length; j++) 
			{
				System.out.print(arr5[i][j] + " ");
			}
			System.out.println();
		}
		
		for (int i = 0; i < arr5.length; i++) 
		{
			for (int j = 0; j < arr5[i].length; j++) 
			{
				arr6[i][j]=arr5[j][i];
			}
			
		}
		
		System.out.println("Output array ");
		for (int i = 0; i < arr6.length; i++) 
		{
			for (int j = 0; j < arr6[i].length; j++) 
			{
				System.out.print(arr6[i][j] + " ");
			}
			System.out.println();
		}

	}

}
