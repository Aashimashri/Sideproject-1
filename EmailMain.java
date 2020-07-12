import java.util.Scanner;
public class EmailMain {

	public static void main(String[] args) {
	String firstname = null;
		String lastname = null;
		String email = null;
		
	
		EmailApp  e = new EmailApp(firstname,lastname);
		
		
	     Scanner sc = new Scanner(System.in);
	
		System.out.println("Enter first name");
		
       String fname = sc.next();
      e.setFirstname(fname);
       
       System.out.println("Enter last  name");
	    String  lname = sc.next();
	   e.setLastname(lname);
         e.display();
         
     
           
		
	
	

	}

}
