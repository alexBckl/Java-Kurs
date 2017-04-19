
public class VererbungSuper {
	public 		int x = 1;	//Innerhalb des gesamten Projekts
	private		int y = 2;	//Innerhalb der Klasse
	protected 	int z = 3;	//Innerhalb der Erbfolge und des Packages
	
	
	//Datenkapselung
	public void setY(int y) {
		this.y = y;
		System.out.println("Super: " + this.y);
	}
	
	public int getY() {
		return this.y;
	}
	
	
}
