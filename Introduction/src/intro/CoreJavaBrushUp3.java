package intro;

public class CoreJavaBrushUp3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// String is an object; below String created an object "s" in the Java Memory Space; this is a "String literal"
		// The object s1 is not new but the String literal points s1 to the already created s object in the previous line.
		String s = "Rahul Shetty Academy";
		String s1 = "Rahul Shetty Academy";
		
		// Another way to create a String: here 2 new objects have been created in the memory space.  
		String s2 = new String("Welcome!");
		String s3 = new String("Welcome!");
		
		// Various string operations:
		String[] splittedString =  s.split(" ");
		System.out.println(splittedString[0]);
		
		for(int i = 0; i < s.length(); i++) {
			System.out.print(s.charAt(i));
		}
		
		System.out.println("\n\nNow reverse it!");
		
		// Reverse the String!  You first start at the end of the string object s, then you check if i is greater then 0, then count back!
		for(int i = s.length()-1; i >= 0; i--) {
			System.out.print(s.charAt(i));
		}
		
	}
}
