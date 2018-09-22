import java.util.Comparator;

public class ScoreComparator implements Comparator<User> {

	@Override
	public int compare(User a, User b) {
		int fark=b.best_score-a.best_score;
		return fark;
	}

}
