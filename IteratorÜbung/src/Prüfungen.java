import java.util.Iterator;
import java.util.List;

public class Prüfungen implements Iterable<Prüfung> {

	private List<Prüfung> prüfungen;

	public List<Prüfung> getPrüfungen() {
		return prüfungen;
	}

	public void setPrüfungen(List<Prüfung> prüfungen) {
		this.prüfungen = prüfungen;
	}

	public Prüfungen(List<Prüfung> prüfungen) {
		this.prüfungen = prüfungen;
	} 
	
	@Override
	public Iterator<Prüfung> iterator() {
		return new PrüfungenIterator(this);
		// return new PrüfungenIterator(this.prüfungen);
	}
	
	
}
