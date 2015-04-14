import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.CardLayout;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

import java.awt.TextField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JButton;

import projecttrial1.theClient;

import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.sql.ResultSet;

public class ClientGUI2 {

	private JFrame frame;
	private JTextField usernameS;
	private JTextField username_1;
	private JTextField passwordS;
	private JTextField firstNameS;
	private JTextField lastNameS;
	private JTextField emailS;
	private JTextField username;
	private JTextField password;
	String currentUser = null;
	private theClient clientz;
	Vector<String> friends = new Vector<String>();
	Vector<String> events = new Vector<String>();
	
	//list of friends and table of events
	JList<String> listOfFriends = new JList<String>();
	private JTable listOfEvents;
	JScrollPane eventsScroll = new JScrollPane();
	JScrollPane friendsScroll = new JScrollPane();
	
	JPanel HomePanel = new JPanel();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientGUI2 window = new ClientGUI2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ClientGUI2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 368, 451);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel LogInPanel = new JPanel();
		frame.getContentPane().add(LogInPanel, "name_17457643716363");
		LogInPanel.setLayout(null);
		
		JPanel SignUpPanel = new JPanel();
		frame.getContentPane().add(SignUpPanel, "name_18858334609441");
		SignUpPanel.setLayout(null);
		
		// ---------------- SIGN UP PANEL -------------------- //
		JLabel Welcome = new JLabel("Enter your details below!");
		Welcome.setBounds(77, 40, 222, 16);
		SignUpPanel.add(Welcome);
		
		JLabel SignUpUsername = new JLabel("Username");
		SignUpUsername.setBounds(36, 85, 94, 16);
		SignUpPanel.add(SignUpUsername);
		
		JLabel SignUpPassword = new JLabel("Password");
		SignUpPassword.setBounds(36, 113, 94, 16);
		SignUpPanel.add(SignUpPassword);
		
		JLabel SignUpFirstName = new JLabel("First Name");
		SignUpFirstName.setBounds(36, 141, 94, 16);
		SignUpPanel.add(SignUpFirstName);
		
		JLabel SignUpLastName = new JLabel("Last Name");
		SignUpLastName.setBounds(36, 169, 94, 16);
		SignUpPanel.add(SignUpLastName);
		
		JLabel SignUpEmailText = new JLabel("Email");
		SignUpEmailText.setBounds(36, 197, 94, 16);
		SignUpPanel.add(SignUpEmailText);
		
		usernameS = new JTextField();
		usernameS.setBounds(124, 79, 134, 22);
		SignUpPanel.add(usernameS);
		usernameS.setColumns(10);
		
		passwordS = new JTextField();
		passwordS.setBounds(124, 113, 134, 22);
		SignUpPanel.add(passwordS);
		passwordS.setColumns(10);
		
		firstNameS = new JTextField();
		firstNameS.setColumns(10);
		firstNameS.setBounds(124, 141, 134, 22);
		SignUpPanel.add(firstNameS);
		
		lastNameS = new JTextField();
		lastNameS.setColumns(10);
		lastNameS.setBounds(124, 169, 134, 22);
		SignUpPanel.add(lastNameS);
		
		emailS = new JTextField();
		emailS.setColumns(10);
		emailS.setBounds(124, 197, 134, 22);
		SignUpPanel.add(emailS);
		
		JButton btnSignUp = new JButton("Sign Up!");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // action taken when Sign Up Button is pressed.
			}
		});
		btnSignUp.setBounds(124, 247, 134, 29);
		SignUpPanel.add(btnSignUp);
		
		// ---------------- LOG IN PANEL --------------------- //
		JLabel lblNewLabel = new JLabel("Welcome to MyCal!");
		lblNewLabel.setBounds(122, 6, 119, 16);
		LogInPanel.add(lblNewLabel);
		
		JLabel usernameLogin_1 = new JLabel("Username");
		usernameLogin_1.setBounds(36, 113, 67, 16);
		LogInPanel.add(usernameLogin_1);
		
		JLabel passwordLogin = new JLabel("Password");
		passwordLogin.setBounds(36, 141, 67, 16);
		LogInPanel.add(passwordLogin);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(122, 107, 134, 22);
		LogInPanel.add(username);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(122, 135, 134, 22);
		LogInPanel.add(password);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // Log in the user
				boolean temp=false;
				currentUser = username.getText();
				try {
					temp=theClient.login(username.getText(), password.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
			
			// Actions to be performed if login is successful:
			if(temp){
				// create the list of friends			
				try {
					friends = theClient.friendList(currentUser);
					events = theClient.eventList(currentUser);
			
				// populate the list and wrap scrollPane around it
					listOfFriends = new JList<String>(friends);
					friendsScroll.setViewportView(listOfFriends);
					
					// split event data into multiple columns
					
					// some temp variables
					String tempString = new String();
					// row vector
					Vector<String> rowI = new Vector<String>();
					// vector of vectors to contain all rows
					Vector<Vector<String>> rowData = new Vector<Vector<String>>();
					for(int i=0; i<events.size();i++){
						// get each event.
						tempString = events.get(i);
//						System.out.println(tempString);
						// split each event into place & time based on "&"
						String [] temp1 = tempString.split("&");
						// add place into vector
						rowI.add(temp1[0]);
						String [] temp2 = temp1[1].split(" ");
						rowI.add(temp2[1]);
						rowI.add(temp2[2]);
//						System.out.println(rowI);
						//System.out.println(rowI);
						rowData.add(rowI);
						System.out.println(rowData);
						rowI = new Vector<String>();
						
					}
					// create column names
					Vector<String> columnNames = new Vector<String>();
					columnNames.add("Place");
					columnNames.add("Date");
					columnNames.add("Time");

					
					listOfEvents = new JTable(rowData, columnNames);
					
					eventsScroll.setViewportView(listOfEvents);
					
				
				
				//transition to homepanel
				LogInPanel.setVisible(false);
				HomePanel.setVisible(true);
				
				
				} catch (Exception e1) {e1.printStackTrace();}

			}
				
			
			// if login is unsuccessful, pop up and tell user it's incorrect
			if(!temp){
				 JPopupMenu popup = new JPopupMenu();
				 popup.setLayout(null);
				 JLabel item = new JLabel("  Incorrect username or password!  ");
				 popup.add(item);
				 popup.show(btnLogIn,-45, -120);

			}
			
			
			}
		});
		btnLogIn.setBounds(122, 192, 134, 29);
		LogInPanel.add(btnLogIn);
		
		JButton btnSignUp_1 = new JButton("Sign Up");
		btnSignUp_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // action performed when Sign Up button is pressed.
				// take user to sign up field
				SignUpPanel.setVisible(true);
				LogInPanel.setVisible(false);
			}
		});
		btnSignUp_1.setBounds(122, 220, 134, 29);
		LogInPanel.add(btnSignUp_1);
		
		// ------------- HOME PANEL ---------------- //

		frame.getContentPane().add(HomePanel, "name_24484181317074");
		HomePanel.setLayout(null);
		

		friendsScroll.setBounds(18, 61, 122, 167);
		HomePanel.add(friendsScroll);
		
//		JList listOfFriends = new JList();

		
		
		eventsScroll.setBounds(18, 257, 322, 155);
		HomePanel.add(eventsScroll);
		
//		listOfEvents = new JTable();
		eventsScroll.setViewportView(listOfEvents);
		
	}
	
	
}
