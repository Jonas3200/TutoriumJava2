
public class Veriensmitglied {

		private String name;
		private int anzahlSportarten;

		Veriensmitglied(String name, int anzahlSportarten) {
			this.name = name;
			this.anzahlSportarten = anzahlSportarten;
		}

		public String getName() {
			return name;
		}

		public void setName(String vereinsmitglied) {
			this.name = vereinsmitglied;
		}

		public int getAnzahlSportarten() {
			return anzahlSportarten;
		}

		public void setAnzahlSportarten(int anzahlSportarten) {
			this.anzahlSportarten = anzahlSportarten;
		}

}
