import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.CardLayout;

import javax.swing.BorderFactory;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

import java.awt.Graphics;
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

import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.border.Border;
import java.awt.Font;

public class ClientGUI2 {

	private JFrame frame;
	private JTextField usernameS;
	private JTextField username_1;
	private JTextField passwordS;
	private JTextField firstNameS;
	private JTextField lastNameS;
	private JTextField emailS;
	private JTextField username;
	private String currentUser = null;
	private theClient clientz;
	private Vector<String> friends = new Vector<String>();
	private Vector<String> events = new Vector<String>();
	
	//list of friends and table of events
	private JList<String> listOfFriends = new JList<String>();
	private JTable listOfEvents;
	private JScrollPane eventsScroll = new JScrollPane();
	private JScrollPane friendsScroll = new JScrollPane();
	
	private JPanel HomePanel = new JPanel();
	private JPasswordField passwordLogIn;


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
		
		try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(250, 248, 245));
		frame.setBounds(100, 100, 320, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel LogInPanel = new JPanel();
		LogInPanel.setBackground(new Color(250, 248, 245));
		frame.getContentPane().add(LogInPanel, "name_17457643716363");
		LogInPanel.setLayout(null);
		
		JPanel SignUpPanel = new JPanel();
		SignUpPanel.setBackground(new Color(250, 248, 245));
		frame.getContentPane().add(SignUpPanel, "name_18858334609441");
		SignUpPanel.setLayout(null);
		
		// ---------------- SIGN UP PANEL -------------------- //
		JLabel Welcome = new JLabel("Enter your details below!");
		Welcome.setBounds(95, 41, 163, 16);
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
		btnSignUp.setBounds(6, 364, 308, 48);
		SignUpPanel.add(btnSignUp);
		
		JButton btnReturnLogIn = new JButton("");
		btnReturnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // return to LogIn page
				LogInPanel.setVisible(true);
				SignUpPanel.setVisible(false);
			}
		});
		btnReturnLogIn.setBackground(new Color(102, 51, 0));
		btnReturnLogIn.setIcon(new ImageIcon(ClientGUI2.class.getResource("/com/sun/javafx/scene/control/skin/caspian/images/backspace-icon.png")));
		btnReturnLogIn.setBounds(6, 6, 57, 51);
		SignUpPanel.add(btnReturnLogIn);
		
		// ---------------- LOG IN PANEL --------------------- //
		JLabel lblNewLabel = new JLabel("Welcome to MyCal!");
		lblNewLabel.setBounds(100, 6, 119, 16);
		LogInPanel.add(lblNewLabel);
		
		JLabel usernameLogin_1 = new JLabel("Username");
		usernameLogin_1.setBounds(6, 113, 67, 16);
		LogInPanel.add(usernameLogin_1);
		
		JLabel passwordLogin = new JLabel("Password");
		passwordLogin.setBounds(6, 138, 67, 16);
		LogInPanel.add(passwordLogin);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(100, 110, 134, 22);
		LogInPanel.add(username);
		
		JButton btnLogIn = new JButton("Sign In");
		btnLogIn.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		btnLogIn.setForeground(Color.WHITE);
		btnLogIn.setBackground(new Color(71,181,250));
		btnLogIn.setContentAreaFilled(false);
		btnLogIn.setOpaque(true);
		btnLogIn.setBorderPainted(false);
		
		Border newborder = BorderFactory.createCompoundBorder();
		btnLogIn.setBorder(newborder);


		btnLogIn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) { // Log in the user
				boolean temp=false;
				currentUser = username.getText();
				try {
					temp=theClient.login(username.getText(), passwordLogIn.getText());
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
				 // replace this with new fields visibility

			}
			
			
			}
		});
		btnLogIn.setBounds(6, 376, 308, 47);
		LogInPanel.add(btnLogIn);
		
		
		JButton btnSignUp_1 = new JButton("Create a free account");
		btnSignUp_1.setForeground(Color.WHITE);
		btnSignUp_1.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		btnSignUp_1.setOpaque(true);
		btnSignUp_1.setBorderPainted(false);
		btnSignUp_1.setBackground(UIManager.getColor("Button.select"));
		btnSignUp_1.setBorder(UIManager.getBorder("Button.border"));
		btnSignUp_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // action performed when Sign Up button is pressed.
				// take user to sign up field
				SignUpPanel.setVisible(true);
				LogInPanel.setVisible(false);
			}
		});
		btnSignUp_1.setBounds(6, 317, 308, 47);
		LogInPanel.add(btnSignUp_1);
		
		passwordLogIn = new JPasswordField();
		passwordLogIn.setBounds(100, 138, 134, 28);
		LogInPanel.add(passwordLogIn);
		
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
