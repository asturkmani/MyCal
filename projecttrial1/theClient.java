package projecttrial1;

import java.io.*;
import java.net.*;
import java.util.Vector;

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
	
	


public static String signup(String username, String password, String email, String firstname, String lastname, String dob) throws Exception
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
	  
	  String reponse = new String();
	  reponse = inFromServer.readLine();
	  clientSocket.close();
	  
	  return reponse;
 
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

public static void createEvent(String username, Vector<String> friends, String datetime, String location) throws Exception {
	
	Socket clientSocket = new Socket("localhost", 6780);
	
	  DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
	  
	  BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	  
	  // output to server details. send friends
	  outToServer.writeBytes("CREATEEVENT\n");
	  outToServer.writeBytes(datetime + "\n");
	  outToServer.writeBytes(location + "\n");	
	  outToServer.writeBytes(username + "\n");
	 
	//write each friend on a line
	  for (String str : friends){
     		outToServer.writeBytes(str + "\n");
	  }
	  outToServer.writeBytes("\n");
}


public static Vector<String> friendList(String username) throws Exception{
	Vector<String> listOfFriends = new Vector<String>(); //create a vector of strings to send back to gui 
	String response= new String();;
	
	Socket clientSocket = new Socket("localhost", 6780);
	  
	  DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
	  
	  BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	
	  
	  outToServer.writeBytes("FRIENDLIST\n"); //added the keyword or "verb"
	  outToServer.writeBytes(username + "\n\n"); //send the username
	
	  response = inFromServer.readLine();
	
	  while (!response.equals("stopz")){

		  //System.out.println("in the loop");
		  listOfFriends.add(response);
		  //System.out.println(data);
		  response = inFromServer.readLine();
		  
	  }
	  
	 	  return listOfFriends;

}

public static Vector<String> eventList(String username) throws Exception{
	
	
	Vector<String> listOfEvents = new Vector<String>(); //create a vector of strings to send back to gui 
	String response= new String();
	
	Socket clientSocket = new Socket("localhost", 6780);
	  
	  DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
	  
	  BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	
	  
	  outToServer.writeBytes("EVENTLIST\n"); //added the keyword or "verb"
	  outToServer.writeBytes(username + "\n\n"); //send the username
	
	  response = inFromServer.readLine();
	
	  while (!response.equals("stopz")){

		 // System.out.println("in the loop");
		  listOfEvents.add(response);
		  //System.out.println(data);
		  response = inFromServer.readLine();
		  
	  }
	  
	
		  return listOfEvents;

}

public static void deleteEvent(String event) throws Exception{
	
	Socket clientSocket = new Socket("localhost", 6780);
	  
	  DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
	  
	  BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	
	  
	  outToServer.writeBytes("DELETEEVENT\n"); //added the keyword or "verb"
	  outToServer.writeBytes(event + "\n\n"); //send the username
	
	
	
}

public static Vector<String> getDetails(String username) throws Exception{
		Socket clientSocket = new Socket("localhost", 6780);
	  
		Vector<String> details = new Vector<String>();
	  DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
	  
	  BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	
	  String response = new String();
	  outToServer.writeBytes("GETDETAILS\n"); //added the keyword or "verb"
	  outToServer.writeBytes(username + "\n\n"); //send the username
	  
		
	  response = inFromServer.readLine();
	  System.out.println("response from server to theClient: " + response);
	
	  while (!response.equals("stopz")){

		  details.add(response);
		  response = inFromServer.readLine();
		  
	  }
	  
	
		  return details;
	
	}
}




