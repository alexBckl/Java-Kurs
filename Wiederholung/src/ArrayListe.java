import java.util.ArrayList;

public class ArrayListe {
	public void Uebung() {
		//Größe ist dynamisch und muss nicht von Begina an festgelegt werden.
		ArrayList <String> dieListe = new ArrayList<String>();
		
		dieListe.add("Daniel");			//Fügt an der nächstfreien Stelle Daniel ein
		dieListe.add("Peter");			//Fügt an der nächstfreien Stelle Peter ein
		dieListe.add("Dimitar");		//...
		dieListe.add("Etien");			//...
		dieListe.add("Frank");			//...
		dieListe.add(3, "Emmanuel");	//Rückt den Inhalt um einen Index weiter und fügt bei Index 3 Emmanuel ein
		dieListe.set(1, "David");		//Überschreibt Inhalt bei Index 1
		dieListe.remove(5);				//Löscht Wert bei Index 5
		dieListe.remove(3);		     	//Löscht Wert bei Index 3 und zieht den Index der restlichen Liste um eins nach oben
		
		//Ausgabe: 
		//1: Daniel
		//2: David
		//3: Dimitar
		for(int x = 0; x < dieListe.size(); x++) {
			System.out.println((x + 1) + ": (Index: " + x + ") " + dieListe.get(x));
		}
		
		
	}
}
