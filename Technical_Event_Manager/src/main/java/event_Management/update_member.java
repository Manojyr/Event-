package event_Management;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class update_member extends JFrame implements ActionListener {
	
	JTextField email,duration,name;
	JPasswordField pswd;
	JButton update,back;
	update_member(){
		setTitle("Update User Info");
		setLayout(null);
		setSize(800,480);
		setVisible(true);
		setLocation(350,200);
		
		name = new JTextField();
		name.setBounds(300,160,300,40);
		name.setText("Set New Name");
		name.setHorizontalAlignment(email.CENTER);
		add(name);
		
		email = new JTextField();
		email.setBounds(300,240,300,40);
		email.setText("Enter email id");
		email.setHorizontalAlignment(email.CENTER);
		add(email);
		
		duration = new JTextField();
		duration.setBounds(300,200,300,40);
		duration.setText("Set Membership Period");
		duration.setHorizontalAlignment(email.CENTER);
		add(duration);
		
		pswd = new JPasswordField();
		pswd.setBounds(300,280,300,40);
		pswd.setText("Set New Password");
		pswd.setHorizontalAlignment(email.CENTER);
		add(pswd);
		
		update = new JButton("Update");
		update.setBounds(360,330,100,40);
		update.addActionListener(this);
		add(update);
		
		back = new JButton("BACK");
		back.setBounds(20,40,100,40);
		back.addActionListener(this);
		add(back);
		
		getContentPane().setBackground(Color.WHITE);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		String Email = email.getText();
		String Duration = duration.getText();
		String Name = name.getText();
		String Pswd = pswd.getText();
		
		if(ae.getSource() == update) {
			if(email.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter the email id");
			}
			else if(duration.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter the duration");
			}
			else {
				Conn conn = new Conn();
				try {
					String query = "update membership set Duration = '"+Duration+"',name = '"+Name+"' where Email = '"+Email+"'";
					String query1 = "update usersignup set Name = '"+Name+"',Pswd = '"+Pswd+"' where Email = '"+Email+"'";
					
					conn.s.executeUpdate(query);
					conn.s.executeUpdate(query1);
					
					JOptionPane.showMessageDialog(null, "Membership Updated");
					setVisible(false);
					new maintain_user();	
				}
				catch(Exception e) {
					System.out.println(e);
				}
			}
		}
		else if(ae.getSource() == back) {
			setVisible(false);
			new maintain_user();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new update_member();
	}

}
