import java.util.Arrays;

public class Controller {

	public static void main(String[] args) {
		
		Rechteck[] figuren = {
				new Rechteck(3,4),
				new Rechteck(4,4),
				new Rechteck(2,8),
				new Quadrat(4),
				new Rechteck(3,4),
		};
		
		Arrays.sort(figuren, new RechteckComparator());
		
		for(Rechteck figur : figuren) {
			System.out.println(figur);
		}
		
		
	}
	
}
