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

public class update_vendor extends JFrame implements ActionListener {
	
	JTextField email,category,name;
	JPasswordField pswd;
	JButton update,back;
	
	update_vendor(){
		setTitle("Update Vendor Info");
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
		
		category = new JTextField();
		category.setBounds(300,200,300,40);
		category.setText("Set Category");
		category.setHorizontalAlignment(email.CENTER);
		add(category);
		
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
		String Category = category.getText();
		String Name = name.getText();
		String Pswd = pswd.getText();
		
		if(ae.getSource() == update) {
			if(email.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter the email id");
			}
			else if(category.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter the Category");
			}
			else {
				Conn conn = new Conn();
				try {
					String query = "update membership1 set Category = '"+Category+"',name = '"+Name+"' where Email = '"+Email+"'";
					String query1 = "update vendorsignup set Name = '"+Name+"',Pswd = '"+Pswd+"' where Email = '"+Email+"'";
					
					conn.s.executeUpdate(query);
					conn.s.executeUpdate(query1);
					
					JOptionPane.showMessageDialog(null, "Vendor Updated");
					setVisible(false);
					new maintain_vendor();	
				}
				catch(Exception e) {
					System.out.println(e);
				}
			}
		}
		else if(ae.getSource() == back) {
			setVisible(false);
			new maintain_vendor();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new update_vendor();
	}

}
