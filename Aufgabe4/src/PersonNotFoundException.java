
public class PersonNotFoundException extends Exception {

	public PersonNotFoundException(Person p) {
		super(p.toString());
	}
	
}
