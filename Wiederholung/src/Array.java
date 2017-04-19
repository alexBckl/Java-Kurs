
public class Array {
	public void Uebung() {
		int[] intArray = new int[10];		//Erzeugt ein Array mit 5 Einträgen, Index läuft von 0-4
		
		intArray[0] = 6;
		
		intArray[1] = (intArray[0] == 6) ? 4 : 2;
		
		//Feste Laufvariable
		System.out.println("Feste Laufvariable");
		for(int x = 0; x < 5; x++) {
			intArray[x] = 2 * x;
		}
		
		for(int x = 0; x < 5; x++) {
			System.out.println(x + " => " + intArray[x]);
		}
		System.out.println("");
		
		//Laufvaiable abhängig der Arraylänge
		System.out.println("Laufvaiable abhängig der Arraylänge");
		for(int x = 0; x < intArray.length; x++) {
			intArray[x] = 2 * x;
		}
		
		for(int x = 0; x < intArray.length; x++) {
			System.out.println(x + " => " + intArray[x]);
		}
		
		//Vorteil: Kein Fehler durch zu hohen Index möglich, passt sich automatisch der Arraylänge an
	}
}
