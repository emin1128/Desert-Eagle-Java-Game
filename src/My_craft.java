import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sql.XAConnection;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class My_craft implements KeyListener {
	
	
	
	private Icon my_plane;
	private Icon icon_start;
	private Icon s_1;
	private Icon s_2;
	private Icon s_3;
	private Icon go;
	public Icon sm_1;
	public Icon sm_2;
	public Icon sm_3;
	public Icon sm_4;
	public static JTextArea txt;

	public  JLabel label1;
	public JLabel start_label;
	public JLabel c1_label;
	public JLabel c2_label;
	public JLabel c3_label;
	public JLabel go_label;
	public JLabel stream1;
	public JLabel stream2;
	public JLabel stream3;
	public JLabel stream4;
	public JLabel scorist;
	public static int xActor;
	public static int yActor;
	public static int bullet_counter;
	public static int q;
	public static int location;
	public static int isDead;
	public static int enter;
	public static int start;
	public static int live;
	
	public  Bullet a=new Bullet();
	
	
	
	public My_craft(){
		
	
		
		my_plane=new ImageIcon(getClass().getResource("f-15.png"));
		
		label1=new JLabel(my_plane);
		
		icon_start=new ImageIcon(getClass().getResource("start.png"));
		
		start_label=new JLabel(icon_start);
		
		s_1=new ImageIcon(getClass().getResource("1.png"));
		
		c1_label=new JLabel(s_1);
		
		s_2=new ImageIcon(getClass().getResource("2.png"));
		
		c2_label=new JLabel(s_2);
		
		s_3=new ImageIcon(getClass().getResource("3.png"));
		
		c3_label=new JLabel(s_3);
		
		go=new ImageIcon(getClass().getResource("GO.png"));
		
		go_label=new JLabel(go);
		
		
	
		
		xActor=600;
		yActor=280;
		bullet_counter=999;
		q=-1;
		location=0;
		isDead=0;
		enter=0;
		start=0;
		live=3;
		death();
		
		
	}

	 public void moveBox(int newX,int newY)
	  {
		 
		  label1.setBounds(newX, newY, 500, 750); 
	  }
	 
	 public void moveBullet(int newX,int newY)
	  {
		 try {
			Thread.sleep(1000);
			 a.label2.setBounds(newX, newY, 500, 750); 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	  }
	@Override
	public void keyPressed(KeyEvent event) {
		// TODO Auto-generated method stub
		String whichKey=KeyEvent.getKeyText(event.getKeyCode());
		
		
		if(whichKey.compareTo("Left")==0 && xActor>-150)
		{
			if(enter!=0){
				changeLayoutLeft();
			}
		}else if(whichKey.compareTo("Right")==0 && xActor<1350){
			
			if(enter!=0){
				changeLayoutRight();
			}
		}else if(whichKey.compareTo("Up")==0 && yActor>-300){
			
			changeLayoutUp();
			
			
			

			
		}else if(whichKey.compareTo("Down")==0 && yActor<280){
			
			changeLayoutDown();	
			
			

			
			
		}else if(whichKey.compareTo("Space")==0 && Game.plane.isDead==0){
			
		//	System.out.println(enter);
			int bullet_way=yActor-135;
			
			int size=Game.enemies.size();
        	//int q=-1;// shows the enemy will be hit in enemy list
        	int r=-1;//The indicator to distinguish the enemy 
        	
        	if(xActor<350){
        		r=0;
        	}
         
        	else if(xActor<850){
        		r=1;
        	}
        	else if(xActor<1350){
        		r=2;
        	}
        	for(int i=Game.enemy_series;i<size;i++){
        		if(i%3==r && Game.enemies.get(i).isActivated==1){
        			q=i;
        			break;
        			
        		}
        	}
			
			 
			new Thread()
	        {
	            public void run() {
	            
	            	int x_through=xActor;
	            	int through=bullet_way;

	            	 while(through>-300 && enter==1){
		                	try {
		                		
		                	URL url = this.getClass().getClassLoader().getResource("goes.wav");
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
		       		         Clip clip = null;
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
		       		 //        clip.start();
		                		
		                		
		                		
		             //   		a.label4.setVisible(false);
								Thread.sleep(16);
								through=through-20;
								Game.bullets.get(bullet_counter).label2.setBounds(x_through, through, 500, 750);
								
								if((through<Game.enemies.get(q).yActor+50) && Game.enemies.get(q).isDead==0 ){
									
									if(((Game.enemies.get(q).location-x_through<50)&&(Game.enemies.get(q).location-x_through>-50))){
										
										Game.player.score=Game.player.score+100;
										
										txt.setText("Score: "+String.valueOf(Game.player.score));
										
										a.label4.setBounds(Game.enemies.get(q).location, through, 500, 750);
										
										a.label4.setVisible(true);
										Game.enemies.get(q).label3.setVisible(false);
										
										Game.enemies.get(q).isDead=1;
										Game.enemies.get(q).isActivated=0;
										
										Game.bullets.get(bullet_counter).label2.setVisible(false);
										Thread.sleep(300);
				                		a.label4.setVisible(false);
										Game.enemy_counter++;
									
										if(Game.enemy_counter>0 && Game.enemy_counter%3==0){
					                		
											int a=Game.enemy_counter;//for next enemy generation
					                		Thread.sleep(100);
					                		Game.create_enemy(a,a+1,a+2);
					                		Game.bullets.get(bullet_counter).label2.setVisible(false);
					                		Game.enemy_series=Game.enemy_series+3;
					                	}
										Game.bullets.remove(bullet_counter);
										bullet_counter--;
										break;
										
									}
									else{
										
										if(through<=-300){
											
											Game.bullets.get(bullet_counter).label2.setVisible(false);
											Game.bullets.remove(bullet_counter);
											bullet_counter--;
										}
									}
									
								
								}
								
								else{
									
									if(through<=-300){
										
										Game.bullets.get(bullet_counter).label2.setVisible(false);
										Game.bullets.remove(bullet_counter);
										bullet_counter--;
									}
								}
								
								
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
		                	
		                			                }
		            }
	            	
	            
	        }.start();
			
			
			
			
			
		}
		
		else if(whichKey.compareTo("Enter")==0 && enter==0){
			
			end_start();
			new Thread()
			{
				
			    public void run() {
			        try {
			        	
			        	
			        	Thread.sleep(200);
			        	Game.plane.c3_label.setVisible(true);
						
						
						
						Thread.sleep(1000);
						Game.plane.c3_label.setVisible(false);
						Game.plane.c2_label.setVisible(true);
						
						Thread.sleep(1000);
						Game.plane.c2_label.setVisible(false);
						Game.plane.c1_label.setVisible(true);
						
						Thread.sleep(1000);
						Game.plane.c1_label.setVisible(false);
						Game.plane.go_label.setVisible(true);
						
						Thread.sleep(1000);
						Game.plane.go_label.setVisible(false);
						enter=1;
						
						Game.plane.c3_label.setBounds(-100, -295, 500, 750);
						Game.plane.c3_label.setVisible(true);
						
						
						changeLayoutLeft();
						changeLayoutRight();
						
						txt=new JTextArea();
						Font font=new Font("Monospaced",Font.ITALIC,24);
						txt.setFont(font);
						txt.setForeground(Color.RED);
						txt.setBackground(Color.BLACK);
						txt.setText("Score: "+String.valueOf(Game.player.score));
						txt.setEditable(false);
						Game.panel.add(txt);
						
						
						
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }
			}.start();
			
			
			
		}
			
		
		
		
		
	}
	

	public void changeLayoutLeft()
	{	
		
		start=1;
		xActor=xActor-15;
		location=xActor;
		moveBox(xActor,yActor);
		
	}
	public void changeLayoutRight()
	{
		
		start=1;
		xActor=xActor+15;
		location=xActor;
		moveBox(xActor,yActor);
	}
	public void changeLayoutUp()
	{
		if(start==1){
			yActor=yActor-15;
			moveBox(xActor,yActor);
		}
	}
	public void changeLayoutDown()
	{
		if(start==1){
			yActor=yActor+15;
			moveBox(xActor,yActor);
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public static void end_start(){
		Game.plane.start_label.setVisible(false);
	}
	
	public static void death(){
		new Thread()
		{
			
		    public void run() {	 
		    	 URL url = this.getClass().getClassLoader().getResource("abc.wav");
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
		         Clip clip = null;
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
		       int flag=1;
		       while(flag==1){
		    	   System.out.println(" ");//bu olmayýnca ,düþman vurduðunda patlama olmuyor,nedeni meçhul
		    	 
		    	   if(Game.plane.isDead==1 && live==0){
		    		   
		    		   try {
		    			
						Thread.sleep(30);
						Game.plane.a.label4.setVisible(true);
						Game.plane.a.label4.setBounds(Game.plane.xActor,Game.plane.yActor,500,750);
						Thread.sleep(600);
						Game.plane.a.label4.setVisible(false);
						flag=0; //alttatki iki satýr biz vurulunca oyunu kapatýyor
						Thread.sleep(200);
						Game.frame2.setVisible(false);
						clip.stop();
						int k=Game.bullets.size()-1;
						while(k>=0){
							
							Game.bullets.remove(k);
							k--;
						}
						System.out.println(Game.bullets.size());
						Mainboard.enterance.setVisible(true);
						Mainboard.enterance.clip.start();
						if(Game.player.score>Game.player.best_score){
							Game.player.best_score=Game.player.score;
							Game.player.score=0;
						}
						
						Game.write_to_file();
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    	   }
		    	   
		       }
		    }
		}.start();
	}
	
	

}
