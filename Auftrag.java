package Werkstatt;

public class Auftrag {
	ReparaturListe reparaturliste;
	Kundendaten kundendaten;
	Abrechnung abrechnung;
	private static String name, adresse, fahrzeug;
			
	// Konstruktor der Klasse Auftrag erhält alle relevanten Kundendaten als Parameter
	public Auftrag(String name, String adresse, String fahrzeug) {
		Auftrag.name = name;
		Auftrag.adresse = adresse;
		Auftrag.fahrzeug = fahrzeug;
	}
	
	public Auftrag() {
	}
	
	public String getName() {
		return name;
	}
	public String getAdresse() {
		return adresse;
	}
	public String getFahrzeug() {
		return fahrzeug;
	}
	
}

