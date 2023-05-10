import java.util.*;
import static java.util.Arrays.*;

public class Sportler {

	public static void main(String[] args) {
		List<String> fußballer = asList("Tim", "Paul", "Andi", "Tom");
		List<String> handballer = asList("Otto", "Andi", "Tim", "Uli");
		List<String> volleyballer = asList("Andrea", "Clara", "Julia", "Tim", "Tom", "Andi");
		List<String> basketballer = asList("Otto", "Tim", "Hans", "Sven", "Andi", "Paul");

		List<List<String>> verein = asList(fußballer, handballer, volleyballer, basketballer);

		List<String> top = topSportler(verein);
		List<String> einzel = einzelSportler(verein);

		System.out.println("Top-Sportler : " + top);
		System.out.println("Einzel-Sportler: " + einzel);

	}

	
	private static String[] vereinsmitglieder(List<List<String>> verein) {
		/* Set, damit keine doppelten Werte vorkommen können */
		Set<String> vereinsmitglieder = new HashSet<>();

		for (List<String> sportart : verein) {
			for (String sportler : sportart) {
				vereinsmitglieder.add(sportler);
			}
		}

		String[] vereinsmitgliederArr = new String[vereinsmitglieder.size()];

		int i = 0;
		for (String vereinsmitglied : vereinsmitglieder) {
			vereinsmitgliederArr[i++] = vereinsmitglied;
		}

		return vereinsmitgliederArr;
	}

	/**
	 * 
	 * @param verein
	 * @return Liste von Vereinsmitglied, in dem die Anzahl der Sportarten zu Namen zugeordnet sind
	 */
	private static List<Veriensmitglied> sportartenZuVereinsmitgliedZuordnen(List<List<String>> verein) {

		List<Veriensmitglied> anzahlSportartenFuerVereinsmitglieder = new LinkedList<>();

		String[] vereinsmitglieder = vereinsmitglieder(verein);
		int[] anzahlBesuchterSportarten = new int[vereinsmitglieder.length];

		int i;
		for (List<String> sportart : verein) {
			i = 0;
			for (String vereinsmitglied : vereinsmitglieder) {
				if (sportart.contains(vereinsmitglied)) {
					anzahlBesuchterSportarten[i]++;
				}
				i++;
			}
		}

		i = 0;
		for (String vereinsmitglied : vereinsmitglieder) {
			anzahlSportartenFuerVereinsmitglieder
					.add(new Veriensmitglied(vereinsmitglied, anzahlBesuchterSportarten[i++]));

		}

		return anzahlSportartenFuerVereinsmitglieder;
	}

	public static List<String> topSportler(List<List<String>> verein) {
		List<String> topSportler = new LinkedList<>();

		for (Veriensmitglied vereinsmitglied : sportartenZuVereinsmitgliedZuordnen(verein)) {
			if (vereinsmitglied.getAnzahlSportarten() == verein.size()) {
				topSportler.add(vereinsmitglied.getName());
			}
		}
		
		topSportler.sort(null);
		return topSportler;
	}
	
	public static List<String> einzelSportler(List<List<String>> verein) {
		List<String> einzelSportler = new LinkedList<>();

		for (Veriensmitglied vereinsmitglied : sportartenZuVereinsmitgliedZuordnen(verein)) {
			if (vereinsmitglied.getAnzahlSportarten() == 1) {
				einzelSportler.add(vereinsmitglied.getName());
			}
		}
		
		einzelSportler.sort(null);
		return einzelSportler;
	}

}
