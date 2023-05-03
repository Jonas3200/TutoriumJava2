import java.util.Comparator;

public class PersonNachnamenComparator implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		String nachname1 = o1.nachname;
		String nachname2 = o2.nachname;
		
		return nachname1.compareTo(nachname2);
		
	}

	
	
}
