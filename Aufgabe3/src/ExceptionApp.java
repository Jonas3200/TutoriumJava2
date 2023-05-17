import java.util.Scanner;

public class ExceptionApp {

	public static void main(String[] args) {

		Scanner din = new Scanner(System.in);

		int[] ip = new int[4];
		IPAdresse ipAddresse = null;
		
//		000.000.000 <- Basic Aufbau einer IP-Adresse (Localhost)  
//		255.255.255 <- Maximale IP-Adresse 
		
		boolean nochmal;

		for (int i = 0; i < 4; i++) {	// Schleift über die Einzelnen "Pakete" 
			nochmal = true;

			while (nochmal) {
				try {
					System.out.println("" + (i + 1) + " . Teil der IP-Adresse : ");
					ip[i] = din.nextInt();

					if (ip[i] < 0 || ip[i] > 255)
						throw new NoIPPartException(ip[i]);

					nochmal = false;

				} catch (NumberFormatException e) {
					System.out.println("Kein Zahlenwert eingegeben!");
					nochmal = true;
				} catch (NoIPPartException e) {
					System.out.println("IP-Teil ausserhalb	des Bereichs" + e + "!");
					nochmal = true;

				}
			}
		}

		System.out.println("Neue IP-Adresse-Objeckt erzeugen");
		ipAddresse = new IPAdresse(ip);
	}

}
