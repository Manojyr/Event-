package event_Management;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Login extends JFrame implements ActionListener{
	
	JButton vendorJlabel,UserJlabel,AdminJlabel;
	
	Login(){
		setTitle("Event Management System");
		setLayout(null);
		setSize(800,480);
		setVisible(true);
		setLocation(350,200);
		
		getContentPane().setBackground(Color.WHITE);
		JLabel text = new JLabel("Login page");
		text.setFont(new Font("Osward",Font.BOLD,38));
		add(text);
		text.setBounds(280,40,400,50);
		
		vendorJlabel = new JButton("Vendor Login");
		vendorJlabel.addActionListener(this);
		add(vendorJlabel);
		vendorJlabel.setBounds(300,180,200,40);
		
		UserJlabel = new JButton("User Login");
		UserJlabel.addActionListener(this);
		add(UserJlabel);
		UserJlabel.setBounds(300,130,200,40);
		
		AdminJlabel = new JButton("Admin Login");
		AdminJlabel.addActionListener(this);
		add(AdminJlabel);
		AdminJlabel.setBounds(300,230,200,40);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource() == vendorJlabel) {
			new Vendor_Login();
			setVisible(false);
		}
		else if(ae.getSource() == UserJlabel) {
			new User_Login();
			setVisible(false);
		}
		
		else if(ae.getSource() == AdminJlabel){
			new Admin_Login();
			setVisible(false);
		}
		
	}
	public static void main(String args[]) {
		
		new Login();
	}

	
}
