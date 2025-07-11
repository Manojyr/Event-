package event_Management;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class add_vendor extends JFrame implements ActionListener {
	JTextField email,category,name;
	JButton add,back;
	add_vendor(){
		setTitle("Add Vendor");
		setLayout(null);
		setSize(800,480);
		setVisible(true);
		setLocation(350,200);
		
		name = new JTextField();
		name.setBounds(500,160,300,40);
		name.setText("Enter Name");
		name.setHorizontalAlignment(email.CENTER);
		add(name);
		
		email = new JTextField();
		email.setBounds(500,240,300,40);
		email.setText("Enter email id");
		email.setHorizontalAlignment(email.CENTER);
		add(email);
		
		category = new JTextField();
		category.setBounds(500,200,300,40);
		category.setText("Enter Vendor Category");
		category.setHorizontalAlignment(email.CENTER);
		add(category);
		
		add = new JButton("ADD");
		add.setBounds(600,400,100,40);
		add.addActionListener(this);
		add(add);
		
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
		
		String Pswd = new random_string().generateRandomString();
		
		if(ae.getSource() == add) {
			if(email.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter the email id");
			}
			else if(Category.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter the Category");
			}
			else {
				Conn conn = new Conn();
				try {
					String query = "insert into membership1 values('"+Name+"','"+Email+"','"+Category+"')";
					String query1 = "insert into vendorsignup values('"+Name+"','"+Email+"','"+Pswd+"')";
					
					conn.s.execute(query);
					conn.s.execute(query1);
					
					JOptionPane.showMessageDialog(null, "Vendor added");
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
		new add_vendor();
	}

}
