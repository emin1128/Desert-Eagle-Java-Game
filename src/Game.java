
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.print.attribute.standard.Media;
import javax.sound.sampled.AudioInputStream;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;



public class Game  {
	

	static JFrame frame2;
	
	static JPanel panel;
	static JPanel panel2;
	static My_craft plane;
	static User player;
	static ArrayList<Bullet> bullets;
	static ArrayList<Enemybullet> enemy_bullets;
	static ArrayList<Enemy> enemies;
	
	static int enemy_counter;
	static int enemy_series;

	
	
	public Game(User player) throws IOException{
		
		Mainboard.enterance.clip.stop();
	
		this.player=player;
		player.score=0;
		
		JMenu fileMenu=new JMenu ("File");
		
		JMenuItem Quit=new JMenuItem("Quit");
		fileMenu.add(Quit);
		Quit.addActionListener(
				new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent event) {    //writing to the file
						
						
						write_to_file();
						
						System.exit(0); //After file_writing,exit because of "Quit"
						
					}
					
				}
				
				
				);
		
		
		
		enemy_counter=0;
		enemy_series=0;
		
		plane=new My_craft();
		frame2= new JFrame("Desert Eagle");
		bullets=new ArrayList<Bullet>();
		enemy_bullets=new ArrayList<Enemybullet>();
		enemies=new ArrayList<Enemy>();
		
		int i=0;
		while(i<1000){
			Bullet a=new Bullet();
			bullets.add(a);
			
			Enemybullet b=new Enemybullet();
			enemy_bullets.add(b);
			
			i++;
		}
		
		int m=0;
		while(m<999){
			Enemy a=new Enemy();
			enemies.add(a);
			m++;
		}
		
		panel=new Welcome("stream22.png");
	
		
		panel2=new Welcome("stream2222.png");
		

		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		plane.c1_label.setBounds(600, 0, 500, 750);
		plane.c1_label.setVisible(false);
		plane.c2_label.setBounds(600, 0, 500, 750);
		plane.c2_label.setVisible(false);
		plane.c3_label.setBounds(600, 0, 500, 750);
		plane.c3_label.setVisible(false);
		plane.go_label.setBounds(600, 0, 500, 750);
		plane.go_label.setVisible(false);
	
		plane.start_label.setBounds(600, 0, 500, 750);
		plane.label1.setBounds(plane.xActor, plane.yActor, 500, 750);
		
		
		frame2.setSize(1800,900);
		frame2.add(plane.start_label);
		frame2.add(plane.label1);
		frame2.add(plane.c1_label);
		frame2.add(plane.c2_label);
		frame2.add(plane.c3_label);
		frame2.add(plane.go_label);
		JMenuBar bar=new JMenuBar();
		frame2.setJMenuBar(bar);
		bar.add(fileMenu);
		
		
	
		int k=0;
		while(k<1000){
			frame2.add(bullets.get(k).label2);
			frame2.add(enemy_bullets.get(k).label2);
			
			if(k<999){
				frame2.add(enemies.get(k).label3);
			}
			k++;
		}
		frame2.add(plane.a.label4);
		frame2.add(panel2);
		
		frame2.add(panel);
		
		
		frame2.addKeyListener(plane);
		
		
		
		create_enemy(0,1,2);
		
		frame2.setVisible(true);
		
		
	}

	
	public static void create_enemy(int a,int b,int c){
		int enemyx_1=-50;
		
		int enemyx_2=800;
		
		int enemyx_3=1300;
		
		int q=0;
		while(q<3){
			if(q%3==0){
				Game.enemies.get(a).xActor=enemyx_1;
				Game.enemies.get(a).label3.setBounds(enemyx_1,-580, 500, 750);
				Game.enemies.get(a).move(-150, 350, enemyx_1, enemy_counter,0);
				Game.enemies.get(a).hit(enemy_counter);
				Game.enemies.get(a).isActivated=1;
				Game.enemies.get(a).isDead=0;
				Game.enemies.get(a).label3.setVisible(true);
				
			}
			else if(q%3==1){
				Game.enemies.get(b).xActor=enemyx_2;
				Game.enemies.get(b).label3.setBounds(enemyx_2,-580, 500, 750);
				Game.enemies.get(b).move(350, 850, enemyx_2, enemy_counter+1,2);
				Game.enemies.get(b).hit(enemy_counter+1);
				Game.enemies.get(b).isActivated=1;
				Game.enemies.get(b).isDead=0;
				Game.enemies.get(b).label3.setVisible(true);
			}
			else if(q%3==2){
				Game.enemies.get(c).xActor=enemyx_3;
				Game.enemies.get(c).label3.setBounds(enemyx_3,-580, 500, 750);
				Game.enemies.get(c).move(850, 1350, enemyx_3, enemy_counter+2,1);
				Game.enemies.get(c).hit(enemy_counter+2);
				Game.enemies.get(c).isActivated=1;
				Game.enemies.get(c).isDead=0;
				Game.enemies.get(c).label3.setVisible(true);
				
			}
			
			q++;
		}
	
	
	}
	
	public static void write_to_file(){
		
		
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
	}

}
