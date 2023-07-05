import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Farbe {
	private int rot;
	private int gruen;
	private int blau;

	public Farbe(int rot, int gruen, int blau) {
		this.rot = rot;
		this.gruen = gruen;
		this.blau = blau;
	}

	public int getRot() {
		return rot;
	}

	public int getBlau() {
		return blau;
	}

	public int getGruen() {
		return gruen;
	}

	public int hashCode() {
		return 0;
	}

	public boolean equals(Object o) {
		return false;
	}

	public static void main(String[] args) {
		String[] tokens = new String[] { "rot", "255", "0", "0", "weiss", "255", "255", "255", "türkis", "0", "255",
				"255", "orange", "255", "165", "0", "grau", "128", "128", "128" };
		Map<Farbe, String> map = verarbeiten(tokens);
		ausgeben(map);
	}

	public static Map<Farbe, String> verarbeiten(String[] tokens) {
		Map<Farbe, String> result = new HashMap<>();

		String name;
		int rot, gruen, blau;
		Farbe farbe;

		for (int i = 0; i < tokens.length; i = i + 4) {
			name = tokens[i];
			rot = Integer.parseInt(tokens[i + 1]);
			gruen = Integer.parseInt(tokens[i + 2]);
			blau = Integer.parseInt(tokens[i + 3]);

			farbe = new Farbe(rot, gruen, blau);

			result.put(farbe, name);
		}

		return result;
	}

	public static void ausgeben(Map<Farbe, String> map) {

		Set<Farbe> farbenSet = map.keySet();

		List<Farbe> farbenListe = new LinkedList<>();

		for (Farbe farbe : farbenSet) {
			farbenListe.add(farbe);
		}

		farbenListe.sort(new FarbeComparator());

		for (Farbe farbe : farbenListe) {
			StringBuilder sb = new StringBuilder();

			sb.append(farbe.getRot() + ",");
			sb.append(farbe.getGruen());
			sb.append("," + farbe.getBlau());
			sb.append(" = ");
			sb.append(map.get(farbe));

			System.out.println(sb.toString());

		}

	}

}
