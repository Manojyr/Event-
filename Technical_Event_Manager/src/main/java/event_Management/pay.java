package event_Management;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class pay extends JFrame implements ActionListener {
	
	JRadioButton payment1,payment2,payment3,payment4;
	JButton signup;
	String Userid,category;
	pay(String who,String Category){
	setTitle("Pay");
	setLayout(null);
	setSize(800,480);
	setVisible(true);
	setLocation(350,200); 
	
	JLabel Jhead = new JLabel("Payment Portal");
	Jhead.setFont(new Font("Osward",Font.BOLD,18));
	Jhead.setBackground(new Color(64, 219, 232));
	Jhead.setOpaque(true);
	add(Jhead);
	Jhead.setBounds(20,50,750,50);
	
	JLabel Jpay = new JLabel("Payment Mode");
	Jpay.setFont(new Font("Osward",Font.BOLD,18));
	Jpay.setBackground(new Color(64, 219, 232));
	Jpay.setOpaque(true);
	add(Jpay);
	Jpay.setBounds(250,150,150,50);
	
	payment1 = new JRadioButton("Pay via card");
	payment1.setBounds(250,210,150,30);
	payment1.addActionListener(this);
	add(payment1);
	
	payment2 = new JRadioButton("Pay via UPI");
	payment2.setBounds(250,250,150,30);
	payment2.addActionListener(this);
	add(payment2);
	
	payment3 = new JRadioButton("Pay via Loan");
	payment3.setBounds(250,290,150,30);
	payment3.addActionListener(this);
	add(payment3);
	
	payment4 = new JRadioButton("Pay via Bitcoin");
	payment4.setBounds(250,330,150,30);
	payment4.addActionListener(this);
	add(payment4);
	
	ButtonGroup group = new ButtonGroup();
	group.add(payment1);
	group.add(payment2);
	group.add(payment3);
	group.add(payment4);
	
	signup = new JButton("Pay");
	signup.setBounds(500,200,100,40);
	signup.addActionListener(this);
	add(signup);
	
	getContentPane().setBackground(Color.WHITE);
	Userid = who;
	category = Category;
	System.out.println(who);
	System.out.println(Category);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource() == signup) {
			Conn conn = new Conn();
			try {
			System.out.println(Userid);
			String query  = "insert into inventory3 values('"+Userid+"','"+category+"')";
			conn.s.executeUpdate(query);
			setVisible(false);
			new user_signup();
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new pay("","");
	}

}
