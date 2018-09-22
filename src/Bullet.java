import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bullet  {
		
	private Icon my_bullet;
	public  JLabel label2;
	
	public Icon explosion;
	public JLabel label4;
	
	
	public Bullet(){
		
		my_bullet=new ImageIcon(getClass().getResource("bullet.png"));
		
		label2=new JLabel(my_bullet);
		
		explosion=new ImageIcon(getClass().getResource("giphy.png"));
		
		label4=new JLabel(explosion);
		
		
		
		
	}


	
	
	
}


	
