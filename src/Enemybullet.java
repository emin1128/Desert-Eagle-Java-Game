import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Enemybullet  {
		
	private Icon my_bullet;
	public  JLabel label2;
	
	public Icon explosion;
	public JLabel label4;
	
	public Enemybullet(){
		
		my_bullet=new ImageIcon(getClass().getResource("enemybullet.png"));
		
		label2=new JLabel(my_bullet);
		
		explosion=new ImageIcon(getClass().getResource("giphy.png"));
		
		label4=new JLabel(explosion);
		
		
		
		
	}


	
	
	
}