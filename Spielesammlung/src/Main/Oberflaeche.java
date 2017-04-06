package Main;
import java.util.Scanner;

public class Oberflaeche {
	//Attribute
	Scanner derScanner = new Scanner(System.in);
	
	//Operationen
	public void gebeAus(int zahl, boolean zeilenumbruch) {
		System.out.print(zahl);
		if(zeilenumbruch) {
			System.out.println();
		}
	}
	public void gebeAus(String text, boolean zeilenumbruch) {
		System.out.print(text);
		if(zeilenumbruch) {
			System.out.println();
		}
	}
	public void gebeAus(int[][] feld, char spieler1, char spieler2) {
		char zeichen = ' ';
		for(int y = feld.length-1; y >= 0; y--){
			for(int x= 0; x < feld.length; x++){
				switch(feld[x][y]) {
				case 1:
					zeichen = spieler1;
					break;
				case -1:
					zeichen = spieler2;
					break;
				case 0:
					zeichen = ' ';
					break;
				default:
					break;
				}
				System.out.print("[" + zeichen + "] ");
			}
			System.out.println();
		}
	}
	public void gebeAus(char zeichen, boolean zeilenumbruch) {
		System.out.print(zeichen);
		if(zeilenumbruch) {
			System.out.println();
		}
	}
	
	public int leseZahl() {
		return derScanner.nextInt();
	}
	public String leseText() {
		return derScanner.next();
	}
	
}
