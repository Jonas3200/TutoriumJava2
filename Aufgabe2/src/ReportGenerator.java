import java.util.List;
import java.util.Map;

public class ReportGenerator {

	public static void printReport(Reportable r) {
		System.out.println(r.überschrift());

		List<String> legende = r.legende();
		for (String s : legende)
			System.out.print(s + "\t");
		System.out.println();

		Map<String, List<Integer>> tabelle = r.report();
		for (String key : tabelle.keySet()) {
			System.out.print(key + "\t");
			for (int i : tabelle.get(key))
				System.out.print(i + "\t");
			System.out.println();
		}
		System.out.println();

	}
	
}
