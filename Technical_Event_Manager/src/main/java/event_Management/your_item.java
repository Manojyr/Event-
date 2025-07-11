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

public class your_item extends JFrame implements ActionListener{
	
	JTextField texts;
	JButton submit,clear;
	your_item(){
		setTitle("Main_Login");
		setLayout(null);
		setSize(800,480);
		setVisible(true);
		setLocation(350,200);
		
		
		JLabel text = new JLabel("Main Page");
		text.setFont(new Font("Osward",Font.BOLD,38));
		add(text);
		text.setBounds(280,40,400,50);
		
		JLabel item = new JLabel("Enter Item");
		item.setFont(new Font("Osward",Font.BOLD,18));
		add(item);
		item.setBounds(280,130,400,50);
		
		texts = new JTextField();
		texts.setFont(new Font("Osward",Font.BOLD,38));
		add(texts);
		texts.setBounds(500,130,200,50);
		
		clear = new JButton("Clear");
		clear.setBounds(420,300,100,40);
		clear.addActionListener(this);
		add(clear);
		
		submit = new JButton("Submit");
		submit.setBounds(300,300,100,40);
		submit.addActionListener(this);
		add(submit);
		
		getContentPane().setBackground(Color.WHITE);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		String item = texts.getText();
		
		try {
			if(item.equals("")) {
				JOptionPane.showMessageDialog(null,"item is required");
			}
			else if(ae.getSource() == clear) {
				texts.setText("");
			}
			else if(ae.getSource() == submit) {
				setVisible(false);
				new add_newitem();
			}
			else {
				Conn c = new Conn();
				String query = "insert into inventory values('"+ item +"')";
				c.s.executeUpdate(query);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new your_item();
	}

}
