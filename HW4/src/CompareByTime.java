import java.util.Comparator;

public class CompareByTime implements Comparator<Playable>{

	@Override
	public int compare(Playable t1, Playable t2) {
		if(t1.getPlayTimeSeconds() < t2.getPlayTimeSeconds()){
			return -1;
		}
		if(t1.getPlayTimeSeconds() > t2.getPlayTimeSeconds()){
			return 1;}
		else
			return 0;
	}
}
