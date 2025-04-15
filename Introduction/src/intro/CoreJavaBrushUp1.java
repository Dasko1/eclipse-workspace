package intro;

// This is a class package!
import java.util.ArrayList;

public class CoreJavaBrushUp1 {

	public static void main(String[] args) {
		
		int myNum = 5;
		String website = "Rahul Shetty Academy";
		char letter = 'r';
		double dec = 5.99;
		boolean myCard = true;
		
		System.out.println(myNum + " is the value stored in the myNum variable!");
		System.out.println(website);
		// Arrays - the line below is an array declaration: you are telling Java what to do! Also "initializing the array"!
		int[] arr = new int[5];
		arr[0] = 1;		// You are telling Java to put 1 into the 1st array position and so on for 5 spots.
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 4;
		arr[4] = 5;
		
		for(int i = 0; i < arr.length; i++)
		{
			System.out.println(arr[i]);
		};
		System.out.println("");
		
		// Same thing in another shorter way!  This way, you can only print 1 array element at a time with System.out.println([3]);
		// System.out.println("The individual array value you want to print is: " + arr2[3]);
		int[] arr2 = {170,35,14,-41,558};
		for(int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		};
		
		String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		for(int i = 0; i < days.length; i++) {
			System.out.println(days[i]);
		}
		System.out.println("");
		
		//Enhanced array loop
		
		for( String d : days) {
			System.out.println(d);
		}
		System.out.println("");
		
		// Enhanced integer array
		for( int x : arr2) {
			System.out.println(x);
		}
		System.out.println("");
		
		
	}
}
