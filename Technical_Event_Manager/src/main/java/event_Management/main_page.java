package event_Management;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class main_page extends JFrame implements ActionListener{
	
	JButton youritem,newitem,transection;
	main_page(){
		
			setTitle("Main_Page");
			setLayout(null);
			setSize(800,480);
			setVisible(true);
			setLocation(350,200);
			
			
			JLabel text = new JLabel("Main Page");
			text.setFont(new Font("Osward",Font.BOLD,38));
			add(text);
			text.setBounds(280,40,400,50);
			
			youritem = new JButton("youritem");
			youritem.setBounds(420,300,100,40);
			youritem.addActionListener(this);
			add(youritem);
			
			newitem= new JButton("Add newitem");
			newitem.setBounds(300,300,100,40);
			newitem.addActionListener(this);
			add(newitem);
			
			transection= new JButton("transection");
			transection.setBounds(300,300,100,40);
			transection.addActionListener(this);
			add(transection);
			
			getContentPane().setBackground(Color.WHITE);
		
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		
		try {
			if(ae.getSource() == youritem) {
				new your_item();
			}
			else if(ae.getSource() == newitem) {
				new add_newitem();
			}
			else if(ae.getSource() == transection) {
				new transection();
			}	
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new main_page();
	}

}
