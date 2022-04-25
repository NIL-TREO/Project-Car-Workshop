package Werkstatt;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

// Klasse Datenbank erzeugt Eintrag in CSV-Datei mit Titel "Kunden"
public class Datenbank {
		
	// Aufruf des Konstruktors führt direkt Methode erstelleCSVFile() aus
	public Datenbank() {
		erstelleCSVFile();
	}
	
	// erstellt neue CSV-Datei mit Headerbezeichungen
	public void erstelleCSVFile() {
		// Festlegen des Speicherorts
		File file = new File("Kunden.csv");
        	// Prüfen, ob DB vorhanden ist. Falls nein, dann neue DB erstellen und Spaltenbezeichnungen in erste Zeile schreiben
		if(!file.exists() && !file.isDirectory()){
        	try (PrintWriter writer = new PrintWriter(new File("Kunden.csv"))) {
    			StringBuilder sb = new StringBuilder();
    	         // Spaltenbezeichnungen in neue CSV schreiben
    			 sb.append("Name");
    	         sb.append(',');
    	         sb.append("Adresse");
    	         sb.append(',');
    	         sb.append("Fahrzeug");
    	         sb.append(',');
    	         sb.append("Rechnungsnummer");
    	         sb.append(',');
    	         sb.append("Rechnungsdatum");
    	         sb.append(',');
    	         sb.append("Rechnungsbetrag");
    	         sb.append('\n');
    	         
    	         writer.write(sb.toString());
    	         writer.close();
    	         System.out.println("Datei erstellt in Pfad:\n" + file);
    	
    	     } catch (FileNotFoundException e) {
    	         System.out.println("Fehler beim Speichern in CSV: " + e.getMessage());
    	     }	
        } else {
        	System.out.println("Datei bereits vorhanden in Pfad:\n" + file);
        }
		schreibeDatensätzeinDB();
	}
	
	// Schreibt neuen Kundendatensatz aus Klasse Auftrag in neue Zeile, damit bestehende Datensätze nicht überschrieben werden
	public void schreibeDatensätzeinDB() {
        try {
        	Auftrag auftrag = new Auftrag();
        	Abrechnung abrechnung = new Abrechnung();
        	Path filePath = Paths.get("Kunden.csv");
	        
	        StringBuilder stringBuilder = new StringBuilder();
	        stringBuilder.append(auftrag.getName());
	        stringBuilder.append(',');
	        stringBuilder.append(auftrag.getAdresse());
	        stringBuilder.append(',');
	        stringBuilder.append(auftrag.getFahrzeug());
	        stringBuilder.append(',');
	        stringBuilder.append(abrechnung.generiereRechnungsnummer());
	        stringBuilder.append(',');
	        stringBuilder.append(abrechnung.generiereRechnungsdatum());
	        stringBuilder.append(',');
	        stringBuilder.append(abrechnung.getGesamtkosten());
	        stringBuilder.append(System.lineSeparator());
	
	        Files.write(filePath, stringBuilder.toString().getBytes(), StandardOpenOption.APPEND);
	        }
        catch (Exception e) {
        	System.out.println(e.getMessage());
		}
	}
	
	// liest testweise zuvor erstellte CSV-Datei aus
    public void readCSVFile(){
        List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("Kunden.csv"))) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(records.toString());
    }
    
    // scannt Werte aus CSV und speichert sie in ArrayList. Wird in Methode readCSVFile benötigt und aufgerufen
    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
            rowScanner.close();
        }
        return values;
    }
    
    /*
    // Methode prüft, ob definierte Datei existiert
    public boolean checkIfCSVExists() {
    	File file = new File("Kunden.csv");
        if(file.exists() && !file.isDirectory()){
            return true;
        	//System.out.println("File Exists in path:\n" + file);
        }else{
            return false;
        	//System.out.println("File does not exist!");
        }
	}*/
}

