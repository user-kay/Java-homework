package lab2;

public class Lab2_1 {
	public static void main(String[] args) {
		for(int i = 1; i <= 1000 ; i++ ) {
			if( f(i) == 1 ) {
				System.out.println( i + " ");
			}
		}
	}
	
	public static int f(int x) {
		int t = 0;
		for(int j = 1 ; j < x ; j++) {
			if(x % j == 0) {
				t += j;
			}
		}
		if(t == x) {
			return 1;
		}
		else {
			return 0;
		}
	}
}
