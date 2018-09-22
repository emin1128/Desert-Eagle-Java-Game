


import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public class Form extends JFrame implements ActionListener {
	
	
	
	JTextField field1 =  new JTextField("Username");
	JTextField field2 = new JTextField("Password");
	JPanel panel;
	
	
	public Form (){
		super("Form");
		
		JButton button3 =new JButton("SAVE");
		button3.addActionListener(this);
		
		JButton button4=new JButton("CANCEL");
		button4.addActionListener(this);
		
		try {
			panel=new Welcome("eagle.jpg");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		
		setSize(800,800);

		
		panel.add(field1);
		panel.add(field2);
		panel.add(button3);
		panel.add(button4);
		add(panel);
		
		
		
		
		
	
		
	}

	@Override
	public void actionPerformed(ActionEvent t) {
		
		String want=t.getActionCommand();
		if(want=="SAVE"){
			
			
			
			
			String username=field1.getText();
			
			
			String password=field2.getText();
			
			
			
			
			
			
			User adam=new User();
			adam.username=username;
			adam.password=password;
			Mainboard.users.add(adam);
				
		}
		
		else if(want=="CANCEL"){
			this.setVisible(false);
			
			
		}
		
	}
	
}
