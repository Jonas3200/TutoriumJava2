
public class Rechteck {

	private int länge;
	private int breite;

	public Rechteck(int länge, int breite) {
		this.länge = länge;
		this.breite = breite;
	}

	public int fläche() {
		return this.länge * this.breite;
	}

	public int umfang() {
		return this.länge * 2 + this.breite * 2;
	}
	
	@Override
	public String toString() {
		return String.format("%-17s (%d x %d, F: %2d, U: %2d)", super.toString(), this.länge, this.breite, this.fläche(), this.umfang());
	}

}
