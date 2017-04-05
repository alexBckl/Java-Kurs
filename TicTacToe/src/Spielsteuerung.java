import java.util.Scanner;
import java.awt.Point;
public class Spielsteuerung {
	Spielfeld dasSpielfeld;
	Spieler[] derSpieler;
	String[][] temp = new String[3][3];
	int aktuellerSpieler;
	Scanner sc = new Scanner(System.in);
	Point hilfe = new Point();
	int status = 0;
	int pruefung = 0;
	long test;
	
	public Spielsteuerung(){
		dasSpielfeld = new Spielfeld();
		derSpieler = new Spieler[2];
		derSpieler[0] = new Spieler(1,"X");
		derSpieler[1] = new Spieler(-1,"O");
	}
	
	public void spiele(){
		switch (status) {
			case 0:
				gebeSpielfeld();
				erwarteEingabe();
				break;
			case 1:
				System.out.println("Spieler 1 hat gewonnen!");
				status = 4;
				break;
			case 2:
				System.out.println("Spieler 2 hat gewonnen!");
				status = 4;
				break;
			case 3:
				System.out.println("Keiner hat gewonnen!");
				status = 4;
				break;
			case 4:
				System.out.print("Nochmal spielen?");
				String zeichen;
				do{
					zeichen = sc.next();
					System.out.println(zeichen);
				}
				while(!zeichen.toLowerCase().equals("j") 
						&& !zeichen.toLowerCase().equals("n"));

				if(zeichen.toLowerCase().equals("j")){
					System.out.println("Weiter");
					dasSpielfeld.initialisiere();
					status = 0;
				}
				else{
					System.out.println("Ende");
					System.exit(0);
				}
			default:
				break;
		}
		
	}
	
	public void pruefeUnentschieden(){
		if(dasSpielfeld.pruefeVoll()){
			System.out.println("Unentschieden!");
			System.exit(0);
		}
	}
	
	private void erwarteEingabe(){
		do{
			hilfe = derSpieler[0].setzeZug();
		}
		while(dasSpielfeld.pruefeFeld(hilfe.x, hilfe.y));
		dasSpielfeld.setzeFeld((int)hilfe.getX(), (int)hilfe.getY(), 
				derSpieler[0].getWert(), derSpieler[0].getFigur());
		
		gebeSpielfeld();
		pruefeGewonnen();
		//pruefeUnentschieden();
		
		
		if(status == 0) {
		do{
			hilfe = derSpieler[1].setzeZug();
		}
		while(dasSpielfeld.pruefeFeld(hilfe.x, hilfe.y));
		dasSpielfeld.setzeFeld(hilfe.x, hilfe.y, derSpieler[1].getWert(), derSpieler[1].getFigur());
		}
		gebeSpielfeld();
		pruefeGewonnen();
		//pruefeUnentschieden();
	}
	
	private void pruefeGewonnen(){
		int[][] feld = dasSpielfeld.gebeWert();
		int temp = 0;
		
		//Spalten prüfen
		for(int y = 0; y < 3; y ++){
			temp += feld[0][y];
		}
		
		if(temp != 3 && temp != -3){
			temp = 0;
			for(int y = 0; y < 3; y ++){
				temp += feld[1][y];
			}
		}
		
		else if(temp != 3 && temp != -3){
			temp = 0;
			for(int y = 0; y < 3; y ++){
				temp += feld[2][y];
			}
		}
		
		//Reihen prüfen
		else if(temp != 3 && temp != -3){
			temp = 0;
			for(int x = 0; x < 3; x ++){
				temp += feld[x][0];
			}
		}
		
		else if(temp != 3 && temp != -3){
			temp = 0;
			for(int x = 0; x < 3; x ++){
				temp += feld[x][1];
			}
		}
		
		else if(temp != 3 && temp != -3){
			temp = 0;
			for(int x = 0; x < 3; x ++){
				temp += feld[x][2];
			}
		}
		
		//Diagonalen prüfen
		else if(temp != 3 && temp != -3){
			temp = 0;
			for(int i = 0; i < 3; i ++){
				temp += feld[i][i];
			}
		}
		
		else if(temp != 3 && temp != -3){
			temp = 0;
			for(int i = 0; i < 3; i ++){
				temp += feld[2-i][i];
			}
		}
		
		
		switch (temp) {
		case 3:
			status = 1;
			break;
		case -3: 
			status = 2;
			break;
		default:
			if(dasSpielfeld.pruefeVoll()) {
				status = 3;
			}
			break;
		}			
	}
	
	private void gebeSpielfeld()
	{
		temp = dasSpielfeld.gebeFeld();
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				System.out.print("[" + temp[j][i] + "] ");
			}
			System.out.println();
		}
	}
}
