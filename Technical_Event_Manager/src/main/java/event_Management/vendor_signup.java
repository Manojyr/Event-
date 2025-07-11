package event_Management;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class vendor_signup extends JFrame implements ActionListener{
	JButton signup,back;
	JTextField name,email;
	JPasswordField pswd;
	vendor_signup(){
		
		setTitle("signup");
		setLayout(null);
		setSize(800,480);
		setVisible(true);
		setLocation(350,200);
        
		JLabel Jhead = new JLabel("Event Management System");
		Jhead.setFont(new Font("Osward",Font.BOLD,18));
		Jhead.setBackground(new Color(64, 219, 232));
		Jhead.setOpaque(true);
		add(Jhead);
		Jhead.setBounds(20,50,750,50);
		
		JLabel Jemail = new JLabel("Email");
		Jemail.setFont(new Font("Osward",Font.BOLD,18));
		Jemail.setBackground(new Color(64, 219, 232));
		Jemail.setOpaque(true);
		add(Jemail);
		Jemail.setBounds(100,230,100,40);
		
		name = new JTextField();
		name.setBounds(500,130,200,40);
		add(name);
		
		email = new JTextField();
		email.setBounds(500,230,200,40);
		add(email);
		
		JLabel Jpswd = new JLabel("Password");
		Jpswd.setFont(new Font("Osward",Font.BOLD,18));
		Jpswd.setBackground(new Color(64, 219, 232));
		Jpswd.setOpaque(true);
		add(Jpswd);
		Jpswd.setBounds(100,180,100,40);
		
		JLabel Jname = new JLabel("Name");
		Jname.setFont(new Font("Osward",Font.BOLD,18));
		Jname.setBackground(new Color(64, 219, 232));
		Jname.setOpaque(true);
		add(Jname);
		Jname.setBounds(100,130,100,40);
		
		pswd = new JPasswordField();
		pswd.setBounds(500,180,200,40);
		add(pswd);
		
		back = new JButton("Back");
		back.setBounds(600,10,100,30);
		back.addActionListener(this);
		add(back);
		
		signup = new JButton("SIGN UP");
		signup.setBounds(300,350,100,40);
		signup.addActionListener(this);
		add(signup);
		
		getContentPane().setBackground(Color.WHITE);
		}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		String Name = name.getText();
		String Email = email.getText();
		String Pswd = pswd.getText();
		
		try {
			if(ae.getSource() == back) {
				new User_Login();
				setVisible(false);
			}
			else if(ae.getSource() == signup) {
				if(Name.equals("")) {
					JOptionPane.showMessageDialog(null,"Enter Name");
				}
				else if(Email.equals("")) {
					JOptionPane.showMessageDialog(null,"Enter Email");
				}
				else if(Pswd.equals("")) {
					JOptionPane.showMessageDialog(null,"Enter Password");
				}
				else {
					Conn c = new Conn();
					String query = "insert into vendorsignup values('"+Name+"','"+Email+"','"+Pswd+"')";
					c.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null,"Sign up successful");
					new Vendor_Login();
					setVisible(false);
				}
			}
		}
			catch(Exception e) {
				System.out.println(e);
			}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new vendor_signup();
	}

}
