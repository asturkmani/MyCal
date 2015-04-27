package projecttrial1;
import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.CardLayout;

import javax.swing.BorderFactory;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.border.Border;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JSeparator;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.ScrollPaneConstants;

import org.freixas.jcalendar.DateEvent;
import org.freixas.jcalendar.DateListener;
import org.freixas.jcalendar.JCalendarCombo;

public class ClientGUI2 {
	private JFrame frame;
	private JTextField usernameS;
	private JTextField firstNameS;
	private JTextField lastNameS;
	private JTextField emailS;
	private JTextField username;
	private String currentUser = null;
	private Vector<String> friends = new Vector<String>();
	private Vector<String> events = new Vector<String>();
	private Vector<String> attendingEvents = new Vector<String>();
	private Vector<String> notificationEvents = new Vector<String>();
	private Vector<String> details = new Vector<String>();
	private JLabel signInError = new JLabel("Incorrect username/password");
	private JPasswordField passwordLogIn;
	private Boolean toset = true;
	private JTextField dobS;
	private JPasswordField passwordField;
	private JTextField newEvent;
	private JTextField eventLocation;
	private Vector<JButton> vectorOfButtons = new Vector<JButton>();
	private JTextField eventLocationModify;
	private JTextField addFriend;
	private JList<String> newFriends;
	private JList<String> newFriends2;
	private JTextField DOB_modify;
	private JTextField email_modify;
	private JTextField FName_modify;
	private JTextField LName_modify;
	private JPasswordField password_modify_profile;


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
	@SuppressWarnings("deprecation")
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
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(null);
		
		JPanel editProfileDetails = new JPanel();
		editProfileDetails.setBounds(62, 111, 93, 171);
		editProfileDetails.setVisible(false);
		profilePanel.add(editProfileDetails);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 98, 302, 226);
		ModifyEvent.add(scrollPane);
		
		JPanel CommentsPanel = new JPanel(new GridLayout(0,2));
		scrollPane.setViewportView(CommentsPanel);
		CommentsPanel.setBackground(Color.WHITE);
		
		JTextArea newComment = new JTextArea("Add a comment...");
		newComment.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				newComment.setText("");
				newComment.setForeground(Color.DARK_GRAY);
			}
		});
		newComment.setForeground(Color.LIGHT_GRAY);
		newComment.setBackground(Color.WHITE);
		newComment.setBounds(12, 326, 250, 45);
		newComment.setVisible(true);
		Border border = BorderFactory.createLineBorder(Color.DARK_GRAY, 1);

		newComment.setBorder(border);
		ModifyEvent.add(newComment);
		
		DOB_modify = new JTextField();
		editProfileDetails.add(DOB_modify);
		DOB_modify.setColumns(7);
		
		FName_modify = new JTextField();
		editProfileDetails.add(FName_modify);
		FName_modify.setColumns(7);
		
		LName_modify = new JTextField();
		editProfileDetails.add(LName_modify);
		LName_modify.setColumns(7);
		
		password_modify_profile = new JPasswordField();
		password_modify_profile.setColumns(7);
		editProfileDetails.add(password_modify_profile);
		
		email_modify = new JTextField();
		editProfileDetails.add(email_modify);
		email_modify.setColumns(7);
		
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
		
		JButton createAccount = new JButton("Create free account");
		createAccount.setForeground(Color.WHITE);
		createAccount.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		createAccount.setOpaque(true);
		createAccount.setBorderPainted(false);
		createAccount.setBackground(UIManager.getColor("Button.select"));
		createAccount.setBorder(UIManager.getBorder("Button.border"));
		createAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // action performed when Sign Up button is pressed.
				// take user to sign up field
				SignUpPanel.setVisible(true);
				LogInPanel.setVisible(false);
			}
		});
		createAccount.setBounds(6, 317, 308, 47);
		LogInPanel.add(createAccount);
		
		passwordLogIn = new JPasswordField();		
		passwordLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLogIn.doClick();
			}
		});
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
		dobS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSignUp.doClick();
			}
		});
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
		
		//================================================================================
		// 1 - Profile panel components
	    //================================================================================
		
		
		
		JLabel DOB_actual = new JLabel("New label");
		DOB_actual.setBounds(62, 120, 93, 22);
		profilePanel.add(DOB_actual);
		
		JLabel fname_actual = new JLabel("New label");
		fname_actual.setBounds(62, 154, 93, 22);
		profilePanel.add(fname_actual);
		
		JLabel lname_actual = new JLabel("New label");
		lname_actual.setBounds(62, 188, 93, 22);
		profilePanel.add(lname_actual);
		
		JLabel email_actual = new JLabel("New label");
		email_actual.setBounds(62, 249, 93, 22);
		profilePanel.add(email_actual);
		
		
		JLabel currentUsername = new JLabel("");
		currentUsername.setBounds(6, 52, 149, 16);
		profilePanel.add(currentUsername);
		
		//================================================================================
		// 1 - Home panel components
	    //================================================================================
		JLabel addFriendError = new JLabel("User does not exist!");
		JCalendarCombo calendarCombo = new JCalendarCombo(3, true);
		JButton modifyEvent = new JButton("Modify Event!");
		
		
	    JScrollPane profileFriendsScroll = new JScrollPane();
		profileFriendsScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		profileFriendsScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		profileFriendsScroll.setBounds(167, 111, 147, 171);
		profilePanel.add(profileFriendsScroll);
		
		JScrollPane inviteFriendsScroll = new JScrollPane();
		inviteFriendsScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		inviteFriendsScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		inviteFriendsScroll.setBounds(205, 87, 92, 68);
		HomePanel.add(inviteFriendsScroll);
		
		JLabel EventLocationDisplay = new JLabel("Location:");
		EventLocationDisplay.setBounds(54, 28, 61, 16);
		ModifyEvent.add(EventLocationDisplay);
		
		JLabel eventTimeDisplay = new JLabel("Time:");
		eventTimeDisplay.setBounds(54, 42, 61, 16);
		ModifyEvent.add(eventTimeDisplay);
		
		JLabel eventLocationDispla = new JLabel("");
		eventLocationDispla.setBounds(127, 28, 173, 16);
		ModifyEvent.add(eventLocationDispla);
		
		JLabel eventTimeDispla = new JLabel("");
		eventTimeDispla.setBounds(127, 42, 173, 16);
		ModifyEvent.add(eventTimeDispla);
		
		JLabel eventNameDispla = new JLabel("Event name");
		eventNameDispla.setBounds(53, 6, 409, 35);
		ModifyEvent.add(eventNameDispla);
		
		JLabel goBack = new JLabel("");
		goBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ModifyEvent.setVisible(false);
				HomePanel.setVisible(true);
			}
		});
		goBack.setIcon(new ImageIcon(ClientGUI2.class.getResource("/org/freixas/jcalendar/images/Back16.gif")));
		goBack.setBounds(12, 6, 35, 35);
		ModifyEvent.add(goBack);
		
		
		JButton deleteEvent = new JButton("Delete Event!");
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
		profileName.setBounds(60, 6, 409, 35);
		HomePanel.add(profileName);
		
		JLabel goToProfile = new JLabel("");
		goToProfile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Vector<String> details = new Vector<String>();
				try {
					details= theClient.getDetails(currentUser);
					DOB_actual.setText(details.get(5));
					lname_actual.setText(details.get(4));
					fname_actual.setText(details.get(3));
					email_actual.setText(details.get(2));
					
					currentUsername.setText(details.get(0));
					profilePanel.setVisible(true);
					HomePanel.setVisible(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
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
//						Vector<String> invitedFriends = newFriends.getSelectedValues();
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
		
		eventLocation.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				eventLocation.setText("");
				eventLocation.setForeground(Color.DARK_GRAY);
			}
		});
		eventLocation.setText("Where?");
		eventLocation.setForeground(new Color(211, 211, 211));
		eventLocation.setBounds(205, 42, 95, 46);
		HomePanel.add(eventLocation);
		eventLocation.setColumns(10);

		//================================================================================
		// 1 - ModifyEvent panel components
	    //================================================================================

		JButton createEvent = new JButton("Create Event!");
		createEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// get name date, time, invited peeps, username from entered fields and create the event. initially set rating to 0.

				
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
				System.out.println("invite friends list is: " + newFriends2);
				List<String> templist = newFriends2.getSelectedValuesList(); //get selected friends
				System.out.println("Selected values are: " + templist);
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

				try {
					System.out.println("Invited friends are: " + selectedFriends);
					theClient.createEvent(newEvent.getText(), currentUser, selectedFriends, finaldate,eventLocation.getText() );
					
					// dynamically update the list
					vectorOfButtons.clear();
					buttonsPanel.removeAll();
					buttonsPanel.setPreferredSize(null);
					
					// re-populate the list of events
					events = theClient.eventList(currentUser); 		// obtain event list
					attendingEvents = theClient.getAttendingUser(currentUser);
					
					System.out.println("OBTAINED EVENTS CREATED: " + events);
					System.out.println("OBTAINED EVENTS ATTENDING: " + attendingEvents);
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
					int maxSize = Math.max(events.size(), attendingEvents.size());
					System.out.println("Max size between attending and invited is: " + maxSize);
//					System.out.println("Obtained events user created: " + events);
				    for(int i = 0; i < maxSize; i++) {


				    	if (i<events.size()){
//				    		System.out.println("Checking if user created any events");
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
								Vector<String> comments = new Vector<String>();
								try {
									eventdetailz=theClient.eventDetails(temp1[2]);
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
								try {
									comments = theClient.getComment(temp1[2]);
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								System.out.println("get comment for: " + temp1[2]);
								System.out.println("Comments are: " + comments);
								
								//fill out comments
								for (int i=0;i<comments.size();i++){
									if(i%2 == 0){
										JTextArea temp = new JTextArea();
										temp.setText(comments.get(i) +": " + comments.get(i+1));
//										System.out.println("users" +comments.get(i));
										temp.setEditable(false);
										temp.setVisible(true);
										CommentsPanel.add(temp);
									}
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
				    	
				    	
				    	// now add events you are attending
				    	if (i<attendingEvents.size()){
				    		System.out.println("Checking if user is attending any events");
					        String tempString2 = attendingEvents.get(i);// get each event.
							// specify button properties
							JButton button = new JButton(tempString2);
							System.out.println("Obtained events attending names: " + tempString2);
							button.setFont(new Font("Lucida Grande", Font.BOLD, 16));
							button.setForeground(Color.WHITE);
							button.setBackground(UIManager.getColor("Button.select"));
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
									Vector<String> comments = new Vector<String>();
									try {
										eventdetailz=theClient.eventDetails(tempString2);
									} catch (Exception e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									
									try {
										comments = theClient.getComment(tempString2);
									} catch (Exception e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									System.out.println("get comment for: " + tempString2);
									System.out.println("Comments are: " + comments);
									
									
									//fill in comments
									for (int i=0;i<comments.size();i++){
										if(i%2 == 0){
											JTextArea temp = new JTextArea();
											temp.setText(comments.get(i) +": " + comments.get(i+1));
//											System.out.println("users" +comments.get(i));
											temp.setEditable(false);
											temp.setVisible(true);
											CommentsPanel.add(temp);
										}
									}
										
									eventLocationDispla.setText(eventdetailz.get(1));
									eventTimeDispla.setText(eventdetailz.get(0));
									eventNameDispla.setText(tempString2);
                                    
                                    calendarCombo.setVisible(false);
                                    eventLocationModify.setVisible(false);
                                    modifyEvent.setVisible(false);
                                    deleteEvent.setVisible(false);
                                    
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
				        
				    }
				    buttonsPanel.revalidate();
				    buttonsPanel.repaint();
					buttonsPanel.revalidate();
					HomePanel.revalidate();
					HomePanel.repaint();
				    HomePanel.revalidate();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				 buttonsPanel.revalidate();
				    buttonsPanel.repaint();
					buttonsPanel.revalidate();
					HomePanel.revalidate();
					HomePanel.repaint();
				    HomePanel.revalidate();
			    
			}
			
		});
		createEvent.setBounds(12, 130, 188, 29);
		HomePanel.add(createEvent);
		
		JLabel notifications = new JLabel("");
		notifications.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					
					// JPanel to contain everything
					JPanel Notifications = new JPanel(new GridLayout(0,2));
					JPopupMenu showNotifications = new JPopupMenu();
					
					Vector<JLabel> events = new Vector<JLabel>();
					Vector<JCheckBox> decisions = new Vector<JCheckBox>();
					
					
					Vector<String> notificationEvents = theClient.getInvitedUser(currentUser);
					for (int i=0;i<notificationEvents.size();i++){
						
						//obtain event name, create it's check box
						JLabel eventNotif = new JLabel(notificationEvents.get(i));
						events.add(eventNotif);
						Notifications.add(eventNotif);
						
						// add the check boxes
						JCheckBox decision = new JCheckBox();
						decisions.add(decision);
						Notifications.add(decision);
					}
					
					JButton acceptNoti = new JButton("Accept");
					acceptNoti.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							try {
								//iterate through the checkboxes and execute its respective event
								for (int i=0;i<decisions.size();i++){
									//accept the event
									if(decisions.get(i).isSelected() )
										theClient.acceptEvent(currentUser, events.get(i).getText()); 
								}
								
								//check if there are anymore notifications, if not hide the notifications sign
								showNotifications.setVisible(false);
								Vector<String> tempCheck = theClient.getInvitedUser(currentUser);
								if(tempCheck.size() == 0){
									notifications.setVisible(false);
									notifications.disable();
								}
								
								//refresh event list
								// dynamically update the list
								vectorOfButtons.clear();
								buttonsPanel.removeAll();
								buttonsPanel.setPreferredSize(null);
								
								// re-populate the list of events
								Vector<String> events = theClient.eventList(currentUser); 		// obtain event list
								attendingEvents = theClient.getAttendingUser(currentUser);
								
								System.out.println("OBTAINED EVENTS CREATED: " + events);
								System.out.println("OBTAINED EVENTS ATTENDING: " + attendingEvents);
							    // GridBagConstraint for button
							    GridBagConstraints constraint = new GridBagConstraints();
							    constraint.anchor = GridBagConstraints.CENTER;
							    constraint.fill = GridBagConstraints.NONE;
							    constraint.gridx = 0;
							    constraint.gridy = GridBagConstraints.RELATIVE;
							    constraint.weightx = 1.0f;
							    constraint.weighty = 1.0f;

//							    int sizeOfButtons = 50;
							    
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
								int maxSize = Math.max(events.size(), attendingEvents.size());
								System.out.println("Max size between attending and invited is: " + maxSize);
//								System.out.println("Obtained events user created: " + events);
							    for(int i = 0; i < maxSize; i++) {


							    	if (i<events.size()){
//							    		System.out.println("Checking if user created any events");
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
							    	
							    	
							    	// now add events you are attending
							    	if (i<attendingEvents.size()){
							    		System.out.println("Checking if user is attending any events");
								        String tempString2 = attendingEvents.get(i);// get each event.
										// specify button properties
										JButton button = new JButton(tempString2);
										System.out.println("Obtained events attending names: " + tempString2);
										button.setFont(new Font("Lucida Grande", Font.BOLD, 16));
										button.setForeground(Color.WHITE);
										button.setBackground(UIManager.getColor("Button.select"));
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
													eventdetailz=theClient.eventDetails(tempString2);
												} catch (Exception e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												}
												eventLocationDispla.setText(eventdetailz.get(1));
												eventTimeDispla.setText(eventdetailz.get(0));
												eventNameDispla.setText(tempString2);
			                                    
			                                    calendarCombo.setVisible(false);
			                                    eventLocationModify.setVisible(false);
			                                    modifyEvent.setVisible(false);
			                                    deleteEvent.setVisible(false);
			                                    
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
							        
							    }
							    HomePanel.repaint();
							    HomePanel.revalidate();
							    buttonsPanel.repaint();
							    buttonsPanel.revalidate();
							    
									
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					});
					Notifications.add(acceptNoti);
					
					// delete event option
					JButton deleteNoti = new JButton("Decline");
					deleteNoti.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							try {
								//iterate through the checkboxes and execute its respective event
								for (int i=0;i<decisions.size();i++){
									//decline the event
									if(decisions.get(i).isSelected() )
										theClient.declineEvent(currentUser, events.get(i).getText()); 
								}
								showNotifications.setVisible(false);
								Vector<String> tempCheck = theClient.getInvitedUser(currentUser);
								if(tempCheck.size() == 0){
									notifications.setVisible(false);
									notifications.disable();}
									

								// dynamically update the list
								vectorOfButtons.clear();
								buttonsPanel.removeAll();
								buttonsPanel.setPreferredSize(null);
								
								// re-populate the list of events
								Vector<String>events = theClient.eventList(currentUser); 		// obtain event list
								attendingEvents = theClient.getAttendingUser(currentUser);
								
								System.out.println("OBTAINED EVENTS CREATED: " + events);
								System.out.println("OBTAINED EVENTS ATTENDING: " + attendingEvents);
							    // GridBagConstraint for button
							    GridBagConstraints constraint = new GridBagConstraints();
							    constraint.anchor = GridBagConstraints.CENTER;
							    constraint.fill = GridBagConstraints.NONE;
							    constraint.gridx = 0;
							    constraint.gridy = GridBagConstraints.RELATIVE;
							    constraint.weightx = 1.0f;
							    constraint.weighty = 1.0f;

//							    int sizeOfButtons = 50;
							    
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
								int maxSize = Math.max(events.size(), attendingEvents.size());
								System.out.println("Max size between attending and invited is: " + maxSize);
//								System.out.println("Obtained events user created: " + events);
							    for(int i = 0; i < maxSize; i++) {


							    	if (i<events.size()){
//							    		System.out.println("Checking if user created any events");
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
							    	
							    	
							    	// now add events you are attending
							    	if (i<attendingEvents.size()){
							    		System.out.println("Checking if user is attending any events");
								        String tempString2 = attendingEvents.get(i);// get each event.
										// specify button properties
										JButton button = new JButton(tempString2);
										System.out.println("Obtained events attending names: " + tempString2);
										button.setFont(new Font("Lucida Grande", Font.BOLD, 16));
										button.setForeground(Color.WHITE);
										button.setBackground(UIManager.getColor("Button.select"));
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
													eventdetailz=theClient.eventDetails(tempString2);
												} catch (Exception e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												}
												eventLocationDispla.setText(eventdetailz.get(1));
												eventTimeDispla.setText(eventdetailz.get(0));
												eventNameDispla.setText(tempString2);
			                                    
			                                    calendarCombo.setVisible(false);
			                                    eventLocationModify.setVisible(false);
			                                    modifyEvent.setVisible(false);
			                                    deleteEvent.setVisible(false);
			                                    
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
							        
							    }
							    buttonsPanel.repaint();
								buttonsPanel.revalidate();
								HomePanel.repaint();
							    HomePanel.revalidate();
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					});
					
					buttonsPanel.repaint();
					buttonsPanel.revalidate();
					HomePanel.repaint();
				    HomePanel.revalidate();				    
					Notifications.add(deleteNoti);

					//place the notifications in the JPanel in a scrollablePane and put them in the popup
					
					JScrollPane notificationsScroll = new JScrollPane(Notifications);

					showNotifications.add(notificationsScroll);
					
					showNotifications.show(notifications, -60, 0);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		notifications.setIcon(new ImageIcon("/Users/asturkmani/Documents/workspace/MyCal/src/notifications.png"));
		notifications.setBounds(280, 6, 35, 35);
		notifications.setVisible(false);
		notifications.disable();
		HomePanel.add(notifications);
		
		JLabel goToHome = new JLabel("");
		goToHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HomePanel.setVisible(true);
				editProfileDetails.setVisible(false);
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
					String response = theClient.addfriend(currentUser, addFriend.getText());
					if(response.equals("success")){
						friends = theClient.friendList(currentUser); 
						JList<String> newFriends = new JList<String>(friends);
						newFriends.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						
						JList<String> newFriends2 = new JList<String>(friends);
						newFriends2.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION );
						
						//update list of friends
						inviteFriendsScroll.setViewportView(newFriends2);
						profileFriendsScroll.setViewportView(newFriends);
						
						//revalidate them
						inviteFriendsScroll.revalidate();
						inviteFriendsScroll.repaint();
						profileFriendsScroll.revalidate();
						
						addFriend.setText("");
						addFriendError.setVisible(false);
					}
					else
						addFriendError.setVisible(true);
						
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		addFriend.setForeground(Color.LIGHT_GRAY);
		addFriend.setText("Add new friend");
		addFriend.setBounds(167, 41, 147, 40);
		profilePanel.add(addFriend);
		addFriend.setColumns(10);

		
		
		addFriendError.setVisible(false);
		addFriendError.setForeground(Color.RED);
		addFriendError.setBounds(167, 86, 147, 16);
		profilePanel.add(addFriendError);
		
		JLabel addNewFriend = new JLabel("Add a new friend:");
		addNewFriend.setBounds(167, 24, 147, 16);
		profilePanel.add(addNewFriend);

		
		JLabel currentUserDOB = new JLabel("DOB");
		currentUserDOB.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		currentUserDOB.setBounds(6, 120, 34, 16);
		profilePanel.add(currentUserDOB);
		
		JLabel fname = new JLabel("FName");
		fname.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		fname.setBounds(6, 157, 51, 16);
		profilePanel.add(fname);
		
		JLabel lname = new JLabel("LName");
		lname.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lname.setBounds(6, 191, 51, 16);
		profilePanel.add(lname);
		
		JLabel email = new JLabel("Email");
		email.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		email.setBounds(6, 252, 45, 16);
		profilePanel.add(email);
		
		JButton deleteFriend = new JButton("Delete selected");
		deleteFriend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String todelete = newFriends.getSelectedValue();
				try {
					String response = theClient.deleteFriend(todelete, currentUser);
					if(response.equals("success")){
						friends = theClient.friendList(currentUser); 
						newFriends = new JList<String>(friends);
						newFriends2 =new JList<String>(friends); 
						newFriends.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						newFriends2.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
						
						
						inviteFriendsScroll.setViewportView(newFriends2);
						profileFriendsScroll.setViewportView(newFriends);
						inviteFriendsScroll.revalidate();
						profileFriendsScroll.revalidate();}
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		deleteFriend.setBounds(167, 294, 147, 29);
		profilePanel.add(deleteFriend);
		
		JLabel editDetials = new JLabel("");
		editDetials.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editProfileDetails.setVisible(true);
				
			}
		});
		editDetials.setIcon(new ImageIcon("/Users/asturkmani/Documents/workspace/MyCal/src/cog.png"));
		editDetials.setBounds(46, 6, 34, 34);
		profilePanel.add(editDetials);
		
		JButton modifyProfile = new JButton("Update profile");
		modifyProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					theClient.updateuser(currentUser, FName_modify.getText(), LName_modify.getText(), email_modify.getText(), password_modify_profile.getText(), DOB_modify.getText());
					FName_modify.setText(""); LName_modify.setText(""); email_modify.setText("");password_modify_profile.setText("");DOB_modify.setText("");
				    editProfileDetails.setVisible(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		modifyProfile.setBounds(6, 294, 149, 29);
		profilePanel.add(modifyProfile);
		
		JLabel pass_actual = new JLabel("********");
		pass_actual.setBounds(62, 221, 93, 16);
		profilePanel.add(pass_actual);
		
		JLabel password_modify = new JLabel("Pass");
		password_modify.setBounds(6, 222, 51, 18);
		profilePanel.add(password_modify);

		
		JButton signOut = new JButton("Sign Out");
		signOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				HomePanel.setVisible(false);
				profilePanel.setVisible(false);
				LogInPanel.setVisible(true);
			}
		});
		signOut.setOpaque(true);
		signOut.setForeground(Color.WHITE);
		signOut.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		signOut.setBorderPainted(false);
		signOut.setBorder(UIManager.getBorder("Button.border"));
		signOut.setBackground(UIManager.getColor("Button.select"));
		signOut.setBounds(6, 405, 308, 47);
		profilePanel.add(signOut);
		
		
		
		calendarCombo.setTodayFont(new Font("Dialog", Font.PLAIN, 14));
		calendarCombo.setTitleFont(new Font("Serif", Font.BOLD | Font.ITALIC, 13));
		calendarCombo.setTimeFont(new Font("DialogInput", Font.PLAIN, 10));
		calendarCombo.setFont(new Font("DialogInput", Font.PLAIN, 13));
		calendarCombo.setEditable(true);
		calendarCombo.setDayOfWeekFont(new Font("SansSerif", Font.ITALIC, 13));
		calendarCombo.setDayFont(new Font("SansSerif", Font.BOLD, 13));
		calendarCombo.setBounds(20, 376, 180, 45);
		ModifyEvent.add(calendarCombo);
		
		eventLocationModify = new JTextField();
		eventLocationModify.setText("New Location");
		eventLocationModify.setForeground(new Color(211, 211, 211));
		eventLocationModify.setColumns(10);
		eventLocationModify.setBounds(197, 375, 117, 46);
		ModifyEvent.add(eventLocationModify);
		
		
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
				//	theClient.deleteEvent(eventNameDispla.getText());
									} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					theClient.modifyEvent(eventNameDispla.getText(), currentUser, tempfriends, finaldate, eventLocationModify.getText());
					

					// dynamically update the list
					vectorOfButtons.clear();
					buttonsPanel.removeAll();
					buttonsPanel.setPreferredSize(null);
					
					// re-populate the list of events
					events = theClient.eventList(currentUser); 		// obtain event list
					attendingEvents = theClient.getAttendingUser(currentUser);
					
					System.out.println("OBTAINED EVENTS CREATED: " + events);
					System.out.println("OBTAINED EVENTS ATTENDING: " + attendingEvents);
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
					int maxSize = Math.max(events.size(), attendingEvents.size());
					System.out.println("Max size between attending and invited is: " + maxSize);
//					System.out.println("Obtained events user created: " + events);
				    for(int i = 0; i < maxSize; i++) {


				    	if (i<events.size()){
//				    		System.out.println("Checking if user created any events");
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
				    	
				    	
				    	// now add events you are attending
				    	if (i<attendingEvents.size()){
				    		System.out.println("Checking if user is attending any events");
					        String tempString2 = attendingEvents.get(i);// get each event.
							// specify button properties
							JButton button = new JButton(tempString2);
							System.out.println("Obtained events attending names: " + tempString2);
							button.setFont(new Font("Lucida Grande", Font.BOLD, 16));
							button.setForeground(Color.WHITE);
							button.setBackground(UIManager.getColor("Button.select"));
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
										eventdetailz=theClient.eventDetails(tempString2);
									} catch (Exception e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									eventLocationDispla.setText(eventdetailz.get(1));
									eventTimeDispla.setText(eventdetailz.get(0));
									eventNameDispla.setText(tempString2);
                                    
                                    calendarCombo.setVisible(false);
                                    eventLocationModify.setVisible(false);
                                    modifyEvent.setVisible(false);
                                    deleteEvent.setVisible(false);
                                    
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
				        
				    }

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				buttonsPanel.repaint();
				buttonsPanel.revalidate();
				HomePanel.repaint();
			    HomePanel.revalidate();
			}
			
		});
		modifyEvent.setBounds(12, 423, 194, 29);
		ModifyEvent.add(modifyEvent);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 80, 302, 6);
		ModifyEvent.add(separator_1);
		
		
		deleteEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				theClient.deleteEvent(eventNameDispla.getText());
				

				// dynamically update the list
				vectorOfButtons.clear();
				buttonsPanel.removeAll();
				buttonsPanel.setPreferredSize(null);
				
				// re-populate the list of events
				events = theClient.eventList(currentUser); 		// obtain event list
				attendingEvents = theClient.getAttendingUser(currentUser);
				
				System.out.println("OBTAINED EVENTS CREATED: " + events);
				System.out.println("OBTAINED EVENTS ATTENDING: " + attendingEvents);
			    // GridBagConstraint for button
			    GridBagConstraints constraint = new GridBagConstraints();
			    constraint.anchor = GridBagConstraints.CENTER;
			    constraint.fill = GridBagConstraints.NONE;
			    constraint.gridx = 0;
			    constraint.gridy = GridBagConstraints.RELATIVE;
			    constraint.weightx = 1.0f;
			    constraint.weighty = 1.0f;

//			    int sizeOfButtons = 50;
			    
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
				int maxSize = Math.max(events.size(), attendingEvents.size());
				System.out.println("Max size between attending and invited is: " + maxSize);
//				System.out.println("Obtained events user created: " + events);
			    for(int i = 0; i < maxSize; i++) {


			    	if (i<events.size()){
//			    		System.out.println("Checking if user created any events");
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
			    	
			    	
			    	// now add events you are attending
			    	if (i<attendingEvents.size()){
			    		System.out.println("Checking if user is attending any events");
				        String tempString2 = attendingEvents.get(i);// get each event.
						// specify button properties
						JButton button = new JButton(tempString2);
						System.out.println("Obtained events attending names: " + tempString2);
						button.setFont(new Font("Lucida Grande", Font.BOLD, 16));
						button.setForeground(Color.WHITE);
						button.setBackground(UIManager.getColor("Button.select"));
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
									eventdetailz=theClient.eventDetails(tempString2);
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								eventLocationDispla.setText(eventdetailz.get(1));
								eventTimeDispla.setText(eventdetailz.get(0));
								eventNameDispla.setText(tempString2);
								
								
								calendarCombo.setVisible(false);
								eventLocationModify.setVisible(false); 
								modifyEvent.setVisible(false);
								deleteEvent.setVisible(false);
								
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
			        
			    }

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			buttonsPanel.repaint();
			buttonsPanel.revalidate();
			HomePanel.repaint();
		    HomePanel.revalidate();
		    
		    ModifyEvent.setVisible(false);
		    HomePanel.setVisible(true);
		}
		
	});
		deleteEvent.setBounds(197, 423, 117, 29);
		ModifyEvent.add(deleteEvent);
		
		JLabel viewInvitees = new JLabel("View pending");
		JLabel viewAttendees = new JLabel("View attending");
		// create a popup menu to show invited users
		viewInvitees.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// create panel to house invitees
				JPanel invitees = new JPanel(new GridLayout(0, 1));
				invitees.setBackground(new Color(255,0,0));
				
				try {
					Vector<String> inviteesList = theClient.getInvited(eventNameDispla.getText());
					
					//if no one is attending
					if( inviteesList.size() == 0){
						JLabel invited = new JLabel("None"); 
						
//						invited.setPreferredSize(new Dimension(60, 20));
						
						invited.setBackground(new Color(255,0,0));
						invited.setPreferredSize(new Dimension(100, 20));
						
						invited.setOpaque(true);
						invited.setForeground(Color.WHITE);
						invited.setFont(new Font("Lucia Grande",Font.BOLD,14));
						
						//add new friend to the JPanel
						invitees.add(invited);
					}
					
					//else add all attending peeps
					for (int i=0;i<inviteesList.size();i++){
						
						JLabel invited = new JLabel(inviteesList.get(i)); 
						
						invited.setPreferredSize(new Dimension(100, 20));
						
						invited.setBackground(new Color(255,0,0));

						
						invited.setOpaque(true);
						invited.setForeground(Color.WHITE);
						invited.setFont(new Font("Lucia Grande",Font.BOLD,14));
						
						//add new friend to the JPanel
						invitees.add(invited);
					}
					//create scrollpane to house textarea

				JScrollPane inviteesScroll = new JScrollPane(invitees);

				inviteesScroll.getViewport().setBorder(null);
				inviteesScroll.setViewportBorder(null);
				inviteesScroll.setBorder(null);
				inviteesScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				
//				JScrollPane attendeesScroll = new JScrollPane(invitees);

//				attendeesScroll.getViewport().setBorder(null);
//				attendeesScroll.setViewportBorder(null);
//				attendeesScroll.setBorder(null);
//				attendeesScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

				
				//place scrollable textarea in the popup menu
				JPopupMenu inviteesPopup = new JPopupMenu();
				inviteesPopup.add(inviteesScroll);
				
//				JPopupMenu attendeesPopup = new JPopupMenu();
//				attendeesPopup.add(attendeesScroll);
				
				inviteesPopup.setVisible(true);
				inviteesPopup.show(viewInvitees, 0, 20);
//				attendeesPopup.show(viewInvitees , 0, 20);

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		viewInvitees.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		viewInvitees.setForeground(Color.BLUE);
		viewInvitees.setBounds(54, 56, 102, 16);
		ModifyEvent.add(viewInvitees);
		
		
		viewAttendees.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// create panel to house invitees
				JPanel attendees = new JPanel(new GridLayout(0,1));
				attendees.setBackground(Color.GREEN);
				try {
					
					// FIX THIS PART //
					Vector<String> attendeesList = theClient.getAttending(eventNameDispla.getText());
					System.out.println("ATTENDEES" + attendeesList);
					
					// if no one is attending
					if(attendeesList.size() == 0){
						JLabel attending = new JLabel("No attendees");

						attending.setPreferredSize(new Dimension(100, 20));

						attending.setBackground(Color.GREEN);
						
						attending.setOpaque(true);
						attending.setForeground(Color.WHITE);
						attending.setFont(new Font("Lucia Grande",Font.BOLD,14));
						
						attendees.add(attending);
						//add new friend to the JPanel
					}
					for (int i=0;i<attendeesList.size();i++){
						
						JLabel attending = new JLabel(attendeesList.get(i));

						attending.setPreferredSize(new Dimension(100, 20));

						attending.setBackground(Color.GREEN);
						attending.setOpaque(true);
						attending.setForeground(Color.WHITE);
						attending.setFont(new Font("Lucia Grande",Font.BOLD,14));
						
						//add new friend to the JPanel
						attendees.add(attending);
					}
					//create scrollpane to house textarea
				
				JScrollPane attendeesScroll = new JScrollPane(attendees);

				attendeesScroll.getViewport().setBorder(null);
				attendeesScroll.setViewportBorder(null);
				attendeesScroll.setBorder(null);
				attendeesScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

				//place scrollable textarea in the popup menu
				
				JPopupMenu attendeesPopup = new JPopupMenu();
				attendeesPopup.add(attendeesScroll);
				attendeesPopup.setVisible(true);
				attendeesPopup.show(viewAttendees, 0, 20);

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		viewAttendees.setForeground(Color.BLUE);
		viewAttendees.setBounds(197, 56, 103, 16);
		ModifyEvent.add(viewAttendees);
		
		JLabel sendComment = new JLabel("");
		sendComment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					theClient.addComment(currentUser, eventNameDispla.getText(), newComment.getText());
					newComment.setText("");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		sendComment.setIcon(new ImageIcon("/Users/asturkmani/Documents/workspace/MyCal/src/send.png"));
		sendComment.setVisible(true);
		sendComment.setBounds(267, 326, 47, 45);
		ModifyEvent.add(sendComment);
		
		
		//================================================================================
		// Log In Panel Actions
		// 1 - Log in User
		// 2 - Load User details, friend list, event list
	    //================================================================================
		btnLogIn.addActionListener(new ActionListener() {
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
					attendingEvents = theClient.getAttendingUser(currentUser);
					notificationEvents = theClient.getInvitedUser(currentUser);
					
					// if user has notifications
					if(notificationEvents.size()>0){
						notifications.enable();
						notifications.setVisible(true);
					}
					
					
					System.out.println(attendingEvents);
					details = theClient.getDetails(currentUser);	// obtain user details
					
					
					newFriends = new JList<String>(friends);
					newFriends2 = new JList<String>(friends);
					newFriends2.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
					newFriends.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					
					profileFriendsScroll.setViewportView(newFriends);
					inviteFriendsScroll.setViewportView(newFriends2);

//					events = theClient.eventList(currentUser); 		// obtain event list
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
					int maxSize = Math.max(events.size(), attendingEvents.size());

				    for(int i = 0; i < maxSize; i++) {

				    	if (i<events.size()){
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
				    	// now add events you are attending
				    	if (i<attendingEvents.size()){
				    		System.out.println("Checking if user is attending any events");
					        String tempString2 = attendingEvents.get(i);// get each event.

//							String [] temp1 = tempString.split("&");// split each event into place & time based on "&"

							
							// specify button properties
							JButton button = new JButton(tempString2);
							System.out.println("Obtained events attending names: " + tempString2);
							button.setFont(new Font("Lucida Grande", Font.BOLD, 16));
							button.setForeground(Color.WHITE);
							button.setBackground(UIManager.getColor("Button.select"));
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
										eventdetailz=theClient.eventDetails(tempString2);
									} catch (Exception e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									eventLocationDispla.setText(eventdetailz.get(1));
									eventTimeDispla.setText(eventdetailz.get(0));
									eventNameDispla.setText(tempString2);
									
									calendarCombo.setVisible(false);
									eventLocationModify.setVisible(false); 
									modifyEvent.setVisible(false);
									deleteEvent.setVisible(false);
									
									
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
				        
				    }
				    buttonsPanel.repaint();
				    buttonsPanel.revalidate();
				    HomePanel.repaint();
					HomePanel.revalidate();

					
					
				    
					JScrollPane eventsScrollPane = new JScrollPane(buttonsPanel);
					eventsScrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
					eventsScrollPane.getViewport().setBorder(null);
					eventsScrollPane.setViewportBorder(null);
					eventsScrollPane.setBorder(null);
					eventsScrollPane.setBounds(28, 180, 266, 272);
					HomePanel.add(eventsScrollPane);

					
					//Transition to home panel
					LogInPanel.setVisible(false);
					profileName.setText(details.get(3) + " " + details.get(4));//include users first in last name on homepage
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
					System.out.println("About to send sign up request to server");
					if (!usernameS.getText().toLowerCase().equals("") && !usernameS.getText().toLowerCase().equals("username") && !passwordField.getText().toLowerCase().equals("") && !passwordField.getText().toLowerCase().equals("password") && !dobS.getText().toLowerCase().equals("") && !dobS.getText().toLowerCase().equals("date of birth") && !firstNameS.getText().toLowerCase().equals("first name") && !firstNameS.getText().toLowerCase().equals("") && !lastNameS.getText().toLowerCase().equals("") && !lastNameS.getText().toLowerCase().equals("last name") )
					
						response = theClient.signup(usernameS.getText(), passwordField.getText(), emailS.getText(), firstNameS.getText(), lastNameS.getText(), dobS.getText());
					
					System.out.println("Response from server: " + response);
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
