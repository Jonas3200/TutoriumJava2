
public class Person {

	private String name;
	private int alter;

	Person(String name, int alter) {
		this.name = name;
		this.alter = alter;
	}

	@Override
	public boolean equals(Object object) {
		Person that = null;
		try {
			that = (Person) object;
		} catch (ClassCastException e) {
			return false;
		}
		return this.name.equals(that.name) && this.alter == that.alter;
	}

	@Override
	public String toString() {
		return name + " (" + alter + ")";
	}

}
