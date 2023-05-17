

public class Test {

	public static void main(String[] args) {
		Personenliste personen = new Personenliste(
				new Person("Hans", 23), 
				new Person ("Martin", 13),
				new Person ("Lisa", 13)
				);
					
		try {
			System.out.println(
					personen.find(new Person("Lisa", 13)));
			System.out.println(
					personen.find(new Person("Lisa", 15)));
		} catch (PersonNotFoundException e) {
			System.out.println(e.toString());
		} finally {
			System.out.println();
		}
	}
	
}
