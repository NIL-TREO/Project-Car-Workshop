package Werkstatt;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Random;

public class Abrechnung {
	static Auftrag auftrag;
	private static double arbeitslohn, materialkosten, gesamtkosten;
	private static int rechnungsnummer;
	private String rechnungsdatum;
	
	// Berechnet Rechnungsbetrag auf Basis des Ersatzteils und geleisteter Arbeitszeit
	private void berechneKostenReparatur() {
		ReparaturListe reparatur = new ReparaturListe();
		arbeitslohn = reparatur.getStundenLohnMechaniker() * ReparaturListe.getArbeitszeit();
		materialkosten = reparatur.getPreisErsatzteil();
		gesamtkosten = arbeitslohn + materialkosten;
	}
	
	public double getGesamtkosten() {
		berechneKostenReparatur();
		return gesamtkosten;
	}
	
	// Rechnungsnummer wird mit 4-stelliger Zufallszahl generiert
	public int generiereRechnungsnummer() {
		Random rand = new Random();
		rechnungsnummer = rand.nextInt((9999 - 100) + 1) + 10;
		return rechnungsnummer;
	}
	
	// Zieht sich das aktuelle Systemdatum
	public String generiereRechnungsdatum() {
		LocalDate date = LocalDate.now();
		DateTimeFormatter dtf;
		dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
		rechnungsdatum = String.valueOf(date.format(dtf));
		return rechnungsdatum;
	}
}
