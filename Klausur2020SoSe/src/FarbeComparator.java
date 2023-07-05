import java.util.Comparator;

public class FarbeComparator implements Comparator<Farbe>{

	@Override
	public int compare(Farbe thisFarbe, Farbe thatFarbe) {
		if(thisFarbe == null || thatFarbe == null) {
			if(thisFarbe == null && thatFarbe == null) {
				return 0;
			} else if(thisFarbe == null) {
				return -1;
			} else {
				return 1;
			}
		}
		
		int rotDiff, gruenDiff, blauDiff;
		
		rotDiff = thisFarbe.getRot() - thatFarbe.getRot();
//		Alternative
//		if(rotDiff != 0) {
//			return rotDiff;
//		}
		
		gruenDiff = thisFarbe.getGruen() - thatFarbe.getGruen();
		//wie oben 
		blauDiff = thisFarbe.getBlau() - thatFarbe.getBlau();
		//wie oben
		
		if(rotDiff == 0) {
			if(gruenDiff == 0) {
				return blauDiff;
			} else {
				return gruenDiff;
			}
		}else {
			return rotDiff;
		}
		
	}

}
