
public class Prüfung {

	private String namen;
	private int ects;
	public String getName() {
		return namen;
	}
	public void setNamen(String namen) {
		this.namen = namen;
	}
	public int getEcts() {
		return ects;
	}
	public void setEcts(int ects) {
		this.ects = ects;
	}
	public Prüfung(String namen, int ects) {
		super();
		this.namen = namen;
		this.ects = ects;
	}
	
	
	
}
