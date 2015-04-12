package projecttrial1.archive;

//package projecttrial1;
import java.io.*;
import java.net.*;
import java.util.Scanner;

class clientnogui1
{
 public static void main(String argv[]) throws Exception
 {
	 System.out.println("Login=0, Sign-Up=1"); //simple user interface
	 Scanner z = new Scanner(System.in);
	int temp = z.nextInt(); //assumes user would enter an integer, not fool-proof. will work on it in the future 
							//note 0 gives a login and any other integer gives a sign up
	
	
	Socket clientSocket = new Socket("localhost", 6780);
	  
	  DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
	  
	  BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	  
	
	if (temp==0) //we have a login
	{
	 	 
	 
	 
  System.out.println("Enter username followed by password");

  Scanner x = new Scanner(System.in); //scanner to take in username and password
  String username = x.nextLine(); //get the username 
  String password = x.nextLine(); //get the password
  String response;
  
  
  //sentence = inFromUser.readLine();
  outToServer.writeBytes("LOGIN\n"); //added the keyword or "verb"
  outToServer.writeBytes(username + "\n"); //send the username
  outToServer.writeBytes(password + "\n\n"); //send the password followed by an empty line to signal end of command
  response = inFromServer.readLine(); //get the response from the user (success or fail)
  
  System.out.println("FROM SERVER: " + response);
  clientSocket.close();
 }



else {
 //Registration
	 System.out.println("Enter username, password, fname, lname, email, dob in that order"); //again not fool-proof

	 Scanner x = new Scanner(System.in); //scanner to take in username and password
	 
	  //same concept as login but with more paramters
	 
	 String username = x.nextLine();
	  String password = x.nextLine();
	  String email = x.nextLine();
	  String firstname = x.nextLine();
	  String lastname = x.nextLine();
	  String dob = x.nextLine();
	
	  outToServer.writeBytes("SIGNUP\n");
	  outToServer.writeBytes(username + "\n");
	  outToServer.writeBytes(password + "\n");
	  outToServer.writeBytes(email + "\n");
	  outToServer.writeBytes(firstname + "\n");
	  outToServer.writeBytes(lastname+ "\n");
	  outToServer.writeBytes(dob + "\n\n");
	  
	  
	
	
	
	
}
}


}