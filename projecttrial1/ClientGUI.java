package projecttrial1;


import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.CardLayout;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.time.Month;
import java.util.List;
import java.util.Vector;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTree;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JLayeredPane;

public class ClientGUI {

	private JFrame frame;
	private JTextField usernameFieldLogin;
	private JTextField passwordFieldLogin;
	private JTextField usernameFieldSignup;
	private JTextField firstnameFieldSignup;
	private JTextField lastnameFieldSignup;
	private JTextField emailFieldSignup;
	private JPasswordField passwordFieldSignup;
	private theClient clientz;
	String currentUser = null;
	private JTextField addfriendField;
	private JTextField wheretextField;
	Vector<String> friends = new Vector<String>();
	Vector<String> events = new Vector<String>();
	JList<String> list = new JList<String>();
	JList<String> listevents = new JList<String>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientGUI window = new ClientGUI();
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
	public ClientGUI() {
		clientz = new theClient();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 577, 443);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel homePanel = new JPanel();
		frame.getContentPane().add(homePanel, "name_215723342773900");
		homePanel.setLayout(null);
		
		addfriendField = new JTextField();
		addfriendField.setBounds(24, 19, 134, 28);
		homePanel.add(addfriendField);
		addfriendField.setColumns(10);
		
		JButton btnAddFriend = new JButton("Add Friend!");
		btnAddFriend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					theClient.addfriend(currentUser, addfriendField.getText()); //call the addfriend function
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAddFriend.setBounds(34, 59, 117, 29);
		homePanel.add(btnAddFriend);
		
		wheretextField = new JTextField();
		wheretextField.setBounds(24, 149, 99, 28);
		homePanel.add(wheretextField);
		wheretextField.setColumns(10);
		
		JLabel whereLabel = new JLabel("Where?");
		whereLabel.setBounds(24, 126, 61, 16);
		homePanel.add(whereLabel);
		
		JLabel whenLabel = new JLabel("When?");
		whenLabel.setBounds(173, 126, 61, 16);
		homePanel.add(whenLabel);
		
		JLabel lblNewLabel = new JLabel("Invite Friends");
		lblNewLabel.setBounds(456, 126, 85, 16);
		homePanel.add(lblNewLabel);
		
		
		
		
		JComboBox comboBoxHour = new JComboBox();
		comboBoxHour.setModel(new DefaultComboBoxModel(new String[] {"00","01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));;
		comboBoxHour.setBounds(135, 151, 99, 27);
		homePanel.add(comboBoxHour);
		
		JComboBox comboBoxMinute = new JComboBox();
		comboBoxMinute.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));;		
		comboBoxMinute.setBounds(246, 151, 85, 27);
		homePanel.add(comboBoxMinute);
		
		JComboBox comboBoxDayEvent = new JComboBox();
		comboBoxDayEvent.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBoxDayEvent.setBounds(135, 182, 72, 27);
		homePanel.add(comboBoxDayEvent);
		
		JComboBox comboBoxMonthEvent = new JComboBox();
		comboBoxMonthEvent.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboBoxMonthEvent.setBounds(214, 182, 72, 27);
		homePanel.add(comboBoxMonthEvent);
		
		JComboBox comboBoxYearEvent = new JComboBox();
		comboBoxYearEvent.setToolTipText("Year");
		comboBoxYearEvent.setModel(new DefaultComboBoxModel(new String[] {"1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015"}));
		comboBoxYearEvent.setBounds(289, 182, 85, 27);
		homePanel.add(comboBoxYearEvent );
		
		// Create an event. List of friends should be preloaded by login time, additionally
		// scrollable list of friends should be placed on homepage already.
		JButton btnCreateEvent = new JButton("Create Event!");
		btnCreateEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String time = new String();
				time = comboBoxHour.getSelectedItem().toString() + ":" + comboBoxMinute.getSelectedItem().toString();
				String date = new String();
				date = comboBoxYearEvent.getSelectedItem().toString() + "-" + comboBoxMonthEvent.getSelectedItem().toString() + "-" + comboBoxDayEvent.getSelectedItem().toString();
				
				String datetime = new String();
				datetime = date + " " + time;  //ma ele khele2 a3melon all in one if u wanna be efficient make datettime directly
				
				List<String> templist =list.getSelectedValuesList(); //get selected values only
			
				
				
				
				//put all values in a vector (we prefer using vector for ease of manipulation)
				Vector<String> selectedFriends = new Vector<String>(); //
				
				
				for (int i=0; i<templist.size();i++) 
				{
					selectedFriends.add(templist.get(i));
					
				}
				
				//calling the createEvent function in theClient
				try {
					theClient.createEvent(currentUser, selectedFriends, datetime, wheretextField.getText());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
					
				
				
				
			}
		});
		btnCreateEvent.setBounds(148, 243, 117, 29);
		homePanel.add(btnCreateEvent);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(455, 149, 86, 123);
		homePanel.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(456, 300, 86, 123);
		homePanel.add(scrollPane_1);
		
		JComboBox comboBoxHourM = new JComboBox();
		comboBoxHourM.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		comboBoxHourM.setBounds(135, 314, 99, 27);
		homePanel.add(comboBoxHourM);
		
		JComboBox comboBoxMinuteM = new JComboBox();
		comboBoxMinuteM.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		comboBoxMinuteM.setBounds(260, 314, 85, 27);
		homePanel.add(comboBoxMinuteM);
		
		JComboBox comboBoxDayEventM = new JComboBox();
		comboBoxDayEventM.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBoxDayEventM.setBounds(135, 353, 72, 27);
		homePanel.add(comboBoxDayEventM);
		
		JComboBox comboBoxMonthEventM = new JComboBox();
		comboBoxMonthEventM.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboBoxMonthEventM.setBounds(214, 353, 72, 27);
		homePanel.add(comboBoxMonthEventM);
		
		JComboBox comboBoxYearEventM = new JComboBox();
		comboBoxYearEventM.setModel(new DefaultComboBoxModel(new String[] {"1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015"}));
		comboBoxYearEventM.setToolTipText("Year");
		comboBoxYearEventM.setBounds(289, 353, 85, 27);
		homePanel.add(comboBoxYearEventM);
		
		JButton btnCreateEventM = new JButton("Resechdule Event!");
		btnCreateEventM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 
				//extract the new time from the dropdown menus
				String time = new String();
				time = comboBoxHourM.getSelectedItem().toString() + ":" + comboBoxMinuteM.getSelectedItem().toString();
				String date = new String();
				date = comboBoxYearEventM.getSelectedItem().toString() + "-" + comboBoxMonthEventM.getSelectedItem().toString() + "-" + comboBoxDayEventM.getSelectedItem().toString();
				
				String datetime = new String();
				datetime = date + " " + time;  //ma ele khele2 a3melon all in one if u wanna be efficient make datettime directly
			
				
				//get the description from the list
				String eventDescription = listevents.getSelectedValue();
				
				
				//extract the location from the eventDescription
				
				
				//divide original string into two parts
				String [] original = eventDescription.split(",");
				//divide the fist part (Place: [place]) into two 
				String [] part1 = original[0].split(": ");
				//create string for place
				String place = part1[1]; //second element will be the location
				
				Vector<String> emptyVector = new Vector<String>();
				
				
				try {
					theClient.createEvent(currentUser, emptyVector, datetime, place); //pass empty vector as friendlist
					theClient.deleteEvent(eventDescription);
					
				} catch (Exception e1) {
				e1.printStackTrace();
				}
				
				
			}
		});
		btnCreateEventM.setBounds(135, 386, 117, 29);
		homePanel.add(btnCreateEventM);
		
		JButton btnDeleteEvent = new JButton("Delete Event!");
		btnDeleteEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //  Delete an event
				
				
				String toDelete; //string to get select value
				/* Why are we not including all selected events to delete? */
				toDelete = listevents.getSelectedValue(); //this method selects only one value (first in list if mulitple selected)
				 
				//call the function to delete (only parameter we need is string of event details which we will parse later)
						
				try {
					theClient.deleteEvent(toDelete);
				} catch (Exception e1) {
					e1.printStackTrace();
				} 
				
				
			}
		});
		
		
		
		btnDeleteEvent.setBounds(260, 386, 117, 29);
		homePanel.add(btnDeleteEvent);
		
		JLabel lblEvents = new JLabel("Events");
		lblEvents.setBounds(465, 282, 61, 16);
		homePanel.add(lblEvents);
		


		homePanel.setVisible(false);
		
		
		JPanel signupPanel = new JPanel();
		frame.getContentPane().add(signupPanel, "name_215725519007162");
		signupPanel.setLayout(null);
		signupPanel.setVisible(false);
		
		JLabel lblUsername_1 = new JLabel("Username");
		lblUsername_1.setBounds(64, 33, 86, 16);
		signupPanel.add(lblUsername_1);
		
		JLabel lblPassword_1 = new JLabel("Password");
		lblPassword_1.setBounds(64, 61, 86, 16);
		signupPanel.add(lblPassword_1);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(64, 89, 86, 16);
		signupPanel.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(64, 117, 86, 16);
		signupPanel.add(lblLastName);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(64, 145, 86, 16);
		signupPanel.add(lblEmail);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setBounds(64, 173, 86, 16);
		signupPanel.add(lblDateOfBirth);
		
		usernameFieldSignup = new JTextField();
		usernameFieldSignup.setBounds(184, 27, 134, 28);
		signupPanel.add(usernameFieldSignup);
		usernameFieldSignup.setColumns(10);
		
		firstnameFieldSignup = new JTextField();
		firstnameFieldSignup.setBounds(184, 83, 134, 28);
		signupPanel.add(firstnameFieldSignup);
		firstnameFieldSignup.setColumns(10);
		
		lastnameFieldSignup = new JTextField();
		lastnameFieldSignup.setBounds(184, 111, 134, 28);
		signupPanel.add(lastnameFieldSignup);
		lastnameFieldSignup.setColumns(10);
		
		emailFieldSignup = new JTextField();
		emailFieldSignup.setBounds(184, 139, 134, 28);
		signupPanel.add(emailFieldSignup);
		emailFieldSignup.setColumns(10);
		
		passwordFieldSignup = new JPasswordField();
		passwordFieldSignup.setBounds(184, 55, 134, 28);
		signupPanel.add(passwordFieldSignup);
		
		JComboBox comboBoxDay = new JComboBox();
		comboBoxDay.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBoxDay.setBounds(184, 169, 72, 27);
		signupPanel.add(comboBoxDay);
		
		JComboBox comboBoxMonth = new JComboBox();
		comboBoxMonth.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboBoxMonth.setBounds(256, 169, 107, 27);
		signupPanel.add(comboBoxMonth);
		
		JComboBox comboBoxYear = new JComboBox();
		comboBoxYear.setModel(new DefaultComboBoxModel(new String[] {"1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015"}));
		comboBoxYear.setBounds(361, 169, 83, 27);
		signupPanel.add(comboBoxYear);
		
		JButton btnSignUp_1 = new JButton("Sign Up");
		btnSignUp_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // Sign up a new user
				
				String date = new String();
				date = comboBoxYear.getSelectedItem().toString() + "-" + comboBoxMonth.getSelectedItem().toString() + "-" + comboBoxDay.getSelectedItem().toString();
				
				String passText = new String(passwordFieldSignup.getPassword());

				
				try {
					theClient.signup(usernameFieldSignup.getText(),passText,emailFieldSignup.getText(),firstnameFieldSignup.getText(),lastnameFieldSignup.getText(),date);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSignUp_1.setBounds(201, 222, 117, 29);
		signupPanel.add(btnSignUp_1);
		
		
		
	
		
		JPanel loginPanel = new JPanel();
		frame.getContentPane().add(loginPanel, "name_215730474256425");
		loginPanel.setLayout(null);
		loginPanel.setVisible(true);
		usernameFieldLogin = new JTextField();
		usernameFieldLogin.setBounds(194, 140, 134, 28);
		loginPanel.add(usernameFieldLogin);
		usernameFieldLogin.setColumns(10);
		
		passwordFieldLogin = new JTextField();
		passwordFieldLogin.setBounds(194, 180, 134, 28);
		loginPanel.add(passwordFieldLogin);
		passwordFieldLogin.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(102, 146, 80, 16);
		loginPanel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(102, 186, 61, 16);
		loginPanel.add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // Login the user
				currentUser = usernameFieldLogin.getText();
				boolean temp=false;
				//clientz.login(usernameField., passwordField.getPassword());
				try {
					temp=theClient.login(usernameFieldLogin.getText(), passwordFieldLogin.getText());
				} catch (Exception e1) {
					System.out.println("error in login button");
					e1.printStackTrace();
				}
				
				
				if (temp){
					// create the list of friends			
					try {friends = theClient.friendList(currentUser);
						events = theClient.eventList(currentUser);
				
					// populate the list and wrap scrollPane around it
					 list = new JList<String>(friends);
					 listevents = new JList<String>(events);
					scrollPane.setViewportView(list);
					scrollPane_1.setViewportView(listevents);
					
					
					//transition to homepanel
					loginPanel.setVisible(false);
					homePanel.setVisible(true);
					
					
					} catch (Exception e1) {e1.printStackTrace();}

				}
	
			}

		});
		
		btnLogin.setBounds(194, 212, 117, 29);
		loginPanel.add(btnLogin);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signupPanel.setVisible(true);
				loginPanel.setVisible(false);
				
			
			}
		});
		btnSignUp.setBounds(194, 243, 117, 29);
		loginPanel.add(btnSignUp);
	}
}
