
public class Array2D {
	public void Uebung() {
		int[][] array2d = new int[2][10];
		
		for(int x = 0; x < 10; x++) {
			array2d[0][x] = 2*x;
			array2d[1][x] = 2*x + x*x;
			System.out.println(x + " => [" + array2d[0][x] + "] [" + array2d[1][x] + "]" );
		}
	}
}
