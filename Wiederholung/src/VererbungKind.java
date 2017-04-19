
public class VererbungKind extends VererbungSuper {
	public void Uebung() {
		System.out.println("X: " + super.x);
		super.x = 4;
		System.out.println("X: " + super.x);
		
		System.out.println("Z: " + super.z);
		super.x = 6;
		System.out.println("Z: " + super.z);
		
		System.out.println("Y: " + super.getY());
		super.setY(5);
		System.out.println("Y: " + super.getY());
	}
	
	public void setY(int y) {
		System.out.println("Kind: " + (y+10));
		super.setY(y + 10);
	}
	
}
