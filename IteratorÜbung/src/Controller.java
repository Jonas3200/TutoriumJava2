import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Controller {

	public static void main(String[] args) {

		Prüfung programmierenPrüfung = new Prüfung("Programmierung II", 4);
		Prüfung rechnungswesenPrüfung = new Prüfung("ReWe", 3);
		Prüfung architekturenPrüfung = new Prüfung("AuTvUA", 10);

		List<Prüfung> prüfungenAsList = new LinkedList<>();
		prüfungenAsList.add(programmierenPrüfung);
		prüfungenAsList.add(rechnungswesenPrüfung);
		prüfungenAsList.add(architekturenPrüfung);

		Prüfungen prüfungen = new Prüfungen(prüfungenAsList);

		for (Prüfung prüfung : prüfungen) {
			System.out.println(prüfung.getName());
		}
		
		System.out.println("++++");
		
		Iterator<Prüfung> prüfungenIteratorBackwards = new PrüfungenIteratorBackwards(prüfungen);
		
		// For Each mit Iterator explizit Programmiert:
		while(prüfungenIteratorBackwards.hasNext()) {
			Prüfung prüfung = prüfungenIteratorBackwards.next();
			System.out.println(prüfung.getName());
		}
		
	}

}
