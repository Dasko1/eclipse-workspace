package intro;

public class MethodsDemo {

	public static void main(String[] args) {
		// You can't write or declare a method in this main block! This is just for execution!
		
		MethodsDemo x = new MethodsDemo();
		String name = x.getData();		// You are capturing everything in the getData method in the variable name (ll.22-25)!  
		System.out.println(name);
		String name3 = getData2();		// Static means you are working from the class level so you need not declare an object variable (ll. 29-32)!
		System.out.println(name3);		// Remember you need to wrap the return statement from getData2 into a String variable!
		getData3();						// This is all you need! This is static so you are working from the class level, no need for object declaration!
		
		
		// Remember methDemo2 is an object of the class MethodsDemo2!  The object methDemo2 calls the variable getData in MethodsDemo2!
		MethodsDemo2 methDemo2 = new MethodsDemo2();
		methDemo2.voidDemo();			// This will print out the voidDemo() method from the MethodsDemo2 class!
		String name2 = methDemo2.getData();
		System.out.println(name2);		// This will print out the return statement in the MethodsDemo2 class!
	}
	
	
	  public String getData() { 
		System.out.println("Hello World!"); 
			return "rahul shetty"; 
		}
	  
	  public static String getData2() {
		  
		  return "\nThis is printed from a static method that returns a String!";
	  }
	  
	  public static void getData3() {
		  System.out.println("This is from a static void that returns nothing!");
	  }
}
