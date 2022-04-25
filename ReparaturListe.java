package Werkstatt;
import java.util.HashMap;

public class ReparaturListe {
	private static String ersatzteil;
	private static int arbeitszeit;
	private static final double stundenLohnMechaniker = 39.55;
	private static HashMap<String, Double> ersatzteile;
	
	// Konstruktor nimmt als Parameter das benötigte Ersatzteil & Dauer Arbeitszeit entgegen
	// Aufruf Konstruktur ruft Methode zum Befüllen der Ersatzteileliste auf und
	// erzeugt neues Objekt der Klasse Datenbank, welches die CSV-Datei erstellt
	public ReparaturListe(String ersatzteil, int arbeitszeit) {
		ReparaturListe.ersatzteil = ersatzteil;
		ReparaturListe.arbeitszeit = arbeitszeit;
		ersatzteileBefüllen();
		Datenbank db = new Datenbank();
	}
	
	// Überlegen: Konstruktur nur mit boolean Reparat. notwendig - dann Rechnung mit 0 €
	
	public ReparaturListe() {
		
	}
	
	// HashMap 'ersatzteile' wird mit den verfügbaren Ersatzteilen befüllt
	final void ersatzteileBefüllen() {
		ersatzteile = new HashMap<String, Double>();
		ersatzteile.put("Auspuff", 89.99);
		ersatzteile.put("Windschutzscheibe", 289.99);
		ersatzteile.put("Bremsbeläge", 59.99);
		ersatzteile.put("Zahnriemen", 35.99);
		ersatzteile.put("Ölwechsel", 49.99);
		ersatzteile.put("Kupplung", 99.99);
	}
	
	// gibt Preis für reparariertes Teil zurück
	public Double getPreisErsatzteil() {
		return ersatzteile.get(ReparaturListe.ersatzteil);
	}
	
	// gibt festen Stundenlohn des Mechanikers zurück
	public double getStundenLohnMechaniker() {
		return stundenLohnMechaniker;
	}

	public static int getArbeitszeit() {
		return arbeitszeit;
	}

	
}
