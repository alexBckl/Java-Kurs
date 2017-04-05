import java.awt.Point;
import java.util.Scanner;
public class Spieler {
	private String figur;
	private int wert;
	private Scanner derScanner = new Scanner(System.in);
	
	public Spieler(int wert, String figur){
		this.figur = figur;
		this.wert = wert;
	}
	
	public Point setzeZug(){
		int x;
		int y;
		do{
			System.out.print("X-Koordinate: ");
			x = derScanner.nextInt() - 1;
			System.out.print("Y-Koordinate: ");
			y = derScanner.nextInt() - 1;
		}
		while(x < 0 || x > 2 || y < 0 || y > 2);

		Point derPunkt = new Point();
		derPunkt.setLocation(x, y);
		return derPunkt;
	}

	public String getFigur() {
		return figur;
	}

	public int getWert() {
		return wert;
	}
}
