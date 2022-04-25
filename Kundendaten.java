package Werkstatt;
import java.util.HashMap;

public class Kundendaten {
	private double rechnung;
	private static HashMap<String, String> datensatz = new HashMap<>();
			
	// erstellt einen neuen Kundendatensatz inkl. Rechnungsh�he in der HashMap
	public String erzeugeKundendatensatz() {
				
		// zieht Gesamtkosten der Reparatur aus Klasse Abrechnung
		Abrechnung abrechnung = new Abrechnung();
		rechnung = abrechnung.getGesamtkosten();
				
		// F�r Ausgabe in Console wird Eintrag in HashMap datensatz schreiben (KEY: Name, VALUE: Adresse + Fahrzeug + Rechnungsnr. + Rechnungsbetrag)
		Auftrag auftrag = new Auftrag();
		datensatz.put("Name: " + auftrag.getName(), (" | Adresse: "+ auftrag.getAdresse() + " | " + "Fahrzeug: " + auftrag.getFahrzeug() + " | " + "Rechnungsbetrag: EUR " + rechnung));
		return datensatz.toString();
	}
	
	// Getter f�r HashMap datensatz
	public static HashMap<String, String> getDatensatz() {
		return datensatz;
	}

}	

