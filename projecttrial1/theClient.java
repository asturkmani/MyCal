package projecttrial1;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.*;

public class theClient {
	
	
	public  theClient()
	{
		
	
	}

	
	public static boolean login(String username, String password) throws Exception {
		
		 String response;
		Socket clientSocket = new Socket("localhost", 6780);
		  
		  DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		  
		  BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		  
		  outToServer.writeBytes("LOGIN\n"); //added the keyword or "verb"
		  outToServer.writeBytes(username + "\n"); //send the username
		  outToServer.writeBytes(password + "\n\n"); //send the password followed by an empty line to signal end of command
		  response = inFromServer.readLine(); //get the response from the user (success or fail)
		  
	
		  switch(response)
		  {
		  case "success":
			  return true;
			  
			  
		  case "fail":
			  return false;
			  
		  }
		  
		  
//		  System.out.println("FROM SERVER: " + response);
		  //clientSocket.close();

		  return false;
			
		
	}
	
	


public static void signup(String username, String password, String email, String firstname, String lastname, String dob) throws Exception
{
	
	Socket clientSocket = new Socket("localhost", 6780);
	  
	  DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
	  
	  BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	
	 outToServer.writeBytes("SIGNUP\n");
	  outToServer.writeBytes(username + "\n");
	  outToServer.writeBytes(password + "\n");
	  outToServer.writeBytes(email + "\n");
	  outToServer.writeBytes(firstname + "\n");
	  outToServer.writeBytes(lastname+ "\n");
	  outToServer.writeBytes(dob + "\n\n");
	  clientSocket.close();
	  
	  
	  
	 
}


public static void addfriend(String username1, String username2) throws Exception {
	
	Socket clientSocket = new Socket("localhost", 6780);
	  
	  DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
	  
	  BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	
	 outToServer.writeBytes("ADDFRIEND\n");
	 outToServer.writeBytes(username1 + "\n");
	 outToServer.writeBytes(username2 + "\n\n");
	//clientSocket.close();
	 
	 
	
	
	
}

}


