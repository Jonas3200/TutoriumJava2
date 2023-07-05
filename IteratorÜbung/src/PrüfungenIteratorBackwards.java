import java.util.Iterator;
import java.util.List;

public class PrüfungenIteratorBackwards implements Iterator<Prüfung> {

	private List<Prüfung> prüfungen;
	private int index;
	private int min;

	public PrüfungenIteratorBackwards(List<Prüfung> prüfungen) {
		this.prüfungen = prüfungen;
		this.index = prüfungen.size()-1;
		this.min = 0;
	}

	public PrüfungenIteratorBackwards(Prüfungen prüfungen) {
		this(prüfungen.getPrüfungen());
	}

	@Override
	public boolean hasNext() {
		return min <= index;
	}

	@Override
	public Prüfung next() {
		return prüfungen.get(index--); 
	}

}
