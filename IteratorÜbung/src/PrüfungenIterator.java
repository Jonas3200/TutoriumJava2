import java.util.Iterator;
import java.util.List;

public class PrüfungenIterator implements Iterator<Prüfung>{

	private List<Prüfung> prüfungen;
	private int index;
	private int max;
	
	public PrüfungenIterator(List<Prüfung> prüfungen) {
		this.prüfungen = prüfungen;
		this.index = 0;
		this.max = prüfungen.size();
	}
	
	public PrüfungenIterator(Prüfungen prüfungen) {
		this(prüfungen.getPrüfungen());
	}
	
	
	@Override
	public boolean hasNext() {
		return index < max;
	}

	@Override
	public Prüfung next() {
		Prüfung nextPrüfung = prüfungen.get(index);
		index = index + 1; 
		return nextPrüfung;
	}

}
