package Lab5;

public class Lab5_3 {
	final static double PI = 3.1415;
	static int id;
	
	public static void method1() {
		id = 1;
	}
	
	public void method2() {
		System.out.println(Lab5_3.PI);
		Lab5_3.method1();
		System.out.println(Lab5_3.id);
	}
	
	public static void main(String[] args) {
		Lab5_3 k = new Lab5_3();
		k.method2();
	}
}
