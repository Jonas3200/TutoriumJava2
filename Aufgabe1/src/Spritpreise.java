import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Spritpreise {

	Map<String, Map<Tag, Double>> map;

	public Spritpreise() {
		map = new TreeMap();
	}

	public void add(String markenname, Tag tag, double preis) {
		Map<Tag, Double> innerMap = new HashMap<>();
		innerMap.put(tag, preis);
		map.put(markenname, innerMap);
	}

	public void ausgabe() {
//		System.out.println(		//Stream 
//				Arrays.stream(Tag.values())
//				.map(tag -> String.format("%8s", tag))
//				.collect(Collectors.toList()));
		
		// "Normaler Code" 
		for(Tag tag : Tag.values()) {
			System.out.printf("%8s", tag);
		}
		
	}

}
