package Lab5;

import java.util.Scanner;

class Rectangle {
	public Rectangle(int width,int height) {	
		wid = width;
		h = height;
	}
	public int s() {
		return wid * h;
	}
	private int wid, h;
}


public class Lab5_1 {
	public static void main(String[] args) {
		System.out.println("��������");
		Scanner input1 = new Scanner(System.in);
		int wid1 = input1.nextInt();
		System.out.println("������߶�");
		Scanner input2 = new Scanner(System.in);
		int h1 = input1.nextInt();
		Rectangle r1 = new Rectangle(wid1,h1);
		int k = r1.s();
		System.out.println("�������ε����Ϊ:" + k);
	}
}
