package event_Management;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class admin_page extends JFrame implements ActionListener {
	
	JButton home,logout,maintainU,maintainV;
	admin_page(){
		
		setTitle("admin page");
		setLayout(null);
		setSize(800,480);
		setVisible(true);
		setLocation(350,200);
        
		JLabel Jhead = new JLabel("Welcome Admin");
		Jhead.setFont(new Font("Osward",Font.BOLD,18));
		Jhead.setBackground(new Color(64, 219, 232));
		Jhead.setOpaque(true);
		Jhead.setHorizontalAlignment(Jhead.CENTER);
		add(Jhead);
		Jhead.setBounds(20,50,750,50);
		
//		home = new JButton("Home");
//		home.setBounds(20,10,100,30);
//		home.addActionListener(this);
//		add(home);
		
		logout = new JButton("Logout");
		logout.setBounds(600,10,100,30);
		logout.addActionListener(this);
		add(logout);
		
		maintainU = new JButton("Maintain User");
		maintainU.setBounds(500,280,200,40);
		maintainU.addActionListener(this);
		add(maintainU);
		
		maintainV = new JButton("Maintain Vendor");
		maintainV.setBounds(100,280,200,40);
		maintainV.addActionListener(this);
		add(maintainV);
		
		getContentPane().setBackground(Color.WHITE);
		}
		@Override
		public void actionPerformed(ActionEvent ae) {
			if(ae.getSource() == maintainU) {
				setVisible(false);
				new maintain_user();
			}
			else if(ae.getSource() == logout) {
				setVisible(false);
				new Admin_Login();
			}
			else if(ae.getSource() == maintainV) {
				setVisible(false);
				new maintain_vendor();
			}
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new admin_page();
	}

}
