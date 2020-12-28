package Lab5;

import java.util.Scanner;

class People {
	public People(double weight1, double height1) {
		weight = weight1;
		height = height1;
	}
	protected double weight,height;
	public void speakHello() {
		System.out.println("Hello");
	}
	public void averageHeight() {
		System.out.println(height);
	}
	public void averageWeight() {
		System.out.println(weight);
	}

}

class ChinaPeople extends People {
	ChinaPeople(double w1,double h1) {
		super(w1,h1);

	}
	public void chinaKungFu() {
		System.out.println("会中国功夫");
	}
}

public class Lab5_2 {
	public static void main(String[] args) {
		System.out.println("请输入您的体重");
		Scanner input2 = new Scanner(System.in);
		double k1 = input2.nextDouble();
		System.out.println("请输入您的身高");
		Scanner input1 = new Scanner(System.in);
		double k2 = input1.nextDouble();
		ChinaPeople p = new ChinaPeople(k1,k2);
		p.averageHeight();
	}
}
