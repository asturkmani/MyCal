package projecttrial1;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import java.awt.CardLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.util.List;
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
import java.io.File;
import java.io.IOException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JSeparator;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;

public class ClientGUI2 {
	private JFrame frame;
	private JTextField usernameS;
	private JTextField username_1;
	private JTextField firstNameS;
	private JTextField lastNameS;
	private JTextField emailS;
	private JTextField username;
	private String currentUser = null;
	private theClient clientz;
	private Vector<String> friends = new Vector<String>();
	private Vector<String> events = new Vector<String>();
	private Vector<String> details = new Vector<String>();
	private JList<String> listOfFriends = new JList<String>();
	private JTable listOfEvents;
	private JLabel signInError = new JLabel("Incorrect username/password");
	private JPasswordField passwordLogIn;
	private Boolean toset = true;
	private JTextField dobS;
	private JPasswordField passwordField;
	private JTextField newEvent;
	private JTextField eventLocation;
	private JTextField date;
	private JTextField time;
	private Vector<JButton> vectorOfButtons = new Vector<JButton>();


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
		
		

	    //================================================================================
	    // Panels
		// 1- Log in panel -- initial panel loaded. used to log in users. contains button to access sign up panel
		// 2- Sign up panel -- called from sign up button in log in panel. signs up users
		// 3- Home panel -- Home page of MyCal. Contains user events. User can add events, and add friends here
		// 4- Profile panel -- Profile page. Contains friendlist and personal information. user can edit personal info here
	    //================================================================================
		JPanel LogInPanel = new JPanel();
		LogInPanel.setBackground(new Color(250, 248, 245));
		frame.getContentPane().add(LogInPanel, "name_17457643716363");
		LogInPanel.setLayout(null);
		
		JPanel SignUpPanel = new JPanel();
		SignUpPanel.setBackground(new Color(250, 248, 245));
		frame.getContentPane().add(SignUpPanel, "name_18858334609441");
		SignUpPanel.setLayout(null);
		
		JPanel HomePanel = new JPanel();
		HomePanel.setBackground(new Color(250, 248, 245));
		frame.getContentPane().add(HomePanel, "name_24484181317074");
		HomePanel.setLayout(null);
		
		JPanel profilePanel = new JPanel();
		profilePanel.setBackground(new Color(250, 248, 245));
		frame.getContentPane().add(profilePanel, "name_136468789986287");
		profilePanel.setLayout(null);
		
		 //================================================================================
	    // Components
		//================================================================================
		
		
		//================================================================================
		// 1 - LogIn panel components
	    //================================================================================
		
		JScrollPane inviteFriends = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("MyCal");
		lblNewLabel.setFont(new Font("Kailasa", Font.BOLD, 22));
		lblNewLabel.setBounds(125, 6, 72, 47);
		LogInPanel.add(lblNewLabel);
		
		username = new JTextField();
		username.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				username.setText("");
				username.setForeground(Color.DARK_GRAY);
				signInError.setVisible(false);
				
			}
		});
		username.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				username.setText("");
				username.setForeground(Color.DARK_GRAY);
				signInError.setVisible(false);
				}
				
		});
		username.setForeground(new Color(211, 211, 211));
		username.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		username.setText("Username");
		username.setColumns(10);
		username.setBounds(24, 84, 256, 47);
		LogInPanel.add(username);
		
		JButton btnLogIn = new JButton("Sign In");
		btnLogIn.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		btnLogIn.setForeground(Color.WHITE);
		btnLogIn.setBackground(new Color(71,181,250));
		btnLogIn.setContentAreaFilled(false);
		btnLogIn.setOpaque(true);
		btnLogIn.setBorderPainted(false);
		btnLogIn.requestFocus();		
		Border newborder = BorderFactory.createCompoundBorder();
		btnLogIn.setBorder(newborder);		
		btnLogIn.setBounds(6, 376, 308, 47);
		LogInPanel.add(btnLogIn);
		
		JButton btnSignUp_1 = new JButton("Create free account");
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
		passwordLogIn.setText("Password");
		passwordLogIn.setForeground(new Color(211, 211, 211));
		passwordLogIn.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		passwordLogIn.setEchoChar((char) 0);
		passwordLogIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					passwordLogIn.setText("");
					passwordLogIn.setForeground(Color.DARK_GRAY);
					signInError.setVisible(false);
					passwordLogIn.setEchoChar('*');
			
			}
		});

		passwordLogIn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (toset){
				passwordLogIn.setText("");
				passwordLogIn.setEchoChar('*');
//				signInError.setVisible(false);
				toset=false;
				}
			}
		});
		passwordLogIn.setBounds(24, 132, 256, 47);
		LogInPanel.add(passwordLogIn);
		
		JLabel Icon = new JLabel("");
		Icon.setIcon(new ImageIcon("/Users/asturkmani/Documents/workspace/MyCal/src/calendar-icon.png"));
		Icon.setBounds(70, 178, 256, 256);
		LogInPanel.add(Icon);
		
		signInError.setVisible(false);
		signInError.setForeground(new Color(255, 0, 0));
		signInError.setBounds(25, 56, 255, 16);
		LogInPanel.add(signInError);
		
		//================================================================================
		// 1 - SignUp panel components
	    //================================================================================
		JLabel incorrectSignUp = new JLabel("Account already exists!");
		incorrectSignUp.setVisible(false);
		incorrectSignUp.setForeground(Color.RED);
		incorrectSignUp.setBounds(64, 346, 199, 16);
		SignUpPanel.add(incorrectSignUp);
		
		JButton btnSignUp = new JButton("Sign Up!");
		btnSignUp.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		btnSignUp.setForeground(Color.WHITE);
		btnSignUp.setBackground(new Color(71,181,250));
		btnSignUp.setContentAreaFilled(false);
		btnSignUp.setOpaque(true);
		btnSignUp.setBorderPainted(false);
		btnSignUp.requestFocusInWindow(); 
		btnSignUp.setBounds(6, 364, 308, 48);
		Border newborder2 = BorderFactory.createCompoundBorder();
		btnSignUp.setBorder(newborder2);
		SignUpPanel.add(btnSignUp);
		
		JLabel label = new JLabel("MyCal");
		label.setFont(new Font("Kailasa", Font.BOLD, 22));
		label.setBounds(123, 6, 72, 47);
		SignUpPanel.add(label);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 415, 308, 12);
		SignUpPanel.add(separator);
		
		JButton btnBackLogIn = new JButton("Back");
		btnBackLogIn.setForeground(Color.DARK_GRAY);
		btnBackLogIn.setBackground(new Color(250,248,245));
		btnBackLogIn.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		btnBackLogIn.setOpaque(true);
		btnBackLogIn.setBorderPainted(false);
		btnBackLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogInPanel.setVisible(true);
				SignUpPanel.setVisible(false);
			}
		});
		btnBackLogIn.setBounds(104, 423, 117, 29);
		SignUpPanel.add(btnBackLogIn);
		
		usernameS = new JTextField();
		usernameS.setText("Username");
		usernameS.setForeground(new Color(211, 211, 211));
		usernameS.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		usernameS.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				usernameS.setText("");
				usernameS.setForeground(Color.DARK_GRAY);
				incorrectSignUp.setVisible(false);
			}
		});
		usernameS.setBounds(36, 53, 256, 47);
		usernameS.setColumns(10);
		SignUpPanel.add(usernameS);
		
		usernameS = new JTextField();
		usernameS.setText("Username");
		usernameS.setForeground(new Color(211, 211, 211));
		usernameS.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		usernameS.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				usernameS.setText("");
				usernameS.setForeground(Color.DARK_GRAY);
				incorrectSignUp.setVisible(false);
			}
		});
		usernameS.setBounds(36, 53, 256, 47);
		usernameS.setColumns(10);
		SignUpPanel.add(usernameS);
		
		usernameS = new JTextField();
		usernameS.setText("Username");
		usernameS.setForeground(new Color(211, 211, 211));
		usernameS.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		usernameS.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				usernameS.setText("");
				usernameS.setForeground(Color.DARK_GRAY);
				incorrectSignUp.setVisible(false);
			}
		});
		usernameS.setBounds(36, 53, 256, 47);
		usernameS.setColumns(10);
		SignUpPanel.add(usernameS);
		
		firstNameS = new JTextField();
		firstNameS.setText("First Name");
		firstNameS.setForeground(new Color(211, 211, 211));
		firstNameS.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		firstNameS.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				firstNameS.setText("");
				firstNameS.setForeground(Color.DARK_GRAY);
				incorrectSignUp.setVisible(false);
			}
		});
		firstNameS.setColumns(10);
		firstNameS.setBounds(36, 147, 256, 47);
		SignUpPanel.add(firstNameS);
		
		lastNameS = new JTextField();
		lastNameS.setText("Last Name");
		lastNameS.setForeground(new Color(211, 211, 211));
		lastNameS.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lastNameS.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lastNameS.setText("");
				lastNameS.setForeground(Color.DARK_GRAY);
				incorrectSignUp.setVisible(false);
			}
		});
		lastNameS.setColumns(10);
		lastNameS.setBounds(36, 194, 256, 47);
		SignUpPanel.add(lastNameS);
		
		emailS = new JTextField();
		emailS.setText("Email");
		emailS.setForeground(new Color(211, 211, 211));
		emailS.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		emailS.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				emailS.setText("");
				emailS.setForeground(Color.DARK_GRAY);
				incorrectSignUp.setVisible(false);
			}
		});
		emailS.setColumns(10);
		emailS.setBounds(36, 240, 256, 47);
		SignUpPanel.add(emailS);
		
		dobS = new JTextField();
		dobS.setText("Date of birth");
		dobS.setForeground(new Color(211, 211, 211));
		dobS.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		dobS.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dobS.setText("");
				dobS.setForeground(Color.DARK_GRAY);
				incorrectSignUp.setVisible(false);
			}
		});		
		dobS.setColumns(10);
		dobS.setBounds(36, 287, 256, 47);
		SignUpPanel.add(dobS);

		passwordField = new JPasswordField();		
		passwordField.setText("Password");
		passwordField.setForeground(new Color(211, 211, 211));
		passwordField.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		passwordField.setEchoChar(' ');
		passwordField.setBounds(36, 100, 256, 47);		
		passwordField.setEchoChar((char) 0);
		passwordField.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				passwordField.setText("");
				passwordField.setForeground(Color.DARK_GRAY);
				passwordField.setEchoChar('*');
			}
		});
		SignUpPanel.add(passwordField);
		//================================================================================
		// 1 - Home panel components
	    //================================================================================
		JLabel profileName = new JLabel("");
		profileName.setBounds(68, 6, 409, 35);
		HomePanel.add(profileName);
		
		JLabel goToProfile = new JLabel("");
		goToProfile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				profilePanel.setVisible(true);
				HomePanel.setVisible(false);
			}
		});
		goToProfile.setIcon(new ImageIcon("/Users/asturkmani/Documents/workspace/MyCal/src/user.png"));
		goToProfile.setBounds(18, 6, 35, 35);
		HomePanel.add(goToProfile);

		
		newEvent = new JTextField();
		newEvent.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				newEvent.setText("");
				newEvent.setForeground(Color.DARK_GRAY);
			}
		});
		newEvent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				newEvent.setText("");
				newEvent.setForeground(Color.DARK_GRAY);
			}
		});
		newEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					theClient.createEvent(newEvent.getText(), currentUser, null, null, null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		newEvent.setText("Add a new event!");
		newEvent.setBounds(18, 42, 188, 46);
		newEvent.setForeground(new Color(211, 211, 211));
		HomePanel.add(newEvent);
		newEvent.setColumns(10);
		
		eventLocation = new JTextField();
		eventLocation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				eventLocation.setText("");
				eventLocation.setForeground(Color.DARK_GRAY);
			}
		});
		eventLocation.setText("Where?");
		eventLocation.setForeground(new Color(211, 211, 211));
		eventLocation.setBounds(205, 42, 95, 46);
		HomePanel.add(eventLocation);
		eventLocation.setColumns(10);
		
		date = new JTextField();
		date.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				date.setText("");
				date.setForeground(Color.DARK_GRAY);
			}
		});
		date.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				date.setText("");
				date.setForeground(Color.DARK_GRAY);
			}
		});
		date.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		date.setText("yyyy-mm-dd");
		date.setForeground(new Color(211, 211, 211));
		date.setBounds(18, 87, 95, 46);
		HomePanel.add(date);
		date.setColumns(10);
		
		time = new JTextField();
		time.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				time.setText("");
				time.setForeground(Color.DARK_GRAY);
			}
		});
		time.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				time.setText("");
				time.setForeground(Color.DARK_GRAY);
			}
		});
		time.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		time.setForeground(new Color(211, 211, 211));
		time.setText("hh:mm");
		time.setBounds(110, 87, 95, 46);
		HomePanel.add(time);
		time.setColumns(10);
		
		
		inviteFriends.setBounds(205, 91, 95, 75);
		HomePanel.add(inviteFriends);
		
		JButton btnNewButton = new JButton("Create Event!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// get name date, time, invited peeps, username from entered fields and create the event. initially set rating to 0.

				String timeZ = new String();
				timeZ = time.getText();
				String dateZ = new String();
				dateZ = date.getText();
				
				String datetime = new String();
				datetime = dateZ + " " + timeZ; 
				
				List<String> templist =listOfFriends.getSelectedValuesList(); //get selected friends
				//put all values in a vector (we prefer using vector for ease of manipulation)
				Vector<String> selectedFriends = new Vector<String>(); //
				
				
				for (int i=0; i<templist.size();i++) {
					selectedFriends.add(templist.get(i));}
				
				//calling the createEvent function in theClient
				
				/* here we need to:
				 1) add the new event to the database
				 2)create a new button to represent it
				 3) update the gui to reflect this. Refer to description in initial log in procedure for more details on dynamic
				 creation of buttons */
				
				// create constraints
				GridBagConstraints constraint = new GridBagConstraints();
			    constraint.anchor = GridBagConstraints.CENTER;
			    constraint.fill = GridBagConstraints.NONE;
			    constraint.gridx = 0;
			    constraint.gridy = GridBagConstraints.RELATIVE;
			    constraint.weightx = 1.0f;
			    constraint.weighty = 1.0f;
				try {
					theClient.createEvent(newEvent.getText(), currentUser, selectedFriends, datetime,eventLocation.getText() );
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				JButton button = new JButton(newEvent.getText());
				button.setFont(new Font("Lucida Grande", Font.BOLD, 16));
				button.setForeground(Color.WHITE);
				button.setBackground(new Color(71,181,250));
				button.setContentAreaFilled(false);
				button.setOpaque(true);
				button.setBorderPainted(false);
				button.requestFocus();		
				Border newborder2 = BorderFactory.createCompoundBorder();
				button.setBorder(newborder2);
				//place the new button in the scrollpane. place it below previous buttons (events)
				// if they exist, else place it at the first point in the scroll pane.
				int x,y;
				
				if(vectorOfButtons.size() > 0){
				x = vectorOfButtons.get(vectorOfButtons.size()-1).getX();
				y = vectorOfButtons.get(vectorOfButtons.size()-1).getY() + 43;}
				else{
					x = 19;
					y = 200;}
				button.setBounds(x, y, 280, 40);
				
				//add the new button to the vector of buttons
				vectorOfButtons.add(button);
				// add the new button to the homepanel along with constraints


				
				HomePanel.revalidate();
				frame.revalidate();
				frame.repaint();
			}
		});
		btnNewButton.setBounds(18, 134, 188, 29);
		HomePanel.add(btnNewButton);
		
		JButton btnTestMe = new JButton("test me");
		btnTestMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				Vector<String> temp = new Vector<String>();
//				temp.add("julian");
//				temp.add("aboudi");
//				temp.add("tarekjreidini");
//				
//				
//				
//				try {
//					theClient.createEvent("zabr hmar", "tarekjreidini", temp, "2011-12-12", "ELH");
//				} catch (Exception e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
				
				
				
				try {
					System.out.println("event detailszz:" + theClient.eventDetails("zabr hmar"));
					System.out.println("invited peepz:" + theClient.getInvited("zabr hmar"));
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnTestMe.setBounds(76, 199, 117, 29);
		HomePanel.add(btnTestMe);
		

		
		

		//================================================================================
		// 1 - Profile panel components
	    //================================================================================
		JScrollPane friendsScroll = new JScrollPane();
		friendsScroll.setBounds(173, 37, 122, 167);
		profilePanel.add(friendsScroll);
		
		JLabel goToHome = new JLabel("");
		goToHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HomePanel.setVisible(true);
				profilePanel.setVisible(false);
			}
		});
		goToHome.setIcon(new ImageIcon("/Users/asturkmani/Documents/workspace/MyCal/src/home.jpeg"));
		goToHome.setBounds(6, 6, 34, 34);
		profilePanel.add(goToHome);

		
		//================================================================================
		// Log In Panel Actions
		// 1 - Log in User
		// 2 - Load User details, friend list, event list
	    //================================================================================
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
			
			
			if(!temp){
				signInError.setVisible(true);
			}
			// Actions to be performed if login is successful:
			if(temp){
							
				try {
					friends = theClient.friendList(currentUser); 	// create the list of friends
					events = theClient.eventList(currentUser); 		// obtain event list
					details = theClient.getDetails(currentUser);	// obtain user details
			
					// populate the list and wrap scrollPane around it
					listOfFriends = new JList<String>(friends);
					inviteFriends.setViewportView(listOfFriends);
					friendsScroll.setViewportView(listOfFriends);
					
					// Dynamically create buttons for events.
					// the scrollpane
					JPanel buttonPanel = new JPanel();
					buttonPanel.setLayout(null);
				    buttonPanel.setSize(new Dimension(400, 300)); // whatever
				    

					  
					    

				    // GridBagConstraint for button
				    GridBagConstraints constraint = new GridBagConstraints();
				    constraint.anchor = GridBagConstraints.CENTER;
				    constraint.fill = GridBagConstraints.NONE;
				    constraint.gridx = 0;
				    constraint.gridy = GridBagConstraints.RELATIVE;
				    constraint.weightx = 1.0f;
				    constraint.weighty = 1.0f;

//				    int sizeOfButtons = 50;
				    
				    int x = 0; int y=0;

				    
				    /* TO DYNAMICALLY ADD BUTTONS
				     0) pre-processing : create gridbag constraints for the button
				     1) read in the list of events
				     2) for each event, create a new button with text field equal to the name of the event
				     3) add that button to the vector of buttons so we can access it later on
				     4) add the button to the home panel
				     5) update the homepanel */
				    
					String tempString = new String();
					// create a panel to house the buttons of events
					JPanel buttonsPanel = new JPanel();
					buttonsPanel.setLayout(null);
				    for(int i = 0; i < events.size(); i++) {
//				        JButton button = new JButton();

				        tempString = events.get(i);// get each event.
//				        System.out.println("EVENTS OBTAINED ARE: " + tempString);
						String [] temp1 = tempString.split("&");// split each event into place & time based on "&"
//						System.out.println("IN CLIENT GUI: " + temp1[0] + "&"+temp1[1] + "&"+temp1[2] + "&"+temp1[3] + "&"+temp1[4] + "&");
						String [] temp2 = temp1[1].split(" ");
						
						// specify button properties
						JButton button = new JButton(temp1[2]);
						button.setFont(new Font("Lucida Grande", Font.BOLD, 16));
						button.setForeground(Color.WHITE);
						button.setBackground(new Color(71,181,250));
						button.setContentAreaFilled(false);
						button.setOpaque(true);
						button.setBorderPainted(false);
						button.requestFocus();		
						Border newborder2 = BorderFactory.createCompoundBorder();
						button.setBorder(newborder2);		
						button.setBounds(x, y, 280, 40);
						y = y+43;
						buttonsPanel.setPreferredSize(new Dimension((int) buttonsPanel.getPreferredSize().getWidth(),
			                    (int)(buttonsPanel.getPreferredSize().getHeight()+43)));
						vectorOfButtons.add(button); //add the new button to the vector of buttons
				        buttonsPanel.add(button, constraint); // add the button to the homepanel
				    }

					
					
				    
					JScrollPane eventsScrollPane = new JScrollPane(buttonsPanel);
					eventsScrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
					eventsScrollPane.getViewport().setBorder(null);
					eventsScrollPane.setViewportBorder(null);
					eventsScrollPane.setBorder(null);
					eventsScrollPane.setBounds(28, 180, 266, 272);
					HomePanel.add(eventsScrollPane);

					
					//Transition to home panel
					LogInPanel.setVisible(false);
					profileName.setText(details.get(1) + " " + details.get(2));//include users first in last name on homepage
//					HomePanel.setSize(new Dimension(400,600));
//					frame.setSize(400,600);
					HomePanel.setVisible(true);

				} catch (Exception e1) {e1.printStackTrace();}}}});

		//================================================================================
		// Sign Up Panel Actions
		// 1 - Add new user to database
		// 2 - Load User details, friend list, event list
	    //================================================================================
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // action taken when Sign Up Button is pressed.
				String response = new String();
				try {
					response = theClient.signup(usernameS.getText(), passwordField.getText(), emailS.getText(), firstNameS.getText(), lastNameS.getText(), dobS.getText());
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(response.equals("success")){
				// create the list of friends			
				try {
					friends = theClient.friendList(currentUser);
					events = theClient.eventList(currentUser);
			
				// populate the list and wrap scrollPane around it
					listOfFriends = new JList<String>(friends);
//					friendsScroll.setViewportView(listOfFriends);
					
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
						// split each event into place & time based on "&"
						String [] temp1 = tempString.split("&");
						// add place into vector
						rowI.add(temp1[0]);
						String [] temp2 = temp1[1].split(" ");
						rowI.add(temp2[1]);
						rowI.add(temp2[2]);
						rowData.add(rowI);
						rowI = new Vector<String>();
						
					}

					
				
				
					//transition to homepanel
					SignUpPanel.setVisible(false);
	//				profileName.setText(currentUser)
//					HomePanel.setSize(new Dimension(400,600));
//					frame.setSize(400,600);
					HomePanel.setVisible(true);
				
				
				} catch (Exception e1) {e1.printStackTrace();}

			}else{
				incorrectSignUp.setVisible(true);}}});

	    //================================================================================
	    // Profile Panel
		// 1- Access friends list
		// 2- Add friends
		// 3- Delete friends
		// 4- Access personal information
		// 5- Edit personal information
	    //================================================================================


	}
}
