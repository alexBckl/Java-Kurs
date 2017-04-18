import java.util.Scanner;

public class Oberflaeche {
	//Attribute
	private Scanner derScanner = new Scanner(System.in);
	
	public void gebeAus(String text, boolean zeilenumbruch) {
		System.out.print(text);
		if(zeilenumbruch) {
			System.out.println();
		}
	}
	
	public int leseZahl(String text) {
		System.out.print(text);
		return derScanner.nextInt();
	}
	
	public String leseText(String text) {
		System.out.print(text);
		return derScanner.nextLine();
	}
}
