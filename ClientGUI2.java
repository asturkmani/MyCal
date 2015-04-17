import java.awt.EventQueue;

import javax.imageio.ImageIO;
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
import java.awt.image.BufferedImage;
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
import java.io.IOException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;

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
	
	//list of friends and table of events
	private JList<String> listOfFriends = new JList<String>();
	private JTable listOfEvents;
	private JScrollPane eventsScroll = new JScrollPane();
	private JScrollPane friendsScroll = new JScrollPane();
	
	private JPanel HomePanel = new JPanel();
	private JLabel signInError = new JLabel("Incorrect username/password");
	private JPasswordField passwordLogIn;
	private BufferedImage image;
	private Boolean toset = true;
	private JTextField dobS;
	private JPasswordField passwordField;


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
		
		usernameS = new JTextField();
		usernameS.setText("Username");
		usernameS.setForeground(new Color(211, 211, 211));
		usernameS.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		usernameS.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				usernameS.setText("");
				usernameS.setForeground(Color.DARK_GRAY);
			}
		});
		usernameS.setBounds(36, 53, 256, 47);
		SignUpPanel.add(usernameS);
		usernameS.setColumns(10);
		
		firstNameS = new JTextField();
		firstNameS.setText("First Name");
		firstNameS.setForeground(new Color(211, 211, 211));
		firstNameS.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		firstNameS.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				firstNameS.setText("");
				firstNameS.setForeground(Color.DARK_GRAY);
			}
		});
		firstNameS.setColumns(10);
		firstNameS.setBounds(36, 156, 256, 47);
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
			}
		});
		lastNameS.setColumns(10);
		lastNameS.setBounds(36, 206, 256, 47);
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
			}
		});
		emailS.setColumns(10);
		emailS.setBounds(36, 259, 256, 47);
		SignUpPanel.add(emailS);
		
		JButton btnSignUp = new JButton("Sign Up!");
		btnSignUp.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		btnSignUp.setForeground(Color.WHITE);
		btnSignUp.setBackground(new Color(71,181,250));
		btnSignUp.setContentAreaFilled(false);
		btnSignUp.setOpaque(true);
		btnSignUp.setBorderPainted(false);
		
		dobS = new JTextField();
		dobS.setText("Date of birth");
		dobS.setForeground(new Color(211, 211, 211));
		dobS.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		dobS.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dobS.setText("");
				dobS.setForeground(Color.DARK_GRAY);
			}
		});
		
		dobS.setColumns(10);
		dobS.setBounds(36, 305, 256, 47);
		SignUpPanel.add(dobS);
		
		passwordField = new JPasswordField();
		
		passwordField.setText("Password");
		passwordField.setForeground(new Color(211, 211, 211));
		passwordField.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		passwordField.setEchoChar(' ');
		passwordField.setBounds(36, 107, 256, 47);
		
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
		
		Border newborder2 = BorderFactory.createCompoundBorder();
		btnSignUp.setBorder(newborder2);
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // action taken when Sign Up Button is pressed.
				try {
					theClient.signup(usernameS.getText(), passwordField.getText(), emailS.getText(), firstNameS.getText(), lastNameS.getText(), dobS.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
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
				SignUpPanel.setVisible(false);
				HomePanel.setVisible(true);
				
				
				} catch (Exception e1) {e1.printStackTrace();}

			}
			
		});
		btnSignUp.setBounds(6, 364, 308, 48);
		SignUpPanel.add(btnSignUp);
		
		JLabel label = new JLabel("MyCal");
		label.setFont(new Font("Kailasa", Font.BOLD, 22));
		label.setBounds(137, 6, 72, 47);
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
		

		

		
		// ---------------- LOG IN PANEL --------------------- //
		
		JLabel lblNewLabel = new JLabel("MyCal");
		lblNewLabel.setFont(new Font("Kailasa", Font.BOLD, 22));
		lblNewLabel.setBounds(125, 6, 72, 47);
		LogInPanel.add(lblNewLabel);
		
		username = new JTextField();
		username.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				if(toset){
				username.setText("");
				username.setForeground(Color.DARK_GRAY);
				signInError.setVisible(false);
				toset=false;}
				
//			}
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
			
			
			if(!temp){
				signInError.setVisible(true);
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
				
			
			
			}
		});
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
		passwordLogIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					passwordLogIn.setText("");
					passwordLogIn.setForeground(Color.DARK_GRAY);
					signInError.setVisible(false);
					passwordLogIn.setEchoChar('*');
			
			}
		});
		
		passwordLogIn.setText("Password");
		passwordLogIn.setForeground(new Color(211, 211, 211));
		passwordLogIn.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		passwordLogIn.setEchoChar((char) 0);

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
