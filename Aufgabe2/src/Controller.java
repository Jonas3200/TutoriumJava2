import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Controller {

	public static void main(String[] args) {
		String[] vornamen = {"Clara", "Raphael", "Florian", "Julia", "Helga"};
	
	
	Predicate<String> frauenName = (String x) 
			-> x.lastIndexOf("a") + 1 == x.length();
			
	List<String> a = Arrays.asList(vornamen);
	
	List<String> weiblich = new ArrayList<>();
	List<String> männlich = new ArrayList<>();
	
	a.forEach(vorname -> {
		if(frauenName.test(vorname)) {
			weiblich.add(vorname);
		}
		else { 
			männlich.add(vorname);
		}
	});
	weiblich.sort(String :: compareTo);
	männlich.sort(new StringCoparator());
	
	weiblich.addAll(männlich);
	
	
	
	System.out.println(Arrays.toString(weiblich.toArray()));
	
	}
}

class StringCoparator implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		
		return o1.compareTo(o2);
	}
	
}
