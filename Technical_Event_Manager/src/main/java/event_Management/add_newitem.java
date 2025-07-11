package event_Management;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class add_newitem extends JFrame implements ActionListener {
	
	JButton JProduct,JItem,JView,JLogout,Jadd;
	JTextField Jname,Jprice;
	add_newitem(){
		setTitle("Add NEW ITEM");
		setLayout(null);
		setSize(800,480);
		setVisible(true);
		setLocation(350,200);
		
		JPanel panel = new JPanel();
        panel.setLayout(null);
        
		JLabel text = new JLabel("Welcome");
		text.setFont(new Font("Osward",Font.BOLD,20));
		text.setBounds(25,5,100,40);
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
		
		JView = new JButton("View Product");
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
        
        Jname = new JTextField();
        Jname.setFont(new Font("Osward",Font.BOLD,18));
        Jname.setText("Product Name");
        Jname.setBackground(Color.gray);
		add(Jname);
		Jname.setBounds(10,20,300,50);
		Jname.setHorizontalAlignment(Jname.CENTER);
		
		Jprice = new JTextField();
		Jprice.setFont(new Font("Osward",Font.BOLD,18));
		Jprice.setText("Product Price");
		Jprice.setBackground(Color.gray);
		add(Jprice);
		Jprice.setBounds(10,80,300,50);
		Jprice.setHorizontalAlignment(Jprice.CENTER);
		
		Jadd = new JButton("Add Item");
		Jadd.setBounds(100,250,100,40);
		Jadd.addActionListener(this);
		Jadd.setBackground(Color.WHITE);
		add(Jadd);
		
		panel1.add(Jname);
		panel1.add(Jprice);
		panel1.add(Jadd);
		panel1.setBounds(20,100,320,320);
		panel1.setBackground(new Color(64, 219, 232));
		
		add(panel1);
		
		getContentPane().setBackground(Color.WHITE);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		
		if(ae.getSource() == Jadd) {
			setVisible(false);
			new your_item();
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new add_newitem();
	}

}
