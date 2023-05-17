import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Aufgabe1 {
	
	//final 
	public static final String KONSTANTE = "KONSTANTE";

	public static void main(String[] args) throws Exception /* throws => Weiterwerfen einer Exception*/ {
		
		try {
			FileReader fr = new FileReader("/");
		} catch (FileNotFoundException e) {	// Fangen einer Exception
			System.out.println("File Not Found");
			throw new Exception(e); // throw => Werfen einer Exception 
		} finally {	//finally
			/* z.B.: Ressourcen schlissen */
		}
		
	}
	
	public void Auto() {
		List<String> list = new ArrayList<>(); //Analog zu d und e 
	/* 	  ^                       ^       	^ 
	    Obertyp				Spezifischer	|
								Verwendung des Diamond Operators als "Abkürzung"	
												*/
		
	}
	
	// GeometrischeFigur f = new …
	//	Rechteck e = (Rechteck) f
	// Prüfbar mit instanceof 
	
	public void useMethodFromInterface(List list) {
		list.size();
	}
	
	
}
