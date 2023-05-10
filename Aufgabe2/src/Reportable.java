import java.util.List;
import java.util.Map;

public interface Reportable {

	public String überschrift();

	public List<String> legende();

	public Map<String, List<Integer>> report();

	
	/* Nicht wie in der aufgabe gefordert; siehe Anmerkung Controller */
	public default void printReport() {
		System.out.println(überschrift());

		List<String> legende = legende();
		for (String s : legende)
			System.out.print(s + "\t");
		System.out.println();

		Map<String, List<Integer>> tabelle = report();
		for (String key : tabelle.keySet()) {
			System.out.print(key + "\t");
			for (int i : tabelle.get(key))
				System.out.print(i + "\t");
			System.out.println();
		}
		System.out.println();

	}
}
