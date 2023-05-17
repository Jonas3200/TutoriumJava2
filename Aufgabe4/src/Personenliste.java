
public class Personenliste {

	private Person[] personen;
	
	
	public Personenliste(Person... personen) {
		this.personen = personen;
	}
	
	public Person find(Person personToFind) throws PersonNotFoundException {
		
		for (Person person : personen) {
			if(person.equals(personToFind)) {
				return person;
			}
		}
		
		throw new PersonNotFoundException(personToFind);
		
	}
	
}
