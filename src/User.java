import java.io.Serializable;
import java.util.ArrayList;


public class User implements Serializable {
	
	public String username;
	public String password;//isEqual  fonksiyonu kullan�lacak e�le�me bak�l�rken
	public int best_score;
	public int score;
	
	User(){
		username=" ";
		password=" ";
		best_score=0;
		score=0;
	}

	
	
}
