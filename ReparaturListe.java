package Werkstatt;
import java.util.HashMap;

public class ReparaturListe {
	private static String ersatzteil;
	private static int arbeitszeit;
	private static final double stundenLohnMechaniker = 39.55;
	private static HashMap<String, Double> ersatzteile;
	
	// Konstruktor nimmt Parameter ben�tigtes Ersatzteil und Dauer Arbeitszeit entgegen
	// Aufruf Konstruktur ruft Methode zum Bef�llen der Ersatzteileliste auf
	public ReparaturListe(String ersatzteil, int arbeitszeit) {
		ReparaturListe.ersatzteil = ersatzteil;
		ReparaturListe.arbeitszeit = arbeitszeit;
		ersatzteileBef�llen();
		Datenbank db = new Datenbank();
	}
	
	// �berlegen: Konstruktur nur mit boolean Reparat. notwendig - dann Rechnung mit 0 �
	
	public ReparaturListe() {
		
	}
	
	// HashMap 'ersatzteile' wird mit den verf�gbaren Ersatzteilen bef�llt
	final void ersatzteileBef�llen() {
		ersatzteile = new HashMap<String, Double>();
		ersatzteile.put("Auspuff", 89.99);
		ersatzteile.put("Windschutzscheibe", 289.99);
		ersatzteile.put("Bremsbel�ge", 59.99);
		ersatzteile.put("Zahnriemen", 35.99);
		ersatzteile.put("�lwechsel", 49.99);
		ersatzteile.put("Kupplung", 99.99);
	}
	
	// gibt Preis f�r reparariertes Teil zur�ck
	public Double getPreisErsatzteil() {
		return ersatzteile.get(ReparaturListe.ersatzteil);
	}
	
	// gibt festen Stundenlohn des Mechanikers zur�ck
	public double getStundenLohnMechaniker() {
		return stundenLohnMechaniker;
	}

	public static int getArbeitszeit() {
		return arbeitszeit;
	}

	
}
