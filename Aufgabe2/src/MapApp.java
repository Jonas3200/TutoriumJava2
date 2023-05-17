import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MapApp {

	public static void main(String[] args) {
		StringFunction f = new StringFunction();
		List<String> l = new ArrayList<>();
		List<Integer> intListe = map(f, l);
		
	}
	
	
public static List<Integer> map(StringFunction f, List<String> l){
	List<Integer> result = new LinkedList<>();
	
	for (String elementOfL : l) {
	
		result.add(f.apply(elementOfL));
	
	}
	
	return result;
}
	
}
