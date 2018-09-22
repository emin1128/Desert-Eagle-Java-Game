
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static java.util.Comparator.comparing;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Enterance extends JFrame {
	
	JPanel panel;
	
	 Clip clip;
	
	public Enterance(){
		super("Desert Eagle");
		
		JMenu fileMenu=new JMenu ("File");
		try {
			panel=new Welcome("hughes3.JPG");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.add(panel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuItem register=new JMenuItem("Register");
		fileMenu.add(register);
		register.addActionListener(
				new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent event) {
						Form a=new Form();
						a.setVisible(true);
					}
					
				}
				
				
				);
		
		JMenuItem PlayGame=new JMenuItem("PlayGame");
		fileMenu.add(PlayGame);
		PlayGame.addActionListener(
				new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent event) {
						Loginscreen a=new Loginscreen();
						a.setVisible(true);
						Mainboard.enterance.setVisible(false);
					}
					
				}
				
				
				);
		JMenuItem ScoreBoard=new JMenuItem("ScoreBoard");
		fileMenu.add(ScoreBoard);
		ScoreBoard.addActionListener(
				new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent event) {
						
						Collections.sort(Mainboard.users, new ScoreComparator());
						
						JOptionPane.showMessageDialog(Enterance.this,Mainboard.users.get(0).username+" "+Mainboard.users.get(0).best_score
														
											+"\n "+Mainboard.users.get(1).username+" "+Mainboard.users.get(1).best_score
											+"\n "+Mainboard.users.get(2).username+" "+Mainboard.users.get(2).best_score
																				
								
								);
						
					}
					
				}
				
				
				);
		
		JMenuItem Quit=new JMenuItem("Quit");
		fileMenu.add(Quit);
		Quit.addActionListener(
				new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent event) {    //writing to the file
						
						
						int size=Mainboard.users.size();
						File myFile = new File("users.txt");
						int i=0;
						
						FileOutputStream fileStream=null;
						try {
							fileStream = new FileOutputStream(
									myFile);
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						ObjectOutputStream stream=null;
						try {
							stream = new ObjectOutputStream(
									fileStream);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						while(i<size){
							try {
								
								
								stream.writeObject(Mainboard.users.get(i));
								
								
							} catch (Exception eed) {
								System.err.println("Error!");
							}

							i++;
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
						
						System.exit(0); //After file_writing,exit because of "Quit"
						
					}
					
				}
				
				
				);
		
		JMenuBar bar=new JMenuBar();
		setJMenuBar(bar);
		bar.add(fileMenu);
		
		JMenu helpMenu=new JMenu("Help");
		JMenuItem credits=new JMenuItem("Credits");
		helpMenu.add(credits);
		credits.addActionListener(
				new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent event) {
						JOptionPane.showMessageDialog(Enterance.this,"Emin Aydýn 20140702020");
						
					}
					
				}
				
				
				);
		bar.add(helpMenu);
		
		new Thread()
	    {
	        public void run() {
	        	
	        	
	        	
	    	  
	        }
	    }.start();	
		
	    URL url = this.getClass().getClassLoader().getResource("cda.wav");
        AudioInputStream audioIn = null;
		try {
			audioIn = AudioSystem.getAudioInputStream(url);
		} catch (UnsupportedAudioFileException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        // Get a sound clip resource.
        clip = null;
		try {
			clip = AudioSystem.getClip();
		} catch (LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        // Open audio clip and load samples from the audio input stream.
        try {
			clip.open(audioIn);
		} catch (LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

        clip.loop(100);
		
	}
		
	
	
	
	
}