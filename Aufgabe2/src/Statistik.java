import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Statistik implements Reportable {

	private String überschrift;
	private List<String> legende = new LinkedList<>();
	private Map<String, List<Integer>> tabelle = new TreeMap<>();

	Statistik(String überschrift, String[] legende) {
		this.überschrift = überschrift;
		for (String s : legende)
			this.legende.add(s);
	}

	void add(String s, int[] zahlen) {
		List<Integer> liste = new ArrayList<>();
		for (int i : zahlen)
			liste.add(i);
		tabelle.put(s, liste);
	}

	@Override
	public String überschrift() {
		return überschrift;
	}

	@Override
	public List<String> legende() {
		return legende;
	}

	@Override
	public Map<String, List<Integer>> report() {
		return tabelle;
	}
}
