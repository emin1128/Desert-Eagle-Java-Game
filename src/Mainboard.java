import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Mainboard {
	
	static Enterance enterance;
	static ArrayList<User> users=new ArrayList<User>();

	
	
	

	public static void main(String[] args) {   
		
		
		
		int flag=1;							//start reading from the file
		
		
		
		FileInputStream fileStream=null;
		
		ObjectInputStream stream=null;
		
		
		try{
			fileStream = new FileInputStream("users.txt");
			try {
				stream = new ObjectInputStream(fileStream);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		catch(FileNotFoundException k){
			flag=0;
		}
		
		
		if(flag==1){
			while(true){
				
					
					User henry=new User();
					try {
						henry = (User)stream.readObject();
					} 
					catch(EOFException es){
							break;
						}
					catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
					

					users.add(henry);


				


			}
			

			try {
				stream.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {
				fileStream.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		
	
		}						//Finish reading from the file
		
		enterance=new Enterance();
		enterance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		enterance.setSize(1800, 900);
		enterance.setVisible(true);
		
		

	}

}
