
public class Controller {

	public static void main(String[] args) {
		 Statistik roboter = new Statistik
		 ( "Zahl der Industrieroboter in Tausend",
		 new String[] {"Land", "2010", "2011", "2012"} );
		 roboter.add("Japan", new int[] {308, 307, 311} );
		 roboter.add("USA" , new int[] {180, 193, 207} );
		 roboter.add("D" , new int[] {148, 157, 162} );
	
		 /* Möglichkeit über default implementierung; nicht 100% gemäß Aufgabenstellung */
		 roboter.printReport();
		 
		 /* Möglichkeit gemäß Aufgabenstellung */
		 ReportGenerator.printReport(roboter);
		 }

}
