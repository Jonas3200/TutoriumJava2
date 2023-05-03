
public class Person implements Comparable<Person>{

	public int id;
	public String nachname;
	public String vorname;
	
	
	Person(int id, String vorname, String nachname){
		this.id = id;
		this.vorname = vorname;
		this.nachname = nachname;
	}
	
	public static void main(String[] args) {
		Person jonas = new Person(1, "Jonas", "Viehof");
		Person rasch = new Person(2, "Jochen", "Rasch");
		
//		System.out.println(jonas.compareTo(rasch));
		
		PersonNachnamenComparator nachname = new PersonNachnamenComparator();
		System.out.println(nachname.compare(jonas, rasch));
		
	}

	@Override
	public int compareTo(Person otherPerson) {	// Auf Basis der id
		return this.id - otherPerson.id;
	}
	
}
