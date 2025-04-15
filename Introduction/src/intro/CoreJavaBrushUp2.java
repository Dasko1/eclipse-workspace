package intro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoreJavaBrushUp2 {

	public static void main(String[] args) {
		
		// Question: does the following array have a multiple of 2?
		
		int[] arr2 = {1,2,4,5,6,7,8,9,10,122};
		
		for(int i = 0; i < arr2.length; i++) {
				
				if(arr2[i] % 2 == 0) {
				System.out.println(arr2[i]);
				System.out.println("Yes, the array has a multiple of 2!");
				break;
				}
				
				else {
					System.out.println(arr2[i] + " is not a multiple of 2!");
				}
	}
		System.out.println("");
		
		// Array list!  This is a dynamic array in which you can add elements on the fly!
		ArrayList<String> a = new ArrayList<String>();
		// Create object of the class - object.method!  So easy to remember!
		a.add("rahul");
		a.add("shetty");
		a.add("academy");
		a.add("selenium");
		System.out.println("This is the 4th ArrayList value: " + a.get(3));
		System.out.println("");
		
		for(int i = 0; i < a.size(); i++) {
			System.out.println(a.get(i));
		}
		
		System.out.println(a.contains("selenium"));
		System.out.println("");
		// Convert an array to an array list!
		String[] name = {"rahul", "shetty", "selenium"};
		List<String> nameArrayList = Arrays.asList(name);
		nameArrayList.contains("selenium");
				
  }
}
