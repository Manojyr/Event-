package event_Management;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class user_page extends JFrame implements ActionListener{
	JButton JProduct,JItem,JView,JLogout,Jadd;
	JComboBox category;
	JTextField Jname;
	JTextArea Jprice;
	String Category,price,query,who;
	
	user_page(String uname){
		setTitle("User Page");
		setLayout(null);
		setSize(800,480);
		setVisible(true);
		setLocation(350,200);
		
		JPanel panel = new JPanel();
        panel.setLayout(null);
        
        //System.out.println(uname);
		JLabel text = new JLabel(""+uname);
		text.setFont(new Font("Osward",Font.BOLD,10));
		text.setBounds(25,5,300,40);
		add(text);
		 
		JProduct = new JButton("Product Status");
		JProduct.setBounds(210,5,130,40);
		JProduct.addActionListener(this);
		JProduct.setBackground(Color.WHITE);
		add(JProduct);
		
		JItem = new JButton("Request Item");
		JItem.setBounds(365,25,130,40);
		JItem.addActionListener(this);
		JItem.setBackground(Color.WHITE);
		add(JItem);
		
		JView = new JButton("clear");
		JView.setBounds(480,5,130,40);
		JView.addActionListener(this);
		JView.setBackground(Color.WHITE);
		add(JView);
		
		JLogout = new JButton("Logout");
		JLogout.setBounds(615,5,130,40);
		JLogout.addActionListener(this);
		JLogout.setBackground(Color.WHITE);
		add(JLogout);
		
		panel.add(text);
		panel.add(JProduct);
		panel.add(JView);
		panel.add(JLogout);
		panel.setBounds(20,20,750,50);
		panel.setBackground(new Color(64, 219, 232));
		
		add(panel);
		
		JPanel panel1 = new JPanel();
        panel1.setLayout(null);
		
		String value[] = {"Catering","Florist","Decoration","Lighting"};
		category = new JComboBox(value);
		category.setBounds(10,20,300,50);
		//category.setHorizontalAlignment(category.CENTER);
		category.setBackground(Color.white);
		category.addActionListener(this);
		add(category);
		
		Jprice = new JTextArea();
		Jprice.setFont(new Font("Osward",Font.BOLD,18));
		Jprice.setBackground(Color.white);
		Jprice.setText("");
		add(Jprice);
		Jprice.setBounds(10,80,300,50);
		
		Jadd = new JButton("Add Item");
		Jadd.setBounds(100,250,100,40);
		Jadd.addActionListener(this);
		Jadd.setBackground(Color.WHITE);
		add(Jadd);
		
		panel1.add(category);
		panel1.add(Jprice);
		panel1.add(Jadd);
		panel1.setBounds(20,100,320,320);
		panel1.setBackground(new Color(64, 219, 232));
		
		add(panel1);
		
		getContentPane().setBackground(Color.WHITE);
		who = uname;
//		System.out.println(who);
		}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		Category =(String)this.category.getSelectedItem();
		if(ae.getSource() == JView) {
			Jprice.setText("");
		}
		else if(ae.getSource() == Jadd) {
			setVisible(false);
			new pay(who,Category);
		}
		else if(ae.getSource() == JLogout) {
			setVisible(false);
			new User_Login();
		}
		else {
		Conn conn = new Conn();
		try {
			
			String query = "select Price from inventory1 where Service = '"+Category+"'";
			ResultSet rs = conn.s.executeQuery(query);
			while (rs.next()) {		
			price = rs.getString("Price");
			}
			Jprice.append("Amount = " + price);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new user_page("");
	}

}
