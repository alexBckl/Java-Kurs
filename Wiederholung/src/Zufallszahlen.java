import java.util.Random;

public class Zufallszahlen {
	//Attribute
	private Random zufall = new Random();
	
	//Operationen
	public void Uebung(){
		int zahl;
		
		/*do{
		zahl = zufall.nextInt(9+1) + 1;
		}
		while (zahl != 0);
		System.out.println(zahl);*/
		
		//zahl = zufall.nextInt(14 + 1) + 3;
		
		
		//Zahl zwischen x und y (mit x < y) erzeugen:
		//y - x + 1 kommt in die Klammer
		//Anschließen + x
		
		//Beispiel: zwischen 34 und 27
		do{
		zahl = zufall.nextInt(34 - 27 + 1) + 27;
		}
		while(zahl != 27);
		System.out.println(zahl);
	}
}	
