import java.util.Comparator;

public class RechteckComparator implements Comparator<Rechteck>{

	@Override
	public int compare(Rechteck thisR, Rechteck thatR) {
		int temp;
		
		
		// check for Fläche
		temp = thisR.fläche() - thatR.fläche();
		
		if(temp != 0) {
			return -temp; //Minus, weil größte zuerst
		}
		
		//check for Umfang
		temp = thisR.umfang() - thatR.umfang();
		if(temp != 0) {
			return -temp; //Minus, weil größte zuerst
		}
		
		//check for Klassenname
		temp = thisR.getClass().getSimpleName().compareTo(thatR.getClass().getSimpleName());
		if(temp != 0) {
			return temp;
		}
		
	
		return -thisR.getClass().hashCode() - thatR.getClass().hashCode(); //Minus, weil größte zuerst
	}

}
