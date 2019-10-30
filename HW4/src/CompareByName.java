import java.util.Comparator;

public class CompareByName implements Comparator<Playable>{

	@Override
	public int compare(Playable p1, Playable p2) {
		if(p1.getName().compareTo(p2.getName()) < 0){
			return -1;
		}
		if(p1.getName().compareTo(p2.getName()) > 0){
			return 1;}
		else
			return 0;
	}
}
