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
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JButton;
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

import org.freixas.jcalendar.DateEvent;
import org.freixas.jcalendar.DateListener;
import org.freixas.jcalendar.JCalendar;
import org.freixas.jcalendar.JCalendarCombo;

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
	private JTextField eventNameModify;
	private JTextField eventLocationModify;
	private JScrollPane inviteFriendsScroll = new JScrollPane();
	private JTextField addFriend;


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
		
		JPanel ModifyEvent = new JPanel();
		ModifyEvent.setLayout(null);
		ModifyEvent.setBackground(new Color(250, 248, 245));
		frame.getContentPane().add(ModifyEvent, "name_66068424150500");
		
		 //================================================================================
	    // Components
		//================================================================================
		
		
		//================================================================================
		// 1 - LogIn panel components
	    //================================================================================

		
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
		passwordLogIn.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				passwordLogIn.setText("");
				passwordLogIn.setForeground(Color.DARK_GRAY);
				signInError.setVisible(false);
			}
		});
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
		usernameS.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				usernameS.setText("");
				usernameS.setForeground(Color.DARK_GRAY);
			}
		});
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
		firstNameS.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				firstNameS.setText("");
				firstNameS.setForeground(Color.DARK_GRAY);
				incorrectSignUp.setVisible(false);
			}
		});
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
		lastNameS.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lastNameS.setText("");
				lastNameS.setForeground(Color.DARK_GRAY);
				incorrectSignUp.setVisible(false);
			}
		});
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
		emailS.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				emailS.setText("");
				emailS.setForeground(Color.DARK_GRAY);
				incorrectSignUp.setVisible(false);
			}
		});
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
		dobS.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				dobS.setText("");
				dobS.setForeground(Color.DARK_GRAY);
				incorrectSignUp.setVisible(false);
			}
		});
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
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				passwordField.setText("");
				passwordField.setForeground(Color.DARK_GRAY);
				passwordField.setEchoChar('*');
			}
		});
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
		inviteFriendsScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		//================================================================================
		// 1 - Home panel components
	    //================================================================================
		JLabel addFriendError = new JLabel("User does not exist!");
		
		inviteFriendsScroll.setBounds(205, 87, 95, 76);
		HomePanel.add(inviteFriendsScroll);
		
	    Border etchedBorder =
		BorderFactory.createEtchedBorder();
	    Border emptyBorder =
		BorderFactory.createEmptyBorder(10, 10, 10, 10);
	    Border compoundBorder =
		BorderFactory.createCompoundBorder(etchedBorder, emptyBorder);
	    
		
	    DefaultListModel friendsList = new DefaultListModel();
		JList inviteFriendsList = new JList(friendsList);
		inviteFriendsList.setBounds(205, 87, 95, 76);

//		HomePanel.add(inviteFriendsList);
		
		

	    // Create a date listener to be used for all calendars

	    MyDateListener listener = new MyDateListener();
	    
	    JCalendarCombo calendar1 =
	    		new JCalendarCombo(
	    		    JCalendarCombo.DISPLAY_DATE | JCalendarCombo.DISPLAY_TIME,
	    		    true);
	    	    calendar1.setEditable(true);
	    	    calendar1.addDateListener(listener);
	   calendar1.setEditable(true);
	   calendar1.setBounds(20, 87, 180, 45);
	   HomePanel.add(calendar1);
	    
	   calendar1.setFont(new Font("DialogInput", Font.PLAIN, 13));
	   
	   calendar1.setTitleFont(new Font("Serif", Font.BOLD|Font.ITALIC, 13));
	    calendar1.setDayOfWeekFont(new Font("SansSerif", Font.ITALIC, 13));
	    calendar1.setDayFont(new Font("SansSerif", Font.BOLD, 13));
	    calendar1.setTimeFont(new Font("DialogInput", Font.PLAIN, 10));
	    calendar1.setTodayFont(new Font("Dialog", Font.PLAIN, 14));
	    	    	    
		JLabel profileName = new JLabel("");
		profileName.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		profileName.setBounds(65, 6, 409, 35);
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
					
					theClient.createEvent(newEvent.getText(), currentUser, null, null, eventLocation.getText());
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
		
		//////// MODIFY PAGE COMPONENTS /////////
		JLabel EventLocationDisplay = new JLabel("Location:");
		EventLocationDisplay.setBounds(54, 39, 61, 16);
		ModifyEvent.add(EventLocationDisplay);
		
		JLabel eventTimeDisplay = new JLabel("Time:");
		eventTimeDisplay.setBounds(54, 57, 61, 16);
		ModifyEvent.add(eventTimeDisplay);
		
		JLabel eventLocationDispla = new JLabel("");
		eventLocationDispla.setBounds(127, 39, 173, 16);
		ModifyEvent.add(eventLocationDispla);
		
		JLabel eventTimeDispla = new JLabel("");
		eventTimeDispla.setBounds(127, 57, 173, 16);
		ModifyEvent.add(eventTimeDispla);
		
		JLabel eventNameDispla = new JLabel("Event name");
		eventNameDispla.setBounds(53, 6, 409, 35);
		ModifyEvent.add(eventNameDispla);
		
		JLabel goBack = new JLabel("");
		goBack.setIcon(new ImageIcon(ClientGUI2.class.getResource("/org/freixas/jcalendar/images/Back16.gif")));
		goBack.setBounds(12, 6, 35, 35);
		ModifyEvent.add(goBack);
		
		/// end of components ////


		
		JButton btnNewButton = new JButton("Create Event!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// get name date, time, invited peeps, username from entered fields and create the event. initially set rating to 0.

				String timeZ = new String();
//				timeZ = time.getText();
				String dateZ = new String();
//				dateZ = date.getText();
				
				//int datetime = new String();
				Integer temp = new Integer(0);
				String finaldate = new String();
				Date date = calendar1.getDate();
				
				temp=date.getYear() + 1900;
				finaldate = temp.toString() + "-";
				temp=date.getMonth() + 1;
				
				finaldate = finaldate + temp.toString() + "-";
				temp=date.getDate();
				
				finaldate = finaldate + temp.toString() + " ";
				temp=date.getHours();
				finaldate = finaldate + temp.toString() + ":";
				temp=date.getMinutes();
				finaldate = finaldate + temp.toString();
				
				System.out.println(finaldate);
				
				
				
				
				
				
			//	System.out.println("TIME FROM GUI: " + date.getDate() + date );
				
				List<String> templist =inviteFriendsList.getSelectedValuesList(); //get selected friends
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
					theClient.createEvent(newEvent.getText(), currentUser, selectedFriends, finaldate,eventLocation.getText() );
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
		
		addFriend = new JTextField();
		addFriend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addFriend.setText("");
				addFriend.setForeground(Color.DARK_GRAY);
				addFriendError.setVisible(false);
			}
		});
		addFriend.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				addFriend.setText("");
				addFriend.setForeground(Color.DARK_GRAY);
				addFriendError.setVisible(false);
			}
		});
		addFriend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(!theClient.addfriend(currentUser, addFriend.getText())){
						addFriendError.setVisible(true);
					}
						
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		addFriend.setForeground(Color.LIGHT_GRAY);
		addFriend.setText("Add new friend");
		addFriend.setBounds(167, 46, 147, 40);
		profilePanel.add(addFriend);
		addFriend.setColumns(10);
		
		JScrollPane profileFriendsScroll = new JScrollPane();
		profileFriendsScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		profileFriendsScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		profileFriendsScroll.setBounds(167, 111, 147, 171);
		profilePanel.add(profileFriendsScroll);
		
		
		addFriendError.setVisible(false);
		addFriendError.setForeground(Color.RED);
		addFriendError.setBounds(167, 86, 147, 16);
		profilePanel.add(addFriendError);
		
		
		
		JCalendarCombo calendarCombo = new JCalendarCombo(3, true);
		calendarCombo.setTodayFont(new Font("Dialog", Font.PLAIN, 14));
		calendarCombo.setTitleFont(new Font("Serif", Font.BOLD | Font.ITALIC, 13));
		calendarCombo.setTimeFont(new Font("DialogInput", Font.PLAIN, 10));
		calendarCombo.setFont(new Font("DialogInput", Font.PLAIN, 13));
		calendarCombo.setEditable(true);
		calendarCombo.setDayOfWeekFont(new Font("SansSerif", Font.ITALIC, 13));
		calendarCombo.setDayFont(new Font("SansSerif", Font.BOLD, 13));
		calendarCombo.setBounds(20, 376, 180, 45);
		ModifyEvent.add(calendarCombo);
		
		
		
		eventNameModify = new JTextField();
		eventNameModify.setText("Enter new name");
		eventNameModify.setForeground(new Color(211, 211, 211));
		eventNameModify.setColumns(10);
		eventNameModify.setBounds(20, 329, 188, 46);
		ModifyEvent.add(eventNameModify);
		
		eventLocationModify = new JTextField();
		eventLocationModify.setText("New Location");
		eventLocationModify.setForeground(new Color(211, 211, 211));
		eventLocationModify.setColumns(10);
		eventLocationModify.setBounds(205, 329, 109, 46);
		ModifyEvent.add(eventLocationModify);
		
		JScrollPane friendsModify = new JScrollPane();
		friendsModify.setBounds(219, 103, 95, 75);
		ModifyEvent.add(friendsModify);
		
		JButton modifyEvent = new JButton("Modify Event!");
		modifyEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				Vector<String> tempfriends = new Vector<String>();
				try {
					tempfriends=theClient.getInvited(eventNameDispla.getText());
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				String finaldate = new String();
				Integer temp = new Integer(0);
				Date date = calendarCombo.getDate();
				
				temp=date.getYear() + 1900;
				finaldate = temp.toString() + "-";
				temp=date.getMonth() + 1;
				
				finaldate = finaldate + temp.toString() + "-";
				temp=date.getDate();
				
				finaldate = finaldate + temp.toString() + " ";
				temp=date.getHours();
				finaldate = finaldate + temp.toString() + ":";
				temp=date.getMinutes();
				finaldate = finaldate + temp.toString();
				
				
				
				try {
					theClient.deleteEvent(eventNameDispla.getText());
									} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					theClient.createEvent(eventNameDispla.getText(), currentUser, tempfriends, finaldate, eventLocationModify.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				
				
				
			}
		});
		modifyEvent.setBounds(18, 423, 188, 29);
		ModifyEvent.add(modifyEvent);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 85, 302, 6);
		ModifyEvent.add(separator_1);
		
		JButton btnNewButton_1 = new JButton("Delete Event!");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				theClient.deleteEvent(eventNameDispla.getText());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		btnNewButton_1.setBounds(197, 423, 117, 29);
		ModifyEvent.add(btnNewButton_1);
		
		
		
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
					// prevent log in when incorrect data is entered
					if(!username.getText().toLowerCase().equals("") && !username.getText().toLowerCase().equals("username") && !passwordLogIn.getText().toLowerCase().equals("") && !passwordLogIn.getText().toLowerCase().equals("password")){
						temp=theClient.login(username.getText(), passwordLogIn.getText());}
					else
						signInError.setVisible(true);
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
					
					JList<String> newFriends = new JList<String>(friends);
					inviteFriendsScroll.setViewportView(newFriends);
					profileFriendsScroll.setViewportView(newFriends);
			
					// populate the list and wrap scrollPane around it
					
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


				        tempString = events.get(i);// get each event.

						String [] temp1 = tempString.split("&");// split each event into place & time based on "&"

						
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
						button.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) { // action performed when Sign Up button is pressed.
								// take user to sign up field
								
								Vector<String> eventdetailz = new Vector<String>();
								try {
									eventdetailz=theClient.eventDetails(temp1[2]);
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								eventLocationDispla.setText(eventdetailz.get(1));
								eventTimeDispla.setText(eventdetailz.get(0));
								eventNameDispla.setText(temp1[2]);
								ModifyEvent.setVisible(true);
								HomePanel.setVisible(false);
							}
						});
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
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) { // action taken when Sign Up Button is pressed.
				String response = new String();
				try {
					if (!usernameS.getText().toLowerCase().equals("") && !usernameS.getText().toLowerCase().equals("username") && !passwordField.getText().toLowerCase().equals("") && !passwordField.getText().toLowerCase().equals("password") && dobS.getText().toLowerCase().equals("") && dobS.getText().toLowerCase().equals("") )
					response = theClient.signup(usernameS.getText(), passwordField.getText(), emailS.getText(), firstNameS.getText(), lastNameS.getText(), dobS.getText());
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
//				System.out.println("REsponse from server is: " + response);
				if(response.equals("success")){
					//transition back to loginpanel
					SignUpPanel.setVisible(false);

					LogInPanel.setVisible(true);}
				else{
					incorrectSignUp.setVisible(true);}

				
			}});
		}

	    //================================================================================
	    // Profile Panel
		// 1- Access friends list
		// 2- Add friends
		// 3- Delete friends
		// 4- Access personal information
		// 5- Edit personal information
	    //================================================================================
	
	
	// INNER CLASSES

private class MyDateListener
      implements DateListener
{

public void dateChanged(DateEvent e)
{
    Calendar c = e.getSelectedDate();
    if (c != null) {
	System.out.println(c.getTime());
    }
    else {
	System.out.println("No time selected.");
    }
}

}
}
