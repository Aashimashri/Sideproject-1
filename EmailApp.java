import java.util.*;
public class EmailApp {
 private String firstname = null;
 private String lastname = null ;
 private String password ;
 private String department ;
 private int mailboxcapacity= 500;
 private String email;
 private int defaultPasswordLength = 10;
 private String collegeSuffix = "kiet.edu";
  EmailApp() {
	 
	 
 }
 
  EmailApp(String firstname,String lastname ) {
	 this.firstname = "aashima";
	 this.lastname = "Shrivastava";
	 
	  this.department = setdept();
	  System.out.println("Department:" + this.department);
	  this.password = randompass(defaultPasswordLength);
	  System.out.println("Your password is "+ this.password);
	  
	}
 
  
 public String getFirstname() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public String getLastname() {
	return lastname;
}

public void setLastname(String lastname) {
	this.lastname = lastname;
}
private String setdept() {
	System.out.println("Enter the department\n 1 for MCA\n 2 for MBA\n Enter dept code:");
	Scanner sc = new Scanner(System.in);
	int deptchoice = sc.nextInt();
	if(deptchoice == 1) {
		return "mca";
	}
	else if( deptchoice == 2) {
		return "mba";
	}
	return null;
}
private String randompass(int length) {
	String passwordset = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
	char[] password = new char[length];
	for(int i =0;i<length;i++) {
		int rand = (int) (Math.random()* passwordset.length());
		password[i]= passwordset.charAt(rand);
	}
	return new String(password);
	
}
public int getMailCapacity() {
	return mailboxcapacity;
}
public void setMailBoxCapacity(int capacity) {
	this.mailboxcapacity = capacity;
	
}
public String getPassword() {
	return password;
}
public void changepass(String password) {
	this.password = password;
	
}

 void display() {
	  email = getFirstname().toLowerCase()+ "." + getLastname().toLowerCase()+ "@" + this.department
				 + collegeSuffix;
	  System.out.println("Displaying all information and are as follows :"+ "\nDisplay name:"+ getFirstname()+ " "+ getLastname()+ " "
			  
	  +"\nMailbox capacity :" + mailboxcapacity +"mb" + "\nYour mail id: " + email);
	
	 
	  
	  
}


 
 
 

}
	
