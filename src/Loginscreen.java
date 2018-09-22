import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Loginscreen extends JFrame implements ActionListener {
	
	
	
	JTextField field1 =  new JTextField("Username");
	JTextField field2 = new JTextField("Password");
	JPanel panel;
	
	public Loginscreen (){
		super("Login");
		
		JButton button3 =new JButton("PLAY");
		button3.addActionListener(this);
		
		JButton button4=new JButton("CANCEL");
		button4.addActionListener(this);
		
		try {
			panel=new Welcome("eagleface.jpg");
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
		if(want=="PLAY"){
			
			
			
			
			String username=field1.getText();
			
			
			String password=field2.getText();
			
			int i=0;
			int flag=0;
			while(i<Mainboard.users.size()){
				if(Mainboard.users.get(i).username.equals(username) && Mainboard.users.get(i).password.equals(password)){
					try {
						
						Game a=new Game(Mainboard.users.get(i));
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					flag=1;
					break;
				}
				i++;
			}
			
			if(flag==0){
				JOptionPane.showMessageDialog(Loginscreen.this,"You are not registered.Please register yourself to play the game");
			}
			
			
			
			
			
			
				
		}
		
		else if(want=="CANCEL"){
			this.setVisible(false);
			Mainboard.enterance.setVisible(true);
			
		}
		
	}
	
}
