
public class Spieler {
	//Attribute
	private String name;
	private int punkte;
	
	//Operationen
	public Spieler(String name) {
		this.name = name;
	}
	
	public String gebeName() {
		return name;
	}
	
	public int gebePunkte() {
		return punkte;
	}
	
	public void erhoehePunkte() {
		punkte++;
	}
}
