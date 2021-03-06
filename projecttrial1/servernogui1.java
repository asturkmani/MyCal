package projecttrial1;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.Vector;

class servernogui1
{
   public static void main(String argv[]) throws Exception
      {
         String verb, clientSentence1, clientSentence2; //verb is the keyword that defines what operation is being done
         												// e.g. LOGIN or SIGNUP..
         ServerSocket welcomeSocket = new ServerSocket(6780); //socket

         while(true)
         {
            Socket connectionSocket = welcomeSocket.accept(); //accept a connection
            BufferedReader inFromClient =
               new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
          // ObjectOutputStream outToClient2 = new ObjectOutputStream(connectionSocket.getOutputStream());
            
            
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
            	
            	returnz=login(input, conn);
            break;
            
                  	
            case "signup": returnz=signup(input, conn);	//signup operation, call the signup function
            break;
            
            case "addfriend":
            	returnz=addfriend(input, conn);
            	break;
            	
            case "friendlist":
            	Vector<String> friendlist = new Vector<String>();
            	friendlist=friendlist(input, conn);
            	//outToClient2.writeObject(friendlist);
            	for (String str : friendlist){
            		outToClient.writeBytes(str + "\n");
            		returnz="stopz"; //here this signals the client to stop reading because we dont know how long the list of friends is
            	}
            	break;
            	
            default: outToClient.writeBytes("Everything Failed!\n"); //this should never come because 'login' and 'signup' are
            																//defined by the client side application and not the user
            																//so they are supposed to be fool-proof. but in case
            break;
            
            
            }
            
            outToClient.writeBytes(returnz + "\n"); //send back the response, followed by a line break 
            
         }
      }
   
   
   
   
            	
            	
             
             

            	
        	
      
   
   
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
	  
   
	   PreparedStatement stmt; //again to avoid sql injection
	   
	   stmt = conn.prepareStatement("insert into user values (?, ?, ?, ?, ?, ?)");
	   stmt.setString(1, data.get(0));//username
	   stmt.setString(2, data.get(1));//password
	   stmt.setString(3, data.get(2));//email
	   stmt.setString(4, data.get(3));//first name
	   stmt.setString(5, data.get(4));//last name
	   stmt.setString(6, data.get(5));//date of birth (should be written with caution, sql is very picky here)
	   
	   
	    stmt.execute(); //execute this statement (note we used execute not execute query because we are inserting) 
	   				

	  
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
	   Vector<String> friendlist = new Vector<String>();
	  
	   PreparedStatement stmt;
	   stmt=conn.prepareStatement("select user2 from friends_with where user1=?");
	   stmt.setString(1, data.get(0));
	   
	   ResultSet friendlistRS;
	   friendlistRS=stmt.executeQuery();
	   
	   while(friendlistRS.next()){
		   friendlist.add(friendlistRS.getString(1));
		   System.out.println(friendlistRS.getString(1));
	   }
	
	   System.out.println("hello");
	   System.out.println(friendlist);
	   return friendlist;
   }
   
   
   
   

}