package projecttrial1;

import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Server {

    private int port = 6780;
    private ServerSocket serverSocket;

    public Server() throws ClassNotFoundException {}

    public void acceptConnections() {
        try
        {
            serverSocket = new ServerSocket(port);
        }
        catch (IOException e)
        {
            System.err.println("ServerSocket instantiation failure");
            e.printStackTrace();
            System.exit(0);
        }

        while (true) {
            try
            {
                Socket newConnection = serverSocket.accept();
                //System.out.println("accepted connection");
				//now each client gets a threads that deals with its connection and requests //
                ServerThread st = new ServerThread(newConnection);
                new Thread(st).start();
				//now the server will continue waiting for other requests and the current user will be serviced
				// by the created thread //
            } 
            catch (IOException ioe)
            {
                System.err.println("server accept failed");
            }
        }
    }

    public static void main(String args[]) throws Exception {

        Server server = null;
        try {
            server = new Server();
        } catch (ClassNotFoundException e) {
            //   System.out.println("unable to load JDBC driver");
            e.printStackTrace();
            System.exit(1);
        }

        server.acceptConnections();
    }

    class ServerThread implements Runnable {

        private Socket socket;
        private BufferedReader inFromClient;
        private DataOutputStream outToClient;

        public ServerThread(Socket socket) {
            this.socket = socket;
        }

        public void run()
        {
            try
            {
                inFromClient =  new BufferedReader(new InputStreamReader(socket.getInputStream()));
                outToClient = new DataOutputStream(socket.getOutputStream());
            } 
            catch (IOException e)
            {
                return;
            }
            // Start editing server functions from here
            try 
            {

                String verb; //verb is the keyword that defines what operation is being done
                  
                   
                   verb = inFromClient.readLine().toLowerCase(); //the client side sends a keyword based on the desired operation
                   
                   Vector<String> input = new Vector<String>(); //new vector to store the data (e.g. username password email first name)
                   											//the content depends on the operation (e.g. vector for login will be of size 2)
                   
                   
                   String clientSentence = new String(); //create a string to take input
               	
                   clientSentence = inFromClient.readLine(); //read first time (in the case of login this would be username)
                   											//also happens to be username for the signup case
                   											//in future milestone we would have different cases
                              
                   while (!clientSentence.equals("")) //stop reading when we get an empty string
                   									//notice in the client side the last piece of data is sent with
                   									//two line breaks, this makes the last readLine an empty string
                   {
                 
                   	input.add(clientSentence);
                   	clientSentence = inFromClient.readLine(); //at the last iteration this readLine would be an empty string
                   	
                   }
                   
                   ///////SQL PART////////
                   
                   Connection conn = null; //create a connection instance
                   
           		try {	
           			Class.forName("com.mysql.jdbc.Driver");			//regular JDBC stuff
           		} catch (ClassNotFoundException e) {
           			e.printStackTrace();
           			return;
           		}
           		
           		try {
           			conn = DriverManager
           			.getConnection("jdbc:mysql://localhost:3306/mydb","root",""); //mydb is the name of our database
           		
           		}
           		 catch (SQLException e) {		
            			
            			e.printStackTrace();
            			return;
            		}
            		
                   String returnz = null; 		//returnz is the reply that the server will send out (either success or fail)
                  // System.out.println(verb);
                   
                   
                   switch(verb)			//based on the verb we select the operation
                   {
                   
                   case "login": 	//login operation, call the login function
                   	
                	   try {
                   	returnz=login(input, conn);
                	   }
                	   catch (SQLException e){
                		   e.printStackTrace();
                	   }
                   break;
                   
                         	
                   case "signup": 
                	   
                	   try {
                	   returnz=signup(input, conn);	//signup operation, call the signup function
                	   }
                	   catch (SQLException e){
                		   e.printStackTrace();
                	   }
                   break;
                   
                   case "addfriend":
                	   try {
                		   returnz=addfriend(input, conn);
                	   }
                	   catch (SQLException e){
                		   e.printStackTrace();
                	   }
                   	break;
                   	
                   case "friendlist":
                   	Vector<String> friendlist = new Vector<String>();
                   	try {
						friendlist=friendlist(input, conn);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                   	//outToClient2.writeObject(friendlist);
                   	for (String str : friendlist){
                   		outToClient.writeBytes(str + "\n");
	                   	}
                   	
                   	returnz="stopz"; //here this signals the client to stop reading because we dont know how long the list of friends is

                   	break;
                   	
                   
                   case "deleteevent":
                	   try {
						returnz=deleteevent(input, conn);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                   
                   case "eventlist":
                      	Vector<String> eventlist = new Vector<String>();
                      	try {
   						eventlist=eventlist(input, conn);
   					} catch (SQLException e) {
   						// TODO Auto-generated catch block
   						e.printStackTrace();
   					}
                      	
                      	
                      	for (String str : eventlist){
                      		outToClient.writeBytes(str + "\n");
          		           	}
                
                      	returnz="stopz"; //here this signals the client to stop reading because we dont know how long the list of friends is
                        
                      	
                      	
                      	break;
                      	
                   
                   
                   
                   
                   
                   
                   
                   
                   case "createevent":
                	   try{
                		   System.out.println("just before calling create even");
                		   returnz=createevent(input, conn);
                	   } catch (SQLException e) {
   						e.printStackTrace();
   					}
                   default: outToClient.writeBytes("Everything Failed!\n"); //this should never come because 'login' and 'signup' are
                   																//defined by the client side application and not the user
                   																//so they are supposed to be fool-proof. but in case
                   break;
                   
                   
                   }
                   
                   outToClient.writeBytes(returnz + "\n"); //send back the response, followed by a line break 
                   
                   
                   
                   // Do not edit lines below this.
                   
            }
            catch (IOException k)
            {
                System.out.println(k);
            }
            try
            {
                //System.out.println("closing socket");
                inFromClient.close();
                outToClient.close();
                socket.close();
            } 
            catch (IOException e)
            {
            }
        }
    }
    
    
    // Create functions here.
   public static String login(Vector<String> data, Connection conn) throws SQLException {
	   
	   PreparedStatement stmt;	//using prepared statement to protect from SQL injection
	   ResultSet rs;
	   stmt = conn.prepareStatement("select username from user where username = ? AND password = ?"); //this sql query
	   //is supposed to return just one or none rows since username is a primary key and we would only have one result (if any)
	   stmt.setString(1, data.get(0)); //data.get(0) would be the username
	   stmt.setString(2, data.get(1)); //data.get(1) would be the password
	   
	   
	   
	   
	   rs = stmt.executeQuery(); //execute the statement
	   
	   				
		
		
		
		if(!rs.next())		//the resultset would have a 'next' only if there is 1+ rows, i.e. if we got a match
		
			return "fail"; //if not return fail
			
		
		
		else return "success"; //if we do have a result return success
				
			
				
   }

	

   
   
   
   
 

	   
	   
	   
   

   
   public static String signup(Vector<String> data, Connection conn) throws SQLException {
	  
   System.out.println("create event function called on server");
   
	   PreparedStatement stmt; //again to avoid sql injection
	   
	   stmt = conn.prepareStatement("insert into user values (?, ?, ?, ?, ?, ?)");
	   stmt.setString(1, data.get(0));//username
	   stmt.setString(2, data.get(1));//password
	   stmt.setString(3, data.get(2));//email
	   stmt.setString(4, data.get(3));//first name
	   stmt.setString(5, data.get(4));//last name
	   stmt.setString(6, data.get(5));//date of birth (should be written with caution, sql is very picky here)
	   
	System.out.println("just before stmt.execute");   
	    stmt.execute(); //execute this statement (note we used execute not execute query because we are inserting) 
	   				
System.out.println("after stmt.execute");
	  
	   return "Success"; //always return this because we wouldn't reach this if we got an SQL exception
	   
   }
   
   public static String addfriend(Vector<String> data, Connection conn) throws SQLException {
	   PreparedStatement stmt1,stmt2;
	   
	   stmt1=conn.prepareStatement("insert into friends_with values (?,?)");
	   stmt1.setString(1, data.get(0));
	   stmt1.setString(2, data.get(1));
	   stmt1.execute();
	   
	   stmt2=conn.prepareStatement("insert into friends_with values (?,?)");
	   stmt2.setString(1, data.get(1));
	   stmt2.setString(2, data.get(0));
	   stmt2.execute();
	   
	   return "success";
	   
   }
   
   public static Vector<String> friendlist(Vector<String> data, Connection conn) throws SQLException {
	   // Acquire vector of friends with user1 from SQL database
 	   Vector<String> friendlist = new Vector<String>();
 	  
 	   PreparedStatement stmt;
 	   stmt=conn.prepareStatement("select user2 from friends_with where user1=?");
 	   stmt.setString(1, data.get(0));
 	   
 	   ResultSet friendlistRS;
 	   //execute query to obtain friends. store in ResultSet
 	   friendlistRS=stmt.executeQuery();
 	   
 	   //copy friends into vector
 	   while(friendlistRS.next()){
 		   friendlist.add(friendlistRS.getString(1));
 		   //System.out.println(friendlistRS.getString(1));
 	   }
 	
 	   //System.out.println("Friends of " + data.get(0));
 	   // print out friends of user1 (data.get(0))
 	   //System.out.println(friendlist);
 	   return friendlist;
    }

   public static Vector<String> eventlist(Vector<String> data, Connection conn) throws SQLException {
	   // Acquire vector of friends with user1 from SQL database
 	   Vector<String> eventlist = new Vector<String>();
 	  
 	   PreparedStatement stmt;
 	   stmt=conn.prepareStatement("select `where`, `when` from event where creator=?");
 	   stmt.setString(1, data.get(0));
 	   
 	   ResultSet eventlistRS;
 	   //execute query to obtain friends. store in ResultSet
 	   eventlistRS=stmt.executeQuery();
 	   
 	   // copy event location and time into vector
 	   while(eventlistRS.next()){
// 		   eventlist.add("Place: " + eventlistRS.getString(1) + " & Time: " + eventlistRS.getString(2));
 		   eventlist.add(eventlistRS.getString(1) + " & "+ eventlistRS.getString(2));
 		   //System.out.println(friendlistRS.getString(1));
 	   }
 	
 	   //System.out.println("Events of " + data.get(0));
 	   // print out friends of user1 (data.get(0))
 	   //System.out.println(eventlist);
 	   return eventlist;
    }

   
   
   
 
 public static String createevent(Vector<String> data, Connection conn) throws SQLException {
	 
 
	 	PreparedStatement stmt1; //stmt creates the event in the 'event' entity
	 
	 	stmt1=conn.prepareStatement("insert into event values(?,?,?)");
		
	 	stmt1.setString(1, data.get(0)); //datetime
		stmt1.setString(2, data.get(1)); //location
		stmt1.setString(3, data.get(2)); // username
		
		stmt1.execute(); // create an event with key time and location with constraint username... Taco, is this correct?
		
		
	//	if (data.size()>3){ //only insert into the 'values' table if we have a friendlist (useful when modifying events)
			
		
		
	 	PreparedStatement stmt2; //stmt inserts into the relationship 'invited'
		 
	 	stmt2=conn.prepareStatement("insert into invited values(?,?,?,?)");

	 	stmt2.setString(2, data.get(0)); //datettime
	 	stmt2.setString(3, data.get(1)); //location
		stmt2.setString(4, "0"); //not attending (yet)
		 	
		/* Leave the first ? blank and insert it below. Perform an execution for each
		  user invited to the event.   */
		
		
		int i = 3;
		
		 while (i<data.size())
		 {
		 stmt2.setString(1, data.get(i));
		 stmt2.execute();
		 i++;
		 }
	 
	//	}
	 
	return "Success";
 }
 
 public static String deleteevent(Vector<String> data, Connection conn) throws SQLException{
	 
	 //parse the string we got, it should be divided into location and datetime
	 
	//divide original string into two parts
			String [] original = data.get(0).split(",");
			
			//divide each part 
			String [] part1 = original[0].split(": ");
			
			String [] part2 = original[1].split(": ");
			
			//create string for place, string for time
			String place = part1[1];
			String time = part2[1];
			
			
			   PreparedStatement stmt;
		 	   stmt=conn.prepareStatement("delete from event where `where`=? and `when`=?");
		 	  stmt.setString(1, place);
		 	 stmt.setString(2, time);
		 	   
		 	
		 	 stmt.execute();

			return "success";
			
	 
 }
}
