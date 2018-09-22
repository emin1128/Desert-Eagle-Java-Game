import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Enemy {

	private Icon enemy_plane;
	public  JLabel label3;
	public int xActor;
	public int yActor;
	public int location;
	public static int bullet_counter=999;
	
	public int isDead;
	public int isActivated;
	
	public  Enemybullet a=new Enemybullet();
	
	public Enemy(){
		yActor=-480;
		location=2500;//1500 is not in boundaries,so after 1st change it will be in .
		isDead=0;
		isActivated=0;
		enemy_plane=new ImageIcon(getClass().getResource("enemy.png"));
		
		label3=new JLabel(enemy_plane);
		
		
	}
	
	public static void move(int left,int right,int yer,int code,int factor){
		
		
		
		new Thread()
        {
            public void run() {
            	
            	
            	int turn=0;
            	int flag=1;
            	int now=yer;
        		while(flag==1){
        		
        			
        			try {
						Thread.sleep(60);
						if(Game.plane.start==0){
							this.interrupt();
						}
						if(Game.enemies.get(code).yActor<Game.plane.yActor-280 ){
							Thread.sleep(5);
							Game.enemies.get(code).yActor=Game.enemies.get(code).yActor+5;
						}
						else if(Game.enemies.get(code).yActor+280>=Game.plane.yActor){
							Thread.sleep(10);
							Game.enemies.get(code).yActor=Game.enemies.get(code).yActor-60;
							
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						
					}
        			if(now+50<right && turn==0){
        					now=now+7+factor;
        					Game.enemies.get(code).location=now;
        					Game.enemies.get(code).label3.setBounds(now, Game.enemies.get(code).yActor, 500, 750);
        					
        			}
        			if(now+50==right) {
        				turn=1;
        				
        				
        			}
        			
        			if(turn==1){
        				
        				if(now-50>left){
        					
        					now=now-7-factor;
        					Game.enemies.get(code).location=now;
        					Game.enemies.get(code).label3.setBounds(now, Game.enemies.get(code).yActor, 500, 750);
        				}
        				else{
        					turn=0;
        				}
        			}
        		}
        	  
            }
        }.start();	
	}  
	
	public synchronized void hit(int own){
		
		
		
		
		new Thread()
        {
            public void run() {
            	
            	int flag=1; //yaþýyor olmasýný da ekle ,ölünce de kurþun atmasýn yani!!!!
        		while(Game.plane.isDead==0 && Game.enemies.get(own).isDead==0){ 
        			
        			try {
						Thread.sleep(200);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        		
        			int fire=Game.enemies.get(own).location;
        			int bullet_way=Game.enemies.get(own).yActor+135;
        			int x_through=fire;
        			int through=bullet_way;
        			if(Game.plane.location-fire<50 && Game.plane.location-fire>-50 ){
        			 	
        				while(through<300 && Game.plane.start==1){
        				  try{
        						
        						
        						
        						a.label4.setVisible(false);
        						Thread.sleep(40);
        						through=through+20;
        						Game.enemy_bullets.get(bullet_counter).label2.setBounds(x_through,through,500,750);
        						
        						if(through>Game.plane.yActor-50 && Game.plane.isDead==0){
        							if(Game.plane.location-x_through<50 && Game.plane.location-x_through>-50){
        								
        								Game.plane.live--;
        								a.label4.setBounds(Game.plane.location, through, 500, 750);
        								a.label4.setVisible(true);
        								Game.plane.label1.setVisible(false);
        								if(Game.plane.live!=0){
        									if(Game.plane.live==2){
        										Game.plane.c3_label.setVisible(false);
        										Game.plane.c2_label.setBounds(-100, -295, 500, 750);
        										Game.plane.c2_label.setVisible(true);
        									}
        									else if(Game.plane.live==1){
        										Game.plane.c2_label.setVisible(false);
        										Game.plane.c1_label.setBounds(-100, -295, 500, 750);
        										Game.plane.c1_label.setVisible(true);
        									}
        									Thread.sleep(50);
            								Game.plane.label1.setVisible(true);
            								Thread.sleep(50);
            								Game.plane.label1.setVisible(false);
            								Thread.sleep(50);
            								Game.plane.label1.setVisible(true);
            								
        								}
        								else{
        									Game.plane.isDead=1;
            								Game.plane.start=0;
        								}
        								Game.enemy_bullets.get(bullet_counter).label2.setVisible(false);
        								Thread.sleep(50);
        								a.label4.setVisible(false);
        								bullet_counter--;
        								break;
        							}
        							
        							else{
        								System.out.println(through);
            							if(through>280){
            								Game.enemy_bullets.get(bullet_counter).label2.setVisible(false);
            								bullet_counter--;
            							}
            						}
        						}
        						
        						else{
        							if(through>280){
        								System.out.println("hay");
        								Game.enemy_bullets.get(bullet_counter).label2.setVisible(false);
        								bullet_counter--;
        							}
        						}
        					}catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
        				}
        			 	
        			}
    								
    							
    							
        				
        			}
        			
        			
        		}		
            
        }.start();	
	}
}
