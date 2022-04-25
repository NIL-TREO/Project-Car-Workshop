package Werkstatt;
/*  Das Programm "Werkstatt" berechnet die Reparatur eines Fahrzeugs.
 *  In der main-Klasse werden die kundenbezogenen Daten abgefragt sowie das für die 
 *  Reparatur notwendige Ersatzteil und die Dauer der Reparatur. Auf Basis dieser Daten
 *  wird der Rechnungsbetrage kalkuliert sowie ein Datensatz in einer csv-Datei angelegt
 */
public class Main {

	public static void main(String[] args) {
		// 1. Benötigte Klassenaufrufe: Auftrag (erzeugt Reparaturauftrag mit Kundendaten)
		// 2. Reparaturliste (benötigtes Ersatzteil & Arbeitszeit wird für Mechaniker festgelegt)
		// Ausgabe der Kundendaten & Rechnungsbetrag in Console mit Methode erzeugeKundendatensatz()
		Auftrag auf1 = new Auftrag("Max Mustermann", "Musterstr. 1 Musterstadt", "Volvo V20");		
		ReparaturListe reparatur1 = new ReparaturListe("Auspuff", 4);
		Kundendaten k1 = new Kundendaten();
		System.out.println(k1.erzeugeKundendatensatz());
							
		
		Auftrag auf2 = new Auftrag("Marianne Musterfrau", "Waldweg 12 Waldstadt", "BMW 520");
		ReparaturListe reparatur2 = new ReparaturListe("Bremsbeläge", 2);
		Kundendaten k2 = new Kundendaten();		
	}
}
